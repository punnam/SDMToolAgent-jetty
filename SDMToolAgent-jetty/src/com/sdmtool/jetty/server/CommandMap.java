package com.sdmtool.jetty.server;

public class CommandMap {
	private int portNum;
	private String contextRoot;
	private String warFile;
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public String getContextRoot() {
		return contextRoot;
	}
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}
	public String getWarFile() {
		return warFile;
	}
	public void setWarFileLocation(String warFile) {
		this.warFile = warFile;
	}
}
