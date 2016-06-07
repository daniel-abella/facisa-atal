package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementações do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public class Item {

	public int rotulo;
	public double valor;
	public double peso;

	public static Comparator<Item> porRotulo() {
		return new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return i1.rotulo - i2.rotulo;
			}
		};
	}

	public static Comparator<Item> porProporcao() {
		return new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return Double.compare(i2.getProporcao(), i1.getProporcao());
			}
		};
	}

	public double getProporcao() {
		return valor / peso;
	}
}
