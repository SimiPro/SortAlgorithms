package sort;

public class Main {
	static int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	public static void main(String[] args) {
		int[] A = getA();
		insertionSort(A);
		check(A);

		A = getA();
		bubbleSort(A);
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
