package com.infosys.infyshop.card.dto;

import com.infosys.infyshop.card.entity.Card;

public class CardDTO {
	
	Long cardNumber;
	String email;
	String nameOnCard;
	Integer expiryMonth;
	Long expiryYear;
	
	public CardDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "CardDTO [cardNumber=" + cardNumber + ", email=" + email + ", nameOnCard=" + nameOnCard
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + "]";
	}
	
	public static CardDTO valueOf(Card card) {
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardNumber(card.getCardNumber());
		cardDTO.setEmail(card.getEmail());
		cardDTO.setNameOnCard(card.getNameOnCard());
		cardDTO.setExpiryMonth(card.getExpiryMonth());
		cardDTO.setExpiryYear(card.getExpiryYear());
		return cardDTO;
	}
	
	public Card createEntity() {
		Card card = new Card();
		card.setCardNumber(this.getCardNumber());
		card.setEmail(this.getEmail());
		card.setNameOnCard(this.getNameOnCard());
		card.setExpiryMonth(this.getExpiryMonth());
		card.setExpiryYear(this.getExpiryYear());
		return card;
	}
}
