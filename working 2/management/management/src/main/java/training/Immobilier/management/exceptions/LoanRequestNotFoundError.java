package training.Immobilier.management.exceptions;

public class LoanRequestNotFoundError extends RuntimeException{
    public LoanRequestNotFoundError(){
        super("Loan Request Not found Error");
    }
}
