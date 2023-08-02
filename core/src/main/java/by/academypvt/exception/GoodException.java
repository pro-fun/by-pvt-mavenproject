package by.academypvt.exception;

public class GoodException extends RuntimeException{
    public GoodException(String message) {
        super(message);
        System.err.println(message);
    }
}
