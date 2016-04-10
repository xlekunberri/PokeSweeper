package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import org.pokesweeper.model.Audioa;
import org.pokesweeper.model.Helbideak;

public class MenuaUI extends JMenuBar implements ActionListener{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private JMenuItem maila1, maila2, maila3, rankinga;
	private JMenuItem irten, nolaJokatu, honiBuruz;
	private JLabel username;

	
	//Eraikitzailea
	public MenuaUI() {
		this.setBorder(null);
		this.setBackground(new Color(89, 153, 124));
		this.add(Box.createRigidArea(new Dimension(5, 25)));
		menuaEraiki();
	}
	
	//Beste Metodoak
	private void menuaEraiki() {
				
		JMenu jokatu = new JMenu("Jokatu");
		this.add(jokatu);
		
		maila1 = new JMenuItem("1. maila");
		jokatu.add(maila1);
		maila1.addActionListener(this);
		
		maila2 = new JMenuItem("2. maila");
		jokatu.add(maila2);
		maila2.addActionListener(this);
		
		maila3 = new JMenuItem("3. maila");
		jokatu.add(maila3);
		maila3.addActionListener(this);
		
		jokatu.addSeparator();
		
		rankinga = new JMenuItem("Rankinga");
		jokatu.add(rankinga);
		rankinga.addActionListener(this);
		
		jokatu.addSeparator();
		
		irten = new JMenuItem("Irten");
		jokatu.add(irten);
		irten.addActionListener(this);
		
		jokatu.addSeparator();
		
		JSlider sDuration=new JSlider(JSlider.HORIZONTAL,0,100,20);
	    sDuration.setPaintLabels(true);
	    sDuration.setPaintTicks(true);
	    sDuration.setMajorTickSpacing(20);
	    sDuration.setMinorTickSpacing(10);
	    sDuration.setToolTipText("Volume");
	    jokatu.add(sDuration);
	    Audioa.setVolume((double)sDuration.getValue());
		
		JMenu laguntza = new JMenu("Laguntza");
		this.add(laguntza);
		
		nolaJokatu = new JMenuItem("Nola jokatu?");
		laguntza.add(nolaJokatu);
		nolaJokatu.addActionListener(this);
		
		laguntza.addSeparator();
		
		honiBuruz = new JMenuItem("Honi buruz");
		laguntza.add(honiBuruz);
		honiBuruz.addActionListener(this);
		
		this.add(Box.createHorizontalGlue());
		
		String izena = JokoaUI.getNireJokoa().getUserName();
		username = new JLabel(izena);
		username.setForeground(new Color(248, 208, 0));
		username.setFont(Helbideak.iturria);
		username.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
		this.add(username);	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	            
	        if (e.getSource()==maila1) {
	        	JokoaUI.getNireJokoa().erreseteatu(7, 10, 7, false);
	        }
		 	else if (e.getSource()==maila2) {
		 		JokoaUI.getNireJokoa().erreseteatu(10, 15, 20, false);
	        }       
		 	else if (e.getSource()==maila3) {
		 		JokoaUI.getNireJokoa().erreseteatu(12, 25, 36, false);
	        }
		 	else if (e.getSource()==rankinga){
		 		new RankingUI(JokoaUI.getNireJokoa(), true).setVisible(true);
		 	}
		 	else if (e.getSource()==irten) {
		 		UIManager.put("OptionPane.yesButtonText", "Bai");
		 		UIManager.put("OptionPane.noButtonText", "Ez");
		 		UIManager.put("OptionPane.cancelButtonText", "Ezeztatu");
		 		
		 		JFrame frame = new JFrame();
		 	    int response = JOptionPane.showConfirmDialog(frame, "Jokoa itxi nahi duzu?","Jokoa itxi",
		 	    		JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,Helbideak.pikaGaldu);
		 	    if (response == JOptionPane.YES_OPTION) {
		 	      System.exit(0);
		 	    }
	        }     
			else if (e.getSource()==nolaJokatu) {
				
			}
			else if (e.getSource()==honiBuruz) {
				JPanel panel = new JPanel(new BorderLayout());
				panel.setBackground(new Color(160, 224, 192));
				JTextPane f = new JTextPane();
				f.setContentType("text/html");
				f.setText("<html><center><b><font size = +2>PokéSweeper</font></b><br><br>"
						+ "<b><font size = +1>Egileak:</font></b><br>"
		                + "Eneko Sampedro<br>"
		                + "Javier Sautua<br>"
		                + "Xabier Lekunberri<br>"
		                + "Gontzal Pujana<br><br>"
		                + "<b><font size = +1>Kodea:</font></b><br>"
		                +"</html>");
		        f.setEditable(false);
				f.setBackground(null);
				f.setBorder(null);
				
				JTextPane website = new JTextPane();
				website.setContentType("text/html");
				website.setText("<html><center><a href=\"\">"+"https://github.com/Xabiier/PokeSweeper"+"</a></html>");
		        website.setCursor(new Cursor(Cursor.HAND_CURSOR));
		        website.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                    try {
		                            Desktop.getDesktop().browse(new URI("https://github.com/Xabiier/PokeSweeper"));
		                    } catch (URISyntaxException | IOException ex) {
		                            ex.printStackTrace();
		                    }
		            }
		        });
		        website.setEditable(false);
		        website.setBackground(null);
		        website.setBorder(null);
		        
		        panel.add(f,  BorderLayout.NORTH);
		        panel.add(website,  BorderLayout.CENTER);
		        
		        JFrame frame = new JFrame();
		        UIManager.put("OptionPane.background",new ColorUIResource(160, 224, 192));
		        UIManager.put("Panel.background",new ColorUIResource(160, 224, 192));
		        UIManager.put("OptionPane.okButtonText", "Itzuli");
		        JOptionPane.showMessageDialog(frame, panel, "Egileak", JOptionPane.PLAIN_MESSAGE);
			}
	}
	
}
