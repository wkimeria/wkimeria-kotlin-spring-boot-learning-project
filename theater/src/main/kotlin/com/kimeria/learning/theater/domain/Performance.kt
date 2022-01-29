package com.kimeria.learning.theater.domain

import jakarta.persistence.*

@Entity
data class Performance(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0,
                val title: String = ""){
    @OneToMany(mappedBy = "performance", targetEntity = Booking::class, cascade = [CascadeType.ALL], orphanRemoval = true)
    lateinit var bookings: List<Booking>
}

