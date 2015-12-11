package com.sdmtool.jetty.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class SDMToolAgent {
	public static void main(String[] args) throws Exception {
		CommandMap commandMap = new CommandCli(args).parse();

		sendPost(commandMap);
	}

	private static void sendPost(CommandMap commandMap) throws Exception {

		String POST_URL = "http://localhost:" + commandMap.getPortNum() + "/" + commandMap.getContextRoot();

		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost();
		URIBuilder builder = new URIBuilder(POST_URL+"/rest/setUrl/");
		
		post.setURI(builder.build());
		//+ "/rest/setSDMToolServerUrl"
		//InetAddress.getLocalHost().getHostAddress()
		// add header
		String USER_AGENT = "Mozilla/5.0";
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("SdmServerUrl", commandMap.getSdmServerUrl()));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + POST_URL);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + 
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}
}
