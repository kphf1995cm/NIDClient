package com.cernet.util;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

/**
 * @author wangjiang
 *
 */
/**
 * @author wangjiang
 *
 */
/**
 * @author wangjiang
 *
 */
/**
 * @author wangjiang
 *
 */
public class EncryptUtils {
	
	 public static final String ALGORITHM = "SHA-256";

	   /**
	     * @param orignal   加密字符串
	     * @return
	     */
	    public static String SHA256Encrypt(String orignal) { 
	        MessageDigest md = null; 
	        try { 
	            md = MessageDigest.getInstance(ALGORITHM); 
	        } catch (NoSuchAlgorithmException e) { 
	            e.printStackTrace(); 
	        } 
	        if (null != md) { 
	            byte[] origBytes = orignal.getBytes(); 
	            md.update(origBytes); 
	            byte[] digestRes = md.digest(); 
	            String digestStr = getDigestStr(digestRes); 
	            return digestStr; 
	        }

	        return null; 
	    }

	    private static String getDigestStr(byte[] origBytes) { 
	        String tempStr = null; 
	        StringBuilder stb = new StringBuilder(); 
	        for (int i = 0; i < origBytes.length; i++) { 
	        	 // System.out.println("and by bit: " + (origBytes[i] & 0xff)); 
	            // System.out.println("no and: " + origBytes[i]); 
	            // System.out.println("---------------------------------------------"); 
	            // 这里按位与是为了把字节转整时候取其正确的整数，java中一个int是4个字节 
	            // 如果origBytes[i]最高位为1，则转为int时，int的前三个字节都被1填充了 
	            tempStr = Integer.toHexString(origBytes[i] & 0xff); 
	            if (tempStr.length() == 1) { 
	                stb.append("0"); 
	            } 
	            stb.append(tempStr);

	        } 
	        return stb.toString(); 
	    }
	
		 /**
		 * @param hexString   16进制字符串
		 * @return
		 */
	public static String hexString2binaryString(String hexString)  
	    {  
	        if (hexString == null || hexString.length() % 2 != 0)  
	            return null;  
	        String bString = "", tmp;  
	        for (int i = 0; i < hexString.length(); i++)  
	        {  
	            tmp = "0000"  
	                    + Integer.toBinaryString(Integer.parseInt(hexString  
	                            .substring(i, i + 1), 16));  
	            bString += tmp.substring(tmp.length() - 4);  
	        }  
	        return bString;  
	    }  
	 
	
	 /**
		 * @param bString   二进制字符串
		 * @return
		 */
	public static String binaryString2hexString(String bString)  
	    {  
	        if (bString == null || bString.equals("") || bString.length() % 8 != 0)  
	            return null;  
	        StringBuffer tmp = new StringBuffer();  
	        int iTmp = 0;  
	        for (int i = 0; i < bString.length(); i += 4)  
	        {  
	            iTmp = 0;  
	            for (int j = 0; j < 4; j++)  
	            {  
	                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);  
	            }  
	            tmp.append(Integer.toHexString(iTmp));  
	        }  
	        return tmp.toString();  
	    }  
	 
	 
	 /**
	 * @param has   加密的字符串
	 * @param div    分界位
	 * @param oid    组织位
	 * @return
	 */
	public String getHha256(String has,String div,String oid){
		 String s =SHA256Encrypt(has);
		 String s1=hexString2binaryString(s);
		 s1=s1.substring(s1.length()-18,s1.length());
		 String s2=div+oid+s1;
		 String s3=binaryString2hexString(s2);
		 return s3;
		 
	 }
	
	 /**
	 * @param shStr   加密字符串
	 * @return
	 * @throws Exception
	 */
	public static String runShell(String shStr) throws Exception {
         String str="";

         Process process;
         process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);
         InputStreamReader ir = new InputStreamReader(process.getInputStream());
         LineNumberReader input = new LineNumberReader(ir);
         String line;
         process.waitFor();
         while ((line = input.readLine()) != null){
             str=str+line;
         }

         return str;
     }
	 	
 	
	 /**
	  * 获得idea加密算法
	  * @param ed   加密、解密的参数
	  * @param ideatext  要加密的字符串
	  * @param ideakey    密钥
	  * @return
	  */
         public static String getIdea(String ed,String ideatext,String ideakey) {
        	 
        	 String list = null;
                 try {
                	 ///home/idea_args/main -e 80002a110804ae20 -s 6b48c2bd883461dc866e64bc5b40650b
         list=runShell(Config.getValue("path") +" "+ed+" "+ideatext+" "+"-s"+" "+ideakey        );
         System.out.println(list);

                 } catch (Exception e) {
                         e.printStackTrace();
                 }
                 return list;
         }
         
         
         /**
          * @param etext   要加密的密文
          * @param ekey    密钥
          * @return
          */
        public  static  String getIdeaEncrypt(String etext,String ekey){
        	 String str=null;
        	 str=getIdea("-e",etext,ekey);
        	 return str;
         }
       
        
        /**
         * @param dtext   要解密的密文
         * @param dkey    密钥
         * @return
         */
        public  static String getIdeaDecrypt(String dtext,String dkey){
        	 String str=null;
        	 str=getIdea("-d",dtext,dkey);
        	 return str;
         }
	 
	 
}
