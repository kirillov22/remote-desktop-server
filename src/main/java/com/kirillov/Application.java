package com.kirillov;

import com.beust.jcommander.JCommander;
import com.kirillov.model.Configuration;
import com.kirillov.model.Constants;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {

        var config = new Configuration();
        JCommander.newBuilder()
                .addObject(config)
                .build()
                .parse(args);

        // Some janky way to init the environment
        var environment = config.isDebug() ? Constants.DEBUG : Constants.RELEASE;

        Micronaut
                .build(args)
                .environments(environment)
                .mainClass(Application.class)
                .start();
    }
}
