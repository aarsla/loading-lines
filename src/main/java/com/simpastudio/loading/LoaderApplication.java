package com.simpastudio.loading;

import com.simpastudio.loading.lines.controller.MessageController;
import com.simpastudio.loading.lines.service.MessageService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.IntStream;

@SpringBootApplication
public class LoaderApplication {

	private static final String template = "\t - %s";
	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(MessageController.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LoaderApplication.class, args);
		testRandomMessages(context);
	}

	private static void testRandomMessages(ConfigurableApplicationContext context) {
		LOG.info("Warming up with some random messages:");
		MessageService messageService =  context.getBean(MessageService.class);

		IntStream.rangeClosed(1, 5)
				.forEach(i -> LOG.info(String.format(template, messageService.getMessage())));
	}
}
