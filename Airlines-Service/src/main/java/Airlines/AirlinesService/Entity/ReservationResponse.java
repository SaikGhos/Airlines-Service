package Airlines.AirlinesService.Entity;

import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationResponse {

    private int bookingId;
    private int seatNo;
    private String name;
    private Date bookingDate;
    private String status;

}
