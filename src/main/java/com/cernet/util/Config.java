package com.cernet.util;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Config {

    private static ResourceBundle labels = null;
       
    static {
        try {
        	labels = ResourceBundle.getBundle("config");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error("[ERROR]:NO \"config.properties\" found!");
        }
    }

    public static Enumeration getKeys() {
        return labels.getKeys();
    }

    public static String getValue(String key) {
        try {
            return (String)labels.getObject(key);
        } catch (Exception ex) {
        	
            return null;
        }
    }

}
