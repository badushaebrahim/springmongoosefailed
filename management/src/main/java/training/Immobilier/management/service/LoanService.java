package training.Immobilier.management.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.Immobilier.management.model.repo.LoanRepo;
import training.Immobilier.management.model.request.LoanRequest;
import training.Immobilier.management.model.response.LoanResponse;

@Slf4j
@Service
public class LoanService {

    @Autowired
    LoanRepo loanRepo;

    public LoanResponse get(LoanRequest loanRequest) {
        float rate = 0;
        float fee = 0;
        switch (loanRequest.getTenure()) {
            case 60:
                rate = 6;
                fee = 2;
                break;
            case 48:
                rate = 6.5f;
                fee = 2.5f;
                break;
            case 36:
                rate = 7;
                fee = 3;
                break;
            case 24:
                rate = 7.5f;
                fee = 3.5f;
                break;
            case 12:
                rate = 8;
                fee = 4;
                break;

        }
        int installment = calculateEmi(loanRequest.getLoanAmount(), rate, loanRequest.getTenure());
        int totalAmount = installment * loanRequest.getTenure();
        int totalIntrest = (int) Math.round(totalAmount - loanRequest.getLoanAmount());
        log.info(String.valueOf(totalIntrest) + loanRequest.getTenure());

        return new LoanResponse(installment, rate, totalIntrest, fee, (totalAmount + fee));
    }

    int calculateEmi(double principal, double rate, float duration) {
        float year = duration;
        rate = rate / (12 * 100);
//        year=year*12;
        Double result = (principal * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);
        int emi = (int) Math.round(result);
        return emi;
    }
}
