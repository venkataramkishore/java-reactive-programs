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
public class Lec05FlexGenerate {

	public static void main(String[] args) {
		
		// Flux generate call new emitter always on whole block of code.
		// So that it will allow only 1 next method
		// This flux generate is infinite and developer has to write a breaking point over this infinite loop
		Flux.generate(sinkGenerator -> {
			// If only one next method then it is expected to run infinite loop unless there is breaking point present as part of loop
			sinkGenerator.next(LamdaUtil.FAKER.country().name()); // Synchronous sink will emit only one value at a time
			// uncomment the below line to see error on multiple use of next method
			// sinkGenerator.next(LamdaUtil.FAKER.country().name()); // So this line throws error
			
			// if you trigger onError or onComplete loop will be stopped
		})
		// Here take 3 acts like break point on above infinite loop
		// Difference between Flux create/generate, In create you have to handle cancelled state. In Generate you dont. 
		.take(3)
		.subscribe(LamdaUtil.getSubscriber());
	}
}
