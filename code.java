import java.util.InputMismatchException;
import java.util.Scanner;

public class code {

	public static void main(String[]args){
		
		Scanner scanny = new Scanner(System.in);
		
		boolean done = false;
		
		System.out.println("Hello user, please enter 2 numbers: ");
		
		int a;
		int b;
		while(!done){
		try {
          	a = scanny.nextInt();
			b = scanny.nextInt();
			
			int result = 0;
			
			result = a + b;
			System.out.println("The sum of your numbers " + a + " and " + b + " is: " + result);
                }
            catch (InputMismatchException e){
            	System.out.println("ERROR: Enter numbers!");
            	scanny.nextLine();
            }
		}
	}
}