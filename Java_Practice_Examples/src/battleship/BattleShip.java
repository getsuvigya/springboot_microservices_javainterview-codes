package battleship;

import java.util.Scanner;
/*
 * Code includes two dimensional arrays to represent battle areas for the players.
 * All the indices filled with value 2 represent Q type ships and those filled with one represent P type ship.
 * Since the arrays are zero based, the value of alpha numeric location are normalized taking 65 as base for alphabets.
 */

public class BattleShip {
	public static final int alphaConstant = 65;
	public static final String Q_Type_Ship = "Q";
	public static final String P_Type_Ship = "P";
	public static final char Zero_Constant = '0';
	public static final int Q_Type_Constant = 2;
	public static final int P_Type_Constant = 1;
	public static final String Player1_Constant = "Player-1";
	public static final String Player2_Constant = "Player-2";
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the size of battle area");
	String battleAreaString = scanner.nextLine();
	String areaArray[] = battleAreaString.split(" ");
	int areaWidth = Integer.parseInt(areaArray[0]);
	int areaHeight = (int)(areaArray[1].charAt(0))-alphaConstant+1; // for zero index based
	
	//Define battle areas for player1 and player2
	int battleArea1[][]=new int[areaHeight][areaWidth];
	int battleArea2[][]=new int[areaHeight][areaWidth];
	System.out.println("Enter no. of ships");
	int totalShips=Integer.parseInt(scanner.nextLine());
	
	int undamagedAreas1 = 0;
	int undamagedAreas2 = 0;
	for(int shipNumber=0; shipNumber<totalShips; shipNumber++){
		System.out.println("Enter ship type, width and height of ship, location of ship for player 1 and player 2.");
		String shipDetails = scanner.nextLine();
		String shipDetailsArray[] = shipDetails.split(" ");
		String shipType = shipDetailsArray[0];
		int shipWidth = Integer.parseInt(shipDetailsArray[1]);
		int shipHeight = Integer.parseInt(shipDetailsArray[2]);
		
		//Player 1 Location details
		String player1Loc = shipDetailsArray[3];
		int player1Loc_Y = (int)player1Loc.charAt(0)-alphaConstant;//for vertical
		int player1Loc_X = player1Loc.charAt(1)- Zero_Constant-1;//for horizontal
		
		//Player 2 Location details
		String player2Loc = shipDetailsArray[4];
		int player2Loc_Y = (int)player2Loc.charAt(0)-alphaConstant;//for vertical
		int player2Loc_X = player2Loc.charAt(1)- Zero_Constant-1;//for horizontal
		
		//create battle ships for player 1 and player 2
		for(int shipHeight_k=0; shipHeight_k<shipHeight; shipHeight_k++){
			for(int shipWidth_l=0; shipWidth_l<shipWidth; shipWidth_l++){
				if(shipType.equals(Q_Type_Ship)){
					battleArea1[player1Loc_Y+shipHeight_k][player1Loc_X+shipWidth_l]=2;
					
					battleArea2[player2Loc_Y+shipHeight_k][player2Loc_X+shipWidth_l]=2;
					
					undamagedAreas1 = undamagedAreas1+Q_Type_Constant;
					undamagedAreas2 = undamagedAreas2+Q_Type_Constant;
				}
				if(shipType.equals(P_Type_Ship)){
					battleArea1[player1Loc_Y+shipHeight_k][player1Loc_X+shipWidth_l]=1;
					battleArea2[player2Loc_Y+shipHeight_k][player2Loc_X+shipWidth_l]=1;
					undamagedAreas1 = undamagedAreas1+P_Type_Constant;
					undamagedAreas2 = undamagedAreas2+P_Type_Constant;
				}
				
			}
		}
	}
	

	
	//Note subtract 1 for each x coordinate i.e width coordinate
	System.out.println("Enter player1 missile target coordinate sequences");
	String missileTargetCordinateString1 = scanner.nextLine();
	String missileTargetCordinateArray1[] = missileTargetCordinateString1.split(" ");
	
	System.out.println("Enter player2 missile target coordinate sequences");
	String missileTargetCordinateString2 = scanner.nextLine();
	String missileTargetCordinateArray2[] = missileTargetCordinateString2.split(" ");
	
	int missileCounter1 = 0;
	int missileCounter2 = 0;
	String nextPlayer = Player1_Constant;
	while(true){
		if(undamagedAreas1>0 && undamagedAreas2>0 && missileCounter1==missileTargetCordinateArray1.length && missileCounter2==missileTargetCordinateArray2.length){
			System.out.println(Player1_Constant+" and "+Player2_Constant+" declared peace!");
			break;
		}
		if(nextPlayer.equals(Player1_Constant)){
			if(undamagedAreas2==0){
				System.out.println(Player1_Constant + " has won the game!");
				break;
			}else{
				
				if(missileCounter1<missileTargetCordinateArray1.length){
					String missileCordinateString = missileTargetCordinateArray1[missileCounter1];
					int missilecordinate_Y = (int)missileCordinateString.charAt(0)-alphaConstant;
					int missilecordinate_X = missileCordinateString.charAt(1)- Zero_Constant-1;
					if(battleArea2[missilecordinate_Y][missilecordinate_X]>0){
						battleArea2[missilecordinate_Y][missilecordinate_X] = battleArea2[missilecordinate_Y][missilecordinate_X]-1;
						undamagedAreas2 = undamagedAreas2-1;
						System.out.println(Player1_Constant+ " fires a missile with target "+missileCordinateString+  " which got hit.");
					}else{
						nextPlayer = Player2_Constant;
						System.out.println(Player1_Constant+ " fires a missile with target "+missileCordinateString+  " which got miss.");
					}
					missileCounter1++;
				}else{
					System.out.println(Player1_Constant+" has no more missiles.");
					nextPlayer = Player2_Constant;
				}
			}
		}else{
			if(undamagedAreas1==0){
				System.out.println(Player2_Constant + " has won the game!");
				break;
			}else{
				
				if(missileCounter2<missileTargetCordinateArray2.length){
					String missileCordinateString = missileTargetCordinateArray2[missileCounter2];
					int missilecordinate_Y = (int)missileCordinateString.charAt(0)-alphaConstant;
					int missilecordinate_X = missileCordinateString.charAt(1)- Zero_Constant-1;
					if(battleArea1[missilecordinate_Y][missilecordinate_X]>0){
						battleArea1[missilecordinate_Y][missilecordinate_X] = battleArea1[missilecordinate_Y][missilecordinate_X]-1;
						undamagedAreas1 = undamagedAreas1-1;
						System.out.println(Player2_Constant+ " fires a missile with target "+missileCordinateString+  " which got hit.");
					}else{
						nextPlayer = Player1_Constant;
						System.out.println(Player2_Constant+ " fires a missile with target "+missileCordinateString+  " which got miss.");
					}
					missileCounter2++;
				}else{
					System.out.println(Player2_Constant+" has no more missiles.");
					nextPlayer = Player1_Constant;
				}
			}
		}
	}
	
	scanner.close();
}
}
