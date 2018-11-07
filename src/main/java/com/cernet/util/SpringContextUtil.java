/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cernet.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class SpringContextUtil implements ApplicationContextAware {
	 private static Log logger = LogFactory.getLog(SpringContextUtil.class);  
	 private static ApplicationContext factory = getApplicationContext();  
	 static{  
		 getApplicationContext();  
	 }  
	     
	 public static void setFactoryBean(ApplicationContext factory){  
		 SpringContextUtil.factory = factory;  
	 }  
	
	 public static ApplicationContext getApplicationContext()  {  
	      
	       if ( factory == null )  
	        {  
	          if(logger.isDebugEnabled()) logger.debug("===================================Init Spring's ApplicationContext=========================================");  
	            try  
	             {  
	                 factory = new ClassPathXmlApplicationContext(new String[]{"applicationContext_beans.xml","applicationContext_common.xml"});  
	             }  
	             catch ( Exception e1 )  
	             {  
	                if(logger.isDebugEnabled()) logger.debug("err = " + e1.getMessage());  
	                 e1.printStackTrace();  
	            }  
	        }  
	         
	         return factory;  

	 }

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}
}
