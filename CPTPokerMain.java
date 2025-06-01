import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTPokerMain{
	public static void main(String[] args){
		Console con = new Console("Poker - ICS3U1 CPT", 1280, 720);
		CPTtools.mainmenu(con);
		
		char chrChoice; 
		chrChoice = con.getChar();
		
		if(chrChoice == 'p'){
			CPTtools.clear(con);
		}else if(chrChoice == 'h'){
			CPTtools.clear(con);
		}else if(chrChoice == 'l'){
			CPTtools.clear(con);
		}else if(chrChoice == 'q'){
			CPTtools.clear(con);
		}
			
		
		
		
		
	
	}
}
