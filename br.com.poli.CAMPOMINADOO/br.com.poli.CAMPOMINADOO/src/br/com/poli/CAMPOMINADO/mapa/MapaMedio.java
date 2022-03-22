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

package br.com.poli.CAMPOMINADO.mapa;

import br.com.poli.CAMPOMINADO.Jogo.Dificuldade;

public class MapaMedio extends Mapa {

	private static final Dificuldade TAMANHO = Dificuldade.MEDIO;// Constante do mapa Médio 16*16
	private static final int BOMBAS = 40; // constantes do numero de bombas do Facil 40

	public MapaMedio() {
		super(TAMANHO.getValorDificuldade(), BOMBAS);// getValorDificuldade est� sendo usado, para pegar o valor inteiro
	}
}
