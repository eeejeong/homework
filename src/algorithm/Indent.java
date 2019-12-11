/*
문제: 코딩은 예쁘게
출처: 백준 알고리즘
날짜: 19-10-07

[문제 설명]
백준이는 한 작은 회사에 취직했다. 이 회사에서 백준이는 소스 코드의 뒤죽박죽인 인덴트를 고치고 있다. 인덴트는 각 줄을 탭 키를 이용해 들여 쓰는 것을 말한다. 
다행히 백준이가 사용하는 편집기는 연속된 줄을 그룹으로 선택하고, 여기에서 각 줄의 앞에 탭을 추가하거나, 삭제할 수 있다. 
백준이를 도와 코드의 뒤죽박죽인 인덴트를 예쁘게 고치는 방법을 생각해보자.
줄의 개수 N과 각 줄의 앞에 있는 탭의 개수와 올바른 탭의 개수가 주어진다. 이때, 한 번 편집을 할 때, 다음과 같은 명령을 수행할 수 있다.
- 연속된 줄을 그룹으로 선택한다.
- 선택된 줄의 앞에 탭 1개를 추가하거나 삭제한다.
위의 두 명령을 모두 수행하는 것이 하나의 편집이며, 선택된 줄의 개수와는 상관이 없다. 
만약, 선택한 줄 중에 단 한 줄이라도 탭이 없을 경우에는, 탭을 삭제하는 명령을 수행할 수 없다.

백준이가 몇 번 편집 만에 코드의 인덴트를 올바르게 고칠 수 있는지 구하는 프로그램을 작성하시오. 이때, 편집 회수의 최솟값을 구해야 한다.

[입력]
첫째 줄에 줄의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄에는 현재 줄에 있는 탭의 개수가 주어지며, 1번째 줄부터 순서대로 주어진다. 
탭의 개수는 0보다 크거나 같고, 80보다 작거나 같은 정수이다. 
셋째 줄에는 각 줄의 올바른 탭의 개수가 주어진다. 
1번째 줄부터 순서대로 주어지며, 이 값도 0보다 크거나 같고, 80보다 작거나 같은 정수이다.

[출력]
첫째 줄에 코드의 인덴트를 올바르게 고치는 편집 회수의 최솟값을 출력한다.

[입출력 예]
입력			
4
1 2 3 4
3 1 1 0

출력
6
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Indent {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 줄의 개수 N 입력
		int N = Integer.parseInt(in.readLine());
		// 현재 N개 줄의 인덴트 입력
		String asIs = in.readLine();
		// N개 줄의 올바른 인덴트 입력
		String toBe = in.readLine();

		// 각 배열에 입력 받은 내용을 StringTokenizer로 분할
		StringTokenizer st1 = new StringTokenizer(asIs, " ");
		StringTokenizer st2 = new StringTokenizer(toBe, " ");

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st1.nextToken()) - Integer.parseInt(st2.nextToken()));
		}

		int answer = 0;

		if (arr.size() == 1) {
			answer = Math.abs(arr.get(0));
		} else {

		} // 전체 검사 완료
		out.write(answer + "");
		out.close();
	}
}
