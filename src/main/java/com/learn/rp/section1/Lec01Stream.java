/**
 * 
 */
package com.learn.rp.section1;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * @author kishore
 *
 */
public class Lec01Stream {

	public static void main(String[] args) {
		Stream<Integer> intStream = Stream.of(2)
				.map(i -> {
					try {
						Thread.sleep(Duration.ofSeconds(2).getSeconds());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return i * 2;
				});
		System.out.println(intStream);
		intStream.forEach(System.out::println);
	}

}
