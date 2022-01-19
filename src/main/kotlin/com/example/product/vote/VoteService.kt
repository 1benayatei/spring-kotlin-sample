package com.example.product.vote

interface VoteService {
    fun create(vote: Vote): Vote;
    fun get(id: Long): Vote;
}