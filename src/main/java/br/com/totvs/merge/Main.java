package br.com.totvs.merge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

import org.apache.log4j.Logger;

import com.beust.jcommander.JCommander;

public class Main {

	public static void main(String[] args) throws Exception {

		Logger logger = Logger.getLogger(Main.class);

		Mapa mapa = new Mapa();

		CommandLineParams commandLineParams = new CommandLineParams();
		JCommander jCommander = new JCommander(commandLineParams, args);

		if (commandLineParams.help) {
			jCommander.usage();
			System.exit(1);
		}

		FileReader arqSVN = new FileReader(commandLineParams.svnCSV);
		BufferedReader lerArqSVN = new BufferedReader(arqSVN);
		String linhaSvn;
		while ((linhaSvn = lerArqSVN.readLine()) != null){
			mapa.addSVN(linhaSvn);
			linhaSvn = lerArqSVN.readLine();			
		}

		FileReader arqJira = new FileReader(commandLineParams.jiraCSV);
		BufferedReader lerArqJira = new BufferedReader(arqJira);
		String linhaJira;
		while ((linhaJira = lerArqJira.readLine()) != null){		
			mapa.addJira(linhaJira);			
			linhaJira = lerArqJira.readLine();			
		}

		//System.out.println(mapa.getMap());
		System.out.println("project ; user ; issue ; rework ; currstatus ; date_worklog ; sum_worklog ; review ; date_review ; file/dir ; LOC:I ; LOC:D");
		Set<String> chaves = mapa.getMap().keySet();
		for (String chave : chaves) {
			if (chave != null){
				
				Join join = mapa.getMap().get(chave);
				join.tranforme();
				
				
				System.out.println(join.getProject()+Join.SPLIT
							+join.getUser()+Join.SPLIT
							+join.getIssue()+Join.SPLIT
							+join.getRework()+Join.SPLIT
							+join.getCurrstatus()+Join.SPLIT
							+join.getDate_worklog()+Join.SPLIT
							+join.getSum_worklog()+Join.SPLIT
							+join.getReview()+Join.SPLIT
							+join.getDate_review()+Join.SPLIT
							+join.getFile_dir()+Join.SPLIT
							+join.getLOC_I()+Join.SPLIT
							+join.getLOC_D()						
							);
				
			}
		}

	}
}