/*
날짜: 19-09-25
문제: 연속합
출처: 백준 알고리즘

[문제 설명]
n개의 정수로 이루어진 임의의 수열이 주어진다. 
우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 
단, 수는 한 개 이상 선택해야 한다.
예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 
여기서 정답은 12+21인 33이 정답이 된다.

[입력]
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 
수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

[출력]
첫째 줄에 답을 출력한다.

[입출력 예]
입력
10
10 -4 3 1 5 6 -35 12 21 -1

출력
33
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class successiveSum {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		String[] strArr = str.split(" ");
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		int answer = arr[0];

		if (N != 1) {
			for (int i = 0; i < N; i++) {
				int sum = arr[i];
				int tempMax = arr[i];
				for (int j = i + 1; j < N; j++) {
					sum += arr[j];
					if (sum > tempMax) {
						tempMax = sum;
					}
				}

				if (tempMax > answer) {
					answer = tempMax;
				}
			}
		}

		out.write(String.valueOf(answer));
		out.close();

	}

}
