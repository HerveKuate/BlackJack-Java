import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BlackJackGUI implements ActionListener {
	
	
	
	
	private BlackJack bj;
	private JPanel playerPanel=new JPanel();
	private JPanel bankPanel=new JPanel();;
	
	public BlackJackGUI() throws EmptyDeckException{
		this.bj=new BlackJack();
		
		JFrame frame = new JFrame("BlackJack GUI");
		frame.setMinimumSize(new Dimension(640,480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		
		JPanel container = new JPanel();
	    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			
		//Instanciation d'un objet JPanel
	    JPanel pan1 = new JPanel();
	    JPanel pan2 = new JPanel();
	    JPanel pan3 = new JPanel();
	    
	    this.playerPanel=pan3;
	    this.bankPanel=pan2;
	    //pan1.setSize(640, 300);
	    pan2.setBorder(BorderFactory.createTitledBorder("Bank"));
	    //pan2.setSize(640, 160);
	    pan3.setBorder(BorderFactory.createTitledBorder("Player"));
	    //pan3.setSize(640, 160);
	             

	    
	  //Possibilité 1 : instanciation avec le libellé
	    JButton bouton = new JButton("AnotherCard");
	    JButton bouton2 = new JButton ("No More Card");
	    JButton bouton3 = new JButton ("Reset");
	    
	    
	    bouton.setActionCommand("key1");
	    bouton.addActionListener(this);
	    bouton2.setActionCommand("key2");
	    bouton2.addActionListener(this);
	    bouton3.setActionCommand("key3");
	    bouton3.addActionListener(this);
	    
	   // GridLayout gl = new GridLayout(3,2);
	 //   gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
	//    gl.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical) 
	    
	    //pan1.setLayout(new GridLayout(3, 2));
	    
	    pan1.add(bouton);
	    pan1.add(bouton2);
	    pan1.add(bouton3);	    

	    container.add(pan1);
	    container.add(pan2);
	    container.add(pan3);
	    
	        
	    //On définit le layout à utiliser sur le content pane
	    
	    frame.setContentPane(container);
	    
	    frame.setVisible(true);

	    
	    //On prévient notre JFrame que notre JPanel sera son content pane
	   // frame.setContentPane(pan);  
		}
	
	
	
	private void addToPanel(JPanel p, String token)throws FileNotFoundException {
		
		File file = new File("./img/card_"+token+".png");
		if (!file.exists()) {
		throw new FileNotFoundException("Can't find "+file.getPath());
		}
		ImageIcon icon = new ImageIcon(file.getPath()); // Create the image from the filename
		JLabel label = new JLabel(icon); // Associate the image to a label
		p.add(label);
		
		}
	
	private void updatePlayerPanel()throws FileNotFoundException{
		this.playerPanel.removeAll();
		String token="";
		for(Card card:this.bj.getPlayerCardList()) {
			token=card.getColorName()+"_"+card.getValueSymbole();
			this.addToPanel(this.playerPanel, token);
		}
		JLabel label = new JLabel("Player Best :"+this.bj.getPlayerBest()); // Associate the image to a label
		this.playerPanel.add(label);
		
		if(this.bj.isPlayerWinner()) {
			try {
				this.addToPanel(playerPanel, "winner");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				this.addToPanel(bankPanel, "looser");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}
		/*if(this.bj.getPlayerBest()>21)
				
			try {
				this.addToPanel(this.bankPanel, "winner");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.addToPanel(playerPanel, "looser");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		
				
		this.bankPanel.updateUI();
		this.playerPanel.updateUI();
	}
	
	private void updateBankPanel()throws FileNotFoundException{
		this.bankPanel.removeAll();
		String token="";
		for(Card card:bj.getBankCardList()) {
			token=card.getColorName()+"_"+card.getValueSymbole();
			this.addToPanel(this.bankPanel, token);
		}
		JLabel label = new JLabel("Bank Best :"+this.bj.getBankBest()); // Associate the image to a label
		this.bankPanel.add(label);
		
		if(this.bj.isBankWinner()) {
			try {
				this.addToPanel(this.bankPanel, "winner");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.addToPanel(playerPanel, "looser");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		this.playerPanel.updateUI();
		this.bankPanel.updateUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) { // Valid since Java 1.7
		case "key1": 
			try {
				this.bj.playerDrawAnotherCard();
			} catch (EmptyDeckException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.updatePlayerPanel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "key2": 
			try {
				this.bj.bankLastTurn();
			} catch (EmptyDeckException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.bj.gameFinished=true;
			
			try {
				this.updateBankPanel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.updatePlayerPanel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		
		
		
		
		break;
		
		case "key3":
			try {
				this.bj.reset();
			} catch (EmptyDeckException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.updatePlayerPanel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.updateBankPanel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		}


public static void main(String[] args) throws FileNotFoundException, EmptyDeckException {
new BlackJackGUI();
}
}