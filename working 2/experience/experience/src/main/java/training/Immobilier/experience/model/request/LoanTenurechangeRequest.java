package training.Immobilier.experience.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTenurechangeRequest {

    private int tenure;
    private Long id;
}

