/**
 * 
 */
package com.learn.rp.section2;

import java.time.Duration;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec08FluxInterval {

	public static void main(String[] args) {
		// Interval works in another thread pool, This thread pool has to be sync with
		// current main thread then only you can see subscribe value
		Flux.interval(Duration.ofSeconds(1)).subscribe(LamdaUtil.onNext());
		
		// This makes current main thread to sleep for 5 seconds so that you can see subscribe values
		LamdaUtil.sleepSeconds(5);

	}
}
