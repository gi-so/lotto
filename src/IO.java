import java.util.InputMismatchException;
import java.util.Scanner;


public class IO {
	Scanner user_input;
	
	
	public IO (){
		user_input = new Scanner( System.in );
		
		
	}
	
	public Player playerInput(){
		Player player1= new Player();
		System.out.println("Please enter first Name:");
		player1.setFirstName(user_input.nextLine());
		System.out.println("Please enter last Name:");
		player1.setLastName(user_input.nextLine());
		System.out.println(player1.getFirstName()+" "+player1.getLastName());
		return player1;
	}
	
	public boolean checkNumber(int [] a, int number){
		
		for (int i =0; i<6;i++){
			if(number==a[i]||number<1||number>49){
				System.out.println("Number already exists or ist not from 1 to 49, please enter a diffrent Number:");
				return false;
			}
		}
	
		return true;
	}
	
	public Ticket ticketInput(){
		int  numbers [] ;
		Ticket ticket1=new Ticket();
		for (int i=1;i<7;i++){
			
			
			
			int nummer;
			while(true){
				System.out.println("Please enter Number "+i+":");
				try{
					nummer=Integer.parseInt(user_input.nextLine());
					if(checkNumber(ticket1.numbers, nummer)){
						break;
					}
				}
				catch(NumberFormatException e){
					System.err.println("Invalid input!");
				}
			}
		
			ticket1.numbers[i-1]=nummer;
		}
		
		return ticket1;
		
	}
	
	
	
	
	

}
