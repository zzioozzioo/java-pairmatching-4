package pairmatching.io.reader;

import static pairmatching.constants.ErrorMessages.FILE_INPUT_ERROR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderReader implements Reader {

    private final BufferedReader reader;

    public FileReaderReader(String fileName) {
        try {
            this.reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(FILE_INPUT_ERROR);
        }
    }
}
