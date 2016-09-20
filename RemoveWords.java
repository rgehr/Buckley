import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveWords {

	public static void main(String[]args) throws Exception{
	
		
		/*
		 * COMMENTED SECTION IS FOR TERMINAL -- could not check if it works because I 
		 * "did not have permission to access file"
		 * 
		 * At the bottom is a version that runs in eclipse that I can confirm works.
		 * */
//		if(args.length != 2){
//			System.out.println("Usage: java RemoveWords word file");
//			System.exit(1);
//		}
//		
//		File sourceFile = new File(args[1]);
//		if(!sourceFile.exists()){
//			System.out.println("File " + args[1] + " does not exist");
//			System.exit(2);
//		}
//		
//		File tempFile = new File("tempFile.txt");
//		if(tempFile.exists()){
//			System.out.println("File tempFile already exits. Please move/delete it and try again");
//			System.exit(3);
//		}
		
//		Scanner scanny = new Scanner(sourceFile);
//		while(scanny.hasNextLine()){
//			s1 += scanny.nextLine();
//			s1 += "\n";
//			System.out.println(s1); //Debug
//		}
//		scanny.close();
//		s2 = s1.replaceAll(args[0], "");
//		System.out.println(s2); //Debug
//		PrintWriter output = new PrintWriter(sourceFile);
//		output.print(s2);
//		output.close();
//			
//		}
		String s1 = "";
		String s2 = "";
		String replaceWord = "world";
		File sourceFile = new File("sometext.txt");
		if(!sourceFile.exists()){
			System.out.println("File does not exist");
			System.exit(1);
		}
		Scanner scanny = new Scanner(sourceFile);
		while(scanny.hasNextLine()){
			s1 += scanny.nextLine();
			s1 += "\n";
			System.out.println(s1); //Debug
		}
		scanny.close();
		s2 = s1.replaceAll(replaceWord, "");
		System.out.println(s2); //Debug
		PrintWriter output = new PrintWriter(sourceFile);
		output.print(s2);
		output.close();
		
	}
	
}
