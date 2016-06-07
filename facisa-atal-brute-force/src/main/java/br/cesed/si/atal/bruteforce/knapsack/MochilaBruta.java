package br.cesed.si.atal.bruteforce.knapsack;

import java.util.ArrayList;
import java.util.List;

public class MochilaBruta {

	private Item[] itens = null;

	/**
	 * @param itens
	 */
	public MochilaBruta(Item[] itens) {
		this.itens = itens;
	}

	/**
	 * O m�todo de subconjuntos cria uma lista com todos os subconjuntos
	 * baseados na entrada.
	 * 
	 * @param itens2
	 * @return
	 */
	public List<Item[]> subconjuntos(Item[] itens2) {

		int qtdSubconjuntos = 1 << itens2.length;
		int indiceLista = 0;

		List<Item[]> listaSubconjuntos = new ArrayList<Item[]>(qtdSubconjuntos); //tamanho da lista deve ser a quantidade de subconjuntos possiveis.

		for (int i = 0; i < qtdSubconjuntos; i++) {
			int pos = itens2.length - 1;
			int bitmask = i;
			Item[] listaAux = new Item[itens2.length];
			while (bitmask > 0) {
				if ((bitmask & 1) == 1) {

					// System.out.print(itens2[pos].nome + ",");

					listaAux[indiceLista] = new Item(itens2[pos].nome,
							itens2[pos].valor, itens2[pos].quantidade);
					indiceLista++;
				}

				bitmask >>= 1;
				pos--;

			}

			listaSubconjuntos.add(listaAux);
			indiceLista = 0;
		}
		return listaSubconjuntos;
	}

	/**
	 * O m�todo adicionaItens varre todos os subconjuntos em busca da melhor solu��o para a mochila.
	 * @param capacidade
	 * @return
	 */
	public Item[] adicionaItens(int capacidade) {

		List<Item[]> listaSubconjuntos = new ArrayList<Item[]>();

		listaSubconjuntos = subconjuntos(itens);

		Item[] itensMelhorSolucao = new Item[this.itens.length];

		int valorMelhorSolucao = 0;

		for (Item[] items : listaSubconjuntos) {
			int pesoTotal = 0;
			int valorTotal = 0;

			for (Item item : items) {
				if (item == null) // Se encontra um item null sai do la�o pois � o fim da lista
					break;
				pesoTotal += item.quantidade;
				valorTotal += item.valor * item.quantidade; 
			}
			if (valorTotal > valorMelhorSolucao && pesoTotal <= capacidade) {
				itensMelhorSolucao = items;
				valorMelhorSolucao = valorTotal;

			}

		}
		//retorna o melhor conjunto solu��o (incluindo os nulos)
		return itensMelhorSolucao;

	}

}