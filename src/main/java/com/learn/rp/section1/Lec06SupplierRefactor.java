/**
 * 
 */
package com.learn.rp.section1;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

/**
 * @author kishore
 *
 */
public class Lec06SupplierRefactor {

	public static Mono<String> getName() {
		System.out.println("Inside name generator");
		return Mono.fromSupplier(() -> {
			System.out.println("Generating name...");
			LamdaUtil.sleepSeconds(3);
			return LamdaUtil.FAKER.name().fullName();
		}).map(String::toUpperCase);
	}

	public static void main(String[] args) {
		// getName does not call the supplier method to process instead it crates a
		// pipeline
		getName();
		getName();
		// Only after you subscribe supplier wil start to proces pipeline
		getName().subscribe(LamdaUtil.onNext());
		getName();

	}
}
