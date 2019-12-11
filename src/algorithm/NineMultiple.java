/*
문제: 9의 배수
출처: 구름 코딩
날짜: 2019-12-08

[문제 설명]
평소 동이는 비밀번호로 상당히 긴 N개의 자연수를 사용한다. 
또한 동이는 주기적으로 주로 사용하는 비밀번호를 변경하는데, 이번 달에는 비밀번호를 모두 10진수로 보았을 때 9의 배수가 되는 숫자로 변경하기로 결정했다. 
하지만 아무렇게나 긴 9의 배수를 비밀번호로 사용하면 기억하기 쉽지 않기 때문에 기존에 사용하던 비밀번호들을 조금 변경하여 9의 배수로 만들고자 한다.

현재 동이가 비밀번호로 사용하고 있는 N개의 자연수가 주어졌을 때, 
각 비밀번호에 숫자를 더하여 9의 배수로 만들기위해 더해야 할 최소의 수를 저장하는 계산하는 프로그램을 작성하시오.

[입력]
첫 줄에 동이가 사용하는 비밀번호의 수 N이 주어진다. N은 1과 100사이의 자연수이다.
그 후 N줄에 걸쳐서 한 줄에 하나의 비밀번호가 주어진다. 모든 비밀번호는 1,000자리 이하의 자연수이다.

[출력]
총 N줄에 걸쳐서 각 비밀번호를 9의 배수로 만들기 위하여 더해야 할 최소의 숫자를 출력한다. 
비밀번호가 이미 9의 배수라면 9를 출력한다.

[입력 예시]
5
123
456
111
9
9999999999

[출력 예시]
3
3
6
9
9

 */
package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NineMultiple {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			long password = Long.parseLong(br.readLine());
			long test = password % 9;
			
			bw.write(Long.toString(9 - test) + "\n");
		}
		bw.flush();

		br.close();
		bw.close();
	}

}
