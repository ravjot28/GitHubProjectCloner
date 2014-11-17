package orm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Commit_Details")
public class CommitDetails {
	@Id
	@GeneratedValue(generator = "CommitDetails_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "CommitDetails_seq", name = "CommitDetails_seq")
	@Column(name="commit_id")
	private int id;
	@Lob
	private String message;
	@Column(length = 4000)
	private String author;
	@Column(length = 4000)
	private String authorEmailAddress;
	private Date authorDate;
	@Column(length = 4000)
	private String committer;
	@Column(length = 4000)
	private String committerEmailAddress;
	private Date committerDate;
	@Column(length = 4000)
	private String sha;
	@Column(length = 4000)
	private String parentSha;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commitDetails")
	private List<FileCommitDetails> list = new ArrayList<FileCommitDetails>();

	@ManyToOne
	@JoinColumn(name = "project_id")
	private GithubProjects project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorEmailAddress() {
		return authorEmailAddress;
	}

	public void setAuthorEmailAddress(String authorEmailAddress) {
		this.authorEmailAddress = authorEmailAddress;
	}

	public String getCommitter() {
		return committer;
	}

	public void setCommitter(String committer) {
		this.committer = committer;
	}

	public String getCommitterEmailAddress() {
		return committerEmailAddress;
	}

	public void setCommitterEmailAddress(String committerEmailAddress) {
		this.committerEmailAddress = committerEmailAddress;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public String getParentSha() {
		return parentSha;
	}

	public void setParentSha(String parentSha) {
		this.parentSha = parentSha;
	}

	public Date getAuthorDate() {
		return authorDate;
	}

	public void setAuthorDate(Date authorDate) {
		this.authorDate = authorDate;
	}

	public Date getCommitterDate() {
		return committerDate;
	}

	public void setCommitterDate(Date committerDate) {
		this.committerDate = committerDate;
	}

	public GithubProjects getProject() {
		return project;
	}

	public void setProject(GithubProjects project) {
		this.project = project;
	}

	public List<FileCommitDetails> getList() {
		return list;
	}

	public void setList(List<FileCommitDetails> list) {
		this.list = list;
	}
	
	

}
