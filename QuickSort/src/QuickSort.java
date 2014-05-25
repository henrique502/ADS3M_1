public class QuickSort {

	private int steps;
	
	public QuickSort(){}
	
	public static int sort(int[] array){
		QuickSort sort = new QuickSort();
		
		sort.organize(array);
		
		return sort.steps;
	}
	
	private void organize(int[] array){
		organize(array, 0, array.length - 1);
	}
	
	private void organize(int[] array, int low, int n){
		int less = low;
		int larger = n;

		if(less >= n){
			steps++;
			return;
		}
		int meio = array[(less + larger)/2];

		while(less < larger){
			
			while(less < larger && array[less] < meio){
				less++;
				steps++;
			}
			while(less < larger && array[larger] > meio){
				larger--;
				steps++;
			}
			if(less < larger){
				int aux = array[less];
				array[less] = array[larger];
				array[larger] = aux;
				steps++;
			}
		}
		if(larger < less){
			int i = larger;
			larger = less;
			less = i;
			steps++;
		}
		
		organize(array, low, less);
		
		int temp;
		if(less == low){
			temp = less + 1;
			steps++;
		} else {	
			temp = less;
			steps++;
		}
		
		organize(array, temp, n);

	}
}
