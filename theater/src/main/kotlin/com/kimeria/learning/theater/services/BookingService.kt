package com.kimeria.learning.theater.services

import com.kimeria.learning.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService(){
    fun isSeatFree(seat: Seat) : Boolean {
        return true
    }
}
