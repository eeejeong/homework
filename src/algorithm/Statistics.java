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
import java.util.ArrayList;
import java.util.Arrays;

class Mode {
	int number;
	int frequency;

	Mode(int number, int frequency) {
		this.number = number;
		this.frequency = frequency;
	}

}

public class Statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(arr);

		// 산술평균
		double sum = 0;
		long arithmeticMean = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		arithmeticMean = Math.round((double) sum / N);
		out.write(arithmeticMean + "\n");

		// 중앙값
		int median = arr[N / 2];
		out.write(median + "\n");

		// 최빈값
		ArrayList<Mode> modeArr = new ArrayList<>();
		int mode;
		if (N == 1) {
			mode = arr[0];
		} else {
			int mostFrequent = 1;
			for (int i = 0; i < N; i++) {
				int frequency = 1;
				for (int j = i + 1; j < N; j++) {
					if (arr[i] == arr[j]) {
						frequency++;
						if(j == N - 1) {
							modeArr.add(new Mode(arr[i], frequency));
						}
					} else {
						modeArr.add(new Mode(arr[i], frequency));
						if (frequency >= mostFrequent) {
							mostFrequent = frequency;
						}
						i = j - 1;
						break;
					}			
				}
			}

			ArrayList<Integer> modeArr2 = new ArrayList<>();
			
			for (int i = 0; i < modeArr.size(); i++) {
				Mode temp = modeArr.get(i);
				if (temp.frequency == mostFrequent) {
					modeArr2.add(temp.number);
				}
			}
			
			int[] modeArr3 = new int[modeArr2.size()];
			
			for (int i = 0; i < modeArr3.length; i++) {
				modeArr3[i] = modeArr2.get(i);
			}

			Arrays.sort(modeArr3);
			
			if (modeArr3.length == 1) {
				mode = modeArr3[0];
			} else {
				mode = modeArr3[1];
			}
		}
		out.write(mode + "\n");

		// 범위
		int range = arr[N - 1] - arr[0];
		out.write(range + "");
		out.flush();

	}

}
