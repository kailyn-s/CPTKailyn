import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTPokerMain{
	public static void main(String[] args){
		Console con = new Console("Poker - ICS3U1 CPT", 1280, 720);
		CPTtools.mainmenu(con);
        
        String strName;
		char chrChoice; 
		int intMoney = 1000;
		int intBet; 
		int intCount;
		String strCards[][];
		
		strCards = new String[52][3];
		
		//Column 0 - Card Number
		for(intCount = 0; intCount < 52; intCount++){
			strCards[intCount][0] = ""+ (intCount % 13 + 1);
		}
		
		//Column 1 - Suit
		/*Diamonds - 1
		 * Clubs - 2
		 * Hearts - 3
		 * Spades - 4 */
		 
		for(intCount = 0; intCount < 52; intCount++){
			strCards[intCount][1] = "" + (int)(intCount/13 + 1);		
		}
		
		chrChoice = con.getChar();
		//Play Option
		if(chrChoice == 'p'){
			CPTtools.clear(con);
			CPTtools.getname(con, intMoney);
			strName = con.readLine();
			con.clear();
			CPTtools.getbet(con, intMoney);
			intBet = con.readInt();
			CPTtools.clear(con);
			intMoney = CPTtools.calculatemoney(intBet, intMoney);
			CPTtools.printmoney(con, intMoney);
			
		//Help Option
		}else if(chrChoice == 'h'){
			CPTtools.help(con);
			
		//Leaderboard Option
		}else if(chrChoice == 'l'){
			CPTtools.clear(con);
			
		//Quit Option
		}else if(chrChoice == 'q'){
			CPTtools.clear(con);
		}
			
		
		
		
		
	
	}
}
