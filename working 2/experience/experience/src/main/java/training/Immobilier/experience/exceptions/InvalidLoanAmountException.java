package training.Immobilier.experience.exceptions;

public class InvalidLoanAmountException extends RuntimeException{
    public InvalidLoanAmountException(){
        super("The Loan Amount should be 600 JOD - 2000 JOD");
    }
}
