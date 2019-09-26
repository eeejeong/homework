/*
날짜: 19-09-26
문제: 조세퍼스 문제 
출처: 백준 알고리즘

[문제 설명]
조세퍼스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-조세퍼스 순열이라고 한다. 
예를 들어 (7, 3)-조세퍼스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-조세퍼스 순열을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

[출력]
예제와 같이 조세퍼스 순열을 출력한다.

[입출력 예]
입력			
7 3

출력
<3, 6, 2, 7, 5, 1, 4>
*/

package algorithm;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusPermutation {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		Queue<Integer> list = new LinkedList<>();
		Queue<Integer> answer = new LinkedList<>();
		
		for (int i = 1 ; i <= N ; i ++) {
			list.offer(i);
		}
			
		while(!list.isEmpty()) {
			try {
				for(int i = 0; i < K - 1; i++) {
					list.add(list.poll());
				}
				answer.add(list.poll());
			} catch (IndexOutOfBoundsException e) {
				System.out.println("범위 초과");
			}
		}
		
		out.write("<");
		for(int i = 0; i < N; i++) {
			out.write(String.valueOf(answer.poll()));
			if(i != N - 1) {
				out.write(", ");
			}
		}
		out.write(">");
		
		out.close();		
	}
}
