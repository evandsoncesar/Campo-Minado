/**
* UNIVERSIDADE DE PERNAMBUCO
* ESCOLA POLITECNICA DE PERNAMBUCO
* GRADUAÇÃO EM ENGENHARIA DA COMPUTAÇÃO
* LINGUAGEM DE PROGRAMAÇÃO ORIENTADA A OBJETOS
* 
* QUARTA PARTE DO PROJETO CAMPO MINADO
* @autores
*	EVANDSON CÉSAR DE ARRUDA SANTIAGO
*	LUCAS PEREIRA MOREIRA
* @versÃ£o 4.0
* OBS. 
* 	Escrito no Eclipse, JDK 12.0.2
*/

package br.com.poli.CAMPOMINADO.mapa;

import java.util.Random;

import br.com.poli.CAMPOMINADO.GUI.TelaDeJogo;
import br.com.poli.CAMPOMINADO.Jogo.*;

public abstract class Mapa {
	private Celula[][] campo;
	private boolean fimDeJogo;
	private boolean ganhouJogo;
	private int bombas;
	private int celulasVisiveis;
	private boolean firstTime = true;

	public Mapa(int tamanho, int bombas) {

		this.campo = new Celula[tamanho][tamanho];
		this.bombas = bombas; // Change
		this.inicializarCelulas();
		this.distribuirBombas(bombas);
		this.contarBombas();

	}

	public Celula[][] getCampo() {
		return campo;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public Celula getCelula(int linha, int coluna) {
		return this.campo[linha][coluna]; // Change
	}

	public boolean isFimDeJogo() {
		return this.fimDeJogo;
	}

	public boolean isGanhouJogo() {
		return this.ganhouJogo;
	}

	public int getCelulasVizinhas() {
		return this.celulasVisiveis;
	}

	// METODO PARA DISTRIBUIR BOMBAS "ALEATORIAMENTE" PELA MATRIZ
// NUMERO DE BOMBAS POR PARAMETRO PEGANDO A DIFICULDADE
// Ã‰ "PRIVATE", PARA QUE NAO SEJA POSSIVEL ALTERA-LO POR OUTRA CLASSE
	private void distribuirBombas(int bombas) {

		Random random = new Random();
		while (bombas != 0) {
			int x = random.nextInt(this.campo.length);
			int y = random.nextInt(this.campo.length);
			if (this.campo[x][y].isBomba() != true) {
				this.campo[x][y].setBomba(true);
				bombas--;
			}
		}

	}

// METODO PARAR DISTRIBUIR CELULAS NA MATRIZ, PRIVADO PARA SER USADO APENAS NA CLASSE
	private void inicializarCelulas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				this.campo[i][j] = new Celula(i, j);
			}
		}
	}
	// METODO USADO PARA IMPRIMIR MATRIZ DE DUAS FORMAS
