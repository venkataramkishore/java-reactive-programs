/**
 * 
 */
package com.learn.rp.section3;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec04FluxCreateIssueFix {

	public static void main(String[] args) throws InterruptedException {
		
		Flux.create(fluxSink -> {
			String countryName;
			do {
				countryName = LamdaUtil.FAKER.country().name();
				System.out.println("Emitting : "+ countryName);
				fluxSink.next(countryName);

			} while (!countryName.toLowerCase().equals("canada") && !fluxSink.isCancelled());
		})
		.take(3)
		.subscribe(LamdaUtil.getSubscriber());

	}
}
