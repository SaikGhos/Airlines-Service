package Airlines.AirlinesService.Service;



import Airlines.AirlinesService.Entity.Reservation;
import Airlines.AirlinesService.Entity.ReservationResponse;
import Airlines.AirlinesService.Entity.Seats;
import Airlines.AirlinesService.ExceptionHandler.ReservationNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AirlinesService {

    public Mono<Seats> saveSeats(Seats seats);
    public Flux<Seats> saveAllSeats(List<Seats> seats);
    public Mono<ReservationResponse> saveReservation(Reservation reservation);
    public Flux<Seats> getSeatsInfo();
    public Flux<Reservation> getAllReservations();

    public Mono<Reservation> getBookingById(int bookingId) throws ReservationNotFoundException;


    /*public Reservation deleteById(int reservationId) throws ReservationNotFoundException;

    public Reservation updateReservation(int reservationId, Reservation reservation) throws ReservationNotFoundException;
*/

}
