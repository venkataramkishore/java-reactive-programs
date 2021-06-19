/**
 * 
 */
package com.learn.rp.section3;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author kishore
 *
 */
public class DefaultSubscriber implements Subscriber<Object>{

	private AtomicReference<Subscription> subscription = new AtomicReference<>();
	private String name;
	
	public DefaultSubscriber() {
		this.name = "";
	}
	
	
	public DefaultSubscriber(String name) {
		super();
		this.name = name + " - ";
	}


	@Override
	public void onSubscribe(Subscription s) {
		s.request(Long.MAX_VALUE);
		this.subscription.set(s);
	}
	
	@Override
	public void onNext(Object t) {
		System.out.println(name + "Received : " + t);
	}
	
	@Override
	public void onError(Throwable t) {
	 System.out.println(name + "ERROR "+ t.getMessage());
	 this.subscription.get().cancel();
		
	}
	
	@Override
	public void onComplete() {
		System.out.println(name + "Completed...");
		this.subscription.get().cancel();	
	}
	
	
}
