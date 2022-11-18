package training.Immobilier.management.service;

import org.springframework.stereotype.Service;
import training.Immobilier.management.exceptions.TenureException;

import static training.Immobilier.management.constants.IntrestAndFee.*;
import static training.Immobilier.management.constants.IntrestAndFee.TWELEVE_MONTH_FEE;

@Service
public class CalculationService {
    int calculateInstallment(double principal, double rate, float duration) {
        float year = duration;
        rate = rate / (12 * 100);

        Double result = (principal * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);
        int installment = (int) Math.round(result);
        return installment;
    }
    float[] calculteFeeAndIntrestrate(int duration){
        float intrestRate =0;
        float fee =0;
        float[]data= new float[2];
        switch (duration) {
            case 60:
                intrestRate = SIXTY_MONTH_INTREST;
                fee = SIXTY_MONTH_FEE;
                break;
            case 48:
                intrestRate = FOURTY_EIGHT_MONTH_INTREST;
                fee = FOURTY_EIGHT_MONTH_FEE;
                break;
            case 36:
                intrestRate = THIRTY_SIX_MONTH_INTREST;
                fee = THIRTY_SIX_MONTH_FEE;
                break;
            case 24:
                intrestRate = TWENTY_FOUR_MONTH_INTREST;
                fee = TWENTY_FOUR_MONTH_FEE;
                break;
            case 12:
                intrestRate = TWELEVE_MONTH_INTREST;
                fee = TWELEVE_MONTH_FEE;
                break;
            default:
                throw new TenureException();
        }
        data[0]=intrestRate;
        data[1]=fee;
        return data;
    }
}
