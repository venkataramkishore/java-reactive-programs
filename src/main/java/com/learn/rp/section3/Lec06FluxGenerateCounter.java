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
public class Lec06FluxGenerateCounter {

	public static void main(String[] args) {
		// This is thread safe
		Flux.generate(
				() -> 1,
				(counter, synchrnousSink) -> {
					
					String countryName = LamdaUtil.FAKER.country().name();
					System.out.println("Emitting " + countryName);
					synchrnousSink.next(counter + ". " +countryName);
					
					if(countryName.toLowerCase().equals("canada") || counter < 10) {
						synchrnousSink.complete();
					}
					return counter + 1;
				}).subscribe(LamdaUtil.getSubscriber("Counter"));
	}
}
