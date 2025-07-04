//Kailyn Sy
//Poker - ICS3U1 CPT
//Last Modified: Thursday, June 12, 2025
//Version 1.3

import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage; 

public class CPTtools{
	public static void main(String[] args){
		
	}
	
	public static void mainmenu(Console con){
		//print main menu
		BufferedImage imgMainMenu = con.loadImage("mainmenu.png");
		con.drawImage(imgMainMenu, 0, 0);
		con.println("");
	}
	
	public static void clear(Console con){
		//clear full screen
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
		//print balance of money
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
		//display help page
		BufferedImage imgHelp = con.loadImage("help.png");
		con.drawImage(imgHelp, 0, 0);
		con.println(" ");
		
	}
	
	public static void quit(Console con){
		BufferedImage imgQuit = con.loadImage("quit.png");
		con.drawImage(imgQuit, 0, 0);
		con.println(" ");
	}
	
	public static void printname(String strName){
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		leaderboard.println(strName);
		leaderboard.close();
	}
	
	public static String[][] shuffle(String[][] strCards){
		int intCount; 
		int intCount2; 
		String strCardTemp;
		//column 0
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
		
		//Column 2 - Random Integer (1 to 100)
				for(intCount = 0; intCount < 52; intCount++){
						strCards[intCount][2] = "" + ((int)(Math.random() * 100 + 1));
				}
				
		//Bubble Sort
		for(intCount2 = 0; intCount2 < 52-1; intCount2++){
			for(intCount = 0; intCount < 52-1; intCount++){
				if(Integer.parseInt(strCards[intCount][2]) > Integer.parseInt(strCards[intCount + 1][2])){
					//swap column 0
					strCardTemp = strCards[intCount][0];
					strCards[intCount][0] = strCards[intCount + 1][0];
					strCards[intCount + 1][0] = strCardTemp;
							
					//swap column 1
					strCardTemp = strCards[intCount][1];
					strCards[intCount][1] = strCards[intCount+1][1];
					strCards[intCount+1][1] = strCardTemp;
						
					//swap column 2
					strCardTemp = strCards[intCount][2];
					strCards[intCount][2] = strCards[intCount+1][2];
					strCards[intCount+1][2] = strCardTemp;
							
				}
			}
		}
		return strCards;
	}
	
	public static int[][] dealcards(int intHand[][], String strCards[][]){
		int intCount;
		//deal number
		for(intCount = 0; intCount < 5; intCount++){
			intHand[intCount][0] = Integer.parseInt(strCards[intCount][0]);
		}
		//deal suit
		for(intCount = 0; intCount < 5; intCount++){
			intHand[intCount][1] = Integer.parseInt(strCards[intCount][1]);
		}
		return intHand; 
	}
	
	public static void setup(Console con){
		BufferedImage imgSetUp = con.loadImage("setup.png");
		con.drawImage(imgSetUp, 0, 0);
		con.println(" ");
	}
	
	public static void printcards(Console con, int intHand[][]){
		String strFileName;
		int intCount;
		int intX = 0; 
		
		for(intCount = 0; intCount < 5; intCount++){
			strFileName = "cardnumber" + intHand[intCount][0]+".png";
			BufferedImage cardnumber = con.loadImage(strFileName);
			con.drawImage(cardnumber, intX + intCount, 0);
			strFileName = "cardsuit" + intHand[intCount][1]+".png";
			BufferedImage cardsuit = con.loadImage(strFileName);
			con.drawImage(cardsuit, intX + intCount, 0);
			intX = intX + 216;
			con.sleep(500);
			
			con.println(" ");	
		}
		
		
	}
	
	public static void selectcardstext(Console con){
		con.sleep(500);
		BufferedImage selectcard = con.loadImage("selectcardtext.png");
		con.drawImage(selectcard, 0, 0);
		con.println(" ");
	}
	
	public static int statitan(String strName, int intMoney){
		if(strName.equalsIgnoreCase("statitan")){
			intMoney = 2000;
		}
		return intMoney;
	}
	
