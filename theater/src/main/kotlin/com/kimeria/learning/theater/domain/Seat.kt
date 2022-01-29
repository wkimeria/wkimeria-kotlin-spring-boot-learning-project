package com.kimeria.learning.theater.domain

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Seat(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0,
                val rowNum: Char = 'A',
                val num: Int = 0,
                val price: BigDecimal = BigDecimal.ZERO,
                val description: String = ""){
    //@OneToMany(mappedBy = "seat", targetEntity = Booking::class, cascade = [CascadeType.ALL], orphanRemoval = true)
    //lateinit var bookings: List<Booking>
}
