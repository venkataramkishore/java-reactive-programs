/**
 * 
 */
package com.learn.rp.section2;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec10FluxToMono {

	public static void main(String[] args) {
		
		// Flux is for handling multiple set of data
		// If you want only one value out of flux and stop then 
		Flux.range(1, 5)
		.filter(i -> i > 4) // you can add filter to get data you would like to fetch from stream of data
		.next() // First value emitted by next method is the last value from attached flux stream
		.subscribe(LamdaUtil.getSubscriber());
 	}
}
