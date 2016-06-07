package br.cesed.si.atal.gulosos.knapsack;

/**
 * Implementa��o da Mochila por Estrat�gia Gulosa
 * 
 * @author abella
 *
 */
public class MochilaGulosa {

	private Item[] itens = null;

	/**
	 * Recebe todos os itens que podem ser roubados.
	 * 
	 * @param itens itens que podem ser roubados
	 */
	public MochilaGulosa(Item[] itens) {
		this.itens = itens;
	}

	/**
	 * M�todo guloso.
	 * 
	 * Como funciona o problema da mochila fracion�ria?
	 * 
	 * Vai pegando os itens que tiver pela frente
	 * Sen�o poder pegar o item inteiro, pega a fra��o dele.
	 * 
	 * 
	 * @param capacidade
	 * @return
	 */
	public Item[] adicionaItens(int capacidade) {

		Item[] itensAdicionados = new Item[this.itens.length];

		int itemIndice = 0;
		
		// pegar itens at� que a mochila esteja cheia ou n�o haja mais itens para colocar
		
		while (capacidade > 0 && itemIndice < this.itens.length) {
			
			// se cabe inteiro, pegue inteiro
			if (this.itens[itemIndice].quantidade <= capacidade) {
				//diminuiu a capacidade (por exemplo: se minha capacidade era de 50kg e peguei um item de 10kg, minha capacidade � reduzida para 40kg
				capacidade -= this.itens[itemIndice].quantidade;
				//pegue inteiro
				itensAdicionados[itemIndice] = new Item(itens[itemIndice].nome,itens[itemIndice].valor,itens[itemIndice].quantidade);
			
			// se n�o cabe inteiro, pegue a fra��o que puder
			} else {
				itensAdicionados[itemIndice] = new Item(itens[itemIndice].nome,itens[itemIndice].valor, capacidade);
				capacidade = 0;
			}
			
			itemIndice++;
		}

		// adiciona outros itens de quantidade 0
		for (int i = itemIndice; i < this.itens.length; i++) {
			itensAdicionados[i] = new Item(this.itens[i].nome,this.itens[i].valor, 0);
		}

		return itensAdicionados;
	}
}