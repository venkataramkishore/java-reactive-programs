/**
 * 
 */
package com.learn.rp.assignment1;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class StockPriceObserver {

	public static void main(String[] args) throws InterruptedException {

		AtomicReference<Subscription> stockSubscription = new AtomicReference<>();
		CountDownLatch latch = new CountDownLatch(1);
		
		StockPricePublisher.getStockPublisher().subscribeWith(new Subscriber<Integer>() {
			
			@Override
			public void onSubscribe(org.reactivestreams.Subscription s) {
				System.out.println("Inside onSubscription ");
				s.request(Long.MAX_VALUE);
				stockSubscription.set(s);
			};
			
			@Override
			public void onNext(Integer t) {
				System.out.println("Received : " + t);
				if(t > 110 || t < 90) {
					System.out.println("Cancelling subscription..");
					stockSubscription.get().cancel();
					latch.countDown();
				}
			}
			
			@Override
			public void onError(Throwable t) {
				System.out.println("Throwable exception " + t.getMessage());
				latch.countDown();
			}
			
			@Override
			public void onComplete() {
				System.out.println("Completed...");
				latch.countDown();
			}
		});
		latch.await();
	}
}
