package br.com.poli.CAMPOMINADO.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class YouWin extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public YouWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParabns = new JLabel("PARAB\u00C9NS !!");
		lblParabns.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblParabns.setHorizontalAlignment(SwingConstants.CENTER);
		lblParabns.setBounds(85, 43, 298, 96);
		contentPane.add(lblParabns);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MeAndYou menu = new MeAndYou();
				menu.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(173, 163, 89, 23);
		contentPane.add(btnSair);
	}
}
