/**
 * 
 */
package com.learn.rp.section1;

import com.learn.rp.util.LamdaUtil;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec03MonoSubscribe {

	public static void main(String[] args) {
		
		Disposable dispose = null;
		Mono<String> monoBall = Mono.just("Ball")
				.map(value -> value.concat("Foot"+value));
		dispose = monoBall.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete());
		
		dispose.dispose();
	}
}
