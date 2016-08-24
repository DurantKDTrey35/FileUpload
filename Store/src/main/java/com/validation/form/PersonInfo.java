package com.validation.form;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import groovyjarjarantlr.collections.List;


public class PersonInfo {

    @Size(min=2, max=30 , message="File Name Length must be from 2 to 30!")
    private String name;
/*
    @NotNull(message="ID must be inputed!")
    @Min(value = 12, message = "ID must be at least 1!")
    private Integer aid;
*/
    @Size(min=2, max=30 , message="File State Length must be from 2 to 30!")
    private String state;
   // private String FileName;
    public ArrayList<String> FileName = new ArrayList<String>();
    private String str;
    private int q;
    

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
        FileName.add(this.name);
        q+=1;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
        FileName.add(this.state);
        q+=1;
        
    } 
    
    public String Array() {
    	System.out.println("Test №2  " + q);
    	
    	 for (int i = 0; i < q; i++) {
   		   System.out.print(FileName.get(i) + "  ");
    	 }
    	
    	return "";
    }  
    
    public String toString() {
    	System.out.println("Test №1");
    	
    	return "(File Name: " + this.name + ", State: " + this.state + ")";
    }   
}