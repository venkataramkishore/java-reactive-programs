/**
 * 
 */
package com.learn.rp.section2;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec05FluxFromRange {

	public static void main(String[] args) {
		Flux.range(5, 15).subscribe( // starts number with 5 and increment 15 times ends at 19
				LamdaUtil.onNext(), // display will 19
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
		Flux.range(1,10)
		.log()
		.map(counter -> counter + ". " + LamdaUtil.FAKER.name().fullName())
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
	}
}
