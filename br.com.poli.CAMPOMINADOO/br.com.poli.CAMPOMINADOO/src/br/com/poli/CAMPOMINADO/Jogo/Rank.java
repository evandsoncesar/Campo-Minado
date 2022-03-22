package br.com.poli.CAMPOMINADO.Jogo;
import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rank {

	    private ArrayList<Jogador> rank = new ArrayList<>();
	    private ArrayList<Integer> pontos = new ArrayList<>();



	    public void leRank() {

	        try {

	            //L� as informa��es do ranking

	            BufferedReader leRank = new BufferedReader(new FileReader("Ranking.txt"));

	            String linha;

	            do {

	                try {

	                    //Salva cada informa��o do jogador separadamente

	                    String[] jogadorInfoString = leRank.readLine().split("-");

	                    Jogador jogadorInfo = new Jogador(jogadorInfoString[0]);

	                    rank.add(jogadorInfo);
	                    pontos.add(jogadorInfo.getPontos());
	                   



	                    linha = rank.get(rank.size() - 1).getNome();



	                } catch (ArrayIndexOutOfBoundsException e) {

	                    linha = null;

	                } catch (NullPointerException e) {

	                    linha = null;

	                }

	            }

	            while (linha != null);//while para passar todas as inform��es do .txt para o ArrayList rank

	            leRank.close();

	        } catch (IOException e) {

	        }

	    }



	    public void salvarRank(String nome, String tempo) {

	        try {

	            Jogador newJogadorInfo = new Jogador(nome);

	            rank.add(newJogadorInfo);

	            Collections.sort(pontos);
	            
	            



	            //Grava o ranking no .txt

	            PrintWriter sRank = new PrintWriter("Ranking.txt");

	            for (int i = 0; i < rank.size(); i++) {

	                if (rank.get(i) != null) {

	                    sRank.write(rank.get(i).getNome() + "-" + rank.get(i).getTempo() + "\n");

	                }

	            }

	            sRank.close();

	        } catch (IOException e) {

	        }

	    }



	    public ArrayList<Jogador> getRank() {

	        return rank;

	    }



	    public void setRank(ArrayList<Jogador> rank) {

	        this.rank = rank;

	    }



		

	}

