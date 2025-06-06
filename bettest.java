import arc.*;

public class bettest{
	public static void main(String[] args){
		Console con = new Console();
		int intHand[][];
		intHand = new int[5][2];
		int intBet = 500; 
		int intCardTemp; 
		int intCount;
		int intCount1; 
		boolean blnRoyalFlush = false;
		boolean blnSameSuit = false; 
		boolean bln10Straight = false;
		boolean blnStraight = false; 
		boolean bln4ofaKind = false; 
		boolean bln3ofaKind = false; 
		
		
		
		intHand[0][0] = 1;
		intHand[1][0] = 1; 
		intHand[2][0] = 2; 
		intHand[3][0] = 1;
		intHand[4][0] = 1; 
		intHand[0][1] = 1;
		intHand[1][1] = 1;
		intHand[2][1] = 1;
		intHand[3][1] = 1;
		intHand[4][1] = 1;
		
		
		
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
			con.println("Same Suit");
		}
		if(intHand[0][0] == 1 && intHand[1][0] == 10 && intHand[2][0] == 11 && intHand[3][0] == 12 && intHand[4][0] == 13){
			bln10Straight = true; 
			con.println("10 straight");
		}
		intCount = intHand[0][0]; 
		if(intHand[0][0] == intCount && intHand[1][0] == intCount + 1 && intHand[2][0] == intCount + 2 && intHand[3][0] == intCount + 3 && intHand[4][0] == intCount + 4){
			blnStraight = true; 
			con.println("straight");
		}
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln4ofaKind = true; 
			con.println("four of a kind");
		}
		if((intHand[0][0] == intHand[1][0] && intHand[1][0] == intHand[2][0]) || (intHand[1][0] == intHand[2][0] && intHand[2][0] == intHand[3][0]) || (intHand[2][0] == intHand[3][0] && intHand[3][0] == intHand[4][0])){
			bln3ofaKind = true; 
			con.println("three of a kind"); 
		}
		
		//Determining hand value
		if(bln10Straight == true && blnSameSuit == true){
			con.println("royal flush");
			intBet = intBet * 800; 
		}else if(blnStraight == true && blnSameSuit == true){
			con.println("straight flush");
			intBet = intBet  * 50; 
		}else if(bln4ofaKind == true){
			con.println("four of a kind");
			intBet = intBet * 25;
		//NEED FULLHOUSE!!
		}else if(blnSameSuit == true){
			con.println("flush");
			intBet = intBet * 6	;
		}else if(bln3ofaKind == true){
			con.println("three of a kind");
			intBet = intBet * 3;
		}
		
	}
}
