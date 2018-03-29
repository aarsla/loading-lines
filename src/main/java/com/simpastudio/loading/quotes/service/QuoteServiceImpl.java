package com.simpastudio.loading.quotes.service;

import com.simpastudio.loading.service.CounterService;
import com.simpastudio.loading.quotes.data.model.internal.Quote;
import com.simpastudio.loading.quotes.data.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private CounterService counterService;
    private QuoteRepository quoteRepository;

    public QuoteServiceImpl(CounterService counterService, QuoteRepository quoteRepository) {
        this.counterService = counterService;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote getQuote() {
        counterService.incrementAndGetQuoteCounter();
        return quoteRepository.random();
    }

    @Override
    public List<Quote> getQuotes(int limit) {

        for (int i = 0; i < limit; i++) {
            counterService.incrementAndGetQuoteCounter();
        }

        return quoteRepository.random(limit);
    }
}

