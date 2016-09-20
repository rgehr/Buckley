import java.io.File;
import java.util.Scanner;

public class LetterCount {

	public static void main(String[]args) throws Exception{
		
		Scanner scanny = new Scanner(System.in);
		
		System.out.println("Please enter the name of the file you would like to open: ");
		
		String fileName = scanny.next();
		
		File sourceFile = new File(fileName);
		if(!sourceFile.exists()){
			System.out.println("File not found");
			System.exit(1);
		}
		
		Scanner input = new Scanner(sourceFile);
		
		String line = "";
		while(input.hasNextLine()){
			line += input.nextLine();
		}
		input.close();
		line = line.toUpperCase();
		int count = 0;
		for(int j = 65; j < 91; j++){
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i) == (char)j){
					count++;
				}
			}
			System.out.println((char)j + ": " + count);
			count = 0;
		}
		
	}
	
}
