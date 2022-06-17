  
import java.util.Scanner;

 
public class Calculator {


	public static void main(String[] args) {
	     String operation = new String();
		 int num1;
		 int num2;
		 int intResult;
		 
	 	 double firstDouble;
		 double secondDouble;
		 double doubleResult;
		 
	     String inputStringOne = new String();
	     String inputStringTwo = new String();
	 
		
 		Scanner input= new Scanner(System.in);
		System.out.println("List of operations: add, subtract, multiply, divide, alphabetize" );
		System.out.print("Enter an operation: ");
 		operation= input.nextLine().toLowerCase();
 	    
 		
 		switch (operation) {
 			case "add":
  				System.out.print("Enter two integers: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    num1 = input.nextInt();
                    num2 = input.nextInt();

                    intResult = num1 + num2;
                    System.out.println("Answer: " + intResult);
                }
                break;
			
 			case "subtract":
	            System.out.print("Enter two integers: ");
	
	            if (!input.hasNextInt()) {
	                System.out.println("Invalid input entered. Terminating...");
	            } else {
	                num1 = input.nextInt();
	                num2 = input.nextInt();
	                intResult = num1 - num2;
	                System.out.println("Answer: " + intResult);
	            }
	            break;
			
 			case "multiply":
	 			System.out.print("Enter two doubles: ");
	 			  if (!input.hasNextDouble() && !input.hasNextInt()) {
	                  System.out.println("Invalid input entered. Terminating...");
	              } else {
	                    firstDouble = input.nextDouble();
	                    secondDouble = input.nextDouble();
	                    doubleResult = firstDouble * secondDouble;
	                  System.out.println("Answer: " + String.format("%.2f", doubleResult));
	              }
               break;
 	  			 
 			 
			
			case "divide":
	            System.out.println("Enter two doubles: ");
	
	            if (!input.hasNextDouble() && !input.hasNextInt()) {
	                System.out.println("Invalid input entered. Terminating...");
	            } else {
	                  firstDouble = input.nextDouble();
	                  secondDouble = input.nextDouble();
	
	                if (secondDouble == 0) {
	                    System.out.println("Invalid input entered. Terminating...");
	                } else {
	                      doubleResult = firstDouble / secondDouble;
	                    System.out.println("Answer: " + String.format("%.2f", doubleResult));
	                }
	            }
	            break;

			case "alphabetize":
	  			
	            System.out.println("Enter two words: ");
	            inputStringOne = input.next();
	            inputStringTwo = input.next();
	
	            char charValue1 = inputStringOne.toUpperCase().charAt(0);
	            char charValue2 = inputStringTwo.toUpperCase().charAt(0);
	            
	            int asciiValue1 = charValue1;
	            int asciiValue2 = charValue2;
	    
	
	            if (asciiValue1 < asciiValue2) {
	                System.out.println("Answer: " + inputStringOne + " comes before " + inputStringTwo + " alphabetically.");
	            } else if (asciiValue1 > asciiValue2) {
	                System.out.println("Answer: " + inputStringTwo + " comes before " + inputStringOne + " alphabetically.");
	            } else if (asciiValue1 == asciiValue2) {
	                System.out.println("Answer: Chicken or Egg.");
	            }		 
	 	 	        break;
	 	     
			default:
				System.out.println("Invalid input entered. Terminating...");
				break;
		
		}
	}
}

