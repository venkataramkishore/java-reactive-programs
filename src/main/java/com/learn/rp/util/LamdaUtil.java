/**
 * 
 */
package com.learn.rp.util;

import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;
import com.learn.rp.section3.DefaultSubscriber;

/**
 * @author kishore
 *
 */
public class LamdaUtil {
	
	public static final Faker FAKER = Faker.instance();
	
	public static Consumer<Object> onNext() {
		return o -> System.out.println("Received : " + o);
	}
	
	public static Consumer<Throwable> onError() {
		return err -> System.out.println("ERROR :" + err.getMessage());
	}

	public static Runnable onComplete() {
		return () -> System.out.println("Completed...");
	}
	
	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Subscriber<Object> getSubscriber() {
		return new DefaultSubscriber();
	}
	
	public static Subscriber<Object> getSubscriber(String name) {
		return new DefaultSubscriber(name);
	}
}
