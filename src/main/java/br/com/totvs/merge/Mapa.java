package br.com.totvs.merge;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

	private Map<String, Join> map = new HashMap<String, Join>();	

	public Map<String, Join> getMap() {
		return map;
	}

	public void setMap(Map<String, Join> map) {
		this.map = map;
	}
	
	public void addSVN(String line){		
		String[] svn = line.split(Join.SPLIT);
		String issueSvn = svn[Join.POSICAO_ISSUE_SVN_CSV];
		String userSvn = svn[Join.POSICAO_USER_SVN_CSV];
		String key = issueSvn+"::"+userSvn;
		Join join = map.get(key);		
		if(join == null){
			join = new Join(line, "");
		}else{
			join.setLineSVN(line);
		}
		
		map.put(key, join);		
		
	}
	
	public void addJira(String line){
		String[] jira = line.split(Join.SPLIT);
		String issueJira = jira[Join.POSICAO_ISSUE_JIRA_CSV];
		String userJira = jira[Join.POSICAO_USER_JIRA_CSV];
		String key = issueJira+"::"+userJira;
		Join join = map.get(key);		
		if(join == null){
			join = new Join("", line);
		}else{
			join.setLineJira(line);
		}
		map.put(key, join);
		
		
	}

}
