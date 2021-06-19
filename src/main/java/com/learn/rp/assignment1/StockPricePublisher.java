/**
 * 
 */
package com.learn.rp.assignment1;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class StockPricePublisher {

	public static Flux<Integer> getStockPublisher() {
		AtomicInteger stockPrice = new AtomicInteger(100);
		
		return Flux.interval(Duration.ofSeconds(1))
		.map(price -> stockPrice.getAndAccumulate(LamdaUtil.FAKER.random().nextInt(-5, 5), 
				Integer::sum));
	}
}
