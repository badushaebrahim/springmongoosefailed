package training.Immobilier.experience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import training.Immobilier.experience.exceptions.InvalidLoanAmountException;
import training.Immobilier.experience.exceptions.LoanRequestNotFoundError;
import training.Immobilier.experience.model.request.LoanConfirmationRequest;
import training.Immobilier.experience.model.request.LoanRequest;
import training.Immobilier.experience.model.request.LoanTenurechangeRequest;
import training.Immobilier.experience.model.responses.ResponseObject;
import training.Immobilier.experience.service.LoanService;

import javax.validation.Valid;
import java.util.Optional;

@RestController

public class LoanController {

    @Autowired
    LoanService loanService;
    @PostMapping
    public  ResponseEntity<ResponseObject> getLoanData( @RequestBody @Valid LoanRequest loanRequest){
        try {
            return new ResponseEntity<>(loanService.getLoanData(loanRequest),HttpStatus.ACCEPTED);

        }

        catch (InvalidLoanAmountException l){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(l.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public  ResponseEntity<ResponseObject> updateLoanTenure(@RequestBody LoanTenurechangeRequest loanTenurechangeRequest){
        try {
            return new ResponseEntity<>(loanService.updatedLoanData(loanTenurechangeRequest),HttpStatus.ACCEPTED);

        }
        catch (LoanRequestNotFoundError l){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(l.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/confirm")
    public  ResponseEntity<ResponseObject> confirmLoan(@RequestBody LoanConfirmationRequest loanConfirmationRequest){
        try {
            return new ResponseEntity<>(loanService.confirmLoan(loanConfirmationRequest),HttpStatus.ACCEPTED);

        }catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"400");
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }



}
