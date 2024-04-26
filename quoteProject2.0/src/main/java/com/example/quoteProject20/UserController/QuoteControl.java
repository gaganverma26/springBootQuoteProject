package com.example.quoteProject20.UserController;

import com.example.quoteProject20.Dto.ApiResponse;
import com.example.quoteProject20.Dto.QuoteRequest;
import com.example.quoteProject20.Model.Quote;
import com.example.quoteProject20.Services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteControl {
public final QuoteService quoteService;

    public QuoteControl(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createQuote(@RequestBody QuoteRequest quoteRequest){
        return new ResponseEntity<>(new ApiResponse( 201, true, "", List.of(quoteService.createQuote(quoteRequest))),
                HttpStatus.CREATED);
    }

    @PostMapping("list")
    public List<Quote> createQuotesBatch(@RequestBody List<Quote>  quotesDataList) {
        return quoteService.createQuoteBatch(quotesDataList);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllQuotes(){
        return new ResponseEntity<>(new ApiResponse(200, true, "", quoteService.getAllQuotes()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getQuoteByID(@PathVariable Long id){
        return new ResponseEntity<>(new ApiResponse(200, true, "", List.of(quoteService.getQuoteByID(id))), HttpStatus.OK);
        }


    @GetMapping("/author/{name}")
    public ResponseEntity<ApiResponse> getQuotesByAuthorName(@PathVariable String name){
        return new ResponseEntity<>(new ApiResponse(200, true, "", quoteService.getQuotesByAuthorName(name)), HttpStatus.OK);
    }
}


