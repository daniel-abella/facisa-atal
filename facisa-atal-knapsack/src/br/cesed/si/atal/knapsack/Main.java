package br.cesed.si.atal.knapsack;

import java.util.*;

/**
 * Implementações do Problema da Mochila
 * 
 * Forked from https://github.com/patrickherrmann/Knapsack 
 * @author patrickherrmann
 */
public class Main {
   
   public static void main(String[] args) {
   
      Scanner scanner = new Scanner(System.in);
      int count = scanner.nextInt();
      
      List<Item> items = new LinkedList<Item>();
      for (int i = 0; i < count; i++) {
         Item item = new Item();
         item.rotulo = scanner.nextInt();
         item.valor = scanner.nextDouble();
         item.peso = scanner.nextDouble();
         items.add(item);
      }
      
      int capacity = scanner.nextInt();
      
      List<KnapsackSolver> solvers = new ArrayList<KnapsackSolver>();
      
      if (items.size() <= 20) 
         solvers.add(new BruteForceSolver(items, capacity));
      solvers.add(new GreedySolver(items, capacity));
      solvers.add(new DynamicProgrammingSolver(items, capacity));
      solvers.add(new BranchAndBoundSolver(items, capacity));
      
      for (KnapsackSolver solver : solvers) {
         System.out.println(solver.solve());
      }
   }
}
