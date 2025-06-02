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
	
	public static void help(Console con){
		BufferedImage imgHelp = con.loadImage("help.png");
		con.drawImage(imgHelp, 0, 0);
		con.println(" ");
		
	}
	
	public static void quit(Console con){
		BufferedImage imgQuit = con.loadImage("quit.png");
		con.drawImage(imgQuit, 0, 0);
		con.println(" ");
	}
	
	public static void leaderboard(Console con){
		BufferedImage imgLeaderboard = con.loadImage("leaderboard.png");
		con.drawImage(imgLeaderboard, 0, 0);
		con.println(" ");
		
		TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
		String strLeaderboard[][];
		strLeaderboard = new String[10][2];
		String strName; 
		int intScore;
		int intCount = 0;
		int intCount1; 
		int i; 
		
		while(leaderboard.eof() == false){
			strName = leaderboard.readLine();
			intScore = leaderboard.readInt();
			intCount = intCount + 1;
		}
		System.out.print(intCount);
		intCount1 = intCount; 
		System.out.print(intCount1);
		leaderboard.close();
		TextInputFile leaderboard1 = new TextInputFile("leaderboard.txt"); 
		
		for(i = 0; i < 8; i++){
			con.println(" ");
		}
		if(intCount < 10){
			System.out.print("less than 10");
			while(leaderboard1.eof() == false){
				strName = leaderboard1.readLine();
				intScore = leaderboard1.readInt();
				con.println("                                               "+strName+" - "+intScore);
			}
		}else if(intCount >= 10){
			System.out.print("more than 10");
		}
		
	}
	
	

	
}
