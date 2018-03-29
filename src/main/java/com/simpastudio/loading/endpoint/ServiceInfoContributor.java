package com.simpastudio.loading.endpoint;

import com.simpastudio.loading.service.CounterService;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ServiceInfoContributor implements InfoContributor {

    private CounterService counterService;

    public ServiceInfoContributor(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("served",
                        new HashMap<String, Long>() {{
                            put("messages", counterService.getMessageCounter());
                            put("quotes", counterService.getQuoteCounter());
                        }});
    }
}
