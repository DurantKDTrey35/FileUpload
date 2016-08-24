package com.validation;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootValidationTutorialApplication {
		////////////////////////
		static Scanner scn;
		static String[][] m = new String[5][3];
		static Formatter zap;
		////////////////////////
	public static void main(String[] args) {
        openFile();
        readFile();
        out();
        write();
		SpringApplication.run(SpringbootValidationTutorialApplication.class, args);
	}
	//////////////////////открытие-запись в файл    
		private static void openFile() {
	        try{
	        	scn = new Scanner(new File("res//notes.txt"));
	        }
	        catch(IOException e){            
	            JOptionPane.showMessageDialog(null, "File not found");
	        } 
		}	
		private static void readFile() {
			while(scn.hasNext()){
				for(int row=0;row<m.length;row++){
					for(int col=0;col<m[row].length;col++){
						m[row][col] = scn.next();
					}
				}
			}
		}
		private static void out() {
			for(int row=0;row<m.length;row++){
				for(int col=0;col<m[row].length;col++){
					System.out.print(m[row][col]+" ");
				}
				System.out.println();
			}
		}
		private static void write() {
			String FN = "name", ID = "id", ST = "state";
			try{
				zap = new Formatter("res//notes.txt");
				zap.format("FileName %s,    ID %s,   State %s", FN, ID, ST);
				zap.close();
			}catch(IOException e){}
		}
		/////////////////////////////////////////////////////////////
}