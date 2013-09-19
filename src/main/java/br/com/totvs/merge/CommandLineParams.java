package br.com.totvs.merge;

import com.beust.jcommander.Parameter;

public class CommandLineParams {

	@Parameter(names = { "-h", "-help" }, description = "Ajuda", help = true)
	public boolean help;

	@Parameter(names = { "-j", "-jira" }, description = "Arquivo CSV gerado do jira")
	public String jiraCSV;
	
	@Parameter(names = { "-s", "-svn" }, description = "Arquivo CSV gerado do svn")
	public String svnCSV;

}