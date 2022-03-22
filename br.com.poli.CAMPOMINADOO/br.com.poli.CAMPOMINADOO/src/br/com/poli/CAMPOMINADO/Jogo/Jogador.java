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



public class Jogador{
	private String nome;
	private String tempo;
	private int pontos;


	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}





	

}
	




