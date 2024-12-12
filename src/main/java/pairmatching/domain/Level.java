package pairmatching.domain;

import java.util.List;

public enum Level {

    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private final String grade;
    private final List<String> missions;

    Level(String grade, List<String> missions) {
        this.grade = grade;
        this.missions = missions;
    }

    public static boolean isValidLevel(String input) {
        for (Level level : Level.values()) {
            if (level.getGrade().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidMission(String level, String mission) {
        for (Level targetLevel : Level.values()) {
            if (targetLevel.getGrade().equals(level)) {
                if (targetLevel.getMissions().contains(mission)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getGrade() {
        return grade;
    }

    public List<String> getMissions() {
        return missions;
    }
}
