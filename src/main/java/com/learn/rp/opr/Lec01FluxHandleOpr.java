package com.learn.rp.opr;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

public class Lec01FluxHandleOpr {
	
	public static void main(String[] args) {
		Flux.range(1, 100)
		.handle((value, synchronousSink) -> {
			if(value == 7) {
				synchronousSink.complete();
			}else 
				synchronousSink.next(value);
		})
		.subscribe(LamdaUtil.getSubscriber());
		
		Flux.generate(
				sink -> {
					String country = LamdaUtil.FAKER.country().name();
					if(country.toLowerCase().equals("canada")) {
						sink.complete();
					}else 
						sink.next(country);
				})
		.subscribe(LamdaUtil.getSubscriber());
		System.out.println("+==================== Generate with handle ===============");
		Flux.generate(sink -> sink.next(LamdaUtil.FAKER.country().name()))
		.map(Object::toString)
		.handle((countryName, sink) -> {
			if(countryName.toLowerCase().equals("canada")) {
				sink.complete();
			}else 
				sink.next(countryName);
		}).subscribe(LamdaUtil.getSubscriber());
	}

}
