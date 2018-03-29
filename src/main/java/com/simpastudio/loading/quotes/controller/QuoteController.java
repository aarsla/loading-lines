package com.simpastudio.loading.quotes.controller;

import com.simpastudio.loading.quotes.data.model.internal.Quote;
import com.simpastudio.loading.quotes.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuoteController {

    private QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    @ResponseBody
    public Quote quoteMessage() {
        return quoteService.getQuote();
    }

    @GetMapping("/quote/{n}")
    @ResponseBody()
    public Map<String, List<Quote>> quoteMessages(@PathVariable("n") Integer n) {
        List<Quote> quotes = quoteService.getQuotes(n <= 50 ? n : 50);

        return new HashMap<String, List<Quote>>() {{
            put("quotes", quotes);
        }};
    }
}
