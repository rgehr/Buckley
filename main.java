
public class main {
	
	public static void main(String []args){
		
		StringBuilder stringBuilder = new StringBuilder();
		
		int rand; 
		int j = 1;
		
		for(int i = 0; i < 1111; i++){
			rand = 33 + (int)(Math.random() * ((126 - 33) + 1));
			char newChar = (char)rand;
			stringBuilder.append(newChar);
			if(j==101){
				System.out.println();
				System.out.print(newChar);
				j = 1;
			}
			else{
				System.out.print(newChar);
			}
			j++;
		}
	}
}
