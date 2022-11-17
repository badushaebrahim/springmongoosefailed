package training.Immobilier.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import training.Immobilier.management.model.request.LoanRequest;
import training.Immobilier.management.model.response.LoanResponse;
import training.Immobilier.management.service.LoanService;

@RestController

public class LoanController {

    @Autowired
    LoanService loanService;
    @PostMapping
    public ResponseEntity<LoanResponse> get(@RequestBody LoanRequest loanRequest){
        return new ResponseEntity<>(loanService.get(loanRequest), HttpStatus.OK);
    }
}
