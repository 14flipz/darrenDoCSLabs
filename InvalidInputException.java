
public class InvalidInputException extends Exception {

    // Constructor that accepts a custom error message
    public InvalidInputException(String message) {
        // Pass the message to the parent Exception class
        super(message);
    }
}