	public static int[][] selectcards(int intHand[][], String strCards[][], Console con){
		char chrChoice = 'a'; 
		int intChoice;
		
		while(chrChoice != ' '){
			chrChoice = con.getChar();
			//each char character as a number corresponds to the number above the chosen card
			if(chrChoice == '1'){
				BufferedImage cardselect1 = con.loadImage("cardselect1.png");
				con.drawImage(cardselect1, 0, 0);
				con.println(" ");
				intChoice = chrChoice - '0';
				intHand[(intChoice - 1)][0] = Integer.parseInt(strCards[intChoice + 4][0]);
				intHand[(intChoice - 1)][1] = Integer.parseInt(strCards[intChoice + 4][1]);
			}else if(chrChoice == '2'){
				BufferedImage cardselect2 = con.loadImage("cardselect2.png");
				con.drawImage(cardselect2, 0, 0);
				con.println(" ");
				intChoice = chrChoice - '0';
				intHand[(intChoice - 1)][0] = Integer.parseInt(strCards[intChoice + 4][0]);
				intHand[(intChoice - 1)][1] = Integer.parseInt(strCards[intChoice + 4][1]);
			}else if(chrChoice == '3'){
				BufferedImage cardselect3 = con.loadImage("cardselect3.png");
				con.drawImage(cardselect3, 0, 0);
				con.println(" ");
				intChoice = chrChoice - '0';
				intHand[(intChoice - 1)][0] = Integer.parseInt(strCards[intChoice + 4][0]);
				intHand[(intChoice - 1)][1] = Integer.parseInt(strCards[intChoice + 4][1]);
			}else if(chrChoice == '4'){
				BufferedImage cardselect4 = con.loadImage("cardselect4.png");
				con.drawImage(cardselect4, 0, 0);
				con.println(" ");
				intChoice = chrChoice - '0';
				intHand[(intChoice - 1)][0] = Integer.parseInt(strCards[intChoice + 4][0]);
				intHand[(intChoice - 1)][1] = Integer.parseInt(strCards[intChoice + 4][1]);
			}else if(chrChoice == '5'){
				BufferedImage cardselect5 = con.loadImage("cardselect5.png");
				con.drawImage(cardselect5, 0, 0);
				con.println(" ");
				intChoice = chrChoice - '0';
				intHand[(intChoice - 1)][0] = Integer.parseInt(strCards[intChoice + 4][0]);
				intHand[(intChoice - 1)][1] = Integer.parseInt(strCards[intChoice + 4][1]);
			}
				
		}
		return intHand; 
	}
	
