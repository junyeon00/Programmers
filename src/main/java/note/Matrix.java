package note;

import java.util.Arrays;

public class Matrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                for(int k = 0; k < arr2.length; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3}, {3,3}};
        int[][] answerList = matrix.solution(arr1, arr2);
        for(int i = 0; i < answerList.length; i++) {
            System.out.println(Arrays.toString(answerList[i]));
        }
    }
}