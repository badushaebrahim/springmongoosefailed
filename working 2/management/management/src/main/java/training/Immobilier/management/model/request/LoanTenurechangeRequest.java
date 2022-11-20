package training.Immobilier.management.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.management.enums.LoanStatusEnums;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTenurechangeRequest {

    private int tenure;
    private Long id;
}