	public static int calculatewin(int intHand[][], int intBet, Console con, int intMoney){
		int intCardTemp; 
		int intCount;
		int intCount1; 
		boolean blnRoyalFlush = false;
		boolean blnSameSuit = false; 
		boolean bln10Straight = false;
		boolean blnStraight = false; 
		boolean bln4ofaKind = false; 
		boolean bln3ofaKind = false; 
		boolean blnFullHouse = false; 
		boolean bln2ofaKind = false; 
		boolean blnJacksorBetter = false; 
		boolean blnTwoPair = false; 
		
		//Bubble sort cards by number!!
		for(intCount1 = 0; intCount1 < 5-1; intCount1++){
			for(intCount = 0; intCount < 5-1; intCount++){
				if(intHand[intCount][0] > intHand[intCount + 1][0]){
					//swap column 0
					intCardTemp = intHand[intCount][0];
					intHand[intCount][0] = intHand[intCount+1][0];
					intHand[intCount+1][0] = intCardTemp;
					
					//swap column 1
					intCardTemp = intHand[intCount][1];
					intHand[intCount][1] = intHand[intCount+1][1];
					intHand[intCount+1][1] = intCardTemp;
							
				}
			}
		}
		//Checks
		//(check for which hand is obtained)
		//Check for flush
		if(intHand[0][1] == intHand[1][1] && intHand[1][1] == intHand[2][1] && intHand[2][1] == intHand[3][1] && intHand[3][1] == intHand[4][1]){
			blnSameSuit = true; 
		}
		//Check for straight starting from 10 to ace
		if(intHand[0][0] == 1 && intHand[1][0] == 10 && intHand[2][0] == 11 && intHand[3][0] == 12 && intHand[4][0] == 13){
			bln10Straight = true; 
		}
		
		intCount = intHand[0][0]; 
		
		//Check for straight
		if(intHand[0][0] == intCount && intHand[1][0] == intCount + 1 && intHand[2][0] == intCount + 2 && intHand[3][0] == intCount + 3 && intHand[4][0] == intCount + 4){
			blnStraight = true; 
		}
		//Check for 4 of a kind
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln4ofaKind = true; 
		}
		//Check for 3 of a kind
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln3ofaKind = true; 
		}
		//Check for full house
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0] && intHand[3][0] == intHand[4][0]) || (intHand[0][0] == intHand[1][0] && intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			blnFullHouse = true; 
		}
		//Check for two pair
		if((intHand[0][0] == intHand[1][0] && intHand[2][0] == intHand[3][0]) || (intHand[1][0] == intHand[2][0] && intHand[3][0] == intHand[4][0]) || (intHand[0][0] == intHand[1][0] && intHand[3][0] == intHand[4][0])){
			blnTwoPair = true;
		}
		//Check for jacks or better
		if((intHand[0][0] == intHand[1][0] && intHand[0][0] > 10 && intHand[1][0] > 10) || (intHand[1][0] == intHand[2][0] && intHand[1][0] > 10 && intHand[2][0] > 10) || (intHand[2][0] == intHand[3][0] && intHand[2][0] > 10 && intHand[3][0] > 10) || (intHand[3][0] == intHand[4][0] && intHand[3][0] > 10 && intHand[4][0] > 10) || (intHand[0][0] == intHand[1][0] && intHand[0][0] == 1 && intHand[1][0] == 1) || (intHand[1][0] == intHand[2][0] && intHand[1][0] == 1 && intHand[2][0] == 1) || (intHand[2][0] == intHand[3][0] && intHand[2][0] == 1 && intHand[3][0] == 1) || (intHand[3][0] == intHand[4][0] && intHand[3][0] == 1 && intHand[4][0] == 1)){
			blnJacksorBetter = true; 
		}
		
		BufferedImage imgroyalflush = con.loadImage("royalflush.png");
		BufferedImage imgstraightflush = con.loadImage("straightflush.png");
		BufferedImage imgfourofakind = con.loadImage("fourofakind.png");
		BufferedImage imgfullhouse = con.loadImage("fullhouse.png");
		BufferedImage imgflush = con.loadImage("flush.png");
		BufferedImage imgstraight = con.loadImage("straight.png");
		BufferedImage imgthreeofakind = con.loadImage("threeofakind.png");
		BufferedImage imgtwopair = con.loadImage("twopair.png");
		BufferedImage imgjacksorbetter = con.loadImage("jacksorbetter.png");
		BufferedImage imgnothing = con.loadImage("nothing.png");
		
		con.clear();
		//Determining hand value
		if(bln10Straight == true && blnSameSuit == true){
			con.drawImage(imgroyalflush, 0, 0);
			intBet = intBet * 800; 
			con.println(" ");
		}else if(blnStraight == true && blnSameSuit == true){
			con.drawImage(imgstraightflush, 0, 0);
			intBet = intBet  * 50; 
			con.println(" ");
		}else if(bln4ofaKind == true){
			con.drawImage(imgfourofakind, 0, 0);
			intBet = intBet * 25;
			con.println(" ");
		}else if(blnFullHouse == true){
			con.drawImage(imgfullhouse, 0, 0);
			intBet = intBet * 9;
			con.println(" ");
		}else if(blnSameSuit == true){
			con.drawImage(imgflush, 0, 0);
			intBet = intBet * 6	;
			con.println(" ");
		}else if(blnStraight == true || bln10Straight == true){
			con.drawImage(imgstraight, 0, 0);
			intBet = intBet * 4;
			con.println(" ");
		}else if(bln3ofaKind == true){
			con.drawImage(imgthreeofakind, 0, 0);
			intBet = intBet * 3;
			con.println(" ");
		}else if(blnTwoPair == true){
			con.drawImage(imgtwopair, 0, 0);
			intBet = intBet * 2;
			con.println(" ");
		}else if(blnJacksorBetter == true){
			con.drawImage(imgjacksorbetter, 0, 0);
			con.println(" ");
		}else{
			con.drawImage(imgnothing, 0, 0);
			intBet = intBet * 0;
			con.println(" ");
		}
		intMoney = intMoney + intBet;
		con.println(" ");
		con.println("                                                                                            "+intMoney);
		return intMoney; 
	}

	public static void leaderboard(Console con){
		con.clear();
		BufferedImage imgLeaderboard = con.loadImage("leaderboard.png");
		con.drawImage(imgLeaderboard, 0, 0);
		con.println(" ");
		
		TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
		String strLeaderboard[][];
		int intTemp; 
		String strTemp1; 
		String strTemp2; 
		String strTemp; 
		int intCountLine = 0;
		int intCount;
		int intCount2; 
		
		while(leaderboard.eof() == false){
			strTemp = leaderboard.readLine();
			intTemp = leaderboard.readInt();
			intCountLine++; 
		}
		leaderboard.close();
		strLeaderboard = new String[intCountLine][2];
		leaderboard = new TextInputFile("leaderboard.txt");
		
		for(intCount = 0; intCount < intCountLine; intCount++){
			strLeaderboard[intCount][0] = leaderboard.readLine();
			strLeaderboard[intCount][1] = "" + leaderboard.readInt();
		}
		for(intCount2 = 0; intCount2 < (intCountLine - 1); intCount2++){
			for(intCount = 0; intCount < (intCountLine - 1); intCount++){
				if(Integer.parseInt(strLeaderboard[intCount][1]) < Integer.parseInt(strLeaderboard[intCount + 1][1])){
					//column 1 - name
					strTemp1 = strLeaderboard[intCount][0];
					strLeaderboard[intCount][0] = strLeaderboard[intCount+1][0];
					strLeaderboard[intCount+1][0] = strTemp1;
					
					//column 2 - score
					strTemp2 = strLeaderboard[intCount][1]; 
					strLeaderboard[intCount][1] = strLeaderboard[intCount+1][1];
					strLeaderboard[intCount+1][1] = strTemp2;
				}
			}
		}
		
		for(intCount = 0; intCount < 6; intCount++){
			con.println(" ");
		}
		if(intCountLine >= 10){
			for(intCount = 0; intCount< 10; intCount++){
				con.println("                                              "+strLeaderboard[intCount][0]);
				con.println("                                              "+strLeaderboard[intCount][1]);
			}
		}else{
			for(intCount = 0; intCount < intCountLine; intCount++){
				con.println("                                              "+strLeaderboard[intCount][0]);
				con.println("                                              "+strLeaderboard[intCount][1]);
			}
		}
		
		
	}
	
	public static void secretmenu(Console con){
		BufferedImage imgSecretMenu = con.loadImage("secretmenu.png");
		con.drawImage(imgSecretMenu, 0, 0);
		con.println(" ");
	}
}
