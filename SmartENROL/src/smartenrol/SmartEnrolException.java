package smartenrol;

public class SmartEnrolException extends Exception {

    public SmartEnrolException(final String errorMessage) {
        super(errorMessage);
    }

    public SmartEnrolException(final Throwable throwable) {
        super(throwable);

    }
}
