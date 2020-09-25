package com.infosys.infyshop.card.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.infyshop.card.dto.CardDTO;
import com.infosys.infyshop.card.entity.Card;
import com.infosys.infyshop.card.service.CardService;

@RestController
@CrossOrigin
public class CardController {
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CardService cardService;
	
	@PostMapping(value="/{userId}/card/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> addCard(@PathVariable String userId, @RequestBody CardDTO cardDTO) {
		logger.info("Add card request of user {}", cardDTO);
		return cardService.addCard(userId, cardDTO);
	}
	@GetMapping(value="/{userId}/cards", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CardDTO> viewCards(@PathVariable String userId) {
		logger.info("View cards request of user {}", userId);
		return cardService.viewCards(userId);
	}
	@DeleteMapping(value="/{userId}/card/{cardNumber}/delete")
	public ResponseEntity<String> deleteCard(@PathVariable String userId, @PathVariable Long cardNumber) {
		logger.info("Delete card request of user {}", userId, cardNumber);
		return cardService.deleteCard(userId, cardNumber);
	}
}
