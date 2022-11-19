package training.Immobilier.management.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.management.enums.LoanStatusEnums;
import training.Immobilier.management.enums.SalaryRangeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    private String name;
    private SalaryRangeEnum salaryRange;
    private int age;
    private String nationalId;
    private float loanAmount;
    private int tenure;


}
