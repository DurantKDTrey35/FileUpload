package com.validation.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.validation.form.PersonInfo;

@Controller
public class SimpleWebController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String personalInfo(PersonInfo personInfo) {
        return "personInfo";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonInfo personInfo, BindingResult bindingResult) {

    	if (bindingResult.hasErrors()) {
            return "personInfo";
        }

        System.out.println(personInfo.toString());
        System.out.println(personInfo.Array());
        
        return "successful";
        //return "personInfo";
    }

}