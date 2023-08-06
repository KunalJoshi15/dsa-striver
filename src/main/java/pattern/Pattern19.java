package pattern;

public class Pattern19 {

    public static void main(String[] args) {
        int n = 5;
        for(int i=0;i<n;i++) {
            // stars
            // 5 0 5
            // 4 2 4
            // 3 4 3
            // 2 6 2
            // 1 8 1
            for(int j=1;j<=(n-i);j++) {
                System.out.print("*");
            }

            // spaces
            for(int j=1;j<=2*i;j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=(n-i);j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            for (int j=1;j<=2*(n-i);j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
