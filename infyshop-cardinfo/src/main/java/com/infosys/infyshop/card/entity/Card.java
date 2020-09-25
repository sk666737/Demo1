package com.infosys.infyshop.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	Long cardNumber;
	@Column(nullable=false)
	String email;
	@Column(nullable=false)
	String nameOnCard;
	@Column(nullable=false)
	Integer expiryMonth;
	@Column(nullable=false)
	Long expiryYear;
	
	public Card() {
		super();
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Integer getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public Long getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(Long expiryYear) {
		this.expiryYear = expiryYear;
	}
}
