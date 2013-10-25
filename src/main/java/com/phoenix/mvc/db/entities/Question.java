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
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="questionId")
	@TableGenerator(name="questionId", table="pkQuestion", pkColumnName="questionKey", pkColumnValue="questionValue", allocationSize=1)
	private int questionId;
	
	@Column(nullable=false)
	private int questionIdInExam;
	
	@Column(nullable=false)
	private String questionText;
	
	@Basic
	private String questionImage;
	
	@Column(nullable=false)
	private String correctChoice;
	
	
	// Upper
	@ManyToOne
	@JoinColumn(name="partId")
	private ExamPart examPart;
	
	// Lower
	@OneToMany(targetEntity=Choice.class, mappedBy="question", cascade=CascadeType.ALL/*, fetch=FetchType.EAGER*/)
	private List<Choice> choices;

	
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuestionIdInExam() {
		return questionIdInExam;
	}
	public void setQuestionIdInExam(int questionIdExam) {
		this.questionIdInExam = questionIdExam;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getQuestionImage() {
		return questionImage;
	}
	public void setQuestionImage(String questionImage) {
		this.questionImage = questionImage;
	}
	public String getCorrectChoice() {
		return correctChoice;
	}
	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}
	public ExamPart getExamPart() {
		return examPart;
	}
	public void setExamPart(ExamPart examPart) {
		this.examPart = examPart;
	}
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
}
