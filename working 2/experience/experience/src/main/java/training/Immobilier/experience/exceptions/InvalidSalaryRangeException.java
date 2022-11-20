package training.Immobilier.experience.exceptions;

public class InvalidSalaryRangeException extends  RuntimeException{
    public InvalidSalaryRangeException(){
        super("Invalid Salary provided");
    }
}