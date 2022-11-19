package training.Immobilier.experience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.Immobilier.experience.model.request.LoanConfirmationRequest;
import training.Immobilier.experience.model.request.LoanRequest;
import training.Immobilier.experience.model.request.LoanTenurechangeRequest;
import training.Immobilier.experience.model.responses.ResponseObject;
import training.Immobilier.experience.repo.ExperienceRepo;
@Service
public class LoanService {

    @Autowired
    ExperienceRepo experienceRepo;

    public ResponseObject getLoanData(LoanRequest loanRequest){
        return experienceRepo.getLoanDetails(loanRequest);
    }

    public ResponseObject updatedLoanData(LoanTenurechangeRequest loanTenurechangeRequest){
        return  experienceRepo.updateTenure(loanTenurechangeRequest);
    }

    public ResponseObject confirmLoan(LoanConfirmationRequest loanConfirmationRequest){
        return experienceRepo.ConfirmLoan(loanConfirmationRequest);
    }

}
