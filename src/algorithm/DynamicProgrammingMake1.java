/*
문제: 1로 만들기(다이나믹 프로그래밍) 
출처: 백준 알고리즘
날짜: 2019-12-10

[문제 설명]
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

[입력]
첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

[출력]
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

[입력 예시]
2

10

[출력 예시]
1

3
 */

package algorithm;

import java.util.Scanner;

public class DynamicProgrammingMake1 {
	// public static int[] memo = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N + 1];
		test(N, memo);
		System.out.println(memo[N]);
	}
	
	public static int test(int N, int[] memo) {
		if (N == 1) {
			return 0;
		}
		else if(memo[N] > 0) {
			return memo[N];
		} 
		else {
			memo[N] = test(N - 1, memo) + 1;
			if(N % 3 == 0) {
				int temp = test(N / 3, memo) + 1;
				if(memo[N] > temp) memo[N] = temp;
			}
			if(N % 2 == 0) {
				int temp = test(N / 2, memo) + 1;
				if(memo[N] > temp) memo[N] = temp;
			}
		}
		return test(N, memo);
	}

}
