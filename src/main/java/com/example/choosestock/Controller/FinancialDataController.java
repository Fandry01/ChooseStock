package com.example.choosestock.Controller;

import com.example.choosestock.Model.FinancialDataResponse;
import com.example.choosestock.Service.AlphaAdvantageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/finance")
public class FinancialDataController {
    private final AlphaAdvantageService alphaAdvantageService;

    public FinancialDataController(AlphaAdvantageService alphaAdvantageService) {
        this.alphaAdvantageService = alphaAdvantageService;
    }

    @GetMapping("/income-statement/{symbol}")
    public Mono<FinancialDataResponse> getIncomeStatement(@PathVariable String symbol){
        String apiKey = "VJZOP72DUZVBIXH2";
        return alphaAdvantageService.getIncomeStatement(symbol,apiKey);
    }

}
