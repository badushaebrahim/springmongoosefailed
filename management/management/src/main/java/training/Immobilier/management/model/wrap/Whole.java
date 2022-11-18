package training.Immobilier.management.model.wrap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.management.model.request.LoanRequest;
import training.Immobilier.management.model.response.LoanResponse;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Whole {
    private LoanRequest loanRequest;
    private LoanResponse loanResponse;

}
