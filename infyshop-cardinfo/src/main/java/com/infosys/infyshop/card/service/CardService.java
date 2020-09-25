package com.infosys.infyshop.card.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.card.dto.CardDTO;
import com.infosys.infyshop.card.entity.Card;
import com.infosys.infyshop.card.repository.CardRepository;

@Service
public class CardService {
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CardRepository cardRepository;
	//Add Card
	public ResponseEntity<Card> addCard(String userId, CardDTO cardDTO) {
		logger.info("Add card request of user {}", cardDTO);
		cardDTO.setEmail(userId);
		Card card = cardDTO.createEntity();
		return ResponseEntity.ok().body(cardRepository.save(card));
	}
	
	//View Card
	public List<CardDTO> viewCards(String userId) {
		logger.info("View card request of user {}", userId);
		List<CardDTO> cardDTOList = new ArrayList<>();
		List<Card> cardList= cardRepository.getByEmail(userId);
		for(Card card : cardList) {
			cardDTOList.add(CardDTO.valueOf(card));
		}
		logger.info("View Card of users {}", cardDTOList);
		return cardDTOList;
	}
	
	//Delete Card
	public ResponseEntity<String> deleteCard(String userId, Long cardNumber) {
		logger.info("Delete card request of user {}", userId, cardNumber);
		cardRepository.deleteById(cardNumber);
		return ResponseEntity.ok("Deleted");
	}
}
