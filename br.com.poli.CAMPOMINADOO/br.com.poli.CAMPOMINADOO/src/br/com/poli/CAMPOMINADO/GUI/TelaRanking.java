package br.com.poli.CAMPOMINADO.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaRanking extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public TelaRanking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setBounds(120, 31, 46, 14);
		contentPane.add(lblRanking);
	}
}
