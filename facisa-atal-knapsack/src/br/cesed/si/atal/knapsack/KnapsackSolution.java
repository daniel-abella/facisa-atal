package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementações do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public class KnapsackSolution {
   
   String approach;
   public List<Item> items;
   public double weight;
   public double value;
   
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(approach);
      builder.append(": ");
      builder.append(value);
      builder.append(" ");
      builder.append(weight);
      builder.append("\n");
      
      Collections.sort(items, Item.porRotulo());
      
      for (Item item : items) {
         builder.append(item.rotulo);
         builder.append(" ");
      }
      
      return builder.toString();
   }
}
