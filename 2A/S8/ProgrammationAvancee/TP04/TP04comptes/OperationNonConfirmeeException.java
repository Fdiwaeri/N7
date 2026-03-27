public class OperationNonConfirmeeException extends Exception {
    private String message;

    public OperationNonConfirmeeException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
