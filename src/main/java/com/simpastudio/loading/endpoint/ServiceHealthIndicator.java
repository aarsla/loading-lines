package com.simpastudio.loading.endpoint;

import com.simpastudio.loading.lines.service.MessageService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthIndicator implements HealthIndicator {

    private MessageService messageService;

    public ServiceHealthIndicator(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Health health() {
        return Health.up().withDetail("state", messageService.getVerb() + " " + messageService.getNoun()).build();
    }
}