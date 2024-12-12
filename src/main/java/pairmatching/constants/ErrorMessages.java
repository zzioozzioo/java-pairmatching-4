package pairmatching.constants;

import static pairmatching.constants.StringConstants.NEW_LINE;

public class ErrorMessages {

    public static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";

    public static final String FILE_INPUT_ERROR = PREFIX_ERROR_MESSAGE + "파일 읽기 오류";
    public static final String NON_NUMERIC_ERROR = PREFIX_ERROR_MESSAGE + "입력값이 숫자가 아닙니다." + NEW_LINE;

    public static final String INVALID_FUNCTION_TYPE_ERROR = PREFIX_ERROR_MESSAGE + "유효하지 않은 기능입니다." + NEW_LINE;

    public static final String INVALID_INPUT_ERROR = PREFIX_ERROR_MESSAGE + "유효하지 않은 입력입니다." + NEW_LINE;
}
