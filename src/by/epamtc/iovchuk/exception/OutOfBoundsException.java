package by.epamtc.iovchuk.exception;

public class OutOfBoundsException extends Exception {

    public OutOfBoundsException() {
        super("Индекс вне допустимого диапазона!");
    }

    public OutOfBoundsException(String message) {
        super(message);
    }

    public OutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfBoundsException(Throwable cause) {
        super(cause);
    }

}