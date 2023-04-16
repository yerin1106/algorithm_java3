package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			char[] memory = br.readLine().toCharArray();
			
			int cnt = 0;
			for(int i=0; i<memory.length; i++) {
				if(memory[i] != '0') {
					cnt++;
					for(int j=i; j<memory.length; j++) {
						if(memory[j] == '0') {
							memory[j] = '1';
						} else {
							memory[j] = '0';
						}
					}
				}
			}
			System.out.println("#" + (t+1) + " " + cnt);
		}

	}

}
