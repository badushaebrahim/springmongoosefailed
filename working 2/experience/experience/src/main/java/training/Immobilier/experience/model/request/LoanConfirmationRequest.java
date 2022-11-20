package training.Immobilier.experience.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.experience.enums.LoanStatusEnums;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanConfirmationRequest {
    private Long id;
    private LoanStatusEnums statusEnums;
}

