package by.epamtc.iovchuk.exception;

import java.security.PrivilegedActionException;

public class NullException extends Exception {

    public NullException() {
        super();
    }

    public NullException(String parameter) {
        super(parameter + " can't be null!");
    }

    public NullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullException(Throwable cause) {
        super(cause);
    }
}
