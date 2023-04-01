package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309_일곱난쟁이 {
	
	static int[] input = new int[9];
	static int[] numbers = new int[7];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input 받기
		for(int i=0; i<9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// input 오름차순 sort
		Arrays.sort(input);
		
		// 조합 method 호출
		comb(0,0);
		
	}
	
	// 조합(중복되는 결과 X) method
	public static void comb(int cnt, int start) {
		if(cnt == 7){
			int sum = 0;
			
			for(int i=0; i<7; i++) {
				sum += numbers[i];
			}
			
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(numbers[i]);
				}
				System.exit(0); //프로그램 강제종료
			}
			return; //method 종료
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

}
