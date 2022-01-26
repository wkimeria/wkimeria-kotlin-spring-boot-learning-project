package com.kimeria.learning.theater.domain

import jakarta.persistence.*

@Entity
data class Booking(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    val title: String = ""){

        @ManyToOne
        lateinit var seat: Seat
        @ManyToOne
        lateinit var performance: Performance
}

/*
open class Booking() {
    constructor(
        id: Long,
        title: String): this() {
        this.id = id
        this.title = title
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    lateinit var title: String
    @ManyToOne
    lateinit var seat: Seat
    @ManyToOne
    lateinit var performance: Performance
}
 */

