package training.Immobilier.management.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loan")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private Long nationalId;
    private float loanAmount;
    private int tenure;

    private float installment;
    private float intrestRate;
    private float totalIntrestAmount;
    private int fees;
    private float total;




}
