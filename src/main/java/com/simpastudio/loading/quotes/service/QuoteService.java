package com.simpastudio.loading.quotes.service;

import com.simpastudio.loading.quotes.data.model.internal.Quote;

import java.util.List;

public interface QuoteService {
    Quote getQuote();
    List<Quote> getQuotes(int limit);
}
