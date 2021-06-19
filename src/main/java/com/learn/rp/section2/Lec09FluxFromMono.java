/**
 * 
 */
package com.learn.rp.section2;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec09FluxFromMono {

	public static void main(String[] args) {
		
		Mono<String> mono = Mono.just("Mono text");
		// Flux has a provision to accept publisher, in this case mono is publishing text Mono text
		Flux<String> fluxOfMono = Flux.from(mono);
		// Conversion is possible 
		fluxOfMono.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
	}
}
