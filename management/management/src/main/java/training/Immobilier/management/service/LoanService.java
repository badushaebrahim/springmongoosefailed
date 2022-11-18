package training.Immobilier.management.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.Immobilier.management.enums.LoanStatusEnums;
import training.Immobilier.management.enums.SalaryRangeEnum;
import training.Immobilier.management.model.entity.LoanEntity;
import training.Immobilier.management.model.repo.LoanRepo;
import training.Immobilier.management.model.request.LoanConfirmationRequest;
import training.Immobilier.management.model.request.LoanRequest;
import training.Immobilier.management.model.request.LoanTenurechangeRequest;
import training.Immobilier.management.model.response.LoanResponse;
import training.Immobilier.management.model.wrap.Whole;

@Slf4j
@Service
public class LoanService {

    @Autowired
    LoanRepo loanRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CalculationService calculationService;

    public LoanResponse getLoanData(LoanRequest loanRequest) {
//        log.info(loanRequest.getSalaryRange());
//        if ( loanRequest.getSalaryRange().equals("300 JOD - 500 JOD") ||
//                loanRequest.getSalaryRange().equals("500 JOD - 750 JOD") )
//
//         {
        float[] values = calculationService.calculteFeeAndIntrestrate(loanRequest.getTenure());
        float intrestRate = values[0];
        float fee = values[1];

        int installment = calculationService.calculateInstallment(loanRequest.getLoanAmount(), intrestRate, loanRequest.getTenure());
        int totalAmount = installment * loanRequest.getTenure();
        int totalInterest = (int) Math.round(totalAmount - loanRequest.getLoanAmount());
        log.info(String.valueOf(totalInterest) + loanRequest.getTenure());
        LoanResponse loanResponse = new LoanResponse(null, installment, intrestRate, totalInterest, fee, (totalAmount + fee));
        Whole whole = new Whole(loanRequest, loanResponse);
        log.info(whole.toString());
        LoanEntity loanEntity = modelMapper.map(whole, LoanEntity.class);
        loanEntity.setSalaryRangeEnum(SalaryRangeEnum.valueOf(loanRequest.getSalaryRange().name()));
        loanEntity.setLoanResponseStatus(LoanStatusEnums.PENDING);

        LoanEntity loanEntity1 = loanRepo.save(loanEntity);
        loanResponse.setId(loanEntity1.getId());

        return loanResponse;
    }

    public LoanResponse updatedLoanData(LoanTenurechangeRequest loanTenurechangeRequest) {
        float[] values = calculationService.calculteFeeAndIntrestrate(loanTenurechangeRequest.getTenure());
        float interestRate = values[0];
        float fee = values[1];
        LoanEntity loanEntity = loanRepo.getReferenceById(loanTenurechangeRequest.getId());
        int installment = calculationService.calculateInstallment(loanEntity.getLoanRequestLoanAmount(), interestRate, loanTenurechangeRequest.getTenure());
        int totalAmount = installment * loanTenurechangeRequest.getTenure();
        int totalInterest = (int) Math.round(totalAmount - loanEntity.getLoanResponseTotal());
        log.info(String.valueOf(totalInterest) + loanTenurechangeRequest.getTenure());
        loanEntity.setLoanResponseInstallment(installment);
        loanEntity.setLoanResponseTotal(totalAmount);
        loanEntity.setLoanResponseIntrestRate(interestRate);
        loanEntity.setLoanResponseFees((int) fee);
        loanEntity.setLoanResponseTotalIntrestAmount(totalInterest);
        LoanResponse loanResponse = new LoanResponse(loanEntity.getId(), installment, interestRate, totalInterest, fee, (totalAmount + fee));

//            loanRepo.save(loanEntity);
        return loanResponse;
    }

    public LoanEntity confirmation(LoanConfirmationRequest loanConfirmationRequest) {

        if (loanConfirmationRequest.getStatusEnums().name().equals(LoanStatusEnums.CONFIRMED.name())) {
            log.info("set");
            LoanEntity loanEntity = loanRepo.getReferenceById(loanConfirmationRequest.getId());
//            loanEntity.setLoanResponseStatus(LoanStatusEnums.CONFIRMED);
//            loanRepo.save(loanEntity);
            return loanEntity;
        } else {
            log.info("no set");
            LoanEntity loanEntity = loanRepo.getReferenceById(loanConfirmationRequest.getId());
            return loanEntity;
        }
    }


}
