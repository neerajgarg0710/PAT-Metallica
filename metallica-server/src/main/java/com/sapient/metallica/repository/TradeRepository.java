package com.sapient.metallica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.Trade;

public interface TradeRepository extends MongoRepository<Trade, Long>{
	
	List<Trade> findByCommodity(Commodity commodity);

}
