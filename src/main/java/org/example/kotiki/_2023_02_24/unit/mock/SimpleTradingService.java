package org.example.kotiki._2023_02_24.unit.mock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SimpleTradingService implements TradingService {

	TradeRepository tradeRepository;
	AuditService auditService;

	@Override
	public Long createTrade(Trade trade) throws CreateTradeException {
		Long id = tradeRepository.createTrade(trade);
		auditService.logNewTrade(trade);
		return id;
	}
}