/**
 * 
 */
package com.learn.rp.section3;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * @author kishore
 *
 */
public class NameProducer implements Consumer<FluxSink<String>> {

	public NameProducer() {

	}

	private FluxSink<String> strFluxSink;

	public void accept(reactor.core.publisher.FluxSink<String> fluxSink) {
		this.strFluxSink = fluxSink;
	}

	public void produce() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(10);

		Flux.interval(Duration.ofSeconds(1)).map(second -> LamdaUtil.FAKER.country().name()).subscribe(countryName -> {
			this.strFluxSink.next(countryName);
			if (countryName.equalsIgnoreCase("canada")) {
				this.strFluxSink.complete();
			}
			latch.countDown();
		});

		latch.await();
	}
}
