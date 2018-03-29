package com.simpastudio.loading.service;

public interface CounterService {
    Long getMessageCounter();
    Long getQuoteCounter();

    Long incrementAndGetMessageCounter();
    Long incrementAndGetQuoteCounter();
}
