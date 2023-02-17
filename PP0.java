import java.util.Scanner;
import java.util.*;

public class PP0 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long x;
        do {
            System.out.println("Enter a integer: ");
          x  = sc.nextLong();
        }while (x<0);
        System.out.println("sumDigits(" + x + ") returns "+sumDigits(x));

    }

    public static int sumDigits(long n) {
        if (n == 0) {
            return 0;
        } else {
            return (int) (n % 10 + sumDigits(n / 10));
        }
    }

}
