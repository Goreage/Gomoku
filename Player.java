
public class Player{
	public static boolean[] check = new boolean[225];
	//trace the player's movement
	public static int showMov(){
		for(int i=0;i<225;i++){
		    if(check[i]==false&&FiveChess.guess[i].getColor()!="a"){
		    	check[i]=true;
		    	return i;
     }
			
		}
		return -1;
	}
	
	
     
     
}
