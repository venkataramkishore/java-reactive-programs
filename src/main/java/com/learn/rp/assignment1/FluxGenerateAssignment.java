/**
 * 
 */
package com.learn.rp.assignment1;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class FluxGenerateAssignment {

	public static void main(String[] args) {
		Flux.generate(synchrnousSink -> {
			String countryName = LamdaUtil.FAKER.country().name();
			synchrnousSink.next(countryName);
			
			if(countryName.toLowerCase().equals("canada")) {
				synchrnousSink.complete();
			}
		}).subscribe(LamdaUtil.getSubscriber("Assignment"));
	}
}
