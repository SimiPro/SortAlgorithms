package sort;

public class Quicksort {

	private int[] A;

	Quicksort(int[] A) {
		this.A = A;
		quicky(0, A.length - 1);
	}

	void quicky(int lo, int hi) {
		if (lo < hi - 1) {
			int m = divide(lo, hi);
			quicky(lo, m - 1);
			quicky(m, hi);
		}
	}

	private int divide(int lo, int hi) {
		int i = lo;
		int j = hi - 1;

		int m = A[hi];

		while (i < j) {
			while (A[i] <= m && i < hi)
				i++;
			while (A[j] >= m && lo <= i)
				j--;
			if (i < j)
				swap(i, j);
		}

		swap(i, hi);

		return i;
	}

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
