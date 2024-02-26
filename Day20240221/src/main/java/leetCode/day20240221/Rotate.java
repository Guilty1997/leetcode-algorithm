package leetCode.day20240221;

import java.util.Arrays;

/**
 * @Auther: hehongyi
 * @Date: 2024/2/21 18:13
 * @Description: 旋转矩阵
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(arrays);
    }


    /**
     * 旋转矩阵
     * 原始:
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * <p>
     * 新的:
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * <p>
     * 1:0,0->0,2
     * 2:0,1->1,2
     * 3:0,2->2,2
     * <p>
     * 4:1,0->0,1
     * 5:1,1->1,1
     * 6:1,2->2,1
     * <p>
     * 7:2,0->0,0
     * 8:2,1->1,0
     * 9:2,2->2,0
     * <p>
     * 原始:
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * <p>
     * 新的:
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * <p>
     * 5:0,0->0,3
     * 1:0,1->1,3
     * 9:0,2->2,3
     * 11:0,3->3,3
     * <p>
     * 2:1,0->0,2
     * 4:1,1->1,2
     * 8:1,2->2,2
     * 10:1,3->3,2
     * <p>
     * 13:2,0->0,1
     * 3:2,1->1,1
     * 6:2,2->2,1
     * 9:2,3->3,1
     * <p>
     * 15:3,0->0,0
     * 14:3,1->1,0
     * 12:3,2->2,0
     * 16:3,3->3,0
     * <p>
     * 经推算，可以得出规律：
     * matrix[i][j] = matrix[n-1-j][i]
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                result[i][j] = matrix[n - 1 - j][i];
                result[i][j] = matrix[n - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                result[i][j] = matrix[n - 1 - j][i];
                matrix[i][j] = result[i][j];
            }
        }



    }
}
