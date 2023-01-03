package Airlines.AirlinesService.Controllers;

import Airlines.AirlinesService.Entity.Reservation;
import Airlines.AirlinesService.Entity.ReservationResponse;
import Airlines.AirlinesService.Entity.Seats;
import Airlines.AirlinesService.ExceptionHandler.ReservationNotFoundException;
import Airlines.AirlinesService.Service.AirlinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class AirlinesControllers {

    @Autowired
    private AirlinesService airlinesService;

    @PostMapping("/saveSeatInfo")
    public Mono<Seats> saveSeats(@RequestBody Seats seats) {
        return airlinesService.saveSeats(seats);
    }

    @PostMapping("/saveAllSeatInfo")
    public Flux<Seats> saveAllSeats(@RequestBody List<Seats> seats) {
        return airlinesService.saveAllSeats(seats);
    }

    @PostMapping("/reservation")
    public Mono<ReservationResponse> saveReservation(@RequestBody Reservation reservation) {
        return airlinesService.saveReservation(reservation);
    }

    @GetMapping("/getSeatsInfo")
    public Flux<Seats> getSeatsInfo(){
        return airlinesService.getSeatsInfo();
    }

    @GetMapping("/getAllReservations")
    public Flux<Reservation> getAllReservations(){
        return airlinesService.getAllReservations();
    }

    @GetMapping("/getByBookingId/{bookingId}")
    public Mono<Reservation> getBookingById(@PathVariable int bookingId) throws ReservationNotFoundException {
        return airlinesService.getBookingById(bookingId);
    }

    /*@DeleteMapping("/deleteById/{reservationId}")
    public Reservation deleteById(@PathVariable int reservationId) throws ReservationNotFoundException {
        return airlinesService.deleteById(reservationId);
    }*/
}
