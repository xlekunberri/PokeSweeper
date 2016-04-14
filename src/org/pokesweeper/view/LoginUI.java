package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.pokesweeper.model.Login;
import org.pokesweeper.model.PokéSweeper;
import org.pokesweeper.model.Helbideak;


public class LoginUI extends JPanel {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final JLabel erabiltzailea = new JLabel("Erabiltzailea: ");
	private final JLabel pasahitza = new JLabel("Pasahitza:     ");
	private final JLabel maila = new JLabel("Maila: ");
	private final JTextField erabiltzaileField = new JTextField(15);
	private final JTextField pasahitzaField = new JPasswordField(15);
	private ButtonGroup bg;
	private JRadioButton r1, r2, r3;
    private final JButton jbtOk = new JButton("Sartu");
    private final JButton jbtNew = new JButton("Erregistratu");
    
    //Eraikitzailea
    public LoginUI() {    	
    	bg = new ButtonGroup();
    	r1 = new JRadioButton("1. Maila");
    	r2 = new JRadioButton("2. Maila");
    	r3 = new JRadioButton("3. Maila");
    	
    	r1.setSelected(true);
    	r1.setFocusPainted(false);
    	r2.setFocusPainted(false);
    	r3.setFocusPainted(false);
    	
    	bg.add(r1);
    	bg.add(r2);
    	bg.add(r3);
    	
    	JPanel p1 = new JPanel();
    	p1.add(erabiltzailea);
    	p1.add(erabiltzaileField);
    	
    	JPanel p12 = new JPanel();
    	p12.add(pasahitza);
    	p12.add(pasahitzaField);
    	
    	JPanel p13 = new JPanel(new BorderLayout());
    	p13.add(p1, BorderLayout.NORTH);
    	p13.add(p12, BorderLayout.SOUTH);
    	
    	JPanel p3 = new JPanel(new GridLayout(1,  3));
    	p3.add(r1);
    	p3.add(r2);
    	p3.add(r3);
    	
    	JPanel p2 = new JPanel();
    	p2.add(maila);
    	p2.add(p3);
    	
    	JPanel p4 = new JPanel(new GridLayout(2, 1));
    	p4.add(p13);
    	p4.add(p2);
    	
    	JPanel p5 = new JPanel(new BorderLayout());
    	p5.add(p4, BorderLayout.NORTH);
    	p5.add(jbtOk, BorderLayout.WEST);
    	p5.add(jbtNew, BorderLayout.EAST);
    	
    	JLabel oak = new JLabel(Helbideak.oak);
        
        JPanel p6 = new JPanel();
        p6.setLayout(new BorderLayout(0, 0));
        p6.add(oak, BorderLayout.NORTH);
        p6.add(p5, BorderLayout.SOUTH);
        
    	this.add(p6);

    	//this.getRootPane().setDefaultButton(jbtOk);
    	
    	jbtOk.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String erabiltzailea = getErabiltzaila();
				String pasahitza = getPasahitza();
				if (!(erabiltzailea == null || pasahitza == null)){
					if(Login.getNireLogin().logeatu(erabiltzailea, pasahitza)){
						JokoaUI.getNireJokoa();
						JokoaUI.erabiltzailea = erabiltzailea;
						if(r1.isSelected()) {
							JokoaUI.maila = 1;
						}
						else if (r2.isSelected()) {
							JokoaUI.maila = 2;
						}
						else if (r3.isSelected()) {
							JokoaUI.maila = 3;
						}
						PokéSweeper.getNirePokéSweeper().hurrengoa(2);
					}
					else{
						JOptionPane.showMessageDialog(null, "Erabiltzaile edo pasahitz okerrak");
						pasahitzaField.setText("");
					}
				}
				
			}
		});
    	
    	jbtNew.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				String erabiltzailea = getErabiltzaila();
				String pasahitza = getPasahitza();
				if (!(erabiltzailea == null || pasahitza == null)){
					if(Login.getNireLogin().erabiltzaileaSortu(erabiltzailea,pasahitza)){
						JOptionPane.showMessageDialog(null, "Erabiltzailea sortu da");
					}
					else{
						JOptionPane.showMessageDialog(null, "Ezin da erabiltzailea sortu, izen hori duen beste bat existitzen delako");
					}
				}
				pasahitzaField.setText("");
				
			}
		});
    	
    	PokéSweeperUI.getNirePokéSweeperUI().panelaAldatu(this);
		PokéSweeperUI.getNirePokéSweeperUI().setLocationRelativeTo(null);
    }
    
    //Beste metodoak
    public String getErabiltzaila(){
    	String username = erabiltzaileField.getText().trim();
    	if (username.length()<=10){
    		username = username.substring(0, username.length());
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Erabiltzaileak ezin du 10 karaktere baino gehiago izan");
    		username=null;
    		erabiltzaileField.setText("");
    		pasahitzaField.setText("");
    	}
    	return username;
    }
    
    public String getPasahitza(){
    	String pass = pasahitzaField.getText().trim();
    	if (pass.length()<=16){
    		pass = pass.substring(0, pass.length());
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Pasahitzak ezin du 16 karaktere baino gehiago izan");
    		pass=null;
    		pasahitzaField.setText("");
    	}
    	return pass;
    }
    

}