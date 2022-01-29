package com.kimeria.learning.theater.control

import com.kimeria.learning.theater.data.PerformanceRepository
import com.kimeria.learning.theater.data.SeatRepository
import com.kimeria.learning.theater.domain.Booking
import com.kimeria.learning.theater.domain.Performance
import com.kimeria.learning.theater.domain.Seat
import com.kimeria.learning.theater.services.BookingService
import com.kimeria.learning.theater.services.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController{

    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @Autowired
    lateinit var seatRepository: SeatRepository

    @Autowired
    lateinit var performanceRepository: PerformanceRepository

    @RequestMapping("")
    fun homePage(): ModelAndView{
        val model = mapOf("bean" to CheckAvailabilityBackingBean(),
                            "performances" to performanceRepository.findAll(),
                            "seatNums" to 1..36,
                            "seatRows" to 'A'..'O')

        return ModelAndView("seatBooking", model)
    }

    @RequestMapping("checkAvailability", method = [RequestMethod.POST])
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView {
        val selectedSeat = theaterService.find(bean.selectedSeatNum, bean.selectedSeatRow)
        bean.customerName = "John Smith"
        val selectedPerformance: Performance? = performanceRepository.findByIdOrNull(bean.selectedPerformance)

        if (selectedPerformance !== null && selectedSeat !== null){
            bean.available = bookingService.isSeatFree(selectedSeat, selectedPerformance)
            // bean.booking = bookingService.saveSeat(selectedSeat, selectedPerformance)
        }else{
            bean.available = false

        }
        bean.seat = selectedSeat
        bean.performance = selectedPerformance
        bean.selectedPerformance = selectedPerformance?.id

        return ModelAndView("seatBooking", "bean", bean)
    }

    @RequestMapping("booking", method = [RequestMethod.POST])
    fun booking(bean: CheckAvailabilityBackingBean): ModelAndView {
        val selectedSeat = bean.seat
        val selectedPerformance = bean.performance
        val customerName = bean.customerName

        if(selectedPerformance != null && selectedSeat != null){
            val booking = bookingService.saveSeat(selectedSeat, selectedPerformance, customerName)
            bean.booking = booking
        }

        return ModelAndView("seatBooking", "bean", bean)
    }

    @RequestMapping("bootstrap")
    fun createInitialData(): ModelAndView{
        val seats = theaterService.seats
        seatRepository.saveAll(seats)

        return homePage()
    }
}


class CheckAvailabilityBackingBean{
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var selectedPerformance: Long? = null
    var customerName: String = ""

    var available: Boolean? = null
    var seat: Seat? = null
    var performance: Performance? = null
    var booking: Booking? = null

}
