/*
날짜: 19-09-11
문제: 크로아티아 알파벳
출처: 백준 알고리즘

[문제 설명]
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
크로아티아 알파벳	변경
	č			c=
	ć			c-
	dž			dz=
	đ			d-
	lj			lj
	nj			nj
	š			s=
	ž			z=
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

[입력]
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

[출력]
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

[입출력 예]
입력			출력
ljes=njak	6
*/
package algorithm;

import java.util.Scanner;

public class croatiaAlphabet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] inputArr = input.toCharArray();
		int answer = 0;

		for (int i = 0; i < inputArr.length; i++) {
			if (i + 1 == inputArr.length) {
				answer++;
			} else if (inputArr[i] == 'c') {
				if (inputArr[i + 1] == '=' || inputArr[i + 1] == '-') {
					answer++;
					i++;
				} else {
					answer++;
				}
			} else if (inputArr[i] == 'd') {
				if (inputArr[i + 1] == '-') {
					answer++;
					i++;
				} else if (i + 2 != inputArr.length) { 
					if (inputArr[i + 1] == 'z' && inputArr[i + 2] == '=') {
						answer++;
						i += 2;
					} else {
						answer++;
					}
				} else {
					answer++;
				}
			} else if (inputArr[i] == 'l') {
				if (inputArr[i + 1] == 'j') {
					answer++;
					i++;
				} else {
					answer++;
				}
			} else if (inputArr[i] == 'n') {
				if (inputArr[i + 1] == 'j') {
					answer++;
					i++;
				} else {
					answer++;
				}
			} else if (inputArr[i] == 's') {
				if (inputArr[i + 1] == '=') {
					answer++;
					i++;
				} else {
					answer++;
				}
			} else if (inputArr[i] == 'z') {
				if (inputArr[i + 1] == '=') {
					answer++;
					i++;
				} else {
					answer++;
				}
			} else {
				answer++;
			}
		}

		System.out.println(answer);

	}
}
