package leetCode.day20240125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class SumIndicesWithKSetBits {
    public static void main(String[] args) {

        Integer[] integers = {5, 10, 1, 5, 2};
        List<Integer> list = Arrays.asList(integers);

        int i = sumIndicesWithKSetBits(list, 1);
        System.out.printf("i = " + i + "\n");
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int size = nums.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            int count = 0;
            String binaryString = Integer.toBinaryString(i);
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    count++;
                }
            }
            if (count == k) {
                result = result + nums.get(i);
            }

        }
        return result;

    }
}
