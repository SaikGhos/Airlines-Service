package Airlines.AirlinesService.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(value = "reservation")
public class Reservation {

    @NotNull
    @PrimaryKeyColumn(name = "BookingId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int bookingId;
    @PrimaryKeyColumn(name = "SeatNumber", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private int seatNo;
    @NotBlank
    @Column("Name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;
    @NotBlank
    @Column("BookingDate")
    private Date bookingDate;
}