package com.nixsolution.ppp.junit.robot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockRobotTest {
    @Mock
    private Robot robot;

    private Program program;

    @Before
    public void initProgram() {
        robot = mock(Robot.class);
        program = new Program(robot);
    }

    @Test
    public void shouldHaveCorrectDirectionByDefault() {
        //when
        program.writeRouteToFile("fffffrrll");
        //then
        verify(robot, times(5)).stepForward();
        verify(robot, times(2)).turnRight();
        verify(robot, times(2)).turnLeft();
    }

    @Test
    public void shouldCallMethodStepForwardEachTimeWhenCommandContainCharF() {
        //when
        program.writeRouteToFile("lffrflfrrfffffff");
        //then
        verify(robot, times(11)).stepForward();
    }

    @Test
    public void shouldCallMethodStepForwardEachTimeWhenCommandContainCharL() {
        //when
        program.writeRouteToFile("lrrrfffrlll");
        //then
        verify(robot, times(4)).turnLeft();
    }

    @Test
    public void shouldCallMethodStepForwardEachTimeWhenCommandContainCharR(){
        //when
        program.writeRouteToFile("lllffflrfr");
        //then
        verify(robot, times(2)).turnRight();
    }
}