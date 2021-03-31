package com.qa.rest.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.RestBase;
import com.qa.restclient.RestClient;


public class APITest  extends RestBase {
     RestBase rb;
	 String serviceUrl;
	 String apiUrl;
	 String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse ;
	
	
	@BeforeMethod
	public  void setUp() throws ClientProtocolException, IOException{
		
		
		rb = new RestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		
		url = serviceUrl + apiUrl;
		
	}
	
	@Test(priority=1)
	public  void getAPITestWithoutHeaders() throws ClientProtocolException, IOException  {
		restClient = new RestClient();
		closebaleHttpResponse = restClient.get(url);
	//a StatusCode
		
			int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
			//System.out.println("Status Code--->"+ statusCode);
			Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200);
		
		
		//b JSON String
		
		String responseString = EntityUtils.toString( closebaleHttpResponse.getEntity(),"UTF-8");
		JSONObject  responseJson  = new JSONObject(responseString);
		System.out.println("ResponseJSON---->"+responseJson);
		
		
		//All Headers
		
		Header[] headerArray =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders  = new HashMap<String, String>();
		
		for(Header  header: headerArray) {
			allHeaders.put(header.getName(),header.getValue());
		}
 		System.out.println("Header array---->"+allHeaders);
	}
}
