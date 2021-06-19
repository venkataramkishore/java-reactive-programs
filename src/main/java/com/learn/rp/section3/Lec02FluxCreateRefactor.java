/**
 * 
 */
package com.learn.rp.section3;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec02FluxCreateRefactor {

	public static void main(String[] args) {
		NameProducer producer = new NameProducer();
		
		Flux.create(producer)
		.subscribe(LamdaUtil.getSubscriber());
		
		try {
			producer.produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
