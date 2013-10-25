package com.phoenix.mvc.db.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class ExamPart {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="partId")
	@TableGenerator(name="partId", table="pkExamPart", pkColumnName="partKey", pkColumnValue="partValue", allocationSize=1)
	private int partId;
	
	@Column(nullable=false)
	private int partIdInMasterPart;
	
	@Column(nullable=false)
	private String partName;
	
	@Basic
	private int suggestedTime;
	
	@Column(nullable=false)
	private boolean timeRestricted;
	
	// Upper
	@ManyToOne
	@JoinColumn(name="masterPartId")
	private ExamMasterPart examMasterPart;
	
	// Lower
	@OneToMany(targetEntity=Question.class, mappedBy="examPart", cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	private List<Question> questions;

	
	
	
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public int getPartIdInMasterPart() {
		return partIdInMasterPart;
	}
	public void setPartIdInMasterPart(int partIdInExam) {
		this.partIdInMasterPart = partIdInExam;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getSuggestedTime() {
		return suggestedTime;
	}
	public void setSuggestedTime(int suggestedTime) {
		this.suggestedTime = suggestedTime;
	}
	public boolean isTimeRestricted() {
		return timeRestricted;
	}
	public void setTimeRestricted(boolean timeRestricted) {
		this.timeRestricted = timeRestricted;
	}
	public ExamMasterPart getExamMasterPart() {
		return examMasterPart;
	}
	public void setExamMasterPart(ExamMasterPart examMasterPart) {
		this.examMasterPart = examMasterPart;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
