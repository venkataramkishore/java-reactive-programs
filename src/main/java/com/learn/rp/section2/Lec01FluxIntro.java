package com.learn.rp.section2;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

	public static void main(String[] args) {
		Flux<String> strFlux = Flux.just("one element", "2 element", "3 element", LamdaUtil.FAKER.name().fullName())
				.map(data -> data.toUpperCase());
		
		strFlux.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
		Flux<String> emptyFlux = Flux.empty();
		emptyFlux.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
	}
}
