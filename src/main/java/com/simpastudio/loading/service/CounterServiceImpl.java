package com.simpastudio.loading.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CounterServiceImpl implements CounterService {

    private AtomicLong messageCounter = new AtomicLong();
    private AtomicLong quoteCounter = new AtomicLong();

    @Override
    public Long getMessageCounter() {
        return messageCounter.get();
    }

    @Override
    public Long getQuoteCounter() {
        return quoteCounter.get();
    }

    @Override
    public Long incrementAndGetMessageCounter() {
        return messageCounter.incrementAndGet();
    }

    @Override
    public Long incrementAndGetQuoteCounter() {
        return quoteCounter.incrementAndGet();
    }
}
