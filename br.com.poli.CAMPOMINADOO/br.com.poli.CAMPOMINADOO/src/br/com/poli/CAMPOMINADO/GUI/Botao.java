package br.com.poli.CAMPOMINADO.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.poli.CAMPOMINADO.Jogo.CampoMinado;
import br.com.poli.CAMPOMINADO.Jogo.Dificuldade;
import br.com.poli.CAMPOMINADO.Jogo.Jogador;

public class Botao{

	private int linha, coluna;
	private JButton botao;


	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public JButton getBotao() {
		return botao;
	}

	public void setBotao(JButton botao) {
		this.botao = botao;
	}

	public Botao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		botao = new JButton();
		
		
	}
	
		public void actionBotton(CampoMinado jogo,TelaDeJogo tela) {
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(!jogo.getMapa().getCelula(linha, coluna).isVisivel()) {
					jogo.getMapa().escolherPosicao(linha, coluna);
					if(jogo.getMapa().isGanhouJogo()) {
						YouWin ganhou = new YouWin();
						ganhou.setVisible(true);
						tela.getTempo().cancel();
						System.out.println(tela.stringTempo);
						jogo.getJogador().setTempo(tela.stringTempo);
						tela.dispose();
					}
					if(jogo.getMapa().isFimDeJogo()) {
												
						Loser perdeu = new Loser(tela);
						tela.getTempo().cancel();
						System.out.println(tela.stringTempo);
						perdeu.setVisible(true);
						
						
						
					}
					attGrid(jogo,tela);
					
				}
					
				}
				
			});
			
		}
		
		public void attGrid(CampoMinado jogo,TelaDeJogo tela) {
			for (int i = 0; i < jogo.getDificuldade().getValorDificuldade(); i++) {
				for (int j = 0; j < jogo.getDificuldade().getValorDificuldade(); j++) {
					if(jogo.getMapa().getCelula(i, j).isVisivel()) {
						if(jogo.getMapa().getCelula(i, j).isBomba()) {
							if(jogo.getDificuldade().equals(Dificuldade.FACIL) || jogo.getDificuldade().equals(Dificuldade.MEDIO )) {
							tela.getBotoes()[i][j].botao.setIcon(new ImageIcon(Botao.class.getResource("/Midia/unlit-bomb_38756.png")));
							tela.getBotoes()[i][j].botao.setDisabledIcon(new ImageIcon(Botao.class.getResource("/Midia/unlit-bomb_38756.png")));
							}else {
								tela.getBotoes()[i][j].botao.setIcon(new ImageIcon(Botao.class.getResource("/Midia/mini.png")));
								tela.getBotoes()[i][j].botao.setDisabledIcon(new ImageIcon(Botao.class.getResource("/Midia/mini.png")));
							}
						} else if(jogo.getMapa().getCelula(i, j).getValor()==0) {
							tela.getBotoes()[i][j].getBotao().setText("");
						}else {
							tela.getBotoes()[i][j].getBotao().setText(Integer.toString(jogo.getMapa().getCelula(i, j).getValor()));
						}

						tela.getBotoes()[i][j].getBotao().setEnabled(false);
					}
					if(jogo.getMapa().isFimDeJogo()) {
						tela.getBotoes()[i][j].getBotao().setEnabled(false);
					
					}
					
				}
			}
		}
		
		public void addMouseListener(CampoMinado jogo, TelaDeJogo tela) {
			botao.addMouseListener(new MouseAdapter() {
	             @Override
	             public void mousePressed(MouseEvent e) {
	                if (e.getButton() == MouseEvent.BUTTON3) {
	                   if(jogo.getMapa().getCelula(linha, coluna).isBandeira()) {
	                	   jogo.getMapa().getCelula(linha, coluna).setBandeira(false);
	                	   if(!jogo.getDificuldade().equals(Dificuldade.FACIL)) {
	                		   tela.getBotoes()[linha][coluna].botao.setIcon(new ImageIcon(Botao.class.getResource("/Midia/bandeira 16x16.png")));
	                	   }else {
	                		   tela.getBotoes()[linha][coluna].botao.setIcon(new ImageIcon(Botao.class.getResource("/Midia/bandeira 32x32.png")));
	                	   }
	                   }else {
	                	   jogo.getMapa().getCelula(linha, coluna).setBandeira(true);
	                	   
	                   }
	                	   
	                	
	                	
	                	
	                }
	             }
	          });
		}
	

}