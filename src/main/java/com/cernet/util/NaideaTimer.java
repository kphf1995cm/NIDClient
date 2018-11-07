package com.cernet.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import net.sf.json.JSONArray;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.cernet.model.Group;
import com.cernet.model.Idea;
import com.cernet.service.GroupManager;
import com.cernet.service.IdeaManager;
import com.cernet.soa.NidServer;





public class NaideaTimer extends TimerTask{
	GroupManager groupManager;
	IdeaManager ideaManager;
    String messString;
    
    

	public NaideaTimer(GroupManager groupManager,IdeaManager ideaManager){
		this.groupManager = groupManager;
		this.ideaManager = ideaManager;
		
	}
	public NaideaTimer(){
		
	}
	
	@Override
	public void run(){
		//查询所有GROUP表中的记录
		Date beginTime = new Date();
		
		System.out.println("-----begin-------" + beginTime.getTime());
		List<Group> groupList = groupManager.getGroupList();
		String soaUrlString = Config.getValue("soa.url");//SOA端的访问地址
		System.out.println("soaUrlString:" + soaUrlString);
		
		if(null != groupList && groupList.size() > 0){
			//循环每一条group，根据NA_IP,START_TIME到本地的NA_IDEA表中取NA_IP=NA_IP AND START_TIME >= START_TIME
			for(int i = 0;i < groupList.size();i++){
				Group group = groupList.get(i);
				String naIp = group.getNaIp();//取出NAIP
				String startTime = getStartTimeString();//START_TIME为当前月份的下个月1月1号比如2015-09-01 00:00:00
				System.out.println("naip:" + naIp + " " + "startTime:" + startTime);
				List<Idea> soaIdeaList = null;
				try {
					soaIdeaList = getNaideaList(naIp,startTime,null,soaUrlString);//参数3为空，这里表示endTime,暂时不需要endTime所以传空
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				if(null != soaIdeaList && soaIdeaList.size() > 0){
					updateIdeaTable(soaIdeaList);//根据soaIdeaList更新中央追溯数据库中NT_IDEA表
				}
			}
		}
		Date endTime = new Date();
		System.out.println("------end-------" + endTime.getTime());
		long cha = endTime.getTime()- beginTime.getTime();
		System.out.println("------用时毫秒数------" + cha);
	}

	//手动更新idea
	public void synchronous() throws Exception{
		//查询所有GROUP表中的记录
				Date beginTime = new Date();
				
				System.out.println("-----begin-------" + beginTime.getTime());
				List<Group> groupList = groupManager.getGroupList();
				String soaUrlString = Config.getValue("soa.url");//SOA端的访问地址
				System.out.println("soaUrlString:" + soaUrlString);
				
				if(null != groupList && groupList.size() > 0){
					//循环每一条group，根据NA_IP,START_TIME到本地的NA_IDEA表中取NA_IP=NA_IP AND START_TIME >= START_TIME
					for(int i = 0;i < groupList.size();i++){
						Group group = groupList.get(i);
						String naIp = group.getNaIp();//取出NAIP
						String startTime = getStartTimeString();//START_TIME为当前月份的下个月1月1号比如2015-09-01 00:00:00
						System.out.println("naip:" + naIp + " " + "startTime:" + startTime);
						List<Idea> soaIdeaList = null;
						try {
							soaIdeaList = getNaideaListHand(naIp,startTime,null,soaUrlString);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
						if(null != soaIdeaList && soaIdeaList.size() > 0){
							updateIdeaTable(soaIdeaList);//根据soaIdeaList更新中央追溯数据库中NT_IDEA表
						}
					}
				}
				Date endTime = new Date();
				System.out.println("------end-------" + endTime.getTime());
				long cha = endTime.getTime()- beginTime.getTime();
				System.out.println("------用时毫秒数------" + cha);
	}
	
	/**
	 * 
	 * @param naIp
	 * @param startTime 默认下个月的第一天
	 * @param endTime null
	 * @param soaUrlString SOA访问地址，在配置文件中取
	 * @param svr 访问SOA
	 * @return
	 */
	private List<Idea> getNaideaListHand(String naIp, String startTime, String endTime, String soaUrlString) throws Exception{
		
		List<Idea> soaIdeaList = new ArrayList<Idea>();
		String urlString = "http://" + naIp + ":8080/" + soaUrlString;
		//String urlString = "http://211.68.122.89:8080/" + soaUrlString;
		JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
		svr.setServiceClass(NidServer.class);
		svr.setAddress(urlString);
		NidServer nidServer = (NidServer) svr.create();
		CXFClientUtil.configTimeout(nidServer);
		String soaideajson = nidServer.naIdeaList(naIp, startTime, endTime);
		if(null != soaideajson && !"".equals(soaideajson)){
			//JSON串转换为LIST
			JSONArray data = JSONArray.fromObject(soaideajson); 
			soaIdeaList = JSONArray.toList(data, Idea.class);

		}
		return soaIdeaList;
		
	}
	/**
	 * 根据soaIdeaList更新中央追溯数据库中NT_IDEA表
	 * @param soaIdeaList
	 */
	private void updateIdeaTable(List<Idea> soaIdeaList) {
		for(int i = 0;i < soaIdeaList.size();i++){
			Idea naIdea = soaIdeaList.get(i);//SOA服务端IDEA
			String naIp = naIdea.getNaIp();//soa端的NAIP
			Long startMilliSecond = naIdea.getStartMilliSecond();//SOA端的开始时间毫秒数
			Long endMilliSecond = naIdea.getEndMilliSecond();//SOA端的结束时间毫秒数
			String startTimeString = "";
			String endTimeString = "";
			if(null != startMilliSecond && startMilliSecond.longValue() != 0){
				 startTimeString = getTimeStringByLong(startMilliSecond.longValue());//转换为字符串格式2015-01-01 00:00:00
			}
			if(null != endMilliSecond && endMilliSecond.longValue() != 0){
				 endTimeString = getTimeStringByLong(endMilliSecond.longValue());
			}
			Idea ntIdea = ideaManager.getNtIdea(naIp, startTimeString, endTimeString);
			if(null != ntIdea){//追溯端存在一条更新ntidea，则比较KEY与TYPE是否一致
				String ntKey = ntIdea.getIdeaKey();//中央追溯端KEY
				String ntType = ntIdea.getIdeaType();//中央追溯端类型
				String naKey = naIdea.getIdeaKey();//SOA端KEY
				String naType = naIdea.getIdeaType();//SOA端类型
				//比较中央追溯端与SOA端的KEY和类型是否相等
				if(!ntKey.equals(naKey) || !ntType.equals(naType)){//如果不相等，则更新NTIDEA
					ntIdea.setIdeaKey(naKey);//更新追溯端KEY值为SOA端的KEY
					ntIdea.setIdeaType(naType);//更新追溯端的TYPE值为SOA端的TYPE
					ideaManager.updateNtIdea(ntIdea);//更新NTIDEA记录
				}
			}else{//追溯端不存在ntidea则插入一条新的
				ntIdea =  new Idea();
				ntIdea.setIdeaKey(naIdea.getIdeaKey());
				ntIdea.setIdeaType(naIdea.getIdeaType());
				ntIdea.setNaIp(naIdea.getNaIp());
				ntIdea.setStartTime(new Date(naIdea.getStartMilliSecond().longValue()));
				ntIdea.setEndTime(new Date(naIdea.getEndMilliSecond().longValue()));
				ntIdea.setCreateTime(new Date());
				ideaManager.updateNtIdea(ntIdea);
			}
		}
		
	}

	/**
	 * 
	 * @param naIp
	 * @param startTime 默认下个月的第一天
	 * @param endTime null
	 * @param soaUrlString SOA访问地址，在配置文件中取
	 * @param svr 访问SOA
	 * @return
	 */
	private List<Idea> getNaideaList(String naIp, String startTime, String endTime, String soaUrlString)  throws Exception{
		
		List<Idea> soaIdeaList = new ArrayList<Idea>();
		String urlString = "http://" + naIp + ":8080/" + soaUrlString;
		JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
		svr.setServiceClass(NidServer.class);
		svr.setAddress(urlString);
		NidServer nidServer = (NidServer) svr.create();
		CXFClientUtil.configTimeout(nidServer);
		String soaideajson = nidServer.naIdeaList(naIp, startTime, endTime);
		if(null != soaideajson && !"".equals(soaideajson)){
			//JSON串转换为LIST
			JSONArray data = JSONArray.fromObject(soaideajson); 
			soaIdeaList = JSONArray.toList(data, Idea.class);

		}
		return soaIdeaList;
		
	}

	/**
	 * 
	 * @return返回当前时间下个月1号
	 */
	private String getStartTimeString() {
		 Calendar calendar = Calendar.getInstance(); 
		 calendar.set(Calendar.DAY_OF_MONTH, 1); 
		// calendar.add(Calendar.MONTH, 1); 
		 Date nextMonthFirstDate = calendar.getTime(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		 String nextMonthString = sdf.format(nextMonthFirstDate) + " 00:00:00";
		 System.out.println(nextMonthString);
		 return nextMonthString;
	}

	/**
	 * 
	 * @param timeMilliSecond  时间毫秒数
	 * @return 返回日期字符串 2014-01-01 00：00：00
	 */
	private String getTimeStringByLong(long timeMilliSecond){
		Date date = new Date(timeMilliSecond);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dateString = sdf.format(date);
		return dateString;
	}
	
	public GroupManager getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}

	public IdeaManager getIdeaManager() {
		return ideaManager;
	}

	public void setIdeaManager(IdeaManager ideaManager) {
		this.ideaManager = ideaManager;
	}
	public String getMessString() {
		return messString;
	}
	public void setMessString(String messString) {
		this.messString = messString;
	}
//	public static void main(String args[]){
//		String tag=getStartTimeString();
//		System.out.println(tag);
//	}
}

