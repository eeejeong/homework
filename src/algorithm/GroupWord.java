/*
날짜: 19-09-16
문제: 그룹 단어 체커
출처: 백준 알고리즘

[문제 설명]
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

[출력]
첫째 줄에 그룹 단어의 개수를 출력한다.

[입출력 예]
입력			출력
3			3
happy
new
year

4			1
aba
abab
abcabc
a

*/

package algorithm;

import java.util.Scanner;

public class GroupWord {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = new String[n];
		int answer = 0;
		boolean flag;

		// n 개수 만큼 문자열 입력
		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextLine();
		}

		// 검사 시작
		for (int i = 0; i < n; i++) {
			char[] testArr = input[i].toCharArray();
			flag = true;

			outter: for (int j = 0; j < testArr.length; j++) {
				if (j == 0) {
					continue;
				} else if (testArr[j] == testArr[j - 1]) {
					continue;
				} else {
					for (int k = 0; k < j; k++) {
						if (testArr[k] == testArr[j]) {
							flag = false;
							break outter;
						}
					}
				}
			}
			if (flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
