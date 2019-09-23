/*
날짜: 19-09-22
문제: 블랙잭
출처: 백준 알고리즘

[문제 설명]
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 
카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버젼의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 
블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

[입력]
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

[출력]
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

[입출력 예]
입력			
5 21
5 6 7 8 9

출력
21
*/
package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Blackjack {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = in.readLine();
		String str2 = in.readLine();
		
		// 카드 개수와 최대값 기준 저장
		StringTokenizer st1 = new StringTokenizer(str1);
		int cardNum = Integer.parseInt(st1.nextToken());
		int max = Integer.parseInt(st1.nextToken());

		// 카드 숫자 배열에 저장
		StringTokenizer st2 = new StringTokenizer(str2);
		int[] arr = new int[cardNum];
		for (int i = 0; i < cardNum; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		Arrays.sort(arr);
		int answer = 0;

		outter:
		for (int i = cardNum - 1; i >= 0; i--) {
			// 정렬된 배열 기준 가장 큰 값이 max를 넘으면 그 다음 수로 넘어감
			if (arr[i] >= max) {
				continue;
			}

			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] + arr[j] >= max) {
					continue;
				} else {
					for (int k = j - 1; k >= 0; k--) {
						int test = arr[i] + arr[j] + arr[k];
						// 세 수의 합 test가 max와 같다면 더이상 검사하지 않고 종료
						if (test == max) {
							answer = test;
							break outter;
						// 세 수의 합 test가 max보다 작고, 현재 저장된 최대값보다 크면 현재 값을 답으로 저장
						} else if(test < max && test > answer) {
							answer = test;
						}
					}
				}
			}
		}
		out.write(String.valueOf(answer));
		out.flush();
	}
}
