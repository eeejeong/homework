/*
문제: 소수 찾기(1929) - '에라토스테네스의 체' 연습 
출처: 백준 알고리즘

[문제 설명]
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

[입력]
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

[출력]
주어진 수들 중 소수의 개수를 출력한다.

[입출력 예]
입력
4
1 3 5 7

출력
3

*/
package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeNumber {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] inputNum = br.readLine().split(" ");		
		int answer = 0;

		for(int i = 0; i < N; i++) {
			boolean primeCheck = true;
			int nowNum = Integer.parseInt(inputNum[i]);
			if(nowNum < 2) {
				primeCheck = false;
			}
			else {
				// 루트 N까지 수로 나누어 떨어지는지만 검사해도 소수인지 아닌지 판명 가능
				for(int j = 2; j * j <= nowNum; j++) {
					if(nowNum % j == 0) {
						primeCheck = false;
					}
				}
			}
			if(primeCheck) {
				answer++;
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		
		br.close();
		bw.close();
	}

}
