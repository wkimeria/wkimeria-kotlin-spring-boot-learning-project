package com.kimeria.learning.theater.domain

import jakarta.persistence.*
import org.hibernate.annotations.Cascade


@Entity
data class Booking(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val title: String = ""){

        @ManyToOne(cascade = [CascadeType.ALL])
        //@JoinColumn(name = "seat_id")
        lateinit var seat: Seat

        @ManyToOne(cascade = [CascadeType.ALL])
        //@JoinColumn(name = "performance_id")
        lateinit var performance: Performance
}
