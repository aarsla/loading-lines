package com.simpastudio.loading.event.listener;

import com.simpastudio.loading.lines.controller.MessageController;
import com.simpastudio.loading.lines.service.MessageService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ApplicationReadyListener {

    private static final String template = "\t - %s";
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(MessageController.class);
    private MessageService messageService;

    public ApplicationReadyListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOG.info("Warming up on "+applicationReadyEvent.getClass().getSimpleName()+" with some random messages:");

        IntStream.rangeClosed(1, 5)
                .forEach(i -> LOG.info(String.format(template, messageService.getMessage())));
    }
}
