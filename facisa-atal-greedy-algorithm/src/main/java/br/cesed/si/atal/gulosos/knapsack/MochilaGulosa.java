package br.cesed.si.atal.gulosos.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa��o da Mochila por Estrat�gia Gulosa
 * 
 * @author abella
 *
 */
public class MochilaGulosa {

	private List<Item> itensDisponiveisParaRoubar;

	/**
	 * Recebe todos os itensDisponiveisParaRoubar que podem ser roubados.
	 * 
	 * @param itensDisponiveisParaRoubar;
	 */
	public MochilaGulosa(List<Item> itensDisponiveisParaRoubar) {
		this.itensDisponiveisParaRoubar = itensDisponiveisParaRoubar;
	}

	/**
	 * M�todo guloso.
	 * 
	 * Como funciona o problema da mochila fracion�ria?
	 * 
	 * Vai pegando os itensDisponiveisParaRoubar que tiver pela frente Sen�o
	 * poder pegar o item inteiro, pega a fra��o dele.
	 * 
	 * 
	 * @param capacidade
	 * @return
	 */
	public List<Item> adicionaItens(int capacidade) {

		ArrayList<Item> itensRoubados = new ArrayList<Item>();

		for (Item item : itensDisponiveisParaRoubar) {

			//se eu tenho capacidade para pegar o item inteiro
			//eu pego o item inteiro
			if (item != null && item.getQuantidade() <= capacidade) {
				
				//roubei o item inteiro
				itensRoubados.add(item);
				
				//agora, minha capacidade diminuiu
				capacidade -= item.getQuantidade();
			
			//se eu n�o tenho capacidade de peg�-lo inteiramente
			//eu o pego parcialmente!
				
			} else {
				//crio um objeto que tenha a capacidade
				Item itemParcial = new Item(item.getNome(), item.getValor(), capacidade);

				//roubo o item parcialmente
				itensRoubados.add(itemParcial);
				
				//agora, minha capacidade diminuu
				//ou sen�o esgotou!
				capacidade -= item.getQuantidade();
			}
		}

		return itensRoubados;
	}
}