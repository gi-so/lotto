import java.util.Random;


public class RandomNumber {
	
	 
	
	public int checkNumbers(int number, int randomNumbers[]){
		Random ran = new Random();
		for (int i=0;i<6;i++){
			if(number==randomNumbers[i]||number<1){
			
				number=ran.nextInt(50);
				number=checkNumbers(number,randomNumbers);
			}
		}
		return number;
		
		
	}
	
	public int [] drawNumbers(){
		Random ran = new Random();
		int randomNumbers[] = {0,0,0,0,0,0};
		int current;
		for (int i=0;i<6;i++){
			current=ran.nextInt(50);
			randomNumbers[i]=checkNumbers(current,randomNumbers);
			
		}
		
		
		
		
		return randomNumbers;
	}
	
	
	public static void main(String[] args) {
		RandomNumber rani = new RandomNumber();
		int rannum []=rani.drawNumbers();
		for(int i=0;i<6;i++){
			
			System.out.println(rannum[i]);
		}
	}

}
