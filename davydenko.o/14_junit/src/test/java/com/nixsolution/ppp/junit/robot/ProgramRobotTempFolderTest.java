package com.nixsolution.ppp.junit.robot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class ProgramRobotTempFolderTest {

    private Program program;
    private Path path;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void givenFileRobotProgram() {
        path = temporaryFolder.getRoot().toPath().resolve("test.txt");
        Robot robot = new Robot(0, 0, Direction.RIGHT);
        program = new Program(robot, path);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUnknownCommand() {
        //when
        program.writeRouteToFile("UnknownCommandForRobot");
    }

    @Test
    public void shouldHaveCorrectDirectionAfterThreeStepForward() throws IOException {
        //when
        program.writeRouteToFile("fff");
        //then
        assertEquals("1 0\n2 0\n3 0\n", readFromFile());
    }
    @Test
    public void shouldHaveCorrectDirectionAfterTernLeft() throws IOException {
        //when
        program.writeRouteToFile("lff");
        //then
        assertEquals("0 1\n0 2\n",readFromFile());

    }

    @Test
    public void shouldHaveCorrectDirectionAfterTernRight() throws IOException{
        //when
        program.writeRouteToFile("rff");
        //then
        assertEquals("0 -1\n0 -2\n",readFromFile());
    }

    @Test
    public void shouldHaveCorrectDirectionAfterThisRoute() throws IOException{
        //when
        program.writeRouteToFile("rffllff");
        //then
        assertEquals("0 -1\n0 -2\n0 -1\n0 0\n",readFromFile());
    }

    private String readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines(path)
                .forEach((s) -> sb.append(s)
                        .append("\n"));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}