package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * 1. 첫 번째로 줄을 선 학생은 무조건 0번
 * 2. 두 번째로 줄을 선 학생은 0번 또는 1번 중 하나를 뽑음
 * 	0번을 뽑으면 그 자리 그대로
 * 	1번을 뽑으면 바로 앞의 학생 앞으로
 * 3. 세 번째로 줄을 선 학생은 0, 1, 2 중에 하나를 뽑음
 * 	뽑은 번호만큼 앞자리로 가서 줄서기
 * 4. 계속
 */


public class BJ2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input받기
		int num = Integer.parseInt(br.readLine()); //학생수
		int[] seq = new int[num]; //뽑은수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<num; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		// 로직
		ArrayList<Integer> result = new ArrayList<>(); //결과값
		result.add(1); // 첫번째 줄을 선 학생은 무조건 0
		
		for(int i=1; i<num; i++) {
			// result.add(index, element)
			// 현 리스트의 길이 - 뽑은 수(최대는 현 리스트의 길이) = 위치 (뽑은만큼 앞으로 위치)
			result.add(result.size() - seq[i], i+1);
		}
		
		// 출력
		for(Integer i : result) {
			System.out.print(i + " ");
		}
		
	}

}
