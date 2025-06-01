import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTtools{
	public static void main(String[] args){
		
	}
	
	public static void mainmenu(Console con){
		BufferedImage imgMainMenu = con.loadImage("mainmenu.png");
		con.drawImage(imgMainMenu, 0, 0);
		con.println("");
	}
	
	public static void clear(Console con){
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		BufferedImage imgMoney = con.loadImage("money.png");
		con.drawImage(imgMoney, 0, 0);
		con.println(" ");
		
	}
	
	public static void getname(Console con, int intMoney){
		BufferedImage imgGetName = con.loadImage("getname.png");
		con.drawImage(imgGetName, 0, 0);
		int intCount; 
		CPTtools.printmoney(con, intMoney);
		for(intCount = 0; intCount < 10; intCount++){
			con.println(" ");
		}
		con.println(" ");
		con.print("                                              ");
	}
	
	public static void printmoney(Console con, int intMoney){
		con.println(" ");
		con.println("                                                                                            "+intMoney);
	}
	
	public static void getbet(Console con, int intMoney){
		BufferedImage imgGetBet = con.loadImage("getbet.png");
		con.drawImage(imgGetBet, 0, 0);
		int intCount; 
		con.println(" ");
		CPTtools.printmoney(con, intMoney);
		for(intCount = 0; intCount < 13; intCount++){
			con.println(" ");
		}
		con.println(" ");
		con.print("                                              ");
	}
	
	public static int calculatemoney(int intBet, int intMoney){
		intMoney = intMoney - intBet; 
		return intMoney; 
	}
		
	
	
	
	

	
}
