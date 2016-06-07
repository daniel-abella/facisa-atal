package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementações do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public class DynamicProgrammingSolver extends KnapsackSolver {
   
   private double[][] table;
   
   public DynamicProgrammingSolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
      
      table = new double[capacity + 1][items.size()];
      
      //preenche com -1
      for (int j = 0; j < capacity + 1; j++)
         for (int i = 0; i < items.size(); i++)
            table[j][i] = -1;
      
      getCell(capacity, items.size() - 1);
      
      KnapsackSolution best = traceTable();
      
      best.approach = "Dynamic Programming solution";
      return best;
   }
   
   // Traces back table
   private KnapsackSolution traceTable() {
   
      KnapsackSolution best = new KnapsackSolution();
      best.items = new ArrayList<Item>();
   
      int i = items.size() - 1, j = capacity;
      
      while (i >= 0) {
         Item item = items.get(i);
         
         double without = i == 0 ? 0 : table[j][i - 1];
         
         if (table[j][i] != without) {
            best.items.add(item);
            best.value += item.valor;
            best.weight += item.peso;
            j -= (int) item.peso;
         }
         
         i--;
      }
      
      return best;
   }
   
   // Uses recursion with memoization
   //parameteres: capacity, items.size() - 1
   private double getCell(int j, int i) {
   
      if (i < 0 || j < 0) return 0;
      Item item = items.get(i);
      
      double with, without, cell = table[j][i];
      
      // If not memoized
      if (cell == -1) {
      
         if (item.peso > j) with = -1;
         else with = item.valor + getCell(j - (int) item.peso, i - 1);
         without = getCell(j, i - 1);
         
         cell = Math.max(with, without);
            
         table[j][i] = cell; // Memoize
      }
      
      return cell;
   }
}
