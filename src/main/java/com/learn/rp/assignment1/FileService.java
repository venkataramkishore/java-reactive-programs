package com.learn.rp.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.learn.rp.util.LamdaUtil;

import reactor.core.publisher.Mono;

public class FileService {

	private static final Path path = Paths.get("src/main/resources/assignment");

	private static String readFile(String fileName) {
		String fileContent = null;
		try {
			fileContent = Files.readString(path.resolve(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}

	private static void writeFile(String fileName, String content) {
		try {
			Files.writeString(path.resolve(fileName), content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deleteFile(String fileName) {
		try {
			Files.delete(path.resolve(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Mono<String> read(String fileName) {
		return Mono.fromSupplier(() -> readFile(fileName));
	}

	private static Mono<Void> write(String fileName, String content) {
		return Mono.fromRunnable(() -> writeFile(fileName, content));
	}

	private static Mono<Void> delete(String fileName) {
		return Mono.fromRunnable(() -> deleteFile(fileName));
	}

	public static void main(String[] args) {
		read("file-01.txt")
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		
		write("file-04.txt", "My second file content..")
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete());
		delete("file-03.txt")
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete());
		
		read("file-02.txt")
		.and(write("file-03.txt", "My file 3 content with pipeline"))
		.and(delete("file-03.txt"))
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete()
				);
		write("somenewfile.txt", "Some thing new i am trying to learn using Reactive programming..")
		.subscribe(
				LamdaUtil.onNext(),
				LamdaUtil.onError(),
				LamdaUtil.onComplete());
		
	}
}
