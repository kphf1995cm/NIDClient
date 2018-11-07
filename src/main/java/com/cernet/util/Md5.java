package com.cernet.util;


import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.LNEG;






public class Md5 {


public final static String MD5(String s) {
	char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f' };
	try {
		byte[] strTemp = s.getBytes();
		MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		mdTemp.update(strTemp);
		byte[] md = mdTemp.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	} catch (Exception e) {
		return null;
	}
}
private static String StrToBinstr(String str) {
    char[] strChar=str.toCharArray();
    String result="";
    for(int i=0;i<strChar.length;i++){
    	//String intString = Integer.valueOf(String.valueOf(strChar[i]),16).toString();
    	//int charint = Integer.parseInt(intString);
    	String charstr = Long.toBinaryString(Long.parseLong(String.valueOf(strChar[i]), 16));
    	String charstrnew = charstr;
    	if(charstr.length() < 4){
    		for(int j = 0;j < 4-charstr.length();j++){
    			charstrnew = "0" + charstrnew;
    		}
    	}
    	System.out.println(charstrnew);
        result += charstrnew;
    }
    return result;
}
private static String strToHex(String str){
	String result="";
	 int size = str.length()/4;
	 for(int i = 0;i < size ;i++){
		 String curString = str.substring(i*4,(i+1)*4);
		 System.out.println(curString);
		 result = result + Long.toHexString(Long.parseLong(curString,2));
	 }
	return result;
}
public static Date getCurrYearFirst(){ 
	 Calendar currCal=Calendar.getInstance();   
	 int currentYear = currCal.get(Calendar.YEAR); 
	 return getYearFirst(currentYear); 
} 

public static Date getYearFirst(int year){  
	Date date = null;
	try {
		String dateString = year + "-" + "01-01 " + "00:00:00";
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		date = sdf.parse(dateString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return date; 
} 

//二进制转16进制
public static String BinaryToHex(String s){
	return Long.toHexString(Long.parseLong(s,2));
}
//十六进制转二进制
public static String HexToBinary(String s){
	return Long.toBinaryString(Long.parseLong(s, 16));
}

private static String getPrefix(String ipv6Addr) {
	String prefix = "";
	String[] ipv6ArrayString = ipv6Addr.split(":");
	for(int i = 0;i < 4;i++){
		
		if( ipv6ArrayString[i].equals("0")){
			prefix += ":";
		}else{
			prefix += ipv6ArrayString[i] + ":";
		}
	}
	return prefix;
}
private static String getSuffix(String ipv6Addr) {
	String suffix = "";
	String[] ipv6ArrayString = ipv6Addr.split(":");
	for(int i = 4;i < 8;i++){
		String str = "";
		if(ipv6ArrayString[i].length() < 4){//长度少于4
			for(int j = 0;j < 4 - ipv6ArrayString[i].length();j++){//在前面补0
				str = str + "0";
			}
		}
		suffix += str + ipv6ArrayString[i];
	}
	return suffix;
	
}

private static String strToHex1(String str){
	String result="";
	 int size = str.length()/4;
	 for(int i = 0;i < size ;i++){
		 String curString = str.substring(i*4,(i+1)*4);
		 System.out.println(curString);
		 result = result + Long.toHexString(Long.parseLong(curString,2));
	 }
	return result;
}

public static void main(String args[]) throws ParseException{
//	System.out.println(Md5.MD5("admin"));
	//String aid = "800001fcbb08051f";
	//Integer.toHexString(aid);
	//char a = '8';
	//System.out.println((int)a);
	//String intString = Integer.valueOf("8",16).toString();
	//int i = Integer.parseInt(intString);
	//String i2 = Integer.toBinaryString(i);
	
	//String aid2 = StrToBinstr("800001fcbbafdc55");//800001fcbb08051f
	//String nid = "800001fcbbafdc55".substring(0,10);
	//System.out.println("nid:"+nid);
	//System.out.println("aid2:"+aid2);
	//String timeStr = aid2.substring(42, 46);
	//String macStr = aid2.substring(46);
	//int month = (new BigInteger(timeStr, 2).intValue())+1;
	//String timeStr = aid2.substring(42);
	//System.out.println("timeStr:"+timeStr);
	//System.out.println("macstr:"+macStr);
	//System.out.println("month:"+month);
	//BigInteger src = new BigInteger(timeStr, 2);
	//System.out.println(src);
	
	//Date date = getCurrYearFirst();
	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//String dString = format.format(date);
	//System.out.println(dString);
	
	String dateString = "2015-08-11 10:28:00";
	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	Date date = sdf.parse(dateString);
	
	String dateString1 = "2015-01-01 00:00:00";
	SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	Date date1 = sdf1.parse(dateString1);
	long date2 = date.getTime() - date1.getTime();
	System.out.println("毫秒数"+date2);
	//转分钟数
	date2 = date2/60000;
	System.out.println("分钟数"+date2);
	//BigInteger bigInteger = new BigInteger(date2);
	String binaryStr = Long.toBinaryString(date2);
	System.out.println("二进制" + binaryStr);
	
	String hexString = strToHex1("000001001010111000100000");
	System.out.println("十六进制" + hexString);

	String nidString = "1894dd";
	System.out.println("十六进制转2进制"+StrToBinstr(nidString));
	//10000000000000000010101000010001000010001001010110111100100
	
	//80002a110804ade4解密后
	//Calendar currCal=Calendar.getInstance();
	//currCal.setTime(date);
	//int currentmonth = currCal.get(Calendar.MONTH);
	//System.out.println(currentmonth);
	// ResourceBundle labels = ResourceBundle.getBundle("config");
	// System.out.println(Config.getValue("path"));
	//ApplicationContext ac = SpringContextUtil.getApplicationContext();
	// NidServer userManager = (NidServer) ac.getBean("nidServer");
	// userManager.tracebackNID(null, null);
	
	//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_soa.xml");

	//ApplicationContext ac = SpringContextUtil.getApplicationContext();
	//NidServer nidServer = (NidServer) context.getBean("client");
	//String string1 = nidServer.tracebackNID("8000294619", null);
	//System.out.println(string1);
	
	//JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
	//svr.setServiceClass(NidServer.class);
	//svr.setAddress("http://211.68.122.59:8080/nidadmin/nidServer?wsdl");
	//NidServer hw = (NidServer) svr.create();
	//String aaString = hw.tracebackNID("8000294619", null);
	//System.out.println(aaString);
	//String aid2 = "a";
	//String bin2 = strToHex("1000000000000000000000011111110010111011101011111101110001010101");
	//System.out.println(bin2);
	//String lastNidMacIn = "ab&";
	//String a1 = lastNidMacIn.split("&")[0];
	//String a2 = lastNidMacIn.split("&")[1];
	//System.out.println(a1);
	//System.out.println(a2);
	//String aaString = "2001:da8:00:b255:200::feb0:0";
	//InetAddress address;
	//try {
	//	address = Inet6Address.getByName(aaString);
	//	String aString = address.toString().substring(1);
	//	System.out.println(getPrefix(aString));
	//	System.out.println(getSuffix(aString));
	//if(address instanceof Inet6Address){
	//	System.out.println(address.toString().substring(1));
	//}
	//} catch (UnknownHostException e) {
	//	// TODO Auto-generated catch block
	//	System.out.println("不是IPV6格式");
	//	e.printStackTrace();
	//}
	String dateString2 = "2015-01-01 00:00:00";
	SimpleDateFormat sdf2 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	Date date21 = sdf2.parse(dateString2);
	System.out.println(date21.getTime());
	//Date endTimeDate = getAidDate(createTime + " 23:59:59");
	//1585009920000
	String aString = getAidTime( 1436584080000l);
	System.out.println(aString);
	String ccString = "1000000000000000000000011111110010111011101011111101110001010101";
	System.out.println(ccString.substring(48));
	
	nextMonthFirstDate(); 
	 

}

public static void printDate(Date date) { 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
System.out.println(sdf.format(date)); 
} 

public static String nextMonthFirstDate() { 
	 Calendar calendar = Calendar.getInstance(); 
	 calendar.set(Calendar.DAY_OF_MONTH, 1); 
	 calendar.add(Calendar.MONTH, 1); 
	 Date nextMonthFirstDate = calendar.getTime(); 
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	 String nextMonthString = sdf.format(nextMonthFirstDate) + " 00:00:00";
	 return nextMonthString;
 } 

private static String getAidTime(long timeLong) {
	String dateString = "";
	Date date = new Date(timeLong);
	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	dateString = sdf.format(date);
	return dateString; 
}
private static Date getAidDate(String dateString) {
	Date date = null;
	try {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		date = sdf.parse(dateString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return date; 
}
}