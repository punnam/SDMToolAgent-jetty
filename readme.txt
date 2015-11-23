Step 1. go to on command line  C:\Users\Administrator\workspace\SDMToolBinaries

Step 2: execute following command from command line
javaw -cp SDMToolServerJetty.jar com.sdmtool.jetty.server.SDMToolServer -c SDMTool -p 8080 -w SDMToolServer-0.0.1-SNAPSHOT.war

Step 3: execute following command from command line
javaw -cp SDMToolAgentJetty.jar com.sdmtool.jetty.server.SDMToolAgent -c SDMToolAgent -p 9080 -w SDMToolAgent-0.0.1-SNAPSHOT.war

Step 4: run following url
http://localhost:8080/SDMTool/index.html#/

Step 5: run following urls
http://localhost:9080/SDMToolAgent/index.html#/

