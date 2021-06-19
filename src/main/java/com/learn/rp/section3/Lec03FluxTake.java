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
public class Lec03FluxTake {

	public static void main(String[] args) {
		Flux.range(1, 10)
		.log()
		.take(3) // no of elements/items to handle in the given pipeline
		.log()
		.subscribe(LamdaUtil.getSubscriber("Take Opr"));
	}
}
