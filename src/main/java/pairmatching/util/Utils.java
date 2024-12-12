package pairmatching.util;

import static pairmatching.constants.ErrorMessages.NON_NUMERIC_ERROR;
import static pairmatching.constants.StringConstants.COMMA;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

    // 빈 입력값에 대한 유효성 검사하는 메서드
    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            // TODO: 예외 메서드 수정하기
            throw new IllegalArgumentException();
        }
    }

    // 구분자로 나누는 메서드
    public static String[] splitInputWithComma(String input) {
        return input.split(COMMA, -1);
    }

    // 문자열을 정수로 변환하는 메서드
    public static int parseStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            // TODO: 예외 메서드 수정하기
            throw new IllegalArgumentException(NON_NUMERIC_ERROR);
        }
    }

    // map의 value, list 등의 총합 구하는 메서드
    public static int getSumOfValuesInMap(Map<String, Integer> map) {
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }
        return sum;
    }

    public static int getSumOfList(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    // 최대공약수, 최소공배수 구하는 메서드
    public static int getGCD(int num1, int num2) { // 최대공약수(숫자가 두개인 경우)
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static int getGCD(int[] arr) { // 최대공약수(배열인 경우)
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getGCD(result, arr[i]);
        }
        return result;
    }

    public static int getLCM(int num1, int num2) { // 최소공배수(숫자가 두개인 경우)
        return (num1 * num2) / getGCD(num1, num2);
    }

    public static int getLCM(int[] arr) { // 최소공배수(배열인 경우)
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getLCM(result, arr[i]);
        }
        return result;
    }

    // 리스트 내의 중복 체크하는 메서드
    public static boolean isDataDuplicated(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return list.size() != set.size();
    }
}
