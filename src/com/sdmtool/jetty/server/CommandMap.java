package com.sdmtool.jetty.server;

public class CommandMap {
	private int portNum;
	private String contextRoot;
	private String warFile;
	private String sdmServerUrl;
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
	public String getSdmServerUrl() {
		return sdmServerUrl;
	}
	public void setSdmServerUrl(String sdmServerUrl) {
		this.sdmServerUrl = sdmServerUrl;
	}
}
