package training.Immobilier.experience.repo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import training.Immobilier.experience.model.request.LoanConfirmationRequest;
import training.Immobilier.experience.model.request.LoanRequest;
import training.Immobilier.experience.model.request.LoanTenurechangeRequest;
import training.Immobilier.experience.model.responses.ResponseObject;

@FeignClient(name = "Loan", url = "${config.rest.service.getLoanUrl}")
public interface ExperienceRepo {
    @PostMapping
    public ResponseObject getLoanDetails(@RequestBody LoanRequest loanRequest);

    @PutMapping
    public ResponseObject updateTenure(@RequestBody LoanTenurechangeRequest loanTenurechangeRequest);

    @PutMapping("/confirm")
    public ResponseObject ConfirmLoan(LoanConfirmationRequest loanConfirmationRequest);

}
