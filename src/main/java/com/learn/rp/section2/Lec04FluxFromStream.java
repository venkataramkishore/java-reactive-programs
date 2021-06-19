/**
 * 
 */
package com.learn.rp.section2;

import java.util.List;
import java.util.stream.Stream;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec04FluxFromStream {

	static final List<Integer> numbers = List.of(1,2,3,4,5,6);
	
	public static void main(String[] args) {
		// Once stream is used then you cannot use same stream for another operations
		// because stream once used it is closed.
		Stream<Integer> numStream = numbers.stream();
		
		// numStream.forEach(System.out::println); // here stream is closed
		// numStream.forEach(System.out::println);  // this line with throw java.lang.IllegalStateException: stream has already been operated upon or closed
		
		// Flux has the similary concepts cannot use the same flux steam multiple times.
		// Flux<Integer> fluxStream =  Flux.fromStream(numStream);
		
//		fluxStream.subscribe(
//				LamdaUtil.onNext(),
//				LamdaUtil.onError(),
//				LamdaUtil.onComplete()
//				);
		
//		fluxStream.subscribe(
//				LamdaUtil.onNext(),
//				LamdaUtil.onError(),
//				LamdaUtil.onComplete()
//				);// this line with throw ERROR :stream has already been operated upon or closed
		
		// to reuse the same data several times we need to use supplier with every time new stream
		
		Flux<Integer> numSupplierStream = Flux.fromStream(() -> numbers.stream());
		numSupplierStream.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		numSupplierStream.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
	}
}
