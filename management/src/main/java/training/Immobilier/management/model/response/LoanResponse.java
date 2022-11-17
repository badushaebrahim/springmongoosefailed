package training.Immobilier.management.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {

    private float installment;
    private float intrestRate;
    private int totalIntrestAmount;
    private float fees;
    private float total;
}
