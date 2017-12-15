package com.sapient.metallica.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.sapient.metallica.beans.Trade;

@Component
@RepositoryEventHandler(Trade.class)
public class TradeEventHandler {

	private final SimpMessagingTemplate websocket;
	private final EntityLinks entityLinks;

	@Autowired
	public TradeEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
		this.websocket = websocket;
		this.entityLinks = entityLinks;
	}

	@HandleAfterCreate
	public void newTrade(Trade trade) {
		this.websocket.convertAndSend("/newTrade", getPath(trade));
	}

	@HandleAfterSave
	public void updateTrade(Trade trade) {
		this.websocket.convertAndSend("/updateTrade", getPath(trade));
	}

	private String getPath(Trade trade) {
		return this.entityLinks.linkForSingleResource(trade.getClass(), trade.getTradeId()).toUri().getPath();
	}
}
