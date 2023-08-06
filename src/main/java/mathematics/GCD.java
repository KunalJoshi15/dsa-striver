package mathematics;

public class GCD {

    public static void main(String[] args) {
        int a = 10;
        int b = 4;
        System.out.print(gcd(a,b));
    }

    private static int gcd(int a, int b) {
        if (b==0) return a;

        return gcd(b,a%b);
    }
}
