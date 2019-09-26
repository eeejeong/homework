/*
날짜: 19-09-23
문제: 수 정렬하기1
출처: 백준 알고리즘

[문제 설명]
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

[입력]
첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.

[출력]
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
수는 중복되지 않는다.

[입출력 예]
[입력]
5
5
2
3
4
1

[출력]
1
2
3
4
5

 */

package algorithm;

import java.util.Scanner;

public class Sort1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				int temp = 0;
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
