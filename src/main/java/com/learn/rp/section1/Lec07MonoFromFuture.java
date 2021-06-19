package com.learn.rp.section1;

import java.util.concurrent.CompletableFuture;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {

	private static CompletableFuture<String> getName(){
		return CompletableFuture
				.supplyAsync(() -> LamdaUtil.FAKER.name().fullName());
	}
	
	public static void main(String[] args) {
		Mono.fromFuture(getName())
		.subscribe(LamdaUtil.onNext());
		
		LamdaUtil.sleepSeconds(4);
	}
}
