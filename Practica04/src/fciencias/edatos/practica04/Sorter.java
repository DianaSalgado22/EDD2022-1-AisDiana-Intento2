package fciencias.edatos.practica04;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class Sorter{

    /** Método Quicksort.
     *  ordena un arreglo de forma ascendente
     *  @param arr el arreglo a ordenar.
     */
	public static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}

    /**
	 * Auxiliar de quickSort para dividir y mezclar.
	 * @param arr el arreglo con los elementos a dividir y mezclar.
	 * @param lo el índice de inicio a modificación.
	 * @param hi el índice del último elemento a modificación.
	 */
	private static void quickSort(int[] arr, int lo, int hi){
		// Cuando ya esta ordenado el fragmento de lo hasta hi
		if(hi <= lo)
			return;

		// Se hace la partición
		int j =  partition(arr,lo,hi);
        // se hace la recursión con las dos mitades.
        quickSort ( arr, lo, j - 1);
        quickSort ( arr, j + 1, hi);	
	}
    /** Metodo recursivo auxiliar de quickSirt para partir un arreglo
     * @param arr el arreglo a partir.
	 * @param lo el índice de inicio a partir.
	 * @param hi el índice del último elemento a partir.
     */
    public static int partition(int[] arr, int lo,int hi){
        int i = lo;
        int j = hi + 1;
        // se hace el pivote
        int piv = arr[lo];
        while (true){
            while(arr[++i]<piv){ 
                if (i==hi) 
                    break;
            } 
            while(piv<arr[--j]){
                if (j==lo) 
                    break;
			}
            if(i>=j) 
                break;

            swap(arr,i,j);
		}
        swap(arr,lo,j);
		return j; 
    }

	/**
	 * Ordena un arreglo de forma ascendente con merge sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}

	/**
	 * Auxiliar de mergeSort para dividir y mezclar.
	 * @param arr el arreglo con los elementos a dividir y mezclar.
	 * @param lo el índice de inicio a modificación.
	 * @param hi el índice del último elemento a modificación.
	 */
	private static void mergeSort(int[] arr, int lo, int hi){
		// Cuando ya esta ordenado el fragmento de lo hasta hi
		if(hi <= lo)
			return;

		// La mitad del corte del arreglo
		int mid = lo + (hi-lo) / 2;

		mergeSort(arr, lo, mid);
		mergeSort(arr, mid+1, hi);

		merge(arr, lo, mid, hi);
	}
	
	/**
	 * Mezcla dos arreglos, ordenando de menor a mayor.
	 * @param arr el arreglo con los elementos a modificar.
	 * @param lo el inicio de la primera mitad.
	 * @param mid el índice de la mitad del subarreglo.
	 * @param hi el índice del último elemento.
	 */
	private static void merge(int[] arr, int lo, int mid, int hi){
		int i = lo;
		int j = mid+1;
		int[] aux = Arrays.copyOf(arr,arr.length);
		for(int k = lo ; k <= hi; k++){
			// Si ya nos acabamos los elementos de la primera mitad
			if(i > mid)
				arr[k] = aux[j++];
			else if(j > hi) // Si ya nos acabamos la segunda mitad
				arr[k] = aux[i++];
			else if(aux[j] < aux[i]) // El menor está en la primera mitad
				arr[k] = aux[j++];
			else // El menor está en la segunda mitad
				arr[k] = aux[i++];
		}
	}


    /**
	 * Cambia de posición dos elementos entre sí de un arreglo de enteros.
	 * @param arr el arreglo del cual cambiar la posición de los elementos.
	 * @param i el índice del primer elemento a cambiar.
	 * @param j el índice del segundo elemento a cambiar.
	 */
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
     * Regresa la posici ́on de un elemento en un arreglo ordenado.
     * @param arr el arreglo donde buscar.
     * @param e el elemento a buscar.
     * @return la posici ́on del elemento buscado.
     * -1 si el elemento no se encuentra.
    */
    public static int find(int[] arr, int e){
        int mid=(arr.length-1)/2;
        // Si el elemento esta justo a la mitad
        if(arr[mid]==e){
            return mid;
        }
        // Si el elemento e es mayor que el de la mitad
        // nos ahorramos buscar en la primera mitad
        if(arr[mid]<e){
            for(int j=mid+1;j<arr.length;j++){
                if(arr[j]==e)
                    return j;
            }
        }
        // Si el elemento e es menor que el de la mitad
        // nos ahorramos buscar en la segunda mitad
        if(arr[mid]>e){
            for(int j=0;j<mid;j++){
                if(arr[j]==e)
                    return j;
            }
        }
        //Si el elemento no se encuentra
		return -1;
	}

    /**
	 * Crea un nuevo arreglo con números pseudoaleatorios.
	 * @param n el tamaño del arreglo a crear.
	 * @param max el mayor elemento a generar en el arreglo.
	 * @return un arreglo de tamaño n con números pseudoaleatorios de 0 a 19.
	 */
	public static int[] generate(int n, int max){
		int[] res = new int[n];
		Random rn = new Random();
		for(int i = 0 ; i < n; i++)
			res[i] = rn.nextInt(max);
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = generate(50, 15);
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		int[] arr3 = Arrays.copyOf(arr1, arr1.length);
		//System.out.println("No ordenado: " + Arrays.toString(arr1));
		
		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr1));
		long inicio = System.currentTimeMillis();
		mergeSort(arr1);
		long fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr1));
		System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos");
		System.out.println("¿En qué posición se encuentra el elemento 5? " + find(arr1,5));


		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr2));
		inicio = System.currentTimeMillis();
		quickSort(arr2);
		fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr2));
		System.out.println("Ordenado con quickSort tardó: " + (fin - inicio) + " milisegundos");
		System.out.println("¿En qué posición se encuentra el elemento 2? " + find(arr1,2));

		

		/*

		inicio = System.currentTimeMillis();
		insertionSort(arr2);
		fin = System.currentTimeMillis();

		System.out.println("Ordenado con insertionSort tardó: " + (fin - inicio) + " milisegundos");
		
		
		//System.out.println("No ordenado: " + Arrays.toString(arr3));
		inicio = System.currentTimeMillis();
		mergeSort(arr3);
		fin = System.currentTimeMillis();
		//System.out.println("Ordenado: " + Arrays.toString(arr3));
		System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos");
	*/
    }
}