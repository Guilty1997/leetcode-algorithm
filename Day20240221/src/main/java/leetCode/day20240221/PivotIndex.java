package leetCode.day20240221;

/**
 * @Auther: hehongyi
 * @Date: 2024/2/21 11:43
 * @Description:
 */
public class PivotIndex {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int i = pivotIndex(nums);
        System.out.printf("i = " + i + "\n");
    }

    /**
     * 总和为sum 左边：preSum 右边：sum-preSum-nums[i]
     * preSum = sum-preSum-nums[i]
     * preSum*2+nums[i] = sum
     * 寻找数组的中心索引
     * 1. 先求出数组的和
     * 2. 遍历数组，求出前缀和，判断前缀和*2+当前值是否等于数组和
     * 3. 如果等于，返回当前索引
     * 4. 如果遍历完都没有找到，返回-1
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        //求和
        for (int num : nums) {
            sum += num;
        }
        //左侧之和
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum * 2 + nums[i] == sum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
