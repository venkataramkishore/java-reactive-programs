/**
 * 
 */
package com.learn.rp.section1;

import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec02MonoJust {

	public static void main(String[] args) {
//		Mono<Integer> justMono = 
		Mono<Integer> justMono =  Mono.just(1);
		System.out.println("Just mono -> " + justMono);
		justMono.subscribe(System.out::println);
		justMono.subscribe(value -> System.out.println("Received " + value));
	}
}
