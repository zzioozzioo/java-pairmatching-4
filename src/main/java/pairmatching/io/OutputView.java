package pairmatching.io;

import static pairmatching.constants.StringConstants.NEW_LINE;

import pairmatching.io.writer.Writer;

public class OutputView {

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void readRematchOrNot() {
        writer.write("매칭 정보가 있습니다. 다시 매칭하시겠습니까?" + NEW_LINE + "네 | 아니오" + NEW_LINE);
    }

    public void printErrorMessage(String errorMessage) {
        writer.write(errorMessage);
    }
}
