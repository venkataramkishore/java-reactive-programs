/**
 * 
 */
package com.learn.rp.section2;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec06Subscription {

	public static void main(String[] args) {
		AtomicReference<Subscription> subscription = new AtomicReference<>();
		
		Flux.range(1, 10)
		.subscribeWith(new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("Inside on subscription " + s);
				subscription.set(s);
			}
			@Override
			public void onComplete() {
				System.out.println("Inside on onComplete");
			}
			@Override
			public void onError(Throwable t) {
				System.out.println("Inside on onError " + t.getMessage());
			}
			public void onNext(Integer t) {
				System.out.println("Inside on onNext " + t);
			};
			
		});
		
		subscription.get().request(3);
		LamdaUtil.sleepSeconds(3);
		subscription.get().request(3);
		LamdaUtil.sleepSeconds(5);
		subscription.get().request(3);
		LamdaUtil.sleepSeconds(5);
		subscription.get().cancel();
		LamdaUtil.sleepSeconds(5);
		subscription.get().request(4);
	}
}
