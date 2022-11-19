package training.Immobilier.experience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import training.Immobilier.experience.model.request.LoanConfirmationRequest;
import training.Immobilier.experience.model.request.LoanRequest;
import training.Immobilier.experience.model.request.LoanTenurechangeRequest;
import training.Immobilier.experience.model.responses.ResponseObject;
import training.Immobilier.experience.service.LoanService;

import java.util.Optional;

@RestController

public class LoanController {

    @Autowired
    LoanService loanService;
    @PostMapping
    public  ResponseEntity<ResponseObject> getLoanData(LoanRequest loanRequest){
        try {
            return new ResponseEntity<>(loanService.getLoanData(loanRequest),HttpStatus.ACCEPTED);

        }catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public  ResponseEntity<ResponseObject> updateLoanTenure(LoanTenurechangeRequest loanTenurechangeRequest){
        try {
            return new ResponseEntity<>(loanService.updatedLoanData(loanTenurechangeRequest),HttpStatus.ACCEPTED);

        }catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/confirm")
    public  ResponseEntity<ResponseObject> confirmLoan(LoanConfirmationRequest loanConfirmationRequest){
        try {
            return new ResponseEntity<>(loanService.confirmLoan(loanConfirmationRequest),HttpStatus.ACCEPTED);

        }catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }



}
