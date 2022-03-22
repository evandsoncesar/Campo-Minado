package br.com.poli.CAMPOMINADO.Jogo;
import java.util.Scanner;
/**
* UNIVERSIDADE DE PERNAMBUCO
* ESCOLA POLITECNICA DE PERNAMBUCO
* GRADUAÇÃO ENGENHARIA DA COMPUTAÇÃO
* LINGUAGEM DE PROGRAMAÇÃO ORIENTADA
* 
* SEGUNDA PARTE DO PROJETO CAMPO MINADO
* @autores
*	EVANDSON CÉSAR DE ARRUDA SANTIAGO
*	LUCAS PEREIRA MOREIRA
* @versão 3.0
* OBS. 
* 	Escrito no Eclipse, JDK 12.0.2
*/

import br.com.poli.CAMPOMINADO.mapa.Mapa;
import br.com.poli.CAMPOMINADO.mapa.MapaDificil;
import br.com.poli.CAMPOMINADO.mapa.MapaFacil;
import br.com.poli.CAMPOMINADO.mapa.MapaMedio;

public class CampoMinado {
	private Jogador jogador;
	private Mapa mapa;
	private Dificuldade dificuldade;

// CONSTRUTOR USADO PARA INSTACIAR O TIPO DE MAPA(FACIL, MEDIO, DIFICIL).
	public CampoMinado(Jogador jogador, Dificuldade dificuldade) {
		this.jogador = jogador;
		switch (dificuldade) {
		case FACIL:
			mapa = new MapaFacil();
			break;
		case MEDIO:
			mapa = new MapaMedio();
			break;
		case DIFICIL:
			mapa = new MapaDificil();
			break;
		}
		this.dificuldade = dificuldade;
		//iniciarJogo();
	}

	public Jogador getJogador() {
		return this.jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Mapa getMapa() {
		return this.mapa;

	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Dificuldade getDificuldade() {
		return this.dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	public void iniciarJogo() {
		Scanner scan = new Scanner(System.in);
		int x,y;
		mapa.imprimeTela(true);
		while(!mapa.isFimDeJogo() && !mapa.isGanhouJogo()) {
			mapa.imprimeTela(true);
			mapa.imprimeTela(false);
			System.out.println("digite uma LINHA");
			x=scan.nextInt();
			System.out.println("digite uma COLUNA");
			y=scan.nextInt();
			mapa.escolherPosicao(x, y);
		}
	}
}
