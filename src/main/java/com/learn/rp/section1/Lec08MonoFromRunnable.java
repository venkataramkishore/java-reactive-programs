package com.learn.rp.section1;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

	public static void main(String[] args) {
		
		Mono.fromRunnable(timeConsumingProcess())
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				() -> System.out.println("Successfully executed sending notifications..!")
				);		
		
	}
	
	private static Runnable timeConsumingProcess() {
		return () -> {
			LamdaUtil.sleepSeconds(3);
			System.out.println("System has completed executing process..");
		};
	}
}
