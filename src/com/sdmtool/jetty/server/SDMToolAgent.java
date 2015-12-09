package com.sdmtool.jetty.server;

//

//========================================================================
//Copyright (c) 1995-2015 Mort Bay Consulting Pty. Ltd.
//------------------------------------------------------------------------
//All rights reserved. This program and the accompanying materials
//are made available under the terms of the Eclipse Public License v1.0
//and Apache License v2.0 which accompanies this distribution.
//
//  The Eclipse Public License is available at
//  http://www.eclipse.org/legal/epl-v10.html
//
//  The Apache License v2.0 is available at
//  http://www.opensource.org/licenses/apache2.0.php
//
//You may elect to redistribute this code under either of these licenses.
//========================================================================
//

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SDMToolAgent {
	public static void main(String[] args) throws Exception {
		CommandMap commandMap = new CommandCli(args).parse();

        setServerUrl(commandMap);
      }
  	private static String setServerUrl(CommandMap commandMap) throws IOException {
  		   //String POST_URL ="http://localhost:8080/SDMToolAgent/rest/executeCommand/"; 
  		   //String POST_URL =commandMap"http://localhost:8080/SDMToolAgent/rest/executeCommand/";
  		
  		   String POST_URL = "http://localhost:"+commandMap.getPortNum() + "/" + commandMap.getContextRoot()+ "/rest/setSDMToolServerUrl/";
  		   System.out.println(POST_URL);
  		   CloseableHttpClient client = HttpClients.createDefault();
  		    HttpPost httpPost = new HttpPost(POST_URL);
  		    StringEntity entity = new StringEntity(commandMap.getSdmServerUrl());
  		    httpPost.setEntity(entity);
  		    //httpPost.setHeader("Accept", "application/json");
  		    //httpPost.setHeader("Content-type", "application/json");
  		 
  		    CloseableHttpResponse response = client.execute(httpPost);
  		    System.out.println(response.getStatusLine().getStatusCode());
  		    System.out.println(response.getStatusLine().getReasonPhrase());
  		    client.close();
  		    return "executed";
      }
}
