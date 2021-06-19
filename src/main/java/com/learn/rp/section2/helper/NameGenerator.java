/**
 * 
 */
package com.learn.rp.section2.helper;

import java.util.ArrayList;
import java.util.List;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Flux;

/**
 * @author kishore
 *
 */
public class NameGenerator {

	public Flux<String> getNamesViaFlux(int count) {
		
		return Flux.range(1, count)
				.map(counter -> getName());
	}
	
	public List<String> getNames(int count) {
		List<String> names = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			names.add(getName());
		}
		return names;
	}
	
	private String getName() {
		LamdaUtil.sleepSeconds(1);
		return LamdaUtil.FAKER.name().fullName();
	}
}
