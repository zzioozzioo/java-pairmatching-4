package pairmatching.service;

import pairmatching.domain.BackEnd;
import pairmatching.domain.FrontEnd;
import pairmatching.io.parser.BackEndFileLineParser;
import pairmatching.io.parser.FrontEndFileLineParser;

public class SettingService {


    public BackEnd getBackEnd() {
        return new BackEnd(new BackEndFileLineParser().readBackEndCrewFileInput());
    }

    public FrontEnd getFrontEnd() {
        return new FrontEnd(new FrontEndFileLineParser().readFrontEndCrewFileInput());
    }
}
