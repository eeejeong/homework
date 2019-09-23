/*
날짜: 19-09-11
문제: 달팽이는 올라 가고 싶다
출처: 백준 알고리즘

[문제 설명]
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

[출력]
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

[입출력 예]
입력			출력
2 1 5		4	
*/

package algorithm;

import java.util.Scanner;

public class Snail {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int day = scanner.nextInt();
		int night = scanner.nextInt();
		int dest = scanner.nextInt();

		int answer = 0;

		if (day == dest) {
			answer = 1;
		} else {
			if ((dest - day) % (day - night) == 0) {
				answer = (dest - day) / (day - night) + 1;
			} else {
				answer = (dest - day) / (day - night) + 2;
			}
		}

		System.out.println(answer);

	}

}
