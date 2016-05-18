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



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public int getValor() {
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}
}