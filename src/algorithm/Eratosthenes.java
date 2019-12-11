/*
문제: 소수 구하기(1929) - '에라토스테네스의 체' 연습 
출처: 백준 알고리즘

[문제 설명]
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

[출력]
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

[입출력 예]
입력
3 16

출력
3
5
7
11
13

 */

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Eratosthenes {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		// 소수를 저장하는 배열 
		List<Integer> primeList = new ArrayList<>();
		// 소수 판단하는 배열. 소수이면 false, 소수가 아니면 true
		boolean[] primeCheck = new boolean[N + 1];		
		
		// 2부터 N까지 수 중, 소수를 찾는 과정
		for(int i = 2; i <= N; i++) {
			if(primeCheck[i] == false) {
				primeList.add(i);
				for(int j = 1; i * j <= N; j++) {
					primeCheck[i * j] = true;
				}
			}
		}

		// M부터 N까지의 수 중 소수를 출력
		for(int value : primeList) {
			if(value >= M) {
				bw.write(value + "\n");
			}
		}
		
		br.close();
		bw.close();

	}

}
