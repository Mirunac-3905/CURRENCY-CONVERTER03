package com.api.currency.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.currency.service.CurrencyService;


@Controller
public class CurrencyController {
    
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String getQuotesPage(
        final Model model,
        @RequestParam(value = "q", required = false) String amount,
        @RequestParam(value = "from", required = false) String fromCurrency,
        @RequestParam(value = "to", required = false) String toCurrency
        ) throws IOException {
        String quote = null;
        if (amount != null && fromCurrency != null && toCurrency != null) {
            quote = currencyService.getQuote(fromCurrency, toCurrency, amount);
        }
        final List<String> quotes = currencyService.listQuotes();
        model.addAttribute("quotes", quotes);
        model.addAttribute("quote", quote);
        model.addAttribute("from", fromCurrency);
        model.addAttribute("to", toCurrency);
        model.addAttribute("q", amount);
        return "index";
    }

    @GetMapping("/convert")
    @ResponseBody
    public String convert(
        @RequestParam("from") String from,
        @RequestParam("to") String to,
        @RequestParam("q") String amount
    ) throws IOException {
        return currencyService.getQuote(from, to, amount);
    }
}
