package Airlines.AirlinesService.ExceptionHandler;

public class ReservationNotFoundException extends Exception {
    public ReservationNotFoundException() {
        super();
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
