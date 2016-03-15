import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.swing.JOptionPane;

public class OtherFunctions  {
    
	
	public OtherFunctions(){
		
	}
	
	public void help(){
		JOptionPane.showMessageDialog(null, "The objective of this game is to build a row of "
        		+ "five (own) consecutive stones.\n Both players take turns - black side always starts first.\n"
        		+"The descriptions of the buttons:\n1. TIPS button, it will bring you to a web site which can train your"
        		+ " gomoku's strategic thinkings.\n2. ORDERS button, by inputing the names of both players, it will randomly\n"
        		+ "determine which player is playing the black side.\n3. REPLAY button, start a new game, you can drag away the new game borads\n to see the previous games you had"
        		+"\n4. AI button, the vs AI(computer) mode will be automatically statrted after picking the difficulty level. Ruiqi the BEAST\nrepresents the easy level, "
        		+ "Ricky Peng represents the normal level.\nAnd Ricky the GOD represents the invincible level");
    }
	
	
	public void name() {
		// TODO Auto-generated method stub
		String a="a";
		String b="a";
		while(a.length()<=1){
		a = JOptionPane.showInputDialog(null, "What's the first player's name?");
		if(a==null) return;
		else if(a.length()<=1){
			JOptionPane.showMessageDialog(null, "Pls atleast input one character");
		}
		}
		while(b.length()<=1){
		b =JOptionPane.showInputDialog(null, "What's the second player's name?");
		if(b==null) return;
		else if(b.length()<=1){
			JOptionPane.showMessageDialog(null, "Pls atleast input one character");
			
		}
		}
		int x=0;
		Random random =new Random();
		x=random.nextInt(2)+1;
		if(x==1) JOptionPane.showMessageDialog(null, a+" will be the black(original) side!"); 
		else JOptionPane.showMessageDialog(null, b+" will be the black(original) side!"); 
		
	}


	public void practice() throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		 int h =JOptionPane.showConfirmDialog(null, "Alert : this will bring you to an online website\n(No for cancel, yes for going to the website)", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(h==JOptionPane.YES_OPTION){ 
		java.net.URI uri = new java.net.URI("http://www.wglxy.com/gomoku-tips");
        java.awt.Desktop.getDesktop().browse(uri);
        }
  
		
	}

	
	
	
	
	
	
	

}
