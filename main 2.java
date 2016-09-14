import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[]args){
		
		int randInts [] = new int[100];
		Scanner scanny = new Scanner(System.in);
		int input;
		
		for(int i = 0; i<100; i++){
			
			randInts[i] = (int)(Math.random() * Integer.MAX_VALUE +1);
			
		}
		
		System.out.println("Hello user. Please choose an index of the array");
		try{
		input = scanny.nextInt();
		System.out.println("The number in this index is: " + randInts[input]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR: the chosen index does not exist");
		}
		catch(InputMismatchException e){
			System.out.println("ERROR: you did not input a number (0-99)");
		}
	}
	
}
