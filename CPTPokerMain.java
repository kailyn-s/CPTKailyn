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
		int intCount2;
		String strCards[][];
		int intHand[][];
		String strCardTemp;
		
		strCards = new String[52][3];
		intHand = new int[5][2];
		
		chrChoice = ' ';
		while(chrChoice != 'q'){
			chrChoice = con.getChar();
			//Play Option
			if(chrChoice == 'p'){
				CPTtools.clear(con);
				CPTtools.getname(con, intMoney);
				strName = con.readLine();
				CPTtools.printname(strName);
				con.clear();
				intMoney = CPTtools.statitan(strName, intMoney);
				CPTtools.getbet(con, intMoney);
				intBet = con.readInt();
				CPTtools.clear(con);
				intMoney = CPTtools.calculatemoney(intBet, intMoney);
				strCards = CPTtools.shuffle(strCards);
				intHand = CPTtools.dealcards(intHand, strCards);
				CPTtools.printmoney(con, intMoney);
				CPTtools.setup(con);
				
				CPTtools.printcards(con, intHand);
				CPTtools.selectcardstext(con);
				CPTtools.selectcards(intHand, strCards, con);
				CPTtools.setup(con);
				CPTtools.printcards(con, intHand);
				con.sleep(3000);
				intBet = CPTtools.calculatewin(intHand, intBet, con, intMoney);
				
					
			//Help Option
			}else if(chrChoice == 'h'){
				CPTtools.help(con);
			//Leaderboard Option
			}else if(chrChoice == 'l'){
				CPTtools.leaderboard(con);
			}else if(chrChoice == 'm'){
				CPTtools.clear(con);
				CPTtools.mainmenu(con);
				con.clear();
				con.println(" ");
			}
		}
		CPTtools.quit(con);
		
		
		
		
	
	}
}
