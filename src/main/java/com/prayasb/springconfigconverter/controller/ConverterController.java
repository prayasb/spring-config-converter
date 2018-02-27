package com.prayasb.springconfigconverter.controller;

import com.prayasb.springconfigconverter.converter.XMLConfigConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    private final XMLConfigConverter xmlConfigConverter;

    @Autowired
    public ConverterController(XMLConfigConverter xmlConfigConverter) {
        this.xmlConfigConverter = xmlConfigConverter;
    }

    @RequestMapping("/config/xml")
    public String convertXMLConfiguration(@RequestParam("file")MultipartFile file) {

    }
}
