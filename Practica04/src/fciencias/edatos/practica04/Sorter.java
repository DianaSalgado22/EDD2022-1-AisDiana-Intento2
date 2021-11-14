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
	public static void mergeSortMalo(int[] arr){
		mergeSortMalo(arr, 0, arr.length-1);
	}

	/**
	 * Auxiliar de mergeSort para dividir y mezclar.
	 * @param arr el arreglo con los elementos a dividir y mezclar.
	 * @param lo el índice de inicio a modificación.
	 * @param hi el índice del último elemento a modificación.
	 */
	private static void mergeSortMalo(int[] arr, int lo, int hi){
		// Cuando ya esta ordenado el fragmento de lo hasta hi
		if(hi <= lo)
			return;

		// La mitad del corte del arreglo
		int mid = lo + (hi-lo) / 2;

		mergeSortMalo(arr, lo, mid);
		mergeSortMalo(arr, mid+1, hi);

		mergeMalo(arr, lo, mid, hi);
	}

	/**
	 * Mezcla dos arreglos, ordenando de menor a mayor.
	 * @param arr el arreglo con los elementos a modificar.
	 * @param lo el inicio de la primera mitad.
	 * @param mid el índice de la mitad del subarreglo.
	 * @param hi el índice del último elemento.
	 */
	private static void mergeMalo(int[] arr, int lo, int mid, int hi){
		int i = lo;
		int j = mid+1;
		int[] aux = Arrays.copyOf(arr, arr.length);
	//	System.out.println("prueba"+Arrays.toString(arr)+Arrays.toString(aux));


		for(int k = lo ; k <= hi; k++){
			// Si ya nos acabamos los elementos de la primera mitad
			if(i > mid)
				arr[k] = aux[j++];
			else if(j > hi) // Si ya nos acabamos la segunda mitad
				arr[k] = aux[i++];
			else if(aux[j] < aux[i]) // El menor está en la primera mitad
				arr[k] = aux[j++];
			else // El manor está en la segunda mitad
				arr[k] = aux[i++];
		}
	}
	/**
	 * Ordena un arreglo de forma ascendente con merge sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void mergeSort(int[] arr){
		int[] aux = new int[arr.length];
		//aux=arr;
		for(int p=0;p<arr.length;p++){
			aux[p]=arr[p];
		}
		
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

		//arrAux= arr;
		mergeSort(arr, lo, mid,arrAux);
		//arrAux= arr;
		mergeSort(arr, mid+1, hi,arrAux);
		//arrAux= arr;
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

		//int aux;
		//arrAux= arr;
		arrAux= Arrays.copyOf(arr, arr.length);

		//nos permite recorrer los elementos q queremos ordena
		for(int k = lo ; k <= hi; k++){
			//System.out.println("prueba"+Arrays.toString(arr)+Arrays.toString(arrAux));
			//aux= arr[k];
			// Si ya nos acabamos los elementos de la primera mitad
			if(i > mid){
			//entonces recorremos la segunda mitad
			
			// int aux2= arrAux[j++];
			// 	arr[k] = aux2;
			    arr[k]= arrAux[j++];
				
			}
			else if(j > hi){ // Si ya nos acabamos la segunda mitad
				
				// int aux2= arrAux[i++];
				// arr[k] = aux2;
				arr[k]= arrAux[i++];
				
			}
			else if(arrAux[j] < arrAux[i]){ // El menor está en la primera mitad
				
				// int aux2= arrAux[j++];
				// arr[k] = aux2;
				
				arr[k]= arrAux[j++];
			}
			else{ // El manor está en la segunda mitad
				
				// int aux2= arrAux[i++];
				// arr[k] = aux2;
				arr[k]= arrAux[i++];
				
				
			}
			//arrAux[k]=arr[k];

			
		}

		//arrAux= arr;
	}
	
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
		int[] arr1 = generate(15, 15);
		//int[] arr1p = generate(300, 15);
		//int[] arr1={5, 10, 14, 10, 1};
		//int[] arr2p= {5, 10, 14, 10, 1};
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		int[] arr3 = Arrays.copyOf(arr1, arr1.length);
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);
		//System.out.println("No ordenado: " + Arrays.toString(arr1));
		//int[] arr1={5, 10, 14, 10, 1};
		long inicio;
		long fin;
		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr1));
		inicio = System.currentTimeMillis();
		mergeSort(arr1);
		fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr1));
		System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos");
	
		System.out.println("Arreglo No ordenado: "+Arrays.toString(arr2));
		inicio = System.currentTimeMillis();
		mergeSortMalo(arr2);
		fin = System.currentTimeMillis();
		System.out.println("Arreglo ordenado: "+Arrays.toString(arr2));
		System.out.println("Ordenado con mergeSortMalo tardó: " + (fin - inicio) + " milisegundos");

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