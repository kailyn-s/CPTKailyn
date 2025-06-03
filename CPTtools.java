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
		
		for(i = 0; i < 6; i++){
			con.println(" ");
		}
		if(intCount < 10){
			System.out.print("less than 10");
			while(leaderboard1.eof() == false){
				strName = leaderboard1.readLine();
				intScore = leaderboard1.readInt();
				con.println("                                             "+strName+"             "+intScore);
				con.println(" ");
			}
		}else if(intCount >= 10){
			System.out.print("more than 10");
			for(intCount1 = 0; intCount1 < 10; intCount1++){
				strName = leaderboard1.readLine();
				intScore = leaderboard1.readInt();
				con.println("                                             "+strName+"             "+intScore);
				con.println(" ");
			}
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
	

	
}
