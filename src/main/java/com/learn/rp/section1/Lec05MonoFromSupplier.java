/**
 * 
 */
package com.learn.rp.section1;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec05MonoFromSupplier {

	public static void main(String[] args) {
	
		// Mono.just calls the logic even it is not subscribed. In real time we donot want to call business logic with subscribing. 
		// If you do not have any data then it better to use Supplier because it will call only if you subscribe to it.
		
		Mono<String> justMono = Mono.just(generateName());
		// Lazy loading way of calling business logic
		Supplier<String> stringSupplier = () -> generateName();
		Mono.fromSupplier(stringSupplier)
		.subscribe(
				LamdaUtil.onNext()
				);
		
		
		// Same can be achieved using Callable
		Callable<String> strCallable = () -> generateName();
		Mono.fromCallable(strCallable)
		.subscribe(
				LamdaUtil.onNext()
				);
	}
	
	public static String generateName() {
		System.out.println("Generating name...");
		return LamdaUtil.FAKER.name().fullName();
	}
}
