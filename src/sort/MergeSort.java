package sort;

public class MergeSort {
	static int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	public static void main(String[] args) {
		int[] A = getA();
		sort(A, 0, A.length);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	/**
	 * Basecase) A.lenght == 1? return <br>
	 * 1) Divide A in 2 parts <br>
	 * 2) Merge upcoming part <br>
	 * 
	 */
	public static void sort(int[] A, int start, int end) {
		if (end - start == 1) {
			return;
		}
		int n = (start + end) / 2;
		sort(A, start, n);
		sort(A, n, end);

		// merge
		int[] merge = new int[end - start];
		int leftI = start;
		int leftR = n;
		for (int i = 0; i < merge.length; i++) {
			if (leftI < n && leftR < end) {
				int leftValue = A[leftI];
				int rightValue = A[leftR];
				if (leftValue < rightValue) {
					merge[i] = leftValue;
					leftI++;
				} else {
					merge[i] = rightValue;
					leftR++;
				}
			} else if (leftI < n) {
				merge[i] = A[leftI];
				leftI++;
			} else {
				merge[i] = A[leftR];
				leftR++;
			}
		}
		// just till we have found method to make this insitu copy merge back to
		// A
		for (int i = start, z = 0; i < end; i++, z++) {
			A[i] = merge[z];
		}

	}

	static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	static int[] getA() {
		return new int[] { 8, 5, 3, 9, 2, 11, 7, 1, 4, 10, 6 };
	}

	static void check(int[] A) {
		assert (A.length == expected.length);
		for (int i = 0; i < expected.length; i++) {
			assert (expected[i] == A[i]);
		}
	}
}
