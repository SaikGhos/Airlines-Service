package Airlines.AirlinesService.Service;



import Airlines.AirlinesService.Entity.Reservation;
import Airlines.AirlinesService.Entity.ReservationResponse;
import Airlines.AirlinesService.Entity.Seats;
import Airlines.AirlinesService.ExceptionHandler.ReservationNotFoundException;
import Airlines.AirlinesService.Repo.ReservationRepository;
import Airlines.AirlinesService.Repo.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AirlinesServiceImpl implements AirlinesService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public Mono<Seats> saveSeats(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public Flux<Seats> saveAllSeats(List<Seats> seats) {
        Flux<Seats> seatsFlux = seatsRepository.saveAll(seats);
        return seatsFlux;
    }

    @Override
    public Mono<ReservationResponse> saveReservation(Reservation reservation) {

        return reservationRepository.existsByBookingId(reservation.getBookingId())
        .flatMap(exists -> {
            if (exists) {
                Seats seat = new Seats(reservation.getSeatNo(), "Booked");
                return Mono.zip(Mono.just(reservation)
                                        .flatMap(reservationRepository::save)
                                , Mono.just(seat).flatMap(seatsRepository::save))
                        .map(t -> new ReservationResponse(t.getT1().getBookingId(), t.getT1().getSeatNo(),
                                t.getT1().getName(), t.getT1().getBookingDate(), "Reservation Updated"));
            } else {
                Seats seat = new Seats(reservation.getSeatNo(), "Booked");
                return Mono.zip(Mono.just(reservation)
                                        .flatMap(reservationRepository::save)
                                , Mono.just(seat).flatMap(seatsRepository::save))
                        .map(t -> new ReservationResponse(t.getT1().getBookingId(), t.getT1().getSeatNo(),
                                t.getT1().getName(), t.getT1().getBookingDate(), "Reservation Created"));
            }
        });

    }

    @Override
    public Flux<Seats> getSeatsInfo() {
        return seatsRepository.findAll();
    }


    @Override
    public Flux<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Mono<Reservation> getBookingById(int bookingId) throws ReservationNotFoundException {

        Mono<Reservation> reservation = reservationRepository.findById(bookingId);
        return reservation;
    }

    /*@Override
    public Reservation deleteById(int reservationId) throws ReservationNotFoundException {
        return null;
    }*/
}
