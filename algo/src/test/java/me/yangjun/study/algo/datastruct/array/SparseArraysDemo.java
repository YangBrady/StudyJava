package me.yangjun.study.algo.datastruct.array;

/**
 * sparseArrays 稀疏数组
 *
 * @author Brady
 * @date 2024/07/29
 */
public class SparseArraysDemo {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        array[1][1] = 1;
        array[2][3] = 1;
        array[3][4] = 1;
        array[4][1] = 1;

        printArray(array);

        int[][] sparseArr = arrToSparseArray(array);
        System.out.println("转换成稀疏数组后");
        printArray(sparseArr);

        int[][] array2 = sparseArraysToArray(sparseArr);
        System.out.println("转换回普通数组后");
        printArray(array2);
    }

    private static void printArray(int[][] array) {
        for (int[] arg : array) {
            for (int i : arg) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    /**
     * 二维数组 转 稀疏数组
     */
    public static int[][] arrToSparseArray(int[][] arr) {
        // 构建稀疏数组
        int sum = 0;
        for (int[] arg : arr) {
            for (int i : arg) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArrays = new int[sum + 1][3];

        // 构建第一行
        int row = arr.length;
        int col = arr[0].length;
        sparseArrays[0][0] = row;
        sparseArrays[0][1] = col;
        sparseArrays[0][2] = sum;

        // 加入非空数据
        int sparseArrayIdx = 1;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (arr[x][y] != 0) {
                    sparseArrays[sparseArrayIdx][0] = x;
                    sparseArrays[sparseArrayIdx][1] = y;
                    sparseArrays[sparseArrayIdx][2] = arr[x][y];
                    sparseArrayIdx++;
                }
            }
        }

        return sparseArrays;
    }

    /**
     * 稀疏数组 转 二维数组
     */
    public static int[][] sparseArraysToArray(int[][] sparseArr) {
        // 解析第一行
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] arrays = new int[row][col];

        for (int i = 1; i < sparseArr.length; i++) {
            int x = sparseArr[i][0];
            int y = sparseArr[i][1];
            arrays[x][y] = sparseArr[i][2];
        }

        return arrays;
    }
}
