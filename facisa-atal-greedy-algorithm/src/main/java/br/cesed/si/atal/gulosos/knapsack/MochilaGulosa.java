package br.cesed.si.atal.gulosos.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da Mochila por Estratégia Gulosa
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
	 * Método guloso.
	 * 
	 * Como funciona o problema da mochila fracionária?
	 * 
	 * Vai pegando os itensDisponiveisParaRoubar que tiver pela frente Senão
	 * poder pegar o item inteiro, pega a fração dele.
	 * 
	 * 
	 * @param capacidade
	 * @return
	 */
	public List<Item> executaAlgoritmoGuloso(int capacidade) {

		//representa a mochila do assaltante
		ArrayList<Item> itensRoubadosNossaMochila = new ArrayList<Item>();

		for (Item item : itensDisponiveisParaRoubar) {

			//se eu tenho capacidade para pegar o item inteiro
			//eu pego o item inteiro
			if (item != null && item.getQuantidade() <= capacidade) {
				
				//roubei o item inteiro e coloquei na mochila
				itensRoubadosNossaMochila.add(item);
				
				//agora, minha capacidade diminuiu
				capacidade -= item.getQuantidade();
			
			//se eu não tenho capacidade de pegá-lo inteiramente
			//eu o pego parcialmente!
				
			} else {
				//crio um objeto que tenha a capacidade
				Item itemParcial = new Item(item.getNome(), item.getValor(), capacidade);

				//roubar o item parcialmente
				itensRoubadosNossaMochila.add(itemParcial);
				
				//agora, minha capacidade diminuiu
				//ou senão se esgotou!
				capacidade -= item.getQuantidade();
			}
		}

		return itensRoubadosNossaMochila;
	}
}