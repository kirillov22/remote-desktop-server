package com.kirillov.controller;

import com.kirillov.model.Constants;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;

@Controller("/window")
public class WindowController {
    @Inject
    ApplicationContext applicationContext;

    @Post(value = "/close", produces = MediaType.TEXT_PLAIN)
    public String closeWindow() throws AWTException, InterruptedException {

        if (applicationContext.getEnvironment().getActiveNames().contains(Constants.DEBUG)) {
            Thread.sleep(5000);
        }

        var robot = new Robot();
        // Simulate the key press CTRL + W
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_W);

        return "ISSUED CLOSE WINDOW COMMAND";
    }

    @Post(value = "/openPrevious", produces = MediaType.TEXT_PLAIN)
    public String openPreviousWindow() throws AWTException, InterruptedException {

        if (applicationContext.getEnvironment().getActiveNames().contains(Constants.DEBUG)) {
            Thread.sleep(5000);
        }

        var robot = new Robot();
        // Simulate the key press CTRL + SHIFT + T
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_T);

        return "ISSUED OPENED LAST WINDOW COMMAND";
    }
}
