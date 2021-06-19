package com.learn.rp.section2;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

	public static void main(String[] args) {
		Flux<Integer> intFlux = Flux.just(1,2,3,4,5);
		
		intFlux
		.filter(i -> i%2 ==0)
		.subscribe(
				value -> System.out.println("Sub 1  " + value),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
		intFlux
		.filter(i -> i%2 != 0)
		.subscribe(
				value -> System.out.println("Sub 2  " + value),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
	}
}
