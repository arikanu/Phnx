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
public class ExamMasterPart {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="masterPartId")
	@TableGenerator(name="masterPartId", table="pkExamMasterPart", pkColumnName="masterPartKey", pkColumnValue="masterPartValue", allocationSize=1)
	private int masterPartId;
	
	@Column(nullable=false)
	private int idInExam;
	
	@Column(nullable=false)
	private String masterPartName;
	
	@Basic
	private int suggestedTime;
	
	@Column(nullable=false)
	private boolean timeRestricted;
	
	
	// Upper
	@ManyToOne
	@JoinColumn(name="examId")
	private Exam exam;
	
	// Lower
	@OneToMany(targetEntity=ExamPart.class, mappedBy="examMasterPart", cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	private List<ExamPart> examParts;

	
	
	public int getMasterPartId() {
		return masterPartId;
	}
	public void setMasterPartId(int masterPartId) {
		this.masterPartId = masterPartId;
	}
	public int getIdInExam() {
		return idInExam;
	}
	public void setIdInExam(int idInExam) {
		this.idInExam = idInExam;
	}
	public String getMasterPartName() {
		return masterPartName;
	}
	public void setMasterPartName(String masterPartName) {
		this.masterPartName = masterPartName;
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
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public List<ExamPart> getExamParts() {
		return examParts;
	}
	public void setExamParts(List<ExamPart> examParts) {
		this.examParts = examParts;
	}
}
