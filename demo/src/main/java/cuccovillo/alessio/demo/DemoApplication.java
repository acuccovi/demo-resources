package cuccovillo.alessio.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		writeFileContentToStdOut("log4j2/log4j2.xml");
		writeFileContentToStdOut("file1.txt");
		writeFileContentToStdOut("file2.txt");
	}

	private void writeFileContentToStdOut(String fileName) throws FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:" + fileName);
		try (Scanner scanner = new Scanner(file);) {
			log.trace("Start {}", fileName);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			log.trace("End {}", fileName);
		}
	}

}
