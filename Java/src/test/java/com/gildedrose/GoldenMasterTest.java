package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldenMasterTest {

    PrintStream defaultOut = System.out;
    private ByteArrayOutputStream os;

    @BeforeEach
    void setup() {
        os = captureOutput();
    }

    @AfterEach
    void tearDown() {
        restoreDefaultOut();
    }

    @Test
    void golden_master() throws Exception {
        TexttestFixture.main(new String[]{"50"});

        assertEquals(readExpected(), os.toString());
    }

    private void restoreDefaultOut() {
        System.setOut(defaultOut);
    }

    private String readExpected() throws URISyntaxException, IOException {
        URI uri = this.getClass().getResource("/golden_master.txt").toURI();
        return new String(Files.readAllBytes(Paths.get(uri)));
    }

    private ByteArrayOutputStream captureOutput() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        return os;
    }
}