//SE FOR USADO "TRUE" COMO PARAMETRO, ELE MOSTRA A MATRIZ E TODAS AS SUAS INFORMAÃ‡OES
//DESDE BOMBAS, CASAS COM QUANTIDADE DE BOMBAS VIZINHAS, E CASAS VAZIAS
	// SE FOR USADO "FALSE" NO PARAMETRO, ELE IMPRIMIRÃ� UMA MATRIZ DE "[]"
	// ESCONDEDO AS INFORMAÃ‡OES

	public void imprimeTela(boolean teste) {

		for (int i = 0; i < campo.length; i++) {

			for (int j = 0; j < campo.length; j++) {
				if (teste) {
					System.out.print(" " + campo[i][j].getValor() + " ");

				} else {
					if (!campo[i][j].isVisivel()) {
						System.out.print("[]  ");

					} else {
						System.out.print(" " + campo[i][j].getValor() + "  ");
					}
				}
			}
			System.out.println();
		}
		System.out.println(this.getCelulasVizinhas());
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	// METODO CRIADO PARA VERIFICAR SE A CASA EXISTE DENTRO DA MATRIZ
	public boolean isCasaValida(int i, int j) {
		return i >= 0 && j >= 0 && i < campo.length && j < campo.length;
	}

	// serve para contar bombas ao redor de cada posiÃ§Ã£o na matriz
	public void contarBombas() {

		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {

				if (this.campo[i][j].isBomba() == true) {
// DUPLO FOR USADO APRAR PERCORRER AO REDOR DA POSIÃ‡ÃƒO ESCOLHIDA DA MATRIZ MAIOR
					for (int i2 = -1; i2 < 2; i2++) {
						for (int j2 = -1; j2 < 2; j2++) {
							// CONDICIONAL PARA VERIFICAR SE ACASA EXISTE NA MATRIZ MAIOR
							if (isCasaValida(i + i2, j + j2) && !this.campo[i + i2][j + j2].isBomba()) {
								this.campo[i + i2][j + j2]
										.setQtdBombasVizinhas(campo[i + i2][j + j2].getQtdBombasVizinhas() + 1);
							}
						}

					}
				}

			}
		}
	}

	// VERIFICA SE Ã‰ BOMBA, SE NÃƒO CHAMA A REVELAR ESPAÃ‡OS
	public void escolherPosicao(int linha, int coluna) {
		if(this.firstTime) {
			while(campo[linha][coluna].getValor()!=0) {
				this.inicializarCelulas();
				this.distribuirBombas(bombas);
				this.contarBombas();
								
			}
			this.firstTime = false;
		}
				
			
		
		if (this.isCasaValida(linha, coluna) == true) {
			if (this.campo[linha][coluna].isBomba()) {
				
				this.allbombs();
				System.out.println("Fim de Jogo. Voce perdeu!");
				this.fimDeJogo = true;

			} else {
				revelarEspacos(campo[linha][coluna]);

			}
		} else {
			System.out.println("Casa invalida");
			this.imprimeTela(false);
		}
		
		this.ganhouJogo = this.verificarGanhouJogo();
			
						
		
		

	}

	public void revelarEspacos(Celula celulaEscolhida) {
		// SE A CASA FOR UMA QUE INDIQUE "QUANTIDADE DE CASAS VIZINHAS", ABRE APENAS
		// ELA;
		if (celulaEscolhida.getQtdBombasVizinhas() != 0 && !celulaEscolhida.isBomba()) {
			if(!celulaEscolhida.isVisivel()) {
			celulaEscolhida.setVisivel(true);
			this.celulasVisiveis++; // INCREMENTO SEMPRE QUE ABRE UMA CELULA
			}

		}
		// NO CASO DE CASA VAZIA, ELA ABRE AS CASAS VAZIAS EM CADEIA(RECUSSIVIDADE)
		else if (celulaEscolhida.isBomba() == false && celulaEscolhida.getQtdBombasVizinhas() == 0) {
			
			if(!celulaEscolhida.isVisivel()) {
				celulaEscolhida.setVisivel(true);
				this.celulasVisiveis++; // INCREMENTO SEMPRE QUE ABRE UMA CELULA
				}


			for (int i = celulaEscolhida.getLinha() - 1; i <= celulaEscolhida.getLinha() + 1; i++) {
				for (int j = celulaEscolhida.getColuna() - 1; j <= celulaEscolhida.getColuna() + 1; j++) {

					if (this.isCasaValida(i, j) == true && campo[i][j].isVisivel() == false) {
						
						campo[celulaEscolhida.getLinha()][celulaEscolhida.getColuna()].setVisivel(true);

						// RECUSSIVIDADE MANTIDA
						this.revelarEspacos(campo[i][j]);
					}
				}
			}
		}

	}

	private boolean verificarGanhouJogo() {
		if (this.celulasVisiveis == (campo.length * campo.length) - this.bombas) {
			System.out.println("You Win Son of a beach");// PRAIAAAAA
			

			return true;
		} else {
			return false;
		}
	}
	public void allbombs() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if(this.campo[i][j].isBomba()) {
					this.campo[i][j].setVisivel(true);
				}
			}
			
		}
	}

}
