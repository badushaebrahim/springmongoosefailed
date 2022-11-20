package training.Immobilier.management.exceptions;

public class InvalidSalaryRangeException extends  RuntimeException{
   public InvalidSalaryRangeException(){
        super("Invalid Salary provided");
    }
}
