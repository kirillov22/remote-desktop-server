package com.kirillov.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/connect")
public class ConnectionController {
    @Post(produces = MediaType.TEXT_PLAIN)
    public String connect() {

        return "Successfully made contact with server";
    }
}
