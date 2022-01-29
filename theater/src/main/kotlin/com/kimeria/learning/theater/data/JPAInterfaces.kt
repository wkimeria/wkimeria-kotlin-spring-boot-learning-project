package com.kimeria.learning.theater.data

import com.kimeria.learning.theater.domain.Booking
import com.kimeria.learning.theater.domain.Performance
import com.kimeria.learning.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface SeatRepository: JpaRepository<Seat, Long>

interface PerformanceRepository: JpaRepository<Performance, Long>

interface BookingRepository: JpaRepository<Booking, Long>



