package com.example.week1jvc;

import java.io.IOException;
import java.util.stream.Stream;

public interface IFileManager {
    Stream<String> readFile(String pathFile) throws IOException;
}
