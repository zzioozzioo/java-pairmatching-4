package pairmatching.io.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.io.reader.FileReaderReader;
import pairmatching.io.reader.Reader;

public class BackEndFileLineParser {

    public final static String BACK_END_CREW_NAMES = "src/main/resources/backend-crew.md";

    public List<String> readBackEndCrewFileInput() {
        try {
            return readBackEndCrewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readBackEndCrewFile() throws IOException {
        Reader reader = new FileReaderReader(BACK_END_CREW_NAMES);
        reader.readLine();
        String line;
        List<String> backEndCrewList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            backEndCrewList.add(line);
        }
        return backEndCrewList;
    }
}
