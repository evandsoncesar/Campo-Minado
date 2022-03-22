package br.com.poli.CAMPOMINADO.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CAMPOMINADO.Jogo.CampoMinado;
import br.com.poli.CAMPOMINADO.Jogo.Dificuldade;
import br.com.poli.CAMPOMINADO.Jogo.Jogador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MeAndYou extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeAndYou frame = new MeAndYou();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MeAndYou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(550, 200, 800, 600);//4:3
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//setUndecorated(true); //tira a borda de cima
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dificuldade", "FACIL", "MEDIO", "DIFICIL"}));
		comboBox.setToolTipText("oi\r\noi\r\noi\r\n");
		comboBox.setBounds(318, 193, 123, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Mine Sweeper");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		lblNewLabel.setBounds(300, 23, 196, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblMenu = new JLabel("menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenu.setBounds(359, 140, 37, 73);
		contentPane.add(lblMenu);
		
		textField = new JTextField();
		textField.setBounds(335, 224, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedIndex()!=0 && !textField.getText().equals("")) {
				
				CampoMinado jogo = null;
				switch (comboBox.getSelectedIndex()) {
				case 1:
					 jogo = new CampoMinado(new Jogador(textField.getText()),Dificuldade.FACIL);
					
					break;
				case 2:
					 jogo = new CampoMinado(new Jogador(textField.getText()),Dificuldade.MEDIO);
					
					break;
				
				case 3:
					 jogo = new CampoMinado(new Jogador(textField.getText()),Dificuldade.DIFICIL);
					
					break;	
			
				}	
				
				TelaDeJogo jogar = new TelaDeJogo(jogo);
				jogar.setVisible(true);
				dispose();
				
				}
			}
		});
		btnJogar.setBounds(332, 252, 89, 23);
		contentPane.add(btnJogar);
		
		JButton btnRanking = new JButton("ranking");
		btnRanking.setBounds(332, 286, 89, 23);
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRanking ranking = new TelaRanking();
				ranking.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRanking);
			
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(332, 320, 89, 23);
		contentPane.add(btnExit);
		
		
		
		
		
	}
}
