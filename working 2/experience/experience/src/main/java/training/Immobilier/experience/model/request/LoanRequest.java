package training.Immobilier.experience.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.experience.enums.SalaryRangeEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {


    @Size(min = 5 ,max = 30,message = "Enter Name with size between 5 & 30")
    private String name;
    private SalaryRangeEnum salaryRange;
    private int age;
    @Pattern(regexp = "^\\d{10}$",message = "The National Id must be 10 digits")
    private String nationalId;
    @Min(value = 600,message = "Loan amout must be in the limit of 600 JOD to 2000 JOD")
    @Max(value = 2000,message = "Loan amout must be in the limit of 600 JOD to 2000 JOD")
    private float loanAmount;
    private int tenure;


}
