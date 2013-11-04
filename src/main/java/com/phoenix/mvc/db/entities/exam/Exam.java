package com.phoenix.mvc.db.entities.exam;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="examId")
	@TableGenerator(name="examId", table="pkExam", pkColumnName="examKey", pkColumnValue="examValue", allocationSize=1)
	private int examId;
	
	@Column(nullable=false)
	private String year;
	
	@Column(nullable=false)
	private int idInYear;
	
	@Basic
	private String idName;
	
	@Column(nullable=false)
	private int timeLimit;
	
	@Column(nullable=false)
	private int nbQuestions;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Calendar actualExamDate;
	
	@Basic
	private double actualAvgPoints;

	// Upper
	@ManyToOne
	@JoinColumn(name="examTypeCode")
	private ExamType examType;
	
	// Lower
	@OneToMany(targetEntity=ExamMasterPart.class, mappedBy="exam", cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	private List<ExamMasterPart> examMasterParts;

	
	
	
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getIdInYear() {
		return idInYear;
	}
	public void setIdInYear(int idInYear) {
		this.idInYear = idInYear;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getNbQuestions() {
		return nbQuestions;
	}
	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}
	public Calendar getActualExamDate() {
		return actualExamDate;
	}
	public void setActualExamDate(Calendar actualExamDate) {
		this.actualExamDate = actualExamDate;
	}
	public double getActualAvgPoints() {
		return actualAvgPoints;
	}
	public void setActualAvgPoints(double actualAvgPoints) {
		this.actualAvgPoints = actualAvgPoints;
	}
	public ExamType getExamType() {
		return examType;
	}
	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	public List<ExamMasterPart> getExamMasterParts() {
		return examMasterParts;
	}
	public void setExamMasterParts(List<ExamMasterPart> examMasterParts) {
		this.examMasterParts = examMasterParts;
	}
}
