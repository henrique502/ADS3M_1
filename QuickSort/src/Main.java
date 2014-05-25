
public class Main {
	
	public static void main(String[] args) {
		
		int[] array = {17,6,13,16,29,23,22,30,25,24,12,21,8,9,27,18,5,28,15,20,3,4,10,7,19,2,1,11,26,14};
		
		System.out.println("QuickSort: ");
		for (int i : array)
			System.out.print(i + ",");
		
		int steps = QuickSort.sort(array);
		System.out.println("\nPassos: " + steps);
		
		for (int i : array)
			System.out.print(i + ",");
			
	}
	
}
