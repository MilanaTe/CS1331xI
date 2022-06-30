 import java.util.*;
 import java.io.*;

public class Battleship{
    public static int playerShips1 =5;
    public static int playerShips2=5;
    public static int ErsteUserEingabe;
    public static int ZweiteUserEingabe;
    
     
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
	 	  char [][] round1 = new char[5][5]; 
	 	  char [][] round2 = new char[5][5]; 
	 	  char [][] map = new char[5][5]; 
	 	  char [][] map2 = new char[5][5];
	 	  

		
	 	  char ship='@';

		  char Emptyspace='-';
		    
		 	Makelines(map2, Emptyspace);
		 	Makelines(map, Emptyspace);

 

 	System.out.print("Welcome to Battleship! ");
 	player1(input, round1,Emptyspace,ship);

 	for(int i=1; i < 100; i++) {
 	 	System.out.println();

 	}
 	
 	player2(input, round2, Emptyspace, ship);
 
 	printBattleShip(round2);
 	
	for(int i=1; i < 100; i++) {
 	 	System.out.println();

 	}
  	playingGme(input,round1, round2, map, map2);
  	  	

	}//Ende Main	 
	
	
	
	public static void playingGme(Scanner input, char [][] round1, char [][] round2,  char [][] map, char [][]map2) {
 	  	System.out.println();
 	  	System.out.println();
		System.out.println("Player 1, enter hit row/column:");
 
		int i=0;
	 	do {	 			 
	 	  	playerTurn1(input,round2, round1, map, map2); 
 	 	  	playerTurn2(input,round2, round1, map2, map);
	 	 	i++;
  	 	 	if(Battleship.playerShips1 == 2 || Battleship.playerShips2 == 2) {
	 	 		System.out.println(" ***Skipping to the last turn***");}
 	 	   	} 
	 	while(Battleship.playerShips1 != 0 || Battleship.playerShips2 != 0); {
  	 		winner(round1, round2);
 	 	   	}
	 		
	}
	

	public static void Makelines(char [][] bla, char EmptySpace){
 			 for (int i = 0; i < bla.length; i++) {  
				 for (int j = 0; j < bla[i].length; j++) {  
					 bla[i][j] = EmptySpace; 
 				 }
				 System.out.println();
}
 		 
				
	}
 
	
		public static void winner( char[][] map,  char[][]map2) {
 			if (Battleship.playerShips1==0){
 				System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
				System.out.println("Final boards:");
				printBattleShip(map);
		 	  	System.out.println();
		 	  	System.out.println();
				printBattleShip(map2);
			}else { 
 					System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
					System.out.println("Final boards:");
			 	  	System.out.println();
			 	  	System.out.println();
					printBattleShip(map);
					printBattleShip(map2);
				}		 
				
 		}
 
     public static int checkPosition(char [][] round2 , char [][] map ){
 
          if (ErsteUserEingabe > 5 || ZweiteUserEingabe > 5){
            return 1;
        } else if (map[ErsteUserEingabe][ZweiteUserEingabe] == 'X'){
            return 2;
        } else if (round2[ErsteUserEingabe][ZweiteUserEingabe] == '@') {
 			return 3;
        }
        else if( (Battleship.playerShips1== 0 ) || (Battleship.playerShips2 == 0)) {
        	return 4;
        }
        else if (map[ErsteUserEingabe][ZweiteUserEingabe] == 'O') {
        	return 5;
        }
        return 0;
    }

	 public static char[][] playerTurn1(Scanner input, char[][] round2,char[][] round1, char[][]map, char[][]map2){
  	        boolean correct = false;
 			int  check;
  	        while (!correct){
	        	ErsteUserEingabe = input.nextInt();
	        	ZweiteUserEingabe = input.nextInt();
	        	
		 		if(ErsteUserEingabe > 5 || ZweiteUserEingabe > 5) {
		 			System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println("Player 1, enter hit row/column: ");

		 			
		 		}else {

	        	
	            check = checkPosition(round2,map);   
	            switch(check) {
	                case 1:
	                    System.out.println("Invalid coordinates. Choose different coordinates.");
	                    System.out.println("Player 1, enter hit row/column: ");
	                    correct=true;
	                    break;
	                case 2:
 	                	System.out.println("You already fired on this spot. Choose different coordinates.");
	                    System.out.println("Player 1, enter hit row/column: ");
	                    correct = false;  
	                    break;
	                case 3:
	  	               --Battleship.playerShips1;
	                   System.out.println("PLAYER 1 HIT PLAYER 2’s SHIP!");
 	                   map[ErsteUserEingabe][ZweiteUserEingabe] = 'X';  
 	  				   printBattleShip(map);
   	                   System.out.println("Player 2, enter hit row/column:");
	                    correct = true; 
	                    break;
	                
	                case 4: 
	                	winner(map, map2);
	                	correct = true;
	                	break;
	                
	                case 5:
 	                	System.out.println("You already fired on this spot. Choose different coordinates.");
	                 	System.out.println("Player 1, enter hit row/column:");
 	                	correct = false;
	                	break;
	                	
	                	default:
 	                    System.out.println("PLAYER 1 MISSED!");
 	                    map[ErsteUserEingabe][ZweiteUserEingabe] = 'O';
	                 	printBattleShip(map); 
	                 	System.out.println("Player 2, enter hit row/column:");
	                    correct = true;
	                    break;//
	            }
		 		}

	        }
  
	        return map ;
	    }
 
	   public static int checkPosition2( char[][] round1, char[][] map2 ){
 	         if (ErsteUserEingabe > 5 || ZweiteUserEingabe > 5){
	            return 1;
	        } else if (map2[ErsteUserEingabe][ZweiteUserEingabe] == 'X'){
	            return 2;
	        } else if (round1[ErsteUserEingabe][ZweiteUserEingabe] == '@') {
   	            return 3;
	        }
	        else if( (Battleship.playerShips1 == 0) || (Battleship.playerShips2 == 0)) {
	        	return 4;
	        }
	        else if (map2[ErsteUserEingabe][ZweiteUserEingabe] == 'O') {
	        	return 5;
	        }
	        return 0;
	    }
	   
 	 public static char[][] playerTurn2(Scanner input, char[][] round2, char[][] round1, char [][] map2,  char [][] map  ){
	        boolean correct = false;
	        int check;
	        System.out.println();
	        while (!correct){

	        	ErsteUserEingabe = input.nextInt();
	        	ZweiteUserEingabe = input.nextInt();
	        	
	        	if(ErsteUserEingabe > 5 || ZweiteUserEingabe > 5) {
		 			System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println("Player 1, enter hit row/column: ");

		 			
		 		}else {
	            check = checkPosition2(round1, map2); // Check if the coordinates are valid
	            switch(check) {
	                case 1:
	                    System.out.println("Invalid coordinates. Choose different coordinates.");
	                    System.out.println("Player 2, enter hit row/column: ");
	                    correct=false;
	                    break;
	                case 2:
	                	System.out.println("You already fired on this spot. Choose different coordinates.");
  	                 	System.out.println("Player 2, enter hit row/column:");
  	                    correct = false;  
 	                    break;
	                case 3:
  	                    --Battleship.playerShips2;
	                    System.out.println("PLAYER 2 HIT PLAYER 1’s SHIP!");
	                    map2[ErsteUserEingabe][ZweiteUserEingabe]='X';
	                 	printBattleShip(map2);
  	                 	System.out.println("Player 1, enter hit row/column:");
	                    correct = true;  
	                    break;
	                case 4:
	                	winner(map, map2);
	                	break;
	                	
	                case 5:
	                	System.out.println("You already fired on this spot. Choose different coordinates.");
  	                 	System.out.println("Player 2, enter hit row/column:");
	                	correct = false;  
 	                    break;

	                	
	                default:
  	                    System.out.println("PLAYER 2 MISSED!");
 	                    map2[ErsteUserEingabe][ZweiteUserEingabe] = 'O';
 	                   printBattleShip(map2);
 	          
 	                 	System.out.println("Player 1, enter hit row/column:");
	                    correct = true; 
	                    break;//
	            }
	        }
	        }
 	        return map2 ;//round1
	    }

	
 	public static char player2(Scanner input, char round2[][],char Emptyspace, char ship) {
			 for (int i = 0; i < round2.length; i++) {  
				 for (int j = 0; j < round2[i].length; j++) {  
				 round2[i][j] = Emptyspace; 
 				 }
				 System.out.println();

			  }
			 System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
 	  	    	printBattleShip(round2);
 
 	  	    	int f=1;
	 		
			 do  {
				 
	 		 for (int i = 0; i < round2.length; i++) {  
				 System.out.println("Enter ship " + f + " location: ");
				 if (input.hasNextInt()) {
					 ErsteUserEingabe=input.nextInt();
					 ZweiteUserEingabe=input.nextInt();
 				 	  		if(ErsteUserEingabe>=5 || ZweiteUserEingabe>=5 ){
								 System.out.println("Invalid coordinates. Choose different coordinates.");
 					        	 i=i-1;
 					         }				 
				 	  		else if(check(round2,f)) {
				 	  		    round2[ErsteUserEingabe][ZweiteUserEingabe] = ship;
 				 	  	    	i=i-1;
				 	  		}
				 	  		else {	
 				 	  		round2[ErsteUserEingabe][ZweiteUserEingabe] = ship;
 			 	  	    	f++; 
				 	  		}
					         } 
				 
							  
				 
				 else { 
		        	 i=i-1;
		        	  usereingabe(input,round2, ship,f);
		         }
	 	  		   } 
	 		
	 		 } while(ErsteUserEingabe==5 && ZweiteUserEingabe==5) ;
	 			 System.out.println();
	 			 System.out.println();

 				return round2[ErsteUserEingabe][ZweiteUserEingabe];

 	 		   
	 	}
 
 

	public static char player1(Scanner input, char round1[][],char Emptyspace, char ship) {
		 for (int i = 0; i < round1.length; i++) { 
			 for (int j = 0; j < round1[i].length; j++) {  
			 round1[i][j] =Emptyspace; 
 			 }
			 System.out.println();

		  }
		 System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");			
 	     printBattleShip(round1);
 	    int f=1;
 
		 do  {
			
 		 for (int i = 0; i < round1.length; i++) { 
			 System.out.println("Enter ship " + f + " location: ");
 	  

			 if (input.hasNextInt()) {
				 ErsteUserEingabe=input.nextInt();
				 ZweiteUserEingabe=input.nextInt();
 			 	  		if(ErsteUserEingabe>= 5 || ZweiteUserEingabe>= 5){ 
							 System.out.println("Invalid coordinates. Choose different coordinates.");
							 i=i-1;
 
				         }				 
			 	  		else if(check(round1,f)) { 
			 	  		    round1[ErsteUserEingabe][ZweiteUserEingabe] = ship;
  			 	  	    	i=i-1;
			 	  		}
			 	  		else {			 	  		  
			 	  		round1[ErsteUserEingabe][ZweiteUserEingabe] = ship;
 		 	  	    	f++;
			 	  		}
				         }  
						  
			 
			 else {
				 System.out.println("Invalid coordinates. Choose different coordinates.");
	         } 
	  	    	
} printBattleShip(round1);
		
		 } while(ErsteUserEingabe==5 && ZweiteUserEingabe==5) ;
 			 return round1[ErsteUserEingabe][ZweiteUserEingabe];
 
 		   
	}
 

	
	public static void usereingabe(Scanner input,char [][] round1, char ship, int f) {
 		 
 		 for (int i = 0; i < round1.length; i++) {  
			 System.out.println("Enter ship " + f + " location: ");
			 if (input.hasNextInt() && ErsteUserEingabe<5 && ZweiteUserEingabe<5) {
				 ErsteUserEingabe=input.nextInt();
				 ZweiteUserEingabe=input.nextInt();
	  		      
	  		   round1[ErsteUserEingabe][ZweiteUserEingabe] = ship;
	  		   printBattleShip(round1);
				f++;			
	} else {
		break;
	}
   
		 }
 	} 
    public static boolean check( char[][] round1, int f) { 
             if( round1[ErsteUserEingabe][ZweiteUserEingabe] == '@') {
            	  	System.out.println("You already have a ship there. Choose different coordinates.");
                return true;
    	}
        return false;
    }
    
    public static boolean checkX(char[][] round1, int f) { 
        if( round1[ErsteUserEingabe][ZweiteUserEingabe] == 'X') {
       	  	System.out.println("You already have a hit this. Choose different coordinates.");
           return true;
	}
   return false;
}
	
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			} 
			System.out.println("");
		}
	}
	
	
 
 
	}
 
