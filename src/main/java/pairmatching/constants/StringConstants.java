package pairmatching.constants;

public class StringConstants {
    public static final String COMMA = ",";
    public static final String DASH = "-";
    public static final String EMPTY_STRING = "";
    public static final String ONE_SPACE = " ";
    public static final String NEW_LINE = "\n";
    public static final String TAP = "\t";

    public static final String DATE_TIME_FORMATTER_PATTERN = "yyyy-MM-dd";
    public static final String NUMBER_FORMAT_WITH_COMMA = "%,d";

    // 정규 표현식
    // TODO: 여러 경우의 수 추가하기
    public static final String STRING_NUMBER_WITH_DASH_INPUT_FORMAT = "^[가-힣a-zA-Z]+-\\d+$"; // "문자열-숫자" 형식
    public static final String STRING_NUMBER_WITH_DASH_AND_BRACKET_INPUT_FORMAT = "^\\[[가-힣a-zA-Z]+-\\d+\\]$"; // "[문자열-숫자]" 형식
    public static final String COURSE_MISSION_INPUT_FORMAT = "^[가-힣]+$"; // "문자열" 형식(한글만)
    public static final String LEVEL_INPUT_FORMAT = "^[가-힣]+\\d+$"; // "문자열숫자" 형식(한글만)

}
