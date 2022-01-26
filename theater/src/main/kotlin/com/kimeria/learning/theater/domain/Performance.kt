package com.kimeria.learning.theater.domain

import jakarta.persistence.*


@Entity
data class Performance(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0,
                val title: String = ""){
    @OneToMany(mappedBy = "performance", targetEntity = Booking::class)
    lateinit var bookings: List<Booking>
}



/*
@Entity
data class  Performance() {
    constructor(
        id: Long,
        title: String): this() {
        this.id = id
        this.title = title
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    lateinit var title: String
    @OneToMany(mappedBy = "performance", targetEntity = Booking::class)
    lateinit var bookings: List<Booking>
}
 */

