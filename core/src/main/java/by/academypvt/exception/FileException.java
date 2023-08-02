package by.academypvt.exception;

import java.io.Serial;

public class FileException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7323032768012231680L;

    public FileException(String message) {
        super(message);
        System.err.println(message);
    }
}
