package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementa��es do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public abstract class KnapsackSolver {

   protected List<Item> items;
   protected int capacity;
   
   protected KnapsackSolver(List<Item> items, int capacity) {
      this.items = items;
      this.capacity = capacity;
   }
   
   public abstract KnapsackSolution solve();
   
   public double getWeight(List<Item> items) {
      double weight = 0;
      for (Item item : items) {
         weight += item.peso;
      }
      return weight;
   }
   
   public double getValue(List<Item> items) {
      double value = 0;
      for (Item item : items) {
         value += item.valor;
      }
      return value;
   }
}