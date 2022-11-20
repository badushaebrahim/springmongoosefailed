package training.Immobilier.experience.exceptions;

public class LoanRequestNotFoundError extends RuntimeException{
    public LoanRequestNotFoundError(){
        super("Loan Request Not found Error");
    }
}
