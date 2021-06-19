package com.learn.rp.section2;

import java.util.Arrays;
import java.util.List;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

	private static List<String> names = Arrays.asList(LamdaUtil.FAKER.name().firstName(),
			LamdaUtil.FAKER.name().firstName(),
			LamdaUtil.FAKER.name().firstName(),
			LamdaUtil.FAKER.name().firstName(),
			LamdaUtil.FAKER.name().firstName());
	
	private static Integer[] numbers = {1,2,3,4,5,6,7};
	
	public static void main(String[] args) {
		Flux<String> namesFlux = Flux.fromIterable(names);
		namesFlux.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
		Flux<Integer> numFlux = Flux.fromArray(numbers);
		numFlux.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
	}
}
