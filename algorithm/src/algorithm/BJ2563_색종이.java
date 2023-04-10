package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 0. 초기 값 세팅
		int[][] map = new int[101][101]; //도화지
		int result = 0; //결과
		
		
		// 1. 색종이의 수
		int num = Integer.parseInt(br.readLine());
		
		// 2. 색종이를 붙인 위치, 도화지 색칠
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 2-1. 색종이를 붙인 위치
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 2-2. 도화지 색칠
			for(int a=x; a<x+10; a++) {
				for(int b=y; b<y+10; b++) {
					map[a][b]++;
				}
			}
		}
		
		// 3. 검은색 영역(색칠된 부분) 세기
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(map[i][j] > 0) result++;
			}
		}
		
		// 4. 출력
		System.out.println(result);
	}

}
