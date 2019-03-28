package ru.job4j;

import javafx.scene.Group;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import ru.job4j.chess.Chess;
import ru.job4j.chess.Logic;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
