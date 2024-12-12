package pairmatching.io.parser;

import static pairmatching.constants.ErrorMessages.INVALID_FUNCTION_TYPE_ERROR;
import static pairmatching.constants.ErrorMessages.INVALID_INPUT_ERROR;
import static pairmatching.constants.StringConstants.COURSE_MISSION_INPUT_FORMAT;
import static pairmatching.constants.StringConstants.LEVEL_INPUT_FORMAT;
import static pairmatching.domain.FunctionType.isValidFunction;
import static pairmatching.domain.Level.isValidMission;
import static pairmatching.util.Utils.splitInputWithComma;
import static pairmatching.util.Utils.validateEmptyInput;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InputParser {
    public String parseFunctionType(String input) {
        validateEmptyInput(input);
        if (!isValidFunction(input)) {
            throw new IllegalArgumentException(INVALID_FUNCTION_TYPE_ERROR);
        }
        return input;
    }

    public List<String> parseCourseLevelMission(String input) {
        validateEmptyInput(input);

        List<String> inputs = Arrays.asList(splitInputWithComma(input));
        validate(inputs);

        return inputs;
    }

    private void validate(List<String> inputs) {
        String course = inputs.get(0);
        String level = inputs.get(1);
        String mission = inputs.get(2);

        isValidCourseAndMission(course, mission);
        isValidLevel(level);
        isValidMission(level, mission);
    }

    private void isValidCourseAndMission(String course, String mission) {
        isValidCourseAndMissionFormat(course, mission);
        checkCourseExistence(course);
    }

    private void isValidCourseAndMissionFormat(String course, String mission) {
        if (!course.matches(COURSE_MISSION_INPUT_FORMAT) ||
                !mission.matches(COURSE_MISSION_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private void checkCourseExistence(String course) {
        if (!Course.isValidCourse(course)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private void isValidLevel(String level) {
        isValidLevelFormat(level);
        checkLevelExistence(level);
    }

    private void isValidLevelFormat(String level) {
        if (!level.matches(LEVEL_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private void checkLevelExistence(String level) {
        if (!Level.isValidLevel(level)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
