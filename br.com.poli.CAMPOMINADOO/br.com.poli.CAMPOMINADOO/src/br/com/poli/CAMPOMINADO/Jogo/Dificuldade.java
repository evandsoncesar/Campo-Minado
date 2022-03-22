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

public enum Dificuldade {
	FACIL(9), MEDIO(16), DIFICIL(32);

	private int valorDificuldade;

	private Dificuldade(int valor) {
		this.valorDificuldade = valor;
	}

	public int getValorDificuldade() {
		return valorDificuldade;
	}

	public void setValorDificuldade(int valorDificuldade) {
		this.valorDificuldade = valorDificuldade;
	}
}
