/*
 분해합 
 */

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Decomposition {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			String[] strArr = String.valueOf(i).split("");
			int[] intArr = new int[strArr.length];
			int sum = i;
			for(int j = 0; j < intArr.length; j++) {
				intArr[j] = Integer.parseInt(strArr[j]);
				sum += intArr[j];
			}
			
			if(sum == n) {
				answer = i;
				break;
			}					
		}
		
		out.write(String.valueOf(answer));
		out.close();

	}

}
