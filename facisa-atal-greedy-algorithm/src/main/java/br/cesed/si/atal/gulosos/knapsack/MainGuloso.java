package br.cesed.si.atal.gulosos.knapsack;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementação Gulosa para o Problema da Mochila Fracionária.
 */
public class MainGuloso {

	public static void main(String[] args) {

		List<Item> itens = new ArrayList<Item>();
		
		itens.add(new Item("Item 1", 6, 10));
		itens.add(new Item("Item 2", 5, 20));
		itens.add(new Item("Item 3", 4, 30));
		
		MochilaGulosa mochilaGulosa = new MochilaGulosa(itens);
		
		List<Item> itensRoubados = mochilaGulosa.adicionaItens(50);
		
		for (Item item : itensRoubados) {
			System.out.println(item);
		}
		
	}

}
