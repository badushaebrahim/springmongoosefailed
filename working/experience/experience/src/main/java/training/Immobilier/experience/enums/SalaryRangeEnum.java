package training.Immobilier.experience.enums;

public enum SalaryRangeEnum {
    JOD_300_TO_500("300 JOD - 500 JOD"),
    JOD_500_TO_750("500 JOD - 750 JOD"),
    JOD_750To1000("750 JOD - 1000 JOD"),
    JOD_1000_OR_ABOVE("more than 1000 JOD");

    private String salaryRange;

    SalaryRangeEnum(final String s) {
        salaryRange= s;
    }

}
