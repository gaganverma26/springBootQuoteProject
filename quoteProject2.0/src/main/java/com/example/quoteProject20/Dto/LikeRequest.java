package com.example.quoteProject20.Dto;

import com.example.quoteProject20.Model.Quote;
import com.example.quoteProject20.Model.User;

public record LikeRequest(Boolean isLikes, Quote quote, User user) {
}
