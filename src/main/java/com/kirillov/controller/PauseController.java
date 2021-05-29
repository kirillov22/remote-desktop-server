package com.kirillov.controller;

import com.kirillov.model.Constants;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;

@Controller("/pause-play")
public class PauseController {
    @Inject
    ApplicationContext applicationContext;

    @Post(produces = MediaType.TEXT_PLAIN)
    public String pausePlay() throws AWTException, InterruptedException {

        if (applicationContext.getEnvironment().getActiveNames().contains(Constants.DEBUG)) {
            Thread.sleep(5000);
        }

        var robot = new Robot();
        // Simulate the key press K
        robot.keyPress(KeyEvent.VK_K);
        robot.keyRelease(KeyEvent.VK_K);

        return "ISSUED PAUSE/ PLAY COMMAND";
    }
}
