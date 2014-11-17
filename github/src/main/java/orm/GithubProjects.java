package orm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GitHub_Projects")
public class GithubProjects {
	@Id
	@GeneratedValue(generator = "javaID_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "javaID_seq", name = "javaID_seq")
	@Column(name = "project_id")
	private int id;
	@Column(length = 4000)
	private String repositoryURL;
	@Column(length = 4000)
	private String fileURL;
	private String language;
	private int noOfPullRequest;
	private int noOfOpenIssues;
	private int noOfCollaborators;
	private int noOfCommits;
	private int noOfForks;
	private int noOfReleases;
	@Lob
	private String languagesUsed;
	@OneToMany(mappedBy = "project")
	private List<CommitDetails> list = new ArrayList<CommitDetails>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRepositoryURL() {
		return repositoryURL;
	}

	public void setRepositoryURL(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<CommitDetails> getList() {
		return list;
	}

	public void setList(List<CommitDetails> list) {
		this.list = list;
	}

	public int getNoOfPullRequest() {
		return noOfPullRequest;
	}

	public void setNoOfPullRequest(int noOfPullRequest) {
		this.noOfPullRequest = noOfPullRequest;
	}

	public int getNoOfOpenIssues() {
		return noOfOpenIssues;
	}

	public void setNoOfOpenIssues(int noOfOpenIssues) {
		this.noOfOpenIssues = noOfOpenIssues;
	}

	public int getNoOfCollaborators() {
		return noOfCollaborators;
	}

	public void setNoOfCollaborators(int noOfCollaborators) {
		this.noOfCollaborators = noOfCollaborators;
	}

	public int getNoOfCommits() {
		return noOfCommits;
	}

	public void setNoOfCommits(int noOfCommits) {
		this.noOfCommits = noOfCommits;
	}

	public int getNoOfForks() {
		return noOfForks;
	}

	public void setNoOfForks(int noOfForks) {
		this.noOfForks = noOfForks;
	}

	public String getLanguagesUsed() {
		return languagesUsed;
	}

	public void setLanguagesUsed(String languagesUsed) {
		this.languagesUsed = languagesUsed;
	}

	public int getNoOfReleases() {
		return noOfReleases;
	}

	public void setNoOfReleases(int noOfReleases) {
		this.noOfReleases = noOfReleases;
	}

}
