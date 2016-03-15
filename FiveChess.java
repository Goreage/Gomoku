import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
    
    public class FiveChess extends JFrame implements ActionListener{
	    JPanel p = new JPanel();
	    protected static int count=1;
	    public static boolean isAi = false;
	private OtherFunctions other =  new OtherFunctions();
	public static String diff;
	public static colorButton guess[] = new colorButton[225];
	public static void main(String[] args) {
		new FiveChess();
		
		
		}
	public void title(String title){
		super.setTitle(title);
	
	}
	public  FiveChess(){
		//Constructing the frame
	    super("Gomoku (Wu zi qi 五子棋) @Made by Ricky Peng "+count+" round(Multiplayer mode!!!)");
		setSize(800,800);
		setLocation(425, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//layout
				p.setLayout(new GridLayout(16,15));
				for (int i=0; i<225; i++){
					guess[i]= new colorButton();
					p.add(guess[i]);
				}
		
		//Strategy button: Bring the user to a web site 
		JButton s = new JButton("Tips");
	    s.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  try {
					other.practice();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		  });
	    //replay Button
	    JButton r = new JButton("Replay");
		r.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	   
        		replay();
        	
        }
		 });
		// AI button
		 JButton v = new JButton("AI");
			v.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
					
	        	
	        	Object[] obj2 ={"Ruiqi the BEAST","Ricky Peng","Ricky the GOD"};  
				diff = (String) JOptionPane.showInputDialog(null,"Please select the difficulty level", "AI difficulty", 
						JOptionPane.PLAIN_MESSAGE, null, obj2, "Ricky Peng");
				 if(diff==null){
					 JOptionPane.showMessageDialog(null, "Coward.");
					 isAi=false;
				 }
				 else{
					 isAi = true;
			         title("Gomoku (Wu zi qi 五子棋) @Made by Ricky Peng "+count+" round(VS AI mode!!)");
				 }
				}
	       
			 });
		//Order button
        JButton o = new JButton("Orders");
		o.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
				other.name();
			}
		 });
		//Game description button(help)
		JButton help = new JButton("Help!");
		help.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        other.help();
		   }});
		
		
		 p.add(help); 
		 p.add(s);
		 p.add(o);
		 p.add(r);
		 p.add(v);
		
		 
		add(p);
		setVisible(true);
	}
    public static colorButton[] getGuess(){
    	return guess;
    }
    public static void press(int pos){
    	guess[pos].doClick();
    }
    public static void replay(){
    	 guess[0].setBlack(true);
 	    count++;
 	    for(int i=0;i<225;i++){
 	    	colorButton.isPressed3[i]=true;
 	    }
 	    for(int i=0;i<225;i++){
 	    	Player.check[i]=false;
 	    	
 	    }
 	   isAi = false;
 		new FiveChess();
    }

	    //automatically implemented 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static boolean isWin(){
		//Horizontal five in a row
		for(int h=0;h<15;h++){
	    for(int k=0;k<11;k++){
	    	int i = k+(h*15);
	    	if(guess[i].getColor()!="a"&&guess[i].getColor()==guess[i+1].getColor()&&
	    			guess[i+1].getColor()==guess[i+2].getColor()&&
	    			guess[i+2].getColor()==guess[i+3].getColor()&&
	    			guess[i+3].getColor()==guess[i+4].getColor()){
	    		askReplay(i);
        return true;
	         }
	    	
	    }
		}
		//Vertical five in a row
	    for(int y=0;y<165;y++){
	    	 if(guess[y].getColor()!="a"&&guess[y].getColor()==guess[y+15].getColor()&&
		    			guess[y+15].getColor()==guess[y+30].getColor()&&
		    			guess[y+30].getColor()==guess[y+45].getColor()&&
		    			guess[y+45].getColor()==guess[y+60].getColor()){
	    		 askReplay(y);
	    		 return true;
	    	 }
	    
	    }
	    //right-Diagonal five in a row
	    for(int x=0;x<11;x++){
	    	for(int r=0;r<11;r++){
	    		int pos = r+(x*15);
	    		if(guess[pos].getColor()!="a"&&guess[pos].getColor()==guess[pos+16].getColor()&&
		    			guess[pos+16].getColor()==guess[pos+32].getColor()&&
		    			guess[pos+32].getColor()==guess[pos+48].getColor()&&
		    			guess[pos+48].getColor()==guess[pos+64].getColor()){
	    			askReplay(pos);
	    			return true;
	    		
	    	
	    		}
	    }
	    }
	    //left-diagonal five in a row
	    for(int x=0;x<11;x++){
	    	for(int r=4;r<15;r++){
	    		int pos = r+(x*15);
	    		if(guess[pos].getColor()!="a"&&guess[pos].getColor()==guess[pos+14].getColor()&&
		    			guess[pos+14].getColor()==guess[pos+28].getColor()&&
		    			guess[pos+28].getColor()==guess[pos+42].getColor()&&
		    			guess[pos+42].getColor()==guess[pos+56].getColor()){
	    			askReplay(pos);
	    			return true; 
	    		
	    	
	    		}
	    }
	    }
	    	
	    
	    return false;
	    
	   
}
	public static void askReplay(int pos){
		if(guess[pos].getColor()=="white"){
			 int a = JOptionPane.showConfirmDialog(null, "Congrats! The WHITE side has won the battle! Do you guys want to restart? ", "result", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(a==JOptionPane.YES_OPTION) {
				guess[0].setBlack(true);
        	    count++;
        	    for(int i=0;i<225;i++){
        	    	colorButton.isPressed3[i]=true;
        	    }
        	    for(int i=0;i<225;i++){
        	    	Player.check[i]=false;
        	    	
        	    }
        	    FiveChess.isAi=false;
				new FiveChess();}
   		}
   		else if(guess[pos].getColor()=="black"){
   			int a = JOptionPane.showConfirmDialog(null, "Congrats! The BLACK side has won the battle! Do you guys want to restart? ", "result", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
   			if(a==JOptionPane.YES_OPTION) {
				guess[0].setBlack(true);
        	    count++;
        	    for(int i=0;i<225;i++){
        	    	colorButton.isPressed3[i]=true;
        	    }
        	    for(int i=0;i<225;i++){
        	    	Player.check[i]=false;
        	    	
        	    }
        	    FiveChess.isAi=false;
				new FiveChess();}
   		}
   		}
	
	
	
	
}

