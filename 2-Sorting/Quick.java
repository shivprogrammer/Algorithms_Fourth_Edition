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
}
