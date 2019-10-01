/*
문제: 통계학
출처: 백준 알고리즘(정렬)
날짜: 19-09-30

[문제 설명]
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
- 산술평균 : N개의 수들의 합을 N으로 나눈 값
- 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
- 최빈값 : N개의 수들 중 가장 많이 나타나는 값
- 범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

[출력]
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
둘째 줄에는 중앙값을 출력한다.
셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
넷째 줄에는 범위를 출력한다.

[입출력 예]
입력			
5
1
3
8
-2
2

출력
2
2
1
10
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 숫자 개수
		int N = Integer.parseInt(in.readLine());
		Integer[] arr = new Integer[N];

		// 숫자 하나씩 배열에 저장
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		// 배열 정렬
		Arrays.sort(arr);

		// 1. 산술평균
		long sum = 0;
		long arithmeticMean = 0;

		// 1-1. 모든 정수의 합
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		// 1-2. 평균 구하기 (음수는 따로 처리)
		arithmeticMean = Math.round((double) sum / N);

		if (sum < 0) {
			sum = Math.abs(sum);
			arithmeticMean = Math.round((double) sum / N) * -1;
		}

		// 2. 중앙값
		int median = arr[N / 2];

		// 3. 최빈값
		int mode = arr[0];
	
		if(N != 1) {
			int mostFrequent = 0;
			boolean candidate = false;
			for (int i = 0; i < N; i++) {
				int frequency = 1; // 현재 검사할 숫자의 빈도
				for (int j = i + 1; j < N; j++) {
					
					// 마지막 숫자 처리
					if (j == N - 1) {
						if (arr[i] == arr[j]) {
							frequency++;
						}

						if (frequency > mostFrequent) {
							mode = arr[i];
						} else if ((frequency == mostFrequent) && candidate) {
							mode = arr[i];
						}
						i = j - 1;
						break;
					}

					if (arr[i] == arr[j]) {
						frequency++;
					} else {
						if (frequency > mostFrequent) {
							mostFrequent = frequency;
							mode = arr[i];
							candidate = true;
						} else if (frequency == mostFrequent) {
							if (candidate)
								mode = arr[i];
							candidate = false;
						}
						i = j - 1;
						break;
					}

				}
			}
		}

		// 4. 범위
		int range = arr[N - 1] - arr[0];

		// 답 출력
		out.write(arithmeticMean + "\n");
		out.write(median + "\n");
		out.write(mode + "\n");
		out.write(range + "\n");
		out.flush();

	}

}
