package com.rajesh.Calculator.Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajesh.Calculator.CalculatorApplication;
import com.rajesh.Calculator.Model.CalculatorResponse;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private CalculatorApplication calculator ;
	
	@RequestMapping("/")
	public String calculator() {
		return "calculator";
		
	}
	
    @RequestMapping("/calculate")
    public ResponseEntity<CalculatorResponse> calculate(@RequestBody String displayvalue) {
        try {
      
            	 String result = Dispalyvalues(displayvalue);
            	 
            
           
        	System.out.println("expression "+result );
            
            
            return ResponseEntity.ok(new CalculatorResponse(result));
        } catch (ArithmeticException | NumberFormatException e) {
            return ResponseEntity.badRequest().body(new CalculatorResponse("Error"));
        }
    }

    private String Dispalyvalues(String displayvalue) {
      int num1=0;
  	  int num2=0;
    	  String operator=null;
    	 Pattern pattern = Pattern.compile("(\\d+)([+\\-*/])(\\d+)");
         Matcher matcher = pattern.matcher(displayvalue);
           System.out.println("pattern"  + pattern );
           System.out.println("matchetr"+matcher);
         if (matcher.matches()) {
         
             String num1String = matcher.group(1);
             System.out.println("num1String" +num1String);
             
           operator = matcher.group(2); 
             String num2String = matcher.group(3);
              num1 = Integer.parseInt(num1String);
             num2 = Integer.parseInt(num2String);
         }
        
         switch (operator) {
         case "+":
        	 String adding = String.valueOf(calculator.add(num1, num2));
             return adding;
         case "-":
        	 String sub= String.valueOf(calculator.subtract(num1, num2));
             return sub;
         case "*":
        	 String multiply=String.valueOf(calculator.multiply(num1, num2));
             return multiply;
         case "/":
        	String divide=String.valueOf( calculator.divide(num1, num2));
             return divide;
         default:
             throw new IllegalArgumentException("Invalid operator.");
     }
 }


}

