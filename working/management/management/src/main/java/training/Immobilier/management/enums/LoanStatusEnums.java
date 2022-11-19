package training.Immobilier.management.enums;

public enum LoanStatusEnums {
    PENDING("Pending"),
    CONFIRMED("Confirmed");

    private String value;
    LoanStatusEnums(String value) {
        this.value = value;
    }
}
