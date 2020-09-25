package com.infosys.infyshop.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.infyshop.card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long>{
	List<Card> getByEmail(String email);
}
