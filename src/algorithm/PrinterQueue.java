/*
날짜: 19-09-27
문제: 프린터 큐
출처: 백준 알고리즘

[문제 설명]
여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 
여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 

하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 
예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

[입력]
첫 줄에 test case의 수가 주어진다. 각 test case에 대해서 문서의 수 N(100이하)와 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)이 주어진다. 
다음줄에 N개 문서의 중요도가 주어지는데, 중요도는 1 이상 9 이하이다. 
중요도가 같은 문서가 여러 개 있을 수도 있다. 
위의 예는 N=4, M=0(A문서가 궁금하다면), 중요도는 2 1 4 3이 된다.

test case
N(문서의 수) M(몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치) 
N개 문서의 중요도

[출력]
각 test case에 대해 문서가 몇 번째로 인쇄되는지 출력한다.

[입출력 예]
입력			
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

출력
1
2
5
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Printer {

	// Field
	int firstLocation;
	int priority;

	// Constructor
	public Printer(int firstLocation, int priority) {
		this.firstLocation = firstLocation;
		this.priority = priority;
	}

}

public class PrinterQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 총 테스트케이스 개수 입력
		int testcase = Integer.parseInt(in.readLine());

		// 테스트케이스 만큼 반복
		for (int i = 0; i < testcase; i++) {
			// 기본 정보(base) 입력
			String base = in.readLine();
			StringTokenizer st1 = new StringTokenizer(base, " ");
			// 문서의 개수
			int theNumber = Integer.parseInt(st1.nextToken());
			// 궁금한 문서의 현재 위치
			int question = Integer.parseInt(st1.nextToken());

			LinkedList<Printer> queue = new LinkedList<>();

			// 우선순위(priority) 입력
			String priority = in.readLine();
			StringTokenizer st2 = new StringTokenizer(priority);

			// 현재 위치와 우선순위를 하나씩 큐에 저장
			for (int j = 0; j < theNumber; j++) {
				queue.offer(new Printer(j, Integer.parseInt(st2.nextToken())));
			}

			int answer = 1;
			while (true) {
				// 현재 가장 앞에 있는 문서 객체 저장
				Printer target = queue.poll();
				boolean printable = true;
				
				for(int j = 0; j < queue.size(); j++) {
					// 인쇄 목록에 있는 문서의 우선순위 비교
					Printer temp = queue.get(j);
					// 만약 현재 문서의 우선순위보다 높은 문서가 있다면 
					if(temp.priority > target.priority) {
						// 현재 문서는 가장 뒷 순서로 추가
						queue.offer(target);
						// 프린트 불가
						printable = false;
						break;
					} 
				}
				
				// 프린트가 가능한 경우
				if(printable) {
					// 사용자가 궁금했던 문서라면 검사 종료
					if(target.firstLocation == question) {
						out.write(String.valueOf(answer));
						break;
					// 아니라면 출력 개수 하나 추가 후 검사 반복
					} else {
						answer++;
					}
				}
			}
			out.write("\n");
			out.flush();
		}

	}

}
