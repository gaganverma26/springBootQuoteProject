package com.example.quoteProject20.Services;

import com.example.quoteProject20.Dto.QuoteRequest;
import com.example.quoteProject20.Model.Quote;
import com.example.quoteProject20.Model.User;
import com.example.quoteProject20.Respository.QuoteRepository;
import com.example.quoteProject20.Respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
private final QuoteRepository quoteRepository;
private final UserRepository userRepository;



    public QuoteService(QuoteRepository quoteRepository, UserRepository userRepository) {
        this.quoteRepository = quoteRepository;
        this.userRepository = userRepository;
    }

    public Quote createQuote(QuoteRequest quoteRequest){
        User existingUser = userRepository.findById(quoteRequest.authorId()).orElse(null);

        if(existingUser == null){
            throw new RuntimeException("Author not found");
        }



        Quote quote = mapQuoteRequestToQuote(quoteRequest);
        quote.setAuthor(existingUser);
        return quoteRepository.save(quote);
    }

    public List<Quote> createQuoteBatch(List<Quote> quoteDataList){
        return quoteRepository.saveAll(quoteDataList);
    }

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    public Quote getQuoteByID(Long id){
        return quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("No record(s) found"));
    }

    public List<Quote> getQuotesByAuthorName(String authorname){
        return quoteRepository.findByAuthorNameIgnoreCase(authorname);
    }

    private Quote mapQuoteRequestToQuote(QuoteRequest quoteRequest){
        return Quote.builder()
                .content(quoteRequest.content())
                .build();
    }
}
