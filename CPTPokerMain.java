import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTPokerMain{
	public static void main(String[] args){
		Console con = new Console("Poker - ICS3U1 CPT", 1280, 720);
		CPTtools.mainmenu(con);
        
        String strName;
		char chrChoice; 
		chrChoice = con.getChar();
		int intMoney = 1000;
		int intBet; 
		
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
		}else if(chrChoice == 'h'){
			CPTtools.clear(con);
		}else if(chrChoice == 'l'){
			CPTtools.clear(con);
		}else if(chrChoice == 'q'){
			CPTtools.clear(con);
		}
			
		
		
		
		
	
	}
}
