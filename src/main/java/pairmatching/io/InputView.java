package pairmatching.io;

import static pairmatching.constants.StringConstants.NEW_LINE;

import pairmatching.io.reader.Reader;
import pairmatching.io.writer.Writer;

public class InputView {
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String readFunctionType() {
        writer.write("기능을 선택하세요." + NEW_LINE);
        String input = reader.readLine();
        writer.write(NEW_LINE);
        return input;
    }

    public String readCourseLevelMission() {
        writer.write("과정, 레벨, 미션을 선택하세요." + NEW_LINE);
        String input = reader.readLine();
        writer.write(NEW_LINE);
        return input;
    }
}
