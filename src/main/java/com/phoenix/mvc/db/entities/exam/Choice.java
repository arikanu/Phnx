package com.phoenix.mvc.db.entities.exam;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="choiceId")
	@TableGenerator(name="choiceId", table="pkChoice", pkColumnName="choiceKey", pkColumnValue="choiceValue", allocationSize=1)
	private int choiceId;
	
	@Column(nullable=false)
	private String choiceLabel;
	
	@Column(nullable=false)
	private String choiceText;
	
	@Basic
	private String choiceImage;
	
	@Column(nullable=false)
	private boolean correctAnswer;
	
	
	// Upper
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;

	
	
	
	
	public int getChoiceId() {
		return choiceId;
	}
	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}
	public String getChoiceLabel() {
		return choiceLabel;
	}
	public void setChoiceLabel(String choiceLabel) {
		this.choiceLabel = choiceLabel;
	}
	public String getChoiceText() {
		return choiceText;
	}
	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}
	public String getChoiceImage() {
		return choiceImage;
	}
	public void setChoiceImage(String choiceImage) {
		this.choiceImage = choiceImage;
	}
	public boolean isCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
