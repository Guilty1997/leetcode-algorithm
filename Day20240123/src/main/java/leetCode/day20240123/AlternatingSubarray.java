package leetCode.day20240123;

/**
 * @Auther: hehongyi
 * @Date: 2024/1/23 18:39
 * @Description: 最大交替子数组
 * 分析：
 * 可以先确定两个数组，且后续必须一样才能构成交替子数组
 * 遍历数组判断相邻两个是否交替
 */
public class AlternatingSubarray {
    public static void main(String[] args) {

    }

    public static int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        for (int firstIndex = 0; firstIndex < n; firstIndex++) {
            for (int i = firstIndex + 1; i < n; i++) {
                int length = i - firstIndex + 1;
                if (nums[i] - nums[firstIndex] == (length - 1) % 2) {
                    res = Math.max(res, length);
                } else {
                    break;
                }
            }
        }
        return res;

    }
}
