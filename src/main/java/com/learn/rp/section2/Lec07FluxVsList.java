/**
 * 
 */
package com.learn.rp.section2;

import java.util.List;

import com.learn.rp.section2.helper.NameGenerator;
import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class Lec07FluxVsList {

	public static void main(String[] args) {
		NameGenerator generator = new NameGenerator();
		List<String> names = generator.getNames(5);
		System.out.println(names);
		
		Flux<String> fluxNames = generator.getNamesViaFlux(5);
		fluxNames.subscribe(LamdaUtil.onNext());
	}
}
