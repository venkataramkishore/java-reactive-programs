/**
 * 
 */
package com.learn.rp.section1;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec04MonoEmptyOrError {

	// Assuming this is repository 
	public static Mono<String> userRepository(Integer primaryKey) {
		
		if( primaryKey == 1) {
			return Mono.just(LamdaUtil.FAKER.name().firstName());
		}else if (primaryKey == 2) {
			return Mono.empty();
		}else {
			return Mono.error(new Exception("No such primary key availabe..!"));
		}
	}
	
	public static void main(String[] args) {
		
		userRepository(1)
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);

		userRepository(2)
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);

		userRepository(3)
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);

	}
	
}
