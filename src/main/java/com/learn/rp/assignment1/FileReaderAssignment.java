/**
 * 
 */
package com.learn.rp.assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

/**
 * @author kishore
 *
 */
public class FileReaderAssignment {

	public static final Path path = Paths.get("src/main/resources/assignment-flux");

	private Callable<BufferedReader> openReader(Path path) {
		return () -> Files.newBufferedReader(path);
	}
	
	private Callable<BufferedWriter> openWriter(Path path) {
		return () -> Files.newBufferedWriter(path);
	}
	
	private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
		return (br, sink) -> {
			String line = null;
			try {
				line = br.readLine();
				if(Objects.isNull(line)) {
					sink.complete();
				}else {
					sink.next(line);
				}
			} catch (IOException e) {
				sink.error(e);
			}
			return br;
		};
	}
	
	
	private Consumer<BufferedReader> closeReader() {
		return br -> {
			try {
				System.out.println("About to close the file");
				br.close();
				
			} catch (IOException e) {
				System.out.println("There is some error");
				throw new RuntimeException(e);
			}
		};
	}
	
	public Flux<String> read(Path path) {
		return Flux.generate(openReader(path),
				read(),
				closeReader());
		
	}

	public static void main(String[] args) {
		
		FileReaderAssignment assignement = new FileReaderAssignment();
		assignement.read(path);
	}
}

