package br.cesed.si.atal.vectorsorting;

public class OrdenaVetorBacktracking {
	
	static int v [] = {1,6,3,7};

	public static boolean [] rellenar(int  [] vectorInicial){

		boolean[] disponibles = new boolean [vectorInicial.length];
		
		for(int i = 0; i < vectorInicial.length ; i++){
			disponibles[i] = true;
		}
		
		return disponibles;
	}
	
	public static boolean  ordenar( int solucion [],boolean [] disponibles, int etapa){
		
		boolean exito = false;
		
		for(int i = 0 ; i < v.length && !exito ; i++ ){
			
			if(disponibles[i]){
				
				if(etapa > 0 && solucion[etapa-1] > v[i]) {
					continue;
				}
				
				disponibles[i] = false;
				solucion[etapa] = v[i];
				
				if(etapa == v.length - 1) exito = true;
				
				else {
					
					exito = ordenar( solucion, disponibles, etapa+1);
					
					if(!exito) {
						disponibles[i] = true;
					}
				}
			}
		}
		
		return exito;
	}
	
	
	public static void main(String args[]){
		
		int [] solucion = new int[v.length];
		
		boolean [] disponibles = new boolean [v.length];
		
		disponibles=rellenar(v);
		
		ordenar(solucion,disponibles, 0);
		
		for(int i = 0 ; i < disponibles.length ; i++){
			System.out.println(solucion[i]);
		}
	}
}