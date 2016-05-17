package br.cesed.si.atal.gulosos.mochila;

/*
 * Implementação Gulosa para o Problema da Mochila Fracionária.
 */
public class MainGuloso {

	public static void main(String[] args) {

		Item[] itens = new Item[3];
		
		itens[0] = new Item("Item 1", 6, 10);
		itens[1] = new Item("Item 2", 5, 20);
		itens[2] = new Item("Item 3", 4, 30);
		
		MochilaGulosa mochilaGulosa = new MochilaGulosa(itens);
		
		Item[] itensRoubados = mochilaGulosa.adicionaItens(50);
		
		for (Item item : itensRoubados) {
			System.out.println(item);
		}
		
	}

}
