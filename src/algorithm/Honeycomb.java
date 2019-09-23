/*
날짜: 19-09-10
문제: 벌집
출처: 백준 알고리즘

[문제 설명]
위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 
그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 
예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

[입력]
첫째 줄에 N(1 <= N <= 1,000,000,000)이 주어진다.

[출력]
입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.

[입출력 예]
입력	출력
13		3
58		5
*/

package algorithm;

import java.util.Scanner;

public class Honeycomb {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		int answer = 0;

		int i = 1;
		int flagNum = 1;

		while (true) {
			if (N == 1) {
				answer = i;
				break;
			} else if (flagNum + 1 <= N && N <= flagNum + i * 6) {
				answer = i + 1;
				break;
			} else {
					flagNum = flagNum + i * 6;
					i++;
			}
		}

		System.out.println(answer);

	}

}
