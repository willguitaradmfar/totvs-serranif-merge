package br.com.totvs.merge;

public class Join {
	private String lineSVN;
	private String lineJira;
	
	public static final String UNDEFINED = "UNDEFINED";
	public static final String SPLIT = ";";
	public static final int POSICAO_ISSUE_JIRA_CSV = 1;
	public static final int POSICAO_USER_JIRA_CSV = 2;	
	
	public static final int POSICAO_ISSUE_SVN_CSV = 1;
	public static final int POSICAO_USER_SVN_CSV = 0;
	private static final int QTDE_CAMPOS_SVN = 7;
	private static final int QTDE_CAMPOS_JIRA = 8;
	
	
	private String project = UNDEFINED;
	private String user = UNDEFINED;
	private String issue = UNDEFINED;
	private String rework = UNDEFINED;
	private String currstatus = UNDEFINED;
	private String date_worklog = UNDEFINED;
	private String sum_worklog = UNDEFINED;
	private String review = UNDEFINED;
	private String date_review = UNDEFINED;
	private String file_dir = UNDEFINED;
	private String LOC_I = UNDEFINED;
	private String LOC_D = UNDEFINED;

	public Join(String lineSVN, String lineJira) {
		super();		
		this.lineSVN = lineSVN;
		this.lineJira = lineJira;			
	}
	
	public void tranforme(){
		
		String[] camposJira = lineJira.split(SPLIT);
		if(camposJira.length == QTDE_CAMPOS_JIRA){
			setProject(camposJira[0]);
			setUser(camposJira[POSICAO_USER_JIRA_CSV]);
			setIssue(camposJira[POSICAO_ISSUE_JIRA_CSV]);		
			setRework(camposJira[4]);
			setCurrstatus(camposJira[5]);
			setDate_worklog(camposJira[7]);
			setSum_worklog(camposJira[6]);
		}
		
		String[] camposSVN = lineSVN.split(SPLIT);
		if(camposSVN.length == QTDE_CAMPOS_SVN){
			setReview(camposSVN[2]);
			setDate_review(camposSVN[3]);
			setFile_dir(camposSVN[4]);
			setLOC_I(camposSVN[5]);
			setLOC_D(camposSVN[6]);
			
			if(getIssue().equals(UNDEFINED)){
				setIssue(camposSVN[POSICAO_ISSUE_SVN_CSV]);				
			}
			if(getUser().equals(UNDEFINED)){
				setUser(camposSVN[POSICAO_USER_SVN_CSV]);				
			}
		}
		
		
		
	}

	public String getLineSVN() {
		return lineSVN;
	}

	public void setLineSVN(String lineSVN) {
		this.lineSVN = lineSVN;
	}

	public String getLineJira() {
		return lineJira;
	}

	public void setLineJira(String lineJira) {
		this.lineJira = lineJira;
	}
	
	@Override
	public String toString() {		
		return "\nSVN::"+lineSVN+" \nJIRA::"+lineJira;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getRework() {
		return rework;
	}

	public void setRework(String rework) {
		this.rework = rework;
	}

	public String getCurrstatus() {
		return currstatus;
	}

	public void setCurrstatus(String currstatus) {
		this.currstatus = currstatus;
	}

	public String getDate_worklog() {
		return date_worklog;
	}

	public void setDate_worklog(String date_worklog) {
		this.date_worklog = date_worklog;
	}

	public String getSum_worklog() {
		return sum_worklog;
	}

	public void setSum_worklog(String sum_worklog) {
		this.sum_worklog = sum_worklog;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate_review() {
		return date_review;
	}

	public void setDate_review(String date_review) {
		this.date_review = date_review;
	}

	public String getFile_dir() {
		return file_dir;
	}

	public void setFile_dir(String file_dir) {
		this.file_dir = file_dir;
	}

	public String getLOC_I() {
		return LOC_I;
	}

	public void setLOC_I(String lOC_I) {
		LOC_I = lOC_I;
	}

	public String getLOC_D() {
		return LOC_D;
	}

	public void setLOC_D(String lOC_D) {
		LOC_D = lOC_D;
	}

	public static int getPosicaoIssueJiraCsv() {
		return POSICAO_ISSUE_JIRA_CSV;
	}
	
	

}
