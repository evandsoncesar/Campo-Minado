package br.com.poli.CAMPOMINADO.GUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CAMPOMINADO.Jogo.CampoMinado;
import br.com.poli.CAMPOMINADO.Jogo.Dificuldade;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class TelaDeJogo extends JFrame {

	private JPanel contentPane;
	private Botao botoes[][];
	private Timer tempo;
	private int contador;
	protected String stringTempo;

	
	public Botao[][] getBotoes() {
		return botoes;
	}


	public void setBotoes(Botao[][] botoes) {
		this.botoes = botoes;
	}
	public Timer getTempo() {
		return this.tempo;
	}


	public TelaDeJogo(CampoMinado jogo) {
		
		jogo.getMapa().imprimeTela(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		setBounds(550, 200, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
//******************************** painel do jogo ***********************************************************
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(120, 80, 600, 600);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(new GridLayout(jogo.getDificuldade().getValorDificuldade(),
			jogo.getDificuldade().getValorDificuldade()));

		botoes = new Botao[jogo.getDificuldade().getValorDificuldade()][jogo.getDificuldade().getValorDificuldade()];

		for (int i = 0; i < botoes.length; i++) {
			for (int j = 0; j < botoes.length; j++) {
				botoes[i][j]= new Botao(i,j);
				if(jogo.getDificuldade().equals(Dificuldade.DIFICIL) || jogo.getDificuldade().equals(Dificuldade.MEDIO)  ) {
					botoes[i][j].getBotao().setMargin(new Insets(0,0,0,0));//tira borda bot�o
					botoes[i][j].getBotao().setFont(new Font("Arial", Font.BOLD, 10));// font bot�o
				}
				botoes[i][j].actionBotton(jogo, this);
				botoes[i][j].addMouseListener(jogo, this);
				botoes[i][j].getBotao().setVisible(true);
				panelBotoes.add(botoes[i][j].getBotao());
				
			}
		}
		
		
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(75, 34, 83, 48);
		contentPane.add(lblNome);

		JLabel lblNewLabel = new JLabel("dificuldade");
		lblNewLabel.setBounds(311, 29, 112, 58);
		contentPane.add(lblNewLabel);

		JLabel lblTempo = new JLabel("tempo");
		lblTempo.setBounds(522, 51, 46, 14);
		contentPane.add(lblTempo);

		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jogo.getMapa().isFimDeJogo() || jogo.getMapa().isGanhouJogo()) {
					btnVoltar.setEnabled(false);
				}else {
					MeAndYou menu = new MeAndYou();
					menu.setVisible(true);
					dispose();
				}
				
			}
			
		});
		btnVoltar.setBounds(10, 700, 90, 25);
		contentPane.add(btnVoltar);
		
		JLabel contagemTempo = new JLabel("00:00:00");
		contagemTempo.setBounds(571, 51, 90, 25);
		contentPane.add(contagemTempo);
		 tempo= new Timer();
		 tempo.scheduleAtFixedRate(new TimerTask() {
			 @Override
			 public void run(){
				 contador++;
				 int seg = contador % 60;
				 int min = contador /60;
				 int hora = min / 60;
				 contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min ,seg));
				 stringTempo = String.format("%02d:%02d:%02d", hora, min ,seg);
				 jogo.getJogador().setPontos(contador);
				 
			 }
			 
			  
			 
			 
		 },1000, 1000);
		 
		
		
		
		
		
		
	}
}
//JOptionPane.showMessageDialog(null,"texto")
