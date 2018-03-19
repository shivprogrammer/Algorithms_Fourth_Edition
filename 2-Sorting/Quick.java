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
}
