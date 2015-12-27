package com.sdmtool.jetty.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandCli {
	private static final Logger log = Logger.getLogger(CommandCli.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public CommandCli(String[] args) {

		this.args = args;
		options.addOption("h", "help", false, "show help.");
		options.addOption("p", "port", true, "Port Number");
		options.addOption("c", "contextRoot", true, "Context Root Of Application");
		options.addOption("w", "war", true, "WAR file name with location");
		options.addOption("s", "server", false, "SDM Server URL");
		
	}

	public CommandMap parse() {
		CommandMap command = new CommandMap(); 
		CommandLineParser parser = new BasicParser();

		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("h"))
				help();

			if (cmd.hasOption("p")) {
				log.log(Level.INFO, "Using argument -p=" + cmd.getOptionValue("p"));
				String portNumber = cmd.getOptionValue("p");
				try{
					int portNumInt = Integer.parseInt(portNumber);
					command.setPortNum(portNumInt);
				}catch(Exception e){
					log.log(Level.SEVERE, "Missing p (Port number), must be number.");
					help();
				}
				
			} else {
				log.log(Level.SEVERE, "Missing p (Port number)");
				help();
			}
			if (cmd.hasOption("c")) {
				log.log(Level.INFO, "Using argument -c=" + cmd.getOptionValue("c"));
				String contextRoot = cmd.getOptionValue("c");
				command.setContextRoot(contextRoot);
			} else {
				log.log(Level.SEVERE, "Missing c (Context Root)");
				help();
			}
			if (cmd.hasOption("w")) {
				log.log(Level.INFO, "Using argument -w=" + cmd.getOptionValue("w"));
				String warFileLocation = cmd.getOptionValue("w");
				command.setWarFileLocation(warFileLocation);
			} else {
				log.log(Level.SEVERE, "Missing w (WAR file)");
				help();
			}
			if (cmd.hasOption("s")) {
				log.log(Level.INFO, "Using argument -s=" + cmd.getOptionValue("s"));
				String serverurl = cmd.getOptionValue("s");
				command.setSdmServerUrl(serverurl);
			} 
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}
		return command;
	}

	private void help() {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp("Main", options);
		System.exit(0);
	}
}
