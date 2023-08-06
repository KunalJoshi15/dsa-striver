package mathematics;

public class CountDigits {

    public static void main(String[] args) {
        int n = 1231;
        System.out.print(countDigits(n));
    }

    private static int countDigits(int n) {
        if (n>=0 && n<=9) return 1;
        return 1+countDigits(n/10);
    }
}
