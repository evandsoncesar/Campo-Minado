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

package br.com.poli.CAMPOMINADO.Jogo;

import java.util.ArrayList;

public class Celula {
	private boolean bandeira;
	private boolean bomba;
	private int qtdBombasVizinhas;
	private boolean visivel;
	private int linha;
	private int coluna;
	private ArrayList<Celula> vizinhos = new ArrayList<Celula>();
	
	
	public Celula(int linha, int coluna) {
		this.linha=linha;
		this.coluna=coluna;
	}
	

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}

	public boolean isBomba() {
		return bomba;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}

	public void setQtdBombasVizinhas(int qtdBombasVizinhas) {
		this.qtdBombasVizinhas = qtdBombasVizinhas;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

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
	public int getValor() {
		if (bomba) {
			return -1;
		} else {
			return qtdBombasVizinhas;
		}
	}			
	public void buscarVizinhos(Celula[][] campo) {
		for (int i = linha-1 ; i < linha+1; i++) {
			for (int j = coluna-1; j < coluna+1; j++) {
				if(i>=0 && j>=0 && i<campo.length && j<campo.length && campo[linha][coluna]!= campo[i][j]) {
					vizinhos.add(campo[i][j]);
				}
			}
		}
	}

	private boolean isBranco() {
		if (qtdBombasVizinhas==0) {
			return true;
		} else {
			return false;
		}
	}
}
