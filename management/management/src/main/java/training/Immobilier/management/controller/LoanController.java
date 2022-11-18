package training.Immobilier.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import training.Immobilier.management.exceptions.TenureException;
import training.Immobilier.management.model.request.LoanConfirmationRequest;
import training.Immobilier.management.model.request.LoanRequest;
import training.Immobilier.management.model.request.LoanTenurechangeRequest;
import training.Immobilier.management.model.response.ResponseObject;
import training.Immobilier.management.service.LoanService;

import java.util.Optional;

@RestController

public class LoanController {

    @Autowired
    LoanService loanService;
    @PostMapping
    public ResponseEntity<ResponseObject> get( @RequestBody LoanRequest loanRequest){
        try{
            ResponseObject responseObject =new ResponseObject(Optional.ofNullable(loanService.getLoanData(loanRequest)), Optional.of(" "),"200");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);}
        catch (TenureException r){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(r.getMessage()),"500");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"500");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }
    }




    @PutMapping
    public ResponseEntity<ResponseObject> putWithTenure( @RequestBody LoanTenurechangeRequest loanTenurechangeRequest){
        try {
            ResponseObject responseObject =new ResponseObject(Optional.ofNullable(loanService.updatedLoanData(loanTenurechangeRequest)), Optional.of(" "),"200");
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        }catch (TenureException r){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(r.getMessage()),"400");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"500");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/confirm")
    public ResponseEntity<ResponseObject> Confirmation( @RequestBody LoanConfirmationRequest loanConfirmationRequest){
        try {
            ResponseObject responseObject =new ResponseObject(Optional.ofNullable(loanService.confirmation(loanConfirmationRequest)), Optional.of(" "),"200");
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        }catch (TenureException r){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(r.getMessage()),"400");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ResponseObject responseObject = new ResponseObject(Optional.ofNullable(null), Optional.ofNullable(e.getMessage()),"500");
            return new ResponseEntity<>(responseObject,HttpStatus.BAD_REQUEST);
        }

    }
}
