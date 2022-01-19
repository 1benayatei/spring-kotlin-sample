package com.example.product.comment

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Comment(
    var productId: Long,
    var userId: Long,
    var text: String,
) {

    constructor(status: CommentStatus) : this(0, 0, "") {
        this.status = status
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = -1;

    @Enumerated(EnumType.STRING)
    var status: CommentStatus = CommentStatus.PENDING

    val createdAt: LocalDateTime = LocalDateTime.now()
    var updatedAt: LocalDateTime? = null

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }

    enum class CommentStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}