package training.Immobilier.experience.exceptions;

public class TenureException extends RuntimeException{
    public TenureException(){
        super("invalid tenure selected");
    }
}

