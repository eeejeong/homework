/*
문제: 1, 2, 3 더하기 5 (다이나믹 프로그래밍) 
출처: 백준 알고리즘 15990
날짜: 2019-12-11

[문제 설명]
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 
합을 나타낼 때는 수를 1개 이상 사용해야 한다. 
단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
- 1+2+1
- 1+3
- 3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

[출력]
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

[입력 예시]
3
4
7
10

[출력 예시]
3
9
27
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DPPlusWith123 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		// D[더해서 만들려는 값][마지막으로 사용한 수]
		long[][] D = new long[100001][4];
		D[1][1] = 1;
		D[2][2] = 1;
		D[3][1] = 1; D[3][2] = 1; D[3][3] = 1;
		
		// 반복문을 한 번 돌리고 마지막에 답을 입력 만큼 출력해주면 시간 초과를 방지할 수 있음
		for (int i = 4; i <= 100000; i++) {
			D[i][1] = (D[i - 1][2] + D[i - 1][3]) % 1000000009;
			D[i][2] = (D[i - 2][1] + D[i - 2][3]) % 1000000009;
			D[i][3] = (D[i - 3][1] + D[i - 3][2]) % 1000000009;
		}
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(String.valueOf((D[N][1] + D[N][2] + D[N][3]) % 1000000009) + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
