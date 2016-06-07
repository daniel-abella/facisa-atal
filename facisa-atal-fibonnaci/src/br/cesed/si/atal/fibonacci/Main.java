package br.cesed.si.atal.fibonacci;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
package br.cesed.si.atal.fibonacci;

public class Main {

	public static void main(String[] args) {

		
		DynamicProgrammingSolver dps = new DynamicProgrammingSolver();
		System.out.println(dps.solve(5));
		
		RecursiveSolver rs = new RecursiveSolver();
		System.out.println(rs.solve(5));
	}

}
