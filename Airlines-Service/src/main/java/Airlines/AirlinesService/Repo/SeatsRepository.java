package Airlines.AirlinesService.Repo;

import Airlines.AirlinesService.Entity.Seats;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SeatsRepository extends ReactiveCassandraRepository<Seats, Integer> {

    @AllowFiltering
    public Mono<Seats> findBySeatNo(int seatNo);

}
