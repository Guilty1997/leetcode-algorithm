package leetCode.day20240221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: hehongyi
 * @Date: 2024/2/21 16:19
 * @Description: 合并区间
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 4}, {0, 2}, {3, 5}
        };
        int[][] merge = merge1(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.printf(merge[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }

    /**
     * 声明结果数组
     * 遍历二维数组
     * 如果结果数组为空或者结果数组的最后一个元素的右边界小于当前左边界
     * 则直接添加到结果数组
     * 否则，更新结果数组的最后一个元素的右边界
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[intervals.length][2];
        int removeCount = 0;
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (index == 0 || result[index - 1][1] < left) {
                result[index][0] = left;
                result[index][1] = right;
                index++;
            } else {
                removeCount++;
                result[index - 1][1] = Math.max(result[index - 1][1], right);
            }
        }
        int[][] ints = new int[intervals.length - removeCount][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = result[i];
        }
        return ints;

    }

    public static int[][] merge1(int[][] intervals) {
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (i == 0 || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];
        list.add(interval);
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] < intervals[i][0]) {
                interval = intervals[i];
                list.add(interval);
            } else if (interval[1] <= intervals[i][1]) {
                interval[1] = intervals[i][1];
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
