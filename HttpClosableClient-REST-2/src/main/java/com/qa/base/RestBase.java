package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RestBase {
	
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;
	
	 public static Properties  prop;
	 public static FileInputStream  fis;
	 public String PropertiesFilepath = "\\src\\main\\java\\com\\qa\\config\\config.properties";
	
	public RestBase()  {
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+PropertiesFilepath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
