package orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "File_Commit_Details")
public class FileCommitDetails {
	@Id
	@GeneratedValue(generator = "FileCommitDetails_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "FileCommitDetails_seq", name = "FileCommitDetails_seq")
	private int id;
	@Column(length = 4000)
	private String fileName;
	private int linesAdded;
	private int linesChanged;
	private int linesRemoved;
	@Lob
	private String patch;
	@ManyToOne
	@JoinColumn(name = "commit_id")
	private CommitDetails commitDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getLinesAdded() {
		return linesAdded;
	}

	public void setLinesAdded(int linesAdded) {
		this.linesAdded = linesAdded;
	}

	public int getLinesChanged() {
		return linesChanged;
	}

	public void setLinesChanged(int linesChanged) {
		this.linesChanged = linesChanged;
	}

	public int getLinesRemoved() {
		return linesRemoved;
	}

	public void setLinesRemoved(int linesRemoved) {
		this.linesRemoved = linesRemoved;
	}

	public String getPatch() {
		return patch;
	}

	public void setPatch(String patch) {
		this.patch = patch;
	}

	public CommitDetails getCommitDetails() {
		return commitDetails;
	}

	public void setCommitDetails(CommitDetails commitDetails) {
		this.commitDetails = commitDetails;
	}

}
