import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Lottery {
	
	private HashSet<Player> players ;
	private int random [];
	
	private int counterNumber=0;
	private int needToDraw;
	private int alreadyDrawn;
	
	// IO io = new IO();
	
	Lottery(){
		
		players = new HashSet<Player>();
		
	}
	
	public void enterTicket() {
		IO io = new IO();
		
		Player newPlayer = new Player();
		newPlayer=io.playerInput();
		newPlayer.setTicket(io.ticketInput());
		players.add(newPlayer);
		needToDraw=1;
							
	}
	
	public void lotteryDrawing(){
		if(alreadyDrawn==0){
			Iterator<Player> it= players.iterator();
			if(it.hasNext()==true){
				RandomNumber ran = new RandomNumber();
				random=ran.drawNumbers();
				for (int i=1;i<7;i++){
					System.out.println("Drawn number "+i+": "+random[i-1]);
				needToDraw=0;
				alreadyDrawn=1;
				}
			}else {
				
				System.out.println("Please enter Tickets first.");
				
			}
		}else{
			
			System.out.println("Please Show Results.");
			
		}
	}
	
	public void showResults(){
		
		Iterator<Player> it= players.iterator();
		if(it.hasNext()==true){
			if (random!= null&&needToDraw==0){
				for (int i=1;i<7;i++){
					System.out.println("Drawn number "+i+": "+random[i-1]);
				}
				
			
				
				while(it.hasNext()){
					Player abc = it.next();
					
					System.out.println("\n"+abc.getFirstName()+" "+abc.getLastName()+" numbers:");
					for(int i=0; i<6;i++){
						System.out.println("Number "+ (i+1) +": "+abc.getTicket().getNumber(i));
						
						for(int z =0; z<6;z++){
							if(random[z]==abc.getTicket().getNumber(i)){
								System.out.println("Correct!");
								counterNumber++;
							}
						}
				
					}
				
		
					System.out.println(abc.getFirstName()+" "+abc.getLastName()+" has "+counterNumber+" right number(s).\n");
					counterNumber=0;
					alreadyDrawn=0;
					
					
					
				}
			} else {
				
				System.out.println("Please draw numbers first.");
			}	
		}else {
			
			System.out.println("Please enter Tickets first.");
			
			
		}
	}
	
	public void quit(){
		
		System.exit(0);
		
	}
	public static void main(String[] args) {
		Lottery lott = new Lottery();
		Scanner user_input = new Scanner( System.in );
		int nummer;
		while(true){
			System.out.println("Please chose:\n 1 Enter Ticket \n 2 Lottery Drawing \n 3 Show Results \n 0 Quit \n Your Choice:");
			try{
				nummer=Integer.parseInt(user_input.nextLine());
				switch (nummer){
				
				
				case 1: lott.enterTicket();
						break;
						
				case 2: lott.lotteryDrawing();
						break;
				case 3: lott.showResults();
						break;
				case 0: lott.quit();
			
				}
				
			}
			catch(NumberFormatException e){
				System.err.println("Invalid input!");
			}
			
		
			
		}
		
	}

}
