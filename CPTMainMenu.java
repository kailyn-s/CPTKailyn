import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTMainMenu{
	public static void MainMenu(Console con){
		BufferedImage imgMainMenu = con.loadImage("mainmenu.png");
		con.drawImage(imgMainMenu, 0, 0);
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println(" ");
		con.println("                                             Welcome to Poker!");
		con.println(" ");
		con.println("                                             (p) play");
		con.println("                                             (h) help");
		con.println("                                             (v) view leaderboard");
		con.println("                                             (q) quit");
		
		//TEST
		
		
	}
}
