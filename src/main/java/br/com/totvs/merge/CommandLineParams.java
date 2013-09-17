package br.com.totvs.merge;

import com.beust.jcommander.Parameter;

public class CommandLineParams {

	@Parameter(names = { "-h", "-help" }, description = "This info message.", help = true)
	public boolean help;

	@Parameter(names = { "-s", "-setup" }, description = "Generate file configuration default")
	public boolean setup = false;

	@Parameter(names = { "-j", "-generate-jira-stats" }, description = "Generate file csv jira")
	public boolean generateJiraStats = false;
	
	@Parameter(names = { "-v", "-generate-svn-stats" }, description = "Generate file csv svn")
	public boolean generateSvnStats = false;
	
	@Parameter(names = { "-a", "-generate-all" }, description = "Generate file csv jira+svn")
	public boolean generateAll = false;

}