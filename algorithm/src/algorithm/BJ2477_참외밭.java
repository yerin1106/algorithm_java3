package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준
 * 2477번, 참외밭 
 * 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이가 순서대로 주어짐
 * 
 * 첫째줄: 1m^2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K가 주어짐
 * 둘째줄~일곱번째줄: 변의 방향과 길이가 주어짐(1이상 500 이하)
 * 
 * 변의 방향 (사용하지 않음 / 문제에서 방향 불필요)
 * 1. 동쪽
 * 2. 서쪽
 * 3. 남쪽
 * 4. 북쪽
 */

public class BJ2477_참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int k = Integer.parseInt(br.readLine()); // 1m^2의 넓이에 자라는 참외의 개수
		int[][] input = new int[2][6]; // 변의 방향과 길이
		
		for(int i=0; i<6; i++) {
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp);
			
			input[0][i] = Integer.parseInt(st.nextToken());
			input[1][i] = Integer.parseInt(st.nextToken());
		}
		
		// 로직
		// 1. 가장 긴 변 찾기
		int w = 0;
		int h = 0;
		for(int i=0; i<6; i++) {
			if(i % 2 == 0 && w < input[1][i]) {
				w = input[1][i];
			} else if(i % 2 == 1 && h < input[1][i]) {
				h = input[1][i];
			}
		}
		
		// 2. 꺾이는 부분 찾기
		int ww = 0;
		int hh = 0;
		for(int i=0; i<6; i++) {
			int tmp = input[1][(i+5) % 6] + input[1][(i+1)%6];

			if(i%2 == 0) {
				if(tmp == h) {
					hh = input[1][i];
				}
			}
			else {
				if(tmp == w) {
					ww = input[1][i];
				}
			}
		}
		
		// 결과
		int result = (w*h - ww*hh) * k;
		
		// 출력
		System.out.println(result);
	}

}
