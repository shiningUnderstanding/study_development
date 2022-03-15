package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2580_sudoku {

	public static int[][] sudoku = new int[9][9];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
		
	}
	
	public static void sudoku(int row, int col) {
		if(col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(sudoku[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(row, col, i)) {
					sudoku[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			sudoku[row][col] = 0;
			return;
		}
		
		sudoku(row, col + 1);
	}
	
	public static boolean check(int row, int col, int val) {
		
		for(int i = 0; i < 9; i++) {
			if(sudoku[row][i] == val) {
				return false;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][col] == val) {
				return false;
			}
		}
		
		int start_row = (row / 3) * 3;
		int start_col = (col / 3) * 3;
		
		for(int i = start_row; i <start_row + 3; i++) {
			for(int j = start_col; j < start_col + 3; j++) {
				if(sudoku[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
}
