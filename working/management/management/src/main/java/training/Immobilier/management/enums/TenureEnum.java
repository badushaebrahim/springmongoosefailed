package training.Immobilier.management.enums;

public enum TenureEnum {

    Month60(60),
    Month45(45),
    Month36(36),
    Month24(24),
    Month12(12);

    private int tenure;


    TenureEnum(int i) {
        tenure=i;
    }
}
