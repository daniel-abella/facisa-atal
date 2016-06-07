package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementações do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public class GreedySolver extends KnapsackSolver {
   
   public GreedySolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
   
      KnapsackSolution greedy = new KnapsackSolution();
      
      greedy.items = new ArrayList<Item>(items);
      
      Collections.sort(greedy.items, Item.porProporcao());
      
      double capUsed = 0;
      double value = 0;
      int i;
      
      for (i = 0; i < greedy.items.size(); i++) {
         Item item = greedy.items.get(i);
         if (capUsed + item.peso > capacity) break;
         
         capUsed += item.peso;
         value += item.valor;
      }
      
      greedy.items = greedy.items.subList(0, i);
      greedy.weight = capUsed;
      greedy.value = value;
      greedy.approach = "Greedy solution (not necessarily optimal)";
      
      return greedy;
   }
}
