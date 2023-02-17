import java.util.*;

public class ExtrA {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");
        String line = sc.nextLine();

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        String[] words = line.split(" ");// split up setnece by spaces

        for (String x : words) {

            //if there is
            stringIntegerHashMap.merge(x, 1, Integer::sum);
        }

        System.out.println(stringIntegerHashMap);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (Integer x : arr) {
            count++;
            if (arr.get(x) < 0) {
                count1 += 1;
            } else if (arr.get(x) == 0) {
                count2 += 1;
            } else {
                count3 += 1;
            }
        }
        System.out.println((float)count1/count);
        System.out.println((float) count2/count);
        System.out.println((float) count3/count);
    }
}
