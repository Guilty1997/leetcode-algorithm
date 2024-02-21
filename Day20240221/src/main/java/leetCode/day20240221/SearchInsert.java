package leetCode.day20240221;

/**
 * @Auther: hehongyi
 * @Date: 2024/2/21 14:29
 * @Description:
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int i = searchInsert(nums, target);
        System.out.printf("i = " + i + "\n");
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * 提示:
     * 1 <= nums.length <= 10⁴
     * -10⁴ <= nums[i] <= 10⁴
     * nums 为 无重复元素 的 升序 排列数组
     * -10⁴ <= target <= 10⁴
     */
    public static int searchInsert(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int midIndex = (leftIndex + rightIndex) / 2;
        while (leftIndex <= rightIndex) {
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
            midIndex = (leftIndex + rightIndex) / 2;
        }
        return leftIndex;
    }
}
