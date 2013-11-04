package com.phoenix.mvc.db.entities.exam;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="examtype")
public class ExamType {

	@Id
	private String examTypeCode;
	
	@Column(nullable=false)
	private String examTypeName;

	
	// Lower
	@OneToMany(targetEntity=Exam.class, mappedBy="examType", cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	private List<Exam> exams;


	
	
	public String getExamTypeCode() {
		return examTypeCode;
	}
	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
}
