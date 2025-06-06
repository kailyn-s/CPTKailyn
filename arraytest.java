import arc.*;

public class arraytest{
	public static void main(String[] args){
		Console con = new Console(600, 1000);
		
		int intCount;
		int intCount2;
		String strCards[][];
		String strCardTemp; 
		
		strCards = new String[52][3];
		arraytest.shuffle(strCards, con);
	}
	public static String[][] shuffle(String[][] strCards, Console con){
		
		int intCount;
		int intCount2;
		String strCardTemp; 
		
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
		
		for(intCount = 0; intCount < 52; intCount++){
			con.println(strCards[intCount][0]+" - "+strCards[intCount][1]+" - "+strCards[intCount][2]);
		}
		
		return strCards;
	}

}
