

package com.iluwatar.masterworker;

import java.util.Random;

/**
 *Class ArrayUtilityMethods has some utility methods for matrices and arrays.
 */

public class ArrayUtilityMethods {
 
  /**
   * Method arraysSame compares 2 arrays @param a1 and @param a2
   * and @return whether their values are equal (boolean).
   */

  public static boolean arraysSame(int[] a1, int[] a2) {
    //compares if 2 arrays have the same value
    if (a1.length != a2.length) {
      return false;
    } else {
      boolean answer = false;
      for (int i = 0; i < a1.length; i++) {
        if (a1[i] == a2[i]) {
          answer = true;
        } else {
          answer = false;
          break;
        }
      }
      return answer;
    }
  }

  /**
   * Method matricesSame compares 2 matrices @param m1 and @param m2
   * and @return whether their values are equal (boolean).
   */
  
  public static boolean matricesSame(int[][] m1, int[][] m2) {
    if (m1.length != m2.length) {
      return false;
    } else {
      boolean answer = false;
      for (int i = 0; i < m1.length; i++) {
        if (arraysSame(m1[i], m2[i])) {
          answer = true;
        } else {
          answer = false;
          break;
        }
      }
      return answer;
    }
  }
  
  /**
   * Method createRandomIntMatrix creates a random matrix of size @param rows
   * and @param columns @return it (int[][]).
   */
  
  public static int[][] createRandomIntMatrix(int rows, int columns) {
    int[][] matrix = new int[rows][columns];
    Random rand = new Random();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        //filling cells in matrix
        matrix[i][j] = rand.nextInt(10);
      }
    }
    return matrix;
  }
  
  /**
   * Method printMatrix prints input matrix @param matrix.
   */
  
  public static void printMatrix(int[][] matrix) {
    //prints out int[][]
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }
  
}
