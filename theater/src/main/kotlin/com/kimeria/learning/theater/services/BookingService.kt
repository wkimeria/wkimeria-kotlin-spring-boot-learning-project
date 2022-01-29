package com.kimeria.learning.theater.services

import com.kimeria.learning.theater.data.BookingRepository
import com.kimeria.learning.theater.data.SeatRepository
import com.kimeria.learning.theater.domain.Booking
import com.kimeria.learning.theater.domain.Performance
import com.kimeria.learning.theater.domain.Seat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class BookingService(){
    @Autowired
    lateinit var bookingRepository: BookingRepository

    fun isSeatFree(seat: Seat, performance: Performance) : Boolean {
        val booking = findBooking(seat, performance)
        return booking == null

    }

    fun findBooking(seat: Seat, performance: Performance): Booking? {
        val allBookings = bookingRepository.findAll()
        if (allBookings.isEmpty()) {
            return null
        }
        return allBookings.first { it.seat.id == seat.id && it.performance.id == performance.id }
    }

    fun saveSeat(seat: Seat, performance: Performance, customerName: String): Booking {
        val booking = Booking(1, customerName)
        booking.seat = seat
        booking.performance = performance

        bookingRepository.save(booking)

        return booking
    }
}
