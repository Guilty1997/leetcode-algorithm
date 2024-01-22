package leetCode.day20240122;

/**
 * @Auther: hehongyi
 * @Date: 2024/1/22 20:43
 * @Description:
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(98368));

    }

    /**
     * 最笨解决办法
     * 1. 先将数字转换为字符数组
     * 2. 遍历字符数组，找到第一个比后面大的字符，交换这两个字符
     * 3. 将字符数组转换为数字
     * 4. 返回数字
     *
     * @param num 数字
     * @return 结果
     */

    public int maximumSwap(int num) {

        char[] charArray = String.valueOf(num).toCharArray();
        if (charArray.length == 1) {
            return num;
        }
        int result = num;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                swap(charArray, i, j);
                result = Math.max(result, Integer.parseInt(String.valueOf(charArray)));
                swap(charArray, i, j);

            }
        }
        return result;
    }

    public void swap(char[] numChar, int i, int j) {
        char tmp = numChar[i];
        numChar[i] = numChar[j];
        numChar[j] = tmp;
    }
}
