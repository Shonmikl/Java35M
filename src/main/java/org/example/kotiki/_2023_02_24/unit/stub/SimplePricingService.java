package org.example.kotiki._2023_02_24.unit.stub;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

@AllArgsConstructor
public class SimplePricingService implements PricingService {

	PricingRepository repository;

	@Override
	public Price getHighestPricedTrade(Collection<Trade> trades) {
		Trade[] tradesArr = trades.toArray(new Trade[0]);
		Comparator<Trade> comp =
				Comparator.comparingDouble(t -> t.price.getAmount());
		Arrays.sort(tradesArr, comp);
		return tradesArr[tradesArr.length - 1].price;
	}
	// [... other overridden methods from PricingService interface...]
}