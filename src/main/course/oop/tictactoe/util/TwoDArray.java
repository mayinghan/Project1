package main.course.oop.tictactoe.util;

import java.util.*;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	private int[][] arr;
	private int defaultVal;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		arr = new int[rows][cols];
		this.defaultVal = defaultVal;
		for(int[] a : arr) {
			Arrays.fill(a, defaultVal);
		}
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		this.defaultVal = defaultVal;
		for(int[] a : arr) {
			Arrays.fill(a, defaultVal);
		}
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		if(val == defaultVal) return "Failure: " + val + "is not allowed.";

		if(arr[row][col] == defaultVal) {
			arr[row][col] = val;
			return "Success! " + val + " was inserted.";
		} else {
			//System.out.println("fail");
			return "Failure: " + row + ", " + col + " is not empty.";
		}


	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		
		return arr[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		int m = arr.length;
		int n = arr[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(j == n - 1 && i == m - 1) {
					sb.append(arr[i][j]);
				} else if(j == n - 1) {
					sb.append(arr[i][j] + "\n");
				} else {
					sb.append(arr[i][j] + " ");
				}
			}
		}
		return sb.toString();
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		//HashMap Key: val  Value: count
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(m.containsKey(arr[i][j])) {
					m.put(arr[i][j], m.get(arr[i][j]) + 1);
				} else {
					m.put(arr[i][j], 1);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
//		Set set = m.entrySet();
//		Iterator it = set.iterator();
//		while(it.hasNext()) {
//			Map.Entry entry = (Map.Entry)it.next();
//			sb.append("value:" + entry.getKey() + " count:" + entry.getValue() + "\n");
//		}
		for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
			sb.append("value:" + entry.getKey() + " count:" + entry.getValue() + "\n");
		}
		return sb.toString();
	}		

}
