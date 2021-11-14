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
		int[] aux = new int[arr.length];
		aux=arr;
		mergeSort(arr, 0, arr.length-1,aux);
	}

	/**
	 * Auxiliar de mergeSort para dividir y mezclar.
	 * @param arr el arreglo con los elementos a dividir y mezclar.
	 * @param lo el índice de inicio a modificación.
	 * @param hi el índice del último elemento a modificación.
	 */
	private static void mergeSort(int[] arr, int lo, int hi,int[] arrAux){
		// Cuando ya esta ordenado el fragmento de lo hasta hi
		if(hi <= lo)
			return;

		// La mitad del corte del arreglo
		int mid = lo + (hi-lo) / 2;

		mergeSort(arr, lo, mid,arrAux);
		mergeSort(arr, mid+1, hi,arrAux);

		merge(arr, lo, mid, hi,arrAux);
		//merge hara la mezcla
	}

	/**
	 * Mezcla dos arreglos, ordenando de menor a mayor.
	 * @param arr el arreglo con los elementos a modificar.
	 * @param lo el inicio de la primera mitad.
	 * @param mid el índice de la mitad del subarreglo.
	 * @param hi el índice del último elemento.
	 * 
	 */
	
	private static void merge(int[] arr, int lo, int mid, int hi,int[] arrAux){
		int i = lo;
		int j = mid+1;

		//int[] aux = Arrays.copyOf(arr, arr.length);
		//System.out.println("prueba"+Arrays.toString(aux));
		

		//nos permite recorrer los elementos q queremos ordena
		for(int k = lo ; k <= hi; k++){
			// Si ya nos acabamos los elementos de la primera mitad
			if(i > mid){
			//entonces recorremos la segunda mitad
				arr[k] = arrAux[j];
				arrAux[j++]=arr[k];
			}
			else if(j > hi){ // Si ya nos acabamos la segunda mitad
				arr[k] = arrAux[i];
				arrAux[i++]=arr[k];
			}
			else if(arrAux[j] < arrAux[i]){ // El menor está en la primera mitad
				arr[k] = arrAux[j];
				arrAux[j++]=arr[k];
			}
			else{ // El manor está en la segunda mitad
				arr[k] = arrAux[i];
				arrAux[i++]=arr[k];
			}
			//arrAux[k]=arr[k];
		}
	}
	// /**
	//  * Ordena un arreglo de forma ascendente con merge sort.
	//  * @param arr el arreglo a ordenar.
	//  */
	// public static void mergeSort(int[] arr){
	// 	mergeSort(arr, 0, arr.length-1);
	// }

	// /**
	//  * Auxiliar de mergeSort para dividir y mezclar. OPTIMIZADO
	//  * @param arr el arreglo con los elementos a dividir y mezclar.
	//  * @param lo el índice de inicio a modificación.
	//  * @param hi el índice del último elemento a modificación.
	//  */
	// private static void mergeSort(int[] arr, int lo, int hi){
	// 	// Cuando ya esta ordenado el fragmento de lo hasta hi
	// 	if(hi <= lo)
	// 		return;

	// 	// La mitad del corte del arreglo
	// 	int mid = lo + (hi-lo) / 2;

	// 	mergeSort(arr, lo, mid);
	// 	mergeSort(arr, mid+1, hi);

	// 	merge(arr, lo, mid, hi);
	// }

	// /**
	//  * Mezcla dos arreglos, ordenando de menor a mayor.
	//  * @param arr el arreglo con los elementos a modificar.
	//  * @param lo el inicio de la primera mitad.
	//  * @param mid el índice de la mitad del subarreglo.
	//  * @param hi el índice del último elemento.
	//  */
	// private static void merge(int[] arr, int lo, int mid, int hi){
	// 	// Copiamos solo de lo hasta hi (el +1 es por como esta definido copy of range)
	// 	int[] aux = Arrays.copyOfRange(arr,lo,hi+1);
	// 	// El inicio del primer sub-arreglo (del ya subarreglo de arr lo-hi)
	// 	// (La posición 0 del aux,es decir el elemento en la posicion lo de arr)
	// 	int i = 0; 
	// 	/* El inicio del segundo sub-arreglo (del ya subarreglo de arr lo-hi)
	// 	 * seria la mitad de aux+1, que seria (aux.length-1)+1/2
	// 	*/
	// 	int j = aux.length/2;
		
	// 	for(int k = lo ; k <= hi; k++){
	// 		// Si ya nos acabamos los elementos de la primera mitad
	// 		if(i > (mid-lo))
	// 			arr[k] = aux[j++];
	// 		else if((j +lo)> hi) // Si ya nos acabamos la segunda mitad
	// 			arr[k] = aux[i++];
	// 		else if(aux[j] < aux[i]) // El menor está en la primera mitad
	// 			arr[k] = aux[j++];
	// 		else // El menor está en la segunda mitad
	// 			arr[k] = aux[i++];
	// 	}
	// }
	/**
	 * Ordena un arreglo de forma ascendente con insertion sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void insertionSort(int[] arr){
		for(int i = 0; i < arr.length-1; i++)
			for(int j = i+1; j>0 && arr[j-1]>arr[j]; j--)
				swap(arr, j, j-1);
	}

	/**
	 * Ordena un arreglo de forma ascendente con selection sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void selectionSort(int[] arr){
		for(int i = arr.length-1; i > 0 ; i--){
			int max = 0;
			for(int j = 1; j<=i; j++){
				if(arr[j] > arr[max])
					max = j;
			}
			swap(arr, max, i);
		}
	} // El peor caso es tener el arreglo ordenado descendentemente
	

	

	// desde aqui empieza el mergeoptimizado
	/* static void mergeSort2(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;

//changed range of leftArray from 0-to-q to 0-to-(q-1)
            int[] leftArray = Arrays.copyOfRange(A, 0, q-1);
//changed range of rightArray from q-to-A.length to q-to-(A.length-1)
            int[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort2(leftArray);
            mergeSort2(rightArray);

            merge2(A,leftArray,rightArray);
        }
    }

    static void merge2(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    } */

	 /**
	 * Ordena un arreglo de forma ascendente con merge sort.
	 * @param arr el arreglo a ordenar.
	 */
	// public static void mergeSortOptimizado(int[] arr){
	// 	mergeSortOptimizado(arr, 0, arr.length-1);
	// }

	// /**
	//  * Auxiliar de mergeSort para dividir y mezclar. OPTIMIZADO
	//  * @param arr el arreglo con los elementos a dividir y mezclar.
	//  * @param lo el índice de inicio a modificación.
	//  * @param hi el índice del último elemento a modificación.
	//  */
	// private static void mergeSortOptimizado(int[] arr, int lo, int hi){
	// 	// Cuando ya esta ordenado el fragmento de lo hasta hi
	// 	if(hi <= lo)
	// 		return;

	// 	// La mitad del corte del arreglo
	// 	int mid = lo + (hi-lo) / 2;

	// 	mergeSortOptimizado(arr, lo, mid);
	// 	mergeSortOptimizado(arr, mid+1, hi);

	// 	merge(arr, lo, mid, hi);
	// }
 




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
		int[] arr1 = generate(150, 15);
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		int[] arr3 = Arrays.copyOf(arr1, arr1.length);
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);
		//System.out.println("No ordenado: " + Arrays.toString(arr1));
		
		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr1));
		long inicio = System.currentTimeMillis();
		mergeSort(arr1);
		long fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr1));
		System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos");
		System.out.println("¿En qué posición se encuentra el elemento 5? " + find(arr1,5)+"\n");


		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr2));
		inicio = System.currentTimeMillis();
		quickSort(arr2);
		fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr2));
		System.out.println("Ordenado con quickSort tardó: " + (fin - inicio) + " milisegundos");
		System.out.println("¿En qué posición se encuentra el elemento 2? " + find(arr1,2)+"\n");

		inicio = System.currentTimeMillis();
		selectionSort(arr3);
		fin = System.currentTimeMillis();

		System.out.println("Ordenado con selectionSort tardó: " + (fin - inicio) + " milisegundos"+"\n");

		

		inicio = System.currentTimeMillis();
		insertionSort(arr4);
		fin = System.currentTimeMillis();

		System.out.println("Ordenado con insertionSort tardó: " + (fin - inicio) + " milisegundos"+"\n");

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
		System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos"); */
	
    }
}