package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontEnd {

    private final List<String> crewNames;

    private Map<Level, Map<String, Map<String, String>>> frontEndMatchingResult; // 프론트엔드 매칭

    public FrontEnd(List<String> crewNames) {
        this.crewNames = crewNames;
        frontEndMatchingResult = new HashMap<>();
    }

    public List<String> getCrewNames() {
        return crewNames;
    }

    public Map<Level, Map<String, Map<String, String>>> getFrontEndMatchingResult() {
        return frontEndMatchingResult;
    }

    public void updateMatchingResult(Map<Level, Map<String, Map<String, String>>> frontEndMatchingResult) {
        this.frontEndMatchingResult = frontEndMatchingResult;
    }
}
