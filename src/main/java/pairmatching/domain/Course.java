package pairmatching.domain;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean isValidCourse(String input) {
        for (Course course : Course.values()) {
            if (course.getName().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
