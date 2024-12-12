package pairmatching.service;

import static pairmatching.constants.ErrorMessages.CANNOT_MATCH_PAIR;
import static pairmatching.domain.Level.matchLevelWithString;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import pairmatching.domain.BackEnd;
import pairmatching.domain.Course;
import pairmatching.domain.FrontEnd;
import pairmatching.domain.Level;

public class MatchingService {

    private final BackEnd backEnd;
    private final FrontEnd frontEnd;

    public MatchingService(BackEnd backEnd, FrontEnd frontEnd) {

        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
    }

    // 기존의 결과 존재 여부 확인
    public boolean hasExistingResult(List<String> courseLevelMission) {
        String course = courseLevelMission.get(0);
        String level = courseLevelMission.get(1);

        if (course.equals(Course.BACKEND.getName())) {
            Map<Level, Map<String, Map<String, String>>> backEndMatchingResult = backEnd.getBackEndMatchingResult();
            for (Level targetLevel : backEndMatchingResult.keySet()) {
                if (targetLevel.getGrade().equals(level)) {
                    if (backEndMatchingResult.get(targetLevel) != null) { // 기존 X
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 페어 매칭
    public void matchPair(List<String> courseLevelMission) {

        String course = courseLevelMission.get(0);
        String level = courseLevelMission.get(1);
        String mission = courseLevelMission.get(2);

        if (course.equals(Course.BACKEND.getName())) { // 백엔드 매칭
            matchBackEnd(level, mission);
            return;
        }
        // 프론트엔드 매칭
        matchFrontEnd(level, mission);
    }

    private void matchBackEnd(String level, String mission) {
        int count = 0;
        int index = 0;

        Level targetLevel = matchLevelWithString(level);
        Map<Level, Map<String, Map<String, String>>> backEndMatchingResult = backEnd.getBackEndMatchingResult();
        Map<String, Map<String, String>> missionAndMatchingResult = backEndMatchingResult.get(targetLevel);
        Map<String, String> matchingResult = missionAndMatchingResult.get(mission); // 크루 매칭 목록

        do {
            String crewA;
            String crewB;
            while (true) {
                List<String> shuffledNames = Randoms.shuffle(backEnd.getCrewNames());
                crewA = shuffledNames.get(index++);
                crewB = shuffledNames.get(index++);

                if (!matchingResult.get(crewA).equals(crewB) && !matchingResult.get(crewB)
                        .equals(crewA)) { // 페어 전적이 없다면
                    break;
                }
                if (++count >= 3) {
                    throw new IllegalArgumentException(CANNOT_MATCH_PAIR);
                }
            }
            matchingResult.put(crewA, crewB);
            backEnd.updateMatchingResult(backEndMatchingResult);
        } while (index < backEnd.getCrewNames().size());
    }

    private void matchFrontEnd(String level, String mission) {
        int count = 0;
        int index = 0;

        Level targetLevel = matchLevelWithString(level);
        Map<Level, Map<String, Map<String, String>>> frontEndMatchingResult = frontEnd.getFrontEndMatchingResult();
        Map<String, Map<String, String>> missionAndMatchingResult = frontEndMatchingResult.get(targetLevel);
        Map<String, String> matchingResult = missionAndMatchingResult.get(mission); // 크루 매칭 목록

        do {
            String crewA;
            String crewB;
            while (true) {
                List<String> shuffledNames = Randoms.shuffle(frontEnd.getCrewNames());
                crewA = shuffledNames.get(index++);
                crewB = shuffledNames.get(index++);

                if (!matchingResult.get(crewA).equals(crewB) && !matchingResult.get(crewB)
                        .equals(crewA)) { // 페어 전적이 없다면
                    break;
                }
                if (++count >= 3) {
                    throw new IllegalArgumentException(CANNOT_MATCH_PAIR);
                }
            }
            matchingResult.put(crewA, crewB);
            frontEnd.updateMatchingResult(frontEndMatchingResult);
        } while (index < frontEnd.getCrewNames().size());
    }
}
