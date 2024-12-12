package pairmatching.io.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.io.reader.FileReaderReader;
import pairmatching.io.reader.Reader;

public class FrontEndFileLineParser {

    public final static String FRONT_END_CREW_NAMES = "src/main/resources/frontend-crew.md";

    public List<String> readFrontEndCrewFileInput() {
        try {
            return readFrontEndCrewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readFrontEndCrewFile() throws IOException {
        Reader reader = new FileReaderReader(FRONT_END_CREW_NAMES);
        reader.readLine();
        String line;
        List<String> frontEndCrewList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            frontEndCrewList.add(line);
        }
        return frontEndCrewList;
    }
}
