package training.Immobilier.management.exceptions;

public class TenureException extends RuntimeException{
    public TenureException(){
        super("invalid tenure selected");
    }
}
