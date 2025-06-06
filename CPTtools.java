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
		
		while(leaderboard.eof() == false && intCount < 10){
			strName = leaderboard.readLine();
			intScore = leaderboard.readInt();
			strLeaderboard[intCount][0] = strName;
			strLeaderboard[intCount][1] = "" + intScore;
			intCount = intCount + 1;
		}
		System.out.print(intCount);
		intCount1 = intCount; 
		System.out.print(intCount1);
		leaderboard.close();
		
		for(i = 0; i < 6; i++){
			con.println(" ");
		}
		if(intCount < 10){
			System.out.print("less than 10");
			for(i = 0; i < intCount; i++){
				con.println("                                             "+strLeaderboard[i][0]+"             "+strLeaderboard[i][1]);
				con.println(" ");
			}
		}else if(intCount >= 10){
			System.out.print("more than 10");
			for(intCount1 = 0; intCount1 < 10; intCount1++){
				con.println("                                             "+strLeaderboard[intCount1][0]+"             "+strLeaderboard[intCount1][1]);
				con.println(" ");
			}
		}else{
			con.println("ERROR");
		}
		
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
		for(intCount = 0; intCount < 5; intCount++){
			intHand[intCount][0] = Integer.parseInt(strCards[intCount][0]);
		}
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
		char chrChoice = ' '; 
		int intChoice;
		
		while(chrChoice != 'n'){
			chrChoice = con.getChar();
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
		boolean blnHighCard = false; 
		
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
		if(intHand[0][1] == intHand[1][1] && intHand[1][1] == intHand[2][1] && intHand[2][1] == intHand[3][1] && intHand[3][1] == intHand[4][1]){
			blnSameSuit = true; 
		}
		if(intHand[0][0] == 1 && intHand[1][0] == 10 && intHand[2][0] == 11 && intHand[3][0] == 12 && intHand[4][0] == 13){
			bln10Straight = true; 
		}
		intCount = intHand[0][0]; 
		if(intHand[0][0] == intCount && intHand[1][0] == intCount + 1 && intHand[2][0] == intCount + 2 && intHand[3][0] == intCount + 3 && intHand[4][0] == intCount + 4){
			blnStraight = true; 
		}
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln4ofaKind = true; 
		}
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln3ofaKind = true; 
		}
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0] && intHand[3][0] == intHand[4][0]) || (intHand[0][0] == intHand[1][0] && intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			blnFullHouse = true; 
		}
		if(intHand[0][0] == intHand[1][0] || intHand[1][0] == intHand[2][0] || intHand[2][0] == intHand[3][0] || intHand[3][0] == intHand[4][0]){
			bln2ofaKind = true; 
		}
		if(intHand[0][0] >= 11 || intHand[0][0] == 1 || intHand[1][0] >= 11 || intHand[1][0] == 1 || intHand[2][0] >= 11 || intHand[2][0] == 1 || intHand[3][0] >= 11 || intHand[3][0] == 1 || intHand[4][0] >= 11 || intHand[4][0] == 1){
			blnHighCard = true; 
		}
		
		BufferedImage royalflush = con.loadImage("royalflush.png");
		BufferedImage straightflush = con.loadImage("straightflush.png");
		BufferedImage fourofakind = con.loadImage("fourofakind.png");
		BufferedImage fullhouse = con.loadImage("fullhouse.png");
		BufferedImage flush = con.loadImage("flush.png");
		BufferedImage straight = con.loadImage("straight.png");
		BufferedImage threeofakind = con.loadImage("threeofakind.png");
		BufferedImage twopair = con.loadImage("twopair.png");
		BufferedImage highcard = con.loadImage("highcard.png");
		BufferedImage nothing = con.loadImage("nothing.png");
		
		con.clear();
		//Determining hand value
		if(bln10Straight == true && blnSameSuit == true){
			con.drawImage(royalflush, 0, 0);
			intBet = intBet * 800; 
			con.println(" ");
		}else if(blnStraight == true && blnSameSuit == true){
			con.drawImage(straightflush, 0, 0);
			intBet = intBet  * 50; 
			con.println(" ");
		}else if(bln4ofaKind == true){
			con.drawImage(fourofakind, 0, 0);
			intBet = intBet * 25;
			con.println(" ");
		}else if(blnFullHouse == true){
			con.drawImage(fullhouse, 0, 0);
			intBet = intBet * 9;
			con.println(" ");
		}else if(blnSameSuit == true){
			con.drawImage(flush, 0, 0);
			intBet = intBet * 6	;
			con.println(" ");
		}else if(blnStraight == true || bln10Straight == true){
			con.drawImage(straight, 0, 0);
			intBet = intBet * 4;
			con.println(" ");
		}else if(bln3ofaKind == true){
			con.drawImage(threeofakind, 0, 0);
			intBet = intBet * 3;
			con.println(" ");
		}else if(bln2ofaKind == true){
			con.drawImage(twopair, 0, 0);
			intBet = intBet * 2;
			con.println(" ");
		}else if(blnHighCard == true){
			con.drawImage(highcard, 0, 0);
			con.println(" ");
		}else{
			con.drawImage(nothing, 0, 0);
			intBet = intBet * 0;
			con.println(" ");
		}
		intMoney = intMoney + intBet;
		con.println(" ");
		con.println("                                                                                            "+intMoney);
		return intBet; 
	}

	
}
