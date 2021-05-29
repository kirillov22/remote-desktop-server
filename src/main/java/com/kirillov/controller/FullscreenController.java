package com.kirillov.controller;

import com.kirillov.model.Constants;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;

@Controller("/fullscreen")
public class FullscreenController {
    @Inject
    ApplicationContext applicationContext;

    @Post(produces = MediaType.TEXT_PLAIN)
    public String fullscreen() throws AWTException, InterruptedException {

        if (applicationContext.getEnvironment().getActiveNames().contains(Constants.DEBUG)) {
            Thread.sleep(5000);
        }

        var robot = new Robot();
        // Simulate the key press F
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);

        return "ISSUED FULLSCREEN/ UN-FULLSCREEN COMMAND";
    }
}