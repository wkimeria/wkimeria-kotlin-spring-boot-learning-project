package com.kimeria.learning.theater.data

import com.kimeria.learning.theater.domain.Performance
import com.kimeria.learning.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository: JpaRepository<Seat, Long>

interface PerformanceRepository: JpaRepository<Performance, Long>
