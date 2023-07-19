package com.rajesh.Calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		}
	
   //Logics Of clculations....//
	
	public int add(int num1,int num2) {
		return num1+num2;
	}
	public int subtract(int num1,int num2) {
		return num1-num2;
	}
	public int multiply(int num1,int num2) {
		return num1*num2;
	}
	public int divide(int num1,int num2) {
		
		if(num2==0) {
			 throw new ArithmeticException("zero is not allowed.."); 
			
		}
		return num1/num2;
	}
	
	    
	}
