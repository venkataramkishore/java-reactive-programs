package com.learn.rp.section3;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(10);

		// This is thread safe method to handle all threads
		Flux.create(fluxSink -> {

			Flux.interval(Duration.ofSeconds(1)).map(second -> LamdaUtil.FAKER.country().name())
					.subscribe(countryName -> {
						fluxSink.next(countryName);
						if (countryName.equalsIgnoreCase("canada")) {
							fluxSink.complete();
						}
						latch.countDown();
					});

		}).subscribe(LamdaUtil.getSubscriber());
		latch.await();
	}
}
