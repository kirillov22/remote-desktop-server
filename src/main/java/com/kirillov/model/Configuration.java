package com.kirillov.model;

import com.beust.jcommander.Parameter;

public class Configuration {
    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;

    public boolean isDebug() {
        return debug;
    }
}
