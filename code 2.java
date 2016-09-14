import java.util.Scanner;

public class code {

	public static void main(String[]args){
		
		boolean done = false;
		Scanner scanny = new Scanner(System.in);
		double side1 = 1.0;
		double side2 = 1.0;
		double side3 = 1.0;
		
		while(!done){
			try{
				side1 = scanny.nextDouble();
				side2 = scanny.nextDouble();
				side3 = scanny.nextDouble();
				Triangle tri1 = new Triangle(side1, side2, side3);
			}catch(IllegalTriangleException e){
				System.out.println(e.getMessage());
				System.out.println("Enter lengths again: ");
				scanny.nextLine();
			}
		}
	}
	
}

class IllegalTriangleException extends Exception{
	
	private double side = 1.0;
	
	IllegalTriangleException(double side){
		super(side + " is larger than than the sum of the other 2 sides or is negative");
	}
	
	public double getSide1(){
		return side;
	}
	
}

class Triangle{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}
	
	Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
		
		if((side1 >= side2 + side3) || Math.abs(side1) != side1){
			throw new IllegalTriangleException(side1);
		}
		else if((side2 >= side1 + side3) || Math.abs(side2) != side2){
			throw new IllegalTriangleException(side2);
		}
		else if((side3 >= side2 + side1) || Math.abs(side3) != side3){
			throw new IllegalTriangleException(side3);
		}
		else{
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
	}
	
	public double getArea(){
		double s = (side1 + side2 + side3)/2;
		
		double a = Math.sqrt((s*(s - side1)) * (s*(s - side2)) * (s*(s - side3)));
		
		return a;
	}
	
	public double getPerimiter(){
		double p = side1 + side2 + side3;
		return p;
	}
	
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
