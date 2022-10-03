package exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrudOperationException extends Exception{
    private String message;

    @Override
    public String toString() {
        return "CrudOperationException{" +
                "message='" + message + '\'' +
                '}';
    }
}
