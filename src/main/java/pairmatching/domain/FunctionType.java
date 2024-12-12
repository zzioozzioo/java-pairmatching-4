package pairmatching.domain;

public enum FunctionType {

    PAIR_MATCH("1", "페어 매칭"),
    PAIR_RETRIEVE("2", "페어 조회"),
    PAIR_INITIALIZE("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String function;
    private final String stringName;


    FunctionType(String function, String stringName) {
        this.function = function;
        this.stringName = stringName;
    }

    public static boolean isValidFunction(String input) {
        for (FunctionType functionType : FunctionType.values()) {
            if (functionType.getFunction().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public String getFunction() {
        return function;
    }

    public String getStringName() {
        return stringName;
    }
}
