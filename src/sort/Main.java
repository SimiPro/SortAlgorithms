package sort;

public class Main {
	static int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	static class Timer {
		long currentMillis = 0;

		void start() {
			currentMillis = System.currentTimeMillis();
		}

		void stop(String activity) {
			System.out.println(
					"Activity: " + activity + " || Time passed: " + (System.currentTimeMillis() - currentMillis));
			currentMillis = System.currentTimeMillis();
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();

		int[] A = getA();
		timer.start();
		insertionSort(A);
		timer.stop("Insertion Sort");
		check(A);

		A = getA();
		timer.start();
		bubbleSort(A);
		timer.stop("Bubble Sort");
		check(A);

		A = getA();
		timer.start();
		selectionSort(A);
		timer.stop("Selection Sort");
		check(A);

		A = getA();
		timer.start();
		new Quicksort(A);
		timer.stop("Quicksort");
		check(A);

	}

	static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int z = i;
			while (z > 0 && A[z] < A[z - 1]) {
				swap(A, z, z - 1);
				z--;
			}
		}
	}

	static void bubbleSort(int A[]) {
		for (int j = 0; j < A.length; j++) {
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i + 1] < A[i]) {
					swap(A, i, i + 1);
				}
			}
		}
	}

	static void selectionSort(int[] A) {
		int left = 0;
		int minIndex = 0;
		while (left < A.length - 1) {
			for (int i = left, min = Integer.MAX_VALUE; i < A.length; i++) {
				if (min > A[i]) {
					min = A[i];
					minIndex = i;
				}
			}
			swap(A, left, minIndex);
			left++;
		}

	}

	static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	static void check(int[] A) {
		assert (A.length == expected.length);
		for (int i = 0; i < expected.length; i++) {
			assert (expected[i] == A[i]);
		}
	}

	static int[] getA() {
		return new int[] { 8, 5, 3, 9, 2, 11, 7, 1, 4, 10, 6 };
	}
}
