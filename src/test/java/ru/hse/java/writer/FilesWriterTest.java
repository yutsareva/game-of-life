package ru.hse.java.writer;

import org.junit.Test;

import java.time.Duration;

public class FilesWriterTest {
    public final String path = "src/main/resources/examples/kek.json";

    @Test
    public void writeHeightTest() {
        FilesWriter curWriter = new FilesWriter(path);
        curWriter.writeHeight(33);
    }

    @Test
    public void writeIterationTimeInterval() {
        FilesWriter curWriter = new FilesWriter(path);
        curWriter.writeIterationTimeInterval(Duration.ofMillis(250L));
    }
}
