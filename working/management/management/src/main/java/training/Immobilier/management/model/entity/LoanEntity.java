package training.Immobilier.management.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.Immobilier.management.enums.LoanStatusEnums;
import training.Immobilier.management.enums.SalaryRangeEnum;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loan")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String loanRequestName;
    @Column(name = "age")
    private int loanRequestAge;
    @Column(name = "nationalId")
    private String loanRequestNationalId;
    @Column(name = "loanAmount")
    private float loanRequestLoanAmount;
    @Column(name = "tenure")
    private int loanRequestTenure;
    @Column(name = "installment")
    private float loanResponseInstallment;
    @Column(name = "intrestRate")
    private float loanResponseIntrestRate;
    @Column(name = "totalIntrestAmount")
    private float loanResponseTotalIntrestAmount;
    @Column(name = "fees")
    private int loanResponseFees;
    @Column(name = "total")
    private float loanResponseTotal;
    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private LoanStatusEnums loanResponseStatus;
    @Column(name = "salaryrange")
    @Enumerated(EnumType.STRING)
    private SalaryRangeEnum salaryRangeEnum;

}
