package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackEnd {

    private final List<String> crewNames; // 크루 이름 목록
    private Map<Level, Map<String, Map<String, String>>> backEndMatchingResult; // 백엔드 매칭
    // TODO: 홀수인 경우는 구현 못 하겠다ㅜㅜㅜ

    public BackEnd(List<String> crewNames) {
        this.crewNames = crewNames;
        initResult();
    }

    public List<String> getCrewNames() {
        return crewNames;
    }

    public Map<Level, Map<String, Map<String, String>>> getBackEndMatchingResult() {
        return backEndMatchingResult;
    }

    public void initResult() {
        backEndMatchingResult = new HashMap<>();
    }

    public void updateMatchingResult(Map<Level, Map<String, Map<String, String>>> backEndMatchingResult) {
        this.backEndMatchingResult = backEndMatchingResult;
    }
}
