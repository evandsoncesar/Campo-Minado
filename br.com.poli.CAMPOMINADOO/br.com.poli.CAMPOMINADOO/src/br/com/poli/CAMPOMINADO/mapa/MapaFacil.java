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

public class MapaFacil extends Mapa {

	private static Dificuldade TAMANHO = Dificuldade.FACIL;// Constante do mapa Facil 9*9
	private final static int BOMBAS = 10; // constantes do numero de bombas do Facil 10

	public MapaFacil() {
		super(TAMANHO.getValorDificuldade(), BOMBAS);// getValorDificuldade est� sendo usado, para pegar o valor inteiro

	}

}
