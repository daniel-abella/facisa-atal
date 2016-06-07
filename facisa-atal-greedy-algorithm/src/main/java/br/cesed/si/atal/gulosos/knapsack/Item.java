package br.cesed.si.atal.gulosos.knapsack;

/**
 * Item a ser roubado.
 * 
 * @author abella
 *
 */
public class Item implements Comparable<Item> {

	public String nome;
	public int quantidade;
	public int valor;

	public Item(String nome, int valor, int quantidade) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public int compareTo(Item outroItem) {
		
		if (this.valor < outroItem.valor) {
			return 1;
		}
		
		if (this.valor > outroItem.valor) {
			return -1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
}