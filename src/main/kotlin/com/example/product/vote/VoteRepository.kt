package com.example.product.vote;

import org.springframework.data.jpa.repository.JpaRepository

interface VoteRepository : JpaRepository<Vote, Long> {
}