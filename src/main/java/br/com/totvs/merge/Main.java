
package br.com.totvs.merge;

import com.beust.jcommander.JCommander;


public class Main {

	public static void main(String[] args) throws Exception {

		CommandLineParams commandLineParams = new CommandLineParams();
		JCommander jCommander = new JCommander(commandLineParams, args);

		if (commandLineParams.help) {
			jCommander.usage();
			System.exit(1);
		}
		
		

	}
}