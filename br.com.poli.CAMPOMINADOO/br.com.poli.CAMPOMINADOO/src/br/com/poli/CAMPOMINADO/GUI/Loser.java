package br.com.poli.CAMPOMINADO.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loser extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Loser(TelaDeJogo tela) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSuaPernaFoi = new JLabel("Sua perna foi longe nessa!");
		lblSuaPernaFoi.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblSuaPernaFoi.setBounds(75, 135, 145, 51);
		contentPane.add(lblSuaPernaFoi);
		
		JLabel lblVocPerdeu = new JLabel("VOC\u00CA PERDEU!!!");
		lblVocPerdeu.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocPerdeu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblVocPerdeu.setBounds(7, 73, 270, 51);
		contentPane.add(lblVocPerdeu);
		
		JButton btnVoltarPMenu = new JButton("SAIR");
		btnVoltarPMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeAndYou menu = new MeAndYou();
				menu.setVisible(true);
				dispose();
				tela.dispose();
			}
		});
		btnVoltarPMenu.setBounds(85, 197, 130, 23);
		contentPane.add(btnVoltarPMenu);
		
	}
}
