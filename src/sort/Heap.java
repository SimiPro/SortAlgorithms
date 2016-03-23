package sort;

public class Heap {
	static int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	public static void main(String[] args) {
		int[] A = getA();
		build(A);

		for (int i = 0; i < A.length; i++) {
			swap(A, A.length - i - 1, 0);
			heapify(A, 0, A.length - i - 1);
		}

		check(A);

	}

	/**
	 *  
	 */
	static void build(int[] A) {
		int n = A.length % 2 == 0 ? A.length / 2 - 1 : A.length / 2;
		for (int i = n; i >= 0; i--) {
			swap(A, 0, i);
			heapify(A, 0, A.length);
		}
	}

	/**
	 * root == null => A[0] == -1 replace root mit A[A.length-1] versickere:
	 * here do not forget spezial case i = 0 then 2i = 1 if A[2i+1] > A[2i] then
	 * A[2i+1] > A[i] ? swap(2i+i, i) heapify(2i+1) if A[2i+1] < A[2i] then
	 * A[2i] > A[i] ? swap(2i, i) heapify(2i)
	 * 
	 * @param A
	 * @param i
	 * @param end
	 */
	static void heapify(int[] A, int i, int end) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (right < end) {
			if (A[right] > A[left]) {
				if (A[right] > A[i]) {
					swap(A, right, i);
					heapify(A, right, end);
				}
			} else {
				if (A[left] > A[i]) {
					swap(A, left, i);
					heapify(A, left, end);
				}
			}
		} else if (left < end) {
			if (A[left] > A[i]) {
				swap(A, left, i);
				heapify(A, 2 * i + 1, end);
			}
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
