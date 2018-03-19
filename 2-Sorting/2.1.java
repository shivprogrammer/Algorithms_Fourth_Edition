// Template for sort class
public class Example {
  public static void sort(Comparable[] a) {}
  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }
  private static void exchange(Comparable[] a, int i, int j)
  { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
}
