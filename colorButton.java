import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class colorButton extends JButton implements ActionListener {
	ImageIcon black,white;
	int value;
	private String color;
	private URL sound;
	private AudioClip c;
	public static boolean[] isPressed3;
	private static boolean isPressed2;
	private static boolean isBlack;
	private boolean pos;
	private boolean isWhite;
	private boolean isPressed;
	private boolean isPressed4;
	private boolean isPressed5;
	
    public colorButton() {
    	
		black = new ImageIcon(this.getClass().getResource("black2.png"));
		white=  new ImageIcon(this.getClass().getResource("white3.png"));
	    sound = this.getClass().getResource("158966__carlmartin__jembay-hit-6-center.wav");
	    c = Applet.newAudioClip(sound);
		color = "a";
		pos=true;
		isPressed2 = true;
		isBlack = true;
		isWhite = false;
		isPressed = true;
		isPressed3 = new boolean[225];
		for(int i =0; i<225;i++){
			isPressed3[i]=true;
		}
		isPressed4 = true;
		isPressed5=true;
        this.addActionListener(this);
	}
	
    
	public void setBlack(boolean black){
    	isBlack=black;
    }
  //get the Strings from the color buttons
	public String getColor(){
		if(value==1){
			color = "black";
			return color;
		}
		else if(value==0&&isWhite){
			color = "white";
			return color;
		}
		else {
			return color;
		}
				
	}
	public String getColor2(){
		return color;
	}
	public void setColor(String color2){
		color=color2;
	}
	//Switch turns from black to white
    public  void switchTurns(){
    	if(isBlack){
    		isBlack=false;
			isPressed = false;
    	}
    	else{
    		isWhite=true;
			isBlack=true;
			isPressed = false;
    	}
    }
	// action performed by the buttons
	public  void actionPerformed(ActionEvent e){
		
		while(isPressed){
		
		switch(value){
	   
		case 0:
			if(isBlack){
			setIcon(black);
			switchTurns();
			c.play();
			}
			else
			{
			
		    setIcon(white);
		    value--;
		    switchTurns();
		    c.play();
			
			}
			break;
	   case 1:
			if(isBlack){
		    setIcon(black);
		    value--;
		    switchTurns();
		    c.play();
			
			}
			else
			{
		    setIcon(white);
		    switchTurns();
		    c.play();
			}
			break;
		
		
		}
		    value ++;
		    value %=2;
		    int k = Player.showMov();
		    isPressed3[k]=false;
		    Ai(k);
		    FiveChess.isWin();// Calculate who wins
		   
			    //FiveChess.guess[k+15].doClick();
			 }
	}
	
	
	public void save(){
		 //horizontal left side - 4 in a row
	    if(pos){
	    	for(int x=0;x<15;x++){
	          for(int y=2;y<12;y++){
	        	  int a=y+(x*15);
	    	if(FiveChess.guess[a].getColor()!="a"&&isPressed3[a-1]&&
			    	   FiveChess.guess[a].getColor()==FiveChess.guess[a+1].getColor()&&
			    	   FiveChess.guess[a+1].getColor()==FiveChess.guess[a+2].getColor()&&
			    	   FiveChess.guess[a+2].getColor()==FiveChess.guess[a+3].getColor()){
			    	   FiveChess.guess[a-1].doClick();
			    	   isPressed3[a-1]=false;
			    	   pos=false;
			    		 break;
			    	}
	    	}
	    	}
	        }
	 // horizontal right side - 4 in a row
	    if(pos){
	    for(int x=0;x<15;x++){
	    	for(int y=0;y<11;y++){
	    		int i=y+(x*15);
	    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+4]&&
	    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+1].getColor()&&
	    	   FiveChess.guess[i+1].getColor()==FiveChess.guess[i+2].getColor()&&
	    	   FiveChess.guess[i+2].getColor()==FiveChess.guess[i+3].getColor()){
	    	   FiveChess.guess[i+4].doClick();
	    	   isPressed3[i+4]=false;
	    	   pos=false;
	    		 break;
	    	}
	    	}
	    	}
	    }
	    //vertical upwards -  4 in a row
	    if(pos){
	         for(int x=1;x<12;x++){
	         for(int y=0;y<15;y++){ 
	        	 int r = y+(x*15);
	             if(FiveChess.guess[r].getColor()!="a"&&isPressed3[r-15]&&
			    	   FiveChess.guess[r].getColor()==FiveChess.guess[r+15].getColor()&&
			    	   FiveChess.guess[r+15].getColor()==FiveChess.guess[r+30].getColor()&&
			    	   FiveChess.guess[r+30].getColor()==FiveChess.guess[r+45].getColor()){
			    	   FiveChess.guess[r-15].doClick();
			    	   isPressed3[r-15]=false;
			    	   pos=false;
			    		 break;
			    	}
	         }
	         }
	    }
	    //vertical downwards - 4 in a row
	    if(pos){
	       for(int x=0;x<11;x++){
	    	   for(int y=0;y<15;y++){
	    		   int i = y+(x*15);
	    	   if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+60]&&
			    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+15].getColor()&&
			    	   FiveChess.guess[i+15].getColor()==FiveChess.guess[i+30].getColor()&&
			    	   FiveChess.guess[i+30].getColor()==FiveChess.guess[i+45].getColor()){
			    	   FiveChess.guess[i+60].doClick();
			    	   isPressed3[i+60]=false;
			    	   pos=false;
			    		 break;
			    	}
	    	   }
	       }
	    }
	    //diagonal left upwards - 4 in a row
	    if(pos){
	    	for(int x=1;x<12;x++){
	    		for(int y=1;y<12;y++){
	    			int i =y+(x*15);
	    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i-16]&&
			    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+16].getColor()&&
			    	   FiveChess.guess[i+16].getColor()==FiveChess.guess[i+32].getColor()&&
			    	   FiveChess.guess[i+32].getColor()==FiveChess.guess[i+48].getColor()){
			    	   FiveChess.guess[i-16].doClick();
			    	   isPressed3[i-16]=false;
			    	   pos=false;
			    		 break;
			    	}
	    		}
	    	}
	    }
	    //diagonal right downwards - 4 in a row
	    if(pos){
	    	for(int x=0;x<11;x++){
	    		for(int y=0;y<11;y++){
	    			int i = y+(x*15);
	    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+64]&&
			    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+16].getColor()&&
			    	   FiveChess.guess[i+16].getColor()==FiveChess.guess[i+32].getColor()&&
			    	   FiveChess.guess[i+32].getColor()==FiveChess.guess[i+48].getColor()){
			    	   FiveChess.guess[i+64].doClick();
			    	   isPressed3[i+64]=false;
			    	   pos=false;
			    		 break;
			    	}
	    		}
	    	}
	    }
	    //diagonal right upwards - 4 in a row
	    if(pos){
	    	for(int x=1;x<12;x++){
	    		for(int y=0;y<11;y++){
	    			int i = y+(x*15);
	    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i-14]&&
			    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+14].getColor()&&
			    	   FiveChess.guess[i+14].getColor()==FiveChess.guess[i+28].getColor()&&
			    	   FiveChess.guess[i+28].getColor()==FiveChess.guess[i+14].getColor()){
			    	   FiveChess.guess[i-14].doClick();
			    	   isPressed3[i-14]=false;
			    	   pos=false;
			    		 break;
			    		 
			    	}
	    	}
	    	}
	    }
	    //diagonal left downwards - 4 in a row
	    if(pos){
	    	for(int x =0;x<11;x++){
	    		for(int y=4;y<15;y++){
	    			int i=y+(x*15);
	    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+56]&&
			    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+14].getColor()&&
			    	   FiveChess.guess[i+14].getColor()==FiveChess.guess[i+28].getColor()&&
			    	   FiveChess.guess[i+28].getColor()==FiveChess.guess[i+42].getColor()){
			    	   FiveChess.guess[i+56].doClick();
			    	   isPressed3[i+56]=false;
			    	   pos=false;
			    		 break;
			    	}
	    		}
	    	}
	    }
	}	
	public void saveThree(){
		//Horizontal 
				if(pos){
		        for(int h=0;h<15;h++){
			    for(int k=0;k<11;k++){
			    	int i = k+(h*15);
			    	if(FiveChess.guess[i].getColor()=="a"&&FiveChess.guess[i+1].getColor()!="a"&&
			    			FiveChess.guess[i+1].getColor()==FiveChess.guess[i+2].getColor()&&
			    			FiveChess.guess[i+2].getColor()==FiveChess.guess[i+3].getColor()&&
			    					FiveChess.guess[i+4].getColor()=="a"){
			    		if(FiveChess.guess[i+5].getColor()!="a"){
			    			FiveChess.guess[i+4].doClick();
				    		isPressed3[i+4]=false;
					    	   pos=false;
					    		 break;
			    		}
			    		else{
			    		FiveChess.guess[i].doClick();
			    		isPressed3[i]=false;
				    	   pos=false;
				    		 break;
			    		}
			    		}
			    		
			    		
		              }
			    	
			    }
				}
				
				//Vertical five in a row
				if(pos){
			    for(int y=0;y<165;y++){
			    	 if(FiveChess.guess[y].getColor()=="a"&&FiveChess.guess[y+15].getColor()!="a"&&
			    			 FiveChess.guess[y+15].getColor()==FiveChess.guess[y+30].getColor()&&
			    					 FiveChess.guess[y+30].getColor()==FiveChess.guess[y+45].getColor()&&
			    							 FiveChess.guess[y+60].getColor()=="a"){
			    		 if(y<150&&FiveChess.guess[y+75].getColor()!="a"){
			    			 FiveChess.guess[y+60].doClick();
			    			 isPressed3[y+60]=false;
				    		 pos=false;
				    		 break;
			    		 }
			    		 else{
			    		 FiveChess.guess[y].doClick();
			    		 isPressed3[y]=false;
			    		 pos=false;
			    		 break;
			    		 }
			    	 }
			    }
				
			    
			    }
				if(pos){
				    for(int x=0;x<11;x++){
				    	for(int r=4;r<15;r++){
				    		int p = r+(x*15);
				    		if( FiveChess.guess[p].getColor()=="a"&&FiveChess.guess[p+14].getColor()!="a"&&
				    				 FiveChess.guess[p+14].getColor()== FiveChess.guess[p+28].getColor()&&
				    						 FiveChess.guess[p+28].getColor()== FiveChess.guess[p+42].getColor()&&
				    								 FiveChess.guess[p+56].getColor()=="a"){
				    			if( p+70<225&&FiveChess.guess[p+70].getColor()!="a"){
				    				 FiveChess.guess[p+56].doClick();
				    				 isPressed3[p+56]=false;
						    		 pos=false;
						    		 break;
				    			}
				    		}
				    	}
				    }
				}
			    //right-Diagonal five in a row
				if(pos){
			    for(int x=0;x<11;x++){
			    	for(int r=0;r<11;r++){
			    		int p = r+(x*15);
			    		if(FiveChess.guess[p].getColor()=="a"&&FiveChess.guess[p+16].getColor()!="a"&&
			    				FiveChess.guess[p+16].getColor()==FiveChess.guess[p+32].getColor()&&
			    						FiveChess.guess[p+32].getColor()==FiveChess.guess[p+48].getColor()&&
			    								FiveChess.guess[p+64].getColor()=="a"){
			    			if(p+80<225&&FiveChess.guess[p+80].getColor()!="a"){
			    			FiveChess.guess[p+64].doClick();
			    			isPressed3[p+64]=false;
				    		 pos=false;
				    		 break;
			    			}
			    			else{
			    			 FiveChess.guess[p].doClick();
				    		 isPressed3[p]=false;
				    		 pos=false;
				    		 break;
			    			}
			    		
			    	
			    		}
			    	}
			    }
			    }
			    //left-diagonal five in a row
				if(pos){
			    for(int x=0;x<11;x++){
			    	for(int r=4;r<15;r++){
			    		int p = r+(x*15);
			    		if( FiveChess.guess[p].getColor()=="a"&&FiveChess.guess[p+14].getColor()!="a"&&
			    				 FiveChess.guess[p+14].getColor()== FiveChess.guess[p+28].getColor()&&
			    						 FiveChess.guess[p+28].getColor()== FiveChess.guess[p+42].getColor()&&
			    								 FiveChess.guess[p+56].getColor()=="a"){
			    
			    			
			    			 FiveChess.guess[p].doClick();
				    		 isPressed3[p]=false;
				    		 pos=false;
				    		 break;
			    			
			    	
			    		}
			    }
			    }
				}
			    	
			    
			   
			    
	}
	//AI
	public void Ai(int k){
		if(FiveChess.isAi){
			//difficulty level:Ruiqi the beast!(AI randomly pressing buttons)
			if(FiveChess.diff=="Ruiqi the BEAST"){
			if(isPressed2){
				isPressed2=false;
				int move = (int)(Math.random()*223+0);
				while(isPressed3[move]==false){
					 move = (int)(Math.random()*223+0);
				}
				FiveChess.guess[move].doClick();
				
				isPressed3[move]=false;
			}
			isPressed2=true;
			}  
			//difficulty level:Ricky the god!(AI thinks)
			else if(FiveChess.diff=="Ricky Peng"){
		    if(isPressed2){
		    isPressed2 = false;
		    save();
		    
		    saveThree();
		        if(pos){
		    	if(isPressed5&&k<223){
		    	if(isPressed3[k+1]&&FiveChess.guess[k+1].getColor()=="a"&&FiveChess.guess[k+2].getColor()=="black"){
		    		FiveChess.guess[k+1].doClick();
		    		isPressed3[k+1]=false;
		    		isPressed5=false;
		    		pos=false;
		    	}
		    	}
		        }
		    	if(pos){
		    	if(isPressed5&&k>1){
		    	if(isPressed3[k-1]&&FiveChess.guess[k-1].getColor()=="a"&&FiveChess.guess[k-2].getColor()=="black"){
		    		FiveChess.guess[k-1].doClick();
		    		isPressed3[k-1]=false;
		    		pos=false;
		    	}
		    	}
		    	}
		    	
		    	
		    	
		    
		    if(pos){
		    	for(int x=0;x<13;x++){
		    		for(int y=0;y<13;y++){
		    			int i=y+(x*15);
		    			if(isPressed3[i+16]&&k==i&&FiveChess.guess[i+16].getColor()=="a"&&FiveChess.guess[i+32].getColor()=="black"){
				    		FiveChess.guess[i+16].doClick();
				    		isPressed3[i+16]=false;
				    		pos=false;
				    		break;
		    		}
		    	}
		    }
		    }
		    	if(pos){
			    	for(int x=2;x<15;x++){
			    		for(int y=2;y<15;y++){
			    			int i=y+(x*15);
			    			if(isPressed3[i-16]&&k==i&&FiveChess.guess[i-16].getColor()=="a"&&FiveChess.guess[i-32].getColor()=="black"){
					    		FiveChess.guess[i-16].doClick();
					    		isPressed3[i-16]=false;
					    		pos=false;
					    		break;
			    		}
			    	}
			    }
		    }
		    	if(pos){
			    	for(int x=0;x<13;x++){
			    		for(int y=2;y<15;y++){
			    			int i=y+(x*15);
			    			if(isPressed3[i+14]&&k==i&&FiveChess.guess[i+14].getColor()=="a"&&FiveChess.guess[i+28].getColor()=="black"){
					    		FiveChess.guess[i+14].doClick();
					    		isPressed3[i+14]=false;
					    		pos=false;
					    		break;
			    		}
			    	}
			    }
			    }
		    	
		    if(pos){
		    	for(int x=2;x<15;x++){
		    		for(int y=0;y<13;y++){
		    			int i=y+(x*15);
		    			if(isPressed3[i-14]&&k==i&&FiveChess.guess[i-14].getColor()=="a"&&FiveChess.guess[i-28].getColor()=="black"){
				    		FiveChess.guess[i-14].doClick();
				    		isPressed3[i-14]=false;
				    		pos=false;
				    		break;
		    		}
		    	}
		    }
		    }
		    
		    //horizontal left side
		    if(pos){
		    	for(int x=0;x<15;x++){
		          for(int y=2;y<13;y++){
		        	  int a=y+(x*15);
		    	if(FiveChess.guess[a].getColor()!="a"&&isPressed3[a-1]&&
				    	   FiveChess.guess[a].getColor()==FiveChess.guess[a+1].getColor()&&
				    	   FiveChess.guess[a+1].getColor()==FiveChess.guess[a+2].getColor()){
				    	   FiveChess.guess[a-1].doClick();
				    	   isPressed3[a-1]=false;
				    	   pos=false;
				    		 break;
				    	}
		    	}
		    	}
		        }
		 // horizontal right side
		    if(pos){
		    for(int x=0;x<15;x++){
		    	for(int y=0;y<12;y++){
		    		int i=y+(x*15);
		    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+3]&&
		    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+1].getColor()&&
		    	   FiveChess.guess[i+1].getColor()==FiveChess.guess[i+2].getColor()){
		    	   FiveChess.guess[i+3].doClick();
		    	   isPressed3[i+3]=false;
		    	   pos=false;
		    		 break;
		    	}
		    	}
		    	}
		    }
		    //vertical upwards
		    if(pos){
		         for(int x=1;x<13;x++){
		         for(int y=0;y<15;y++){ 
		        	 int r = y+(x*15);
		             if(FiveChess.guess[r].getColor()!="a"&&isPressed3[r-15]&&
				    	   FiveChess.guess[r].getColor()==FiveChess.guess[r+15].getColor()&&
				    	   FiveChess.guess[r+15].getColor()==FiveChess.guess[r+30].getColor()){
				    	   FiveChess.guess[r-15].doClick();
				    	   isPressed3[r-15]=false;
				    	   pos=false;
				    		 break;
				    	}
		         }
		         }
		    }
		    //vertical downwards
		    if(pos){
		       for(int x=0;x<12;x++){
		    	   for(int y=0;y<15;y++){
		    		   int i = y+(x*15);
		    	   if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+45]&&
				    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+15].getColor()&&
				    	   FiveChess.guess[i+15].getColor()==FiveChess.guess[i+30].getColor()){
				    	   FiveChess.guess[i+45].doClick();
				    	   isPressed3[i+45]=false;
				    	   pos=false;
				    		 break;
				    	}
		    	   }
		       }
		    }
		    //diagonal left upwards
		    if(pos){
		    	for(int x=1;x<13;x++){
		    		for(int y=1;y<13;y++){
		    			int i =y+(x*15);
		    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i-16]&&
				    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+16].getColor()&&
				    	   FiveChess.guess[i+16].getColor()==FiveChess.guess[i+32].getColor()){
				    	   FiveChess.guess[i-16].doClick();
				    	   isPressed3[i-16]=false;
				    	   pos=false;
				    		 break;
				    	}
		    		}
		    	}
		    }
		    //diagonal right downwards
		    if(pos){
		    	for(int x=0;x<12;x++){
		    		for(int y=0;y<12;y++){
		    			int i = y+(x*15);
		    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+48]&&
				    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+16].getColor()&&
				    	   FiveChess.guess[i+16].getColor()==FiveChess.guess[i+32].getColor()){
				    	   FiveChess.guess[i+48].doClick();
				    	   isPressed3[i+48]=false;
				    	   pos=false;
				    		 break;
				    	}
		    		}
		    	}
		    }
		    //diagonal right upwards
		    if(pos){
		    	for(int x=1;x<13;x++){
		    		for(int y=0;y<12;y++){
		    			int i = y+(x*15);
		    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i-14]&&
				    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+14].getColor()&&
				    	   FiveChess.guess[i+14].getColor()==FiveChess.guess[i+28].getColor()){
				    	   FiveChess.guess[i-14].doClick();
				    	   isPressed3[i-14]=false;
				    	   pos=false;
				    		 break;
				    		 
				    	}
		    	}
		    	}
		    }
		    //diagonal left downwards
		    if(pos){
		    	for(int x =0;x<12;x++){
		    		for(int y=3;y<15;y++){
		    			int i=y+(x*15);
		    	if(FiveChess.guess[i].getColor()!="a"&&isPressed3[i+42]&&
				    	   FiveChess.guess[i].getColor()==FiveChess.guess[i+14].getColor()&&
				    	   FiveChess.guess[i+14].getColor()==FiveChess.guess[i+28].getColor()){
				    	   FiveChess.guess[i+42].doClick();
				    	   isPressed3[i+42]=false;
				    	   pos=false;
				    		 break;
				    	}
		    		}
		    	}
		    }
		    
		    
		    //normal move
		    if(pos&isPressed4){
		    	if(k<=209){
		    	if(FiveChess.guess[k+15].getColor()=="a"){
		    		       
		    		       FiveChess.guess[k+15].doClick();
		    		       isPressed3[k+15]=false;
		    		       isPressed4 = false;
		    		       pos=false;
		    		       
		    		      
		    	}
		    	}
		    	if(k>14&&isPressed4){
			    	   if(FiveChess.guess[k-15].getColor()=="a"&k>14){
		    		       FiveChess.guess[k-15].doClick();
		    		       isPressed3[k-15]=false;
		    		       isPressed4 = false;
		    		       pos=false;
		    		       
		    		       
		    	}
			    	}
		    	if(k<224&&isPressed4){
		    	 if(FiveChess.guess[k+1].getColor()=="a"){
	    		       FiveChess.guess[k+1].doClick();
	    		       isPressed3[k+1]=false;
	    		       isPressed4 = false;
	    		       pos=false;
	    		       
	    	}
		    	}
		    	if(k>1&&isPressed4){
		    	if(FiveChess.guess[k-1].getColor()=="a"){
	    		       FiveChess.guess[k-1].doClick();
	    		       isPressed3[k-1]=false;
	    		       isPressed4 = false;
	    		       pos=false;
	    		      
	    	}
		    	}
		    	
		    }
		   
		}
		    isPressed2 = true;
		    	
		 	
		    
		}//end of difficulty level choices
			else if(FiveChess.diff=="Ricky the GOD"){
				if(isPressed2){
					isPressed2=false;
					if(k>61){
					for(int i=0;i<61;i++){
						FiveChess.guess[i].doClick();
					}
				}
					else{
						for(int i=75;i<136;i++){
							FiveChess.guess[i].doClick();
						}
					}
				}
			}
		}//end of isAi
	}//end of AI method
	
}
	
    
  


	
			
 
		
	

