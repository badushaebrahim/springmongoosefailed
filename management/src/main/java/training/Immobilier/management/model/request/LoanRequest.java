package training.Immobilier.management.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private String name;
    private int age;
    private Long nationalId;
    private float loanAmount;
    private int tenure;
}
