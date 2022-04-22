package lcm;

public class Main {
  public int lcm(int a, int b) {
    int gcd = gcd(a, b);
    int lcm = (a * b) / gcd;
    return lcm;
  }
  
  public int gcd(int p, int q) {
    if (q == 0)
      return p;
    return gcd(q, p % q);
  }
}
