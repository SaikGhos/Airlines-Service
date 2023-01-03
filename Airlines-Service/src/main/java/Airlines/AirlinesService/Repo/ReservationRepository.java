package Airlines.AirlinesService.Repo;


import Airlines.AirlinesService.Entity.Reservation;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReservationRepository extends ReactiveCassandraRepository<Reservation, Integer> {

    Mono<Boolean> existsByBookingId(Integer bookingId);

}
