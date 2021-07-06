package com.example.demo.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
public class HelloController {

    private InputStream is = null;

    @GetMapping("/hello")
    public String sayHello() throws IOException {
        return IOUtils.toString(is, Charset.defaultCharset());
    }

    @PostMapping(value = "/hello", consumes = {"application/json", "application/xml"})
    public void save(InputStream iss){
        this.is = iss;
    }
}
