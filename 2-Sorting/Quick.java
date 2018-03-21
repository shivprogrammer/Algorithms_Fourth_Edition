public class Quick {

  // This class should not be instantiated
  private Quick() { }

  /*
  Rearranges the array in ascending order, using the natural order.
  Param a is the array to be sorted
  */
  public static void(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  // quicksort the subarray from a[lo] to a[hi]
  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partitiion(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
    assert isSorted(a, lo, hi);
  }

  // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi] and retur the index j.
  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];
    while (true) {

      // find item on lo to swap
      while (less(a[++i], v)) {
        if (i == hi) break;
      }

      // find item on hi to swap
      while (less(v, a[--j])) {
        if (j == lo) break;
      }

      // check if pointers cross
      if (i >= j) break;

      exch(a, i, j);
    }

    // put partitioning item v at a[j]
    exch(a, lo, j);

    //now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    return j;
  }
}
