/*
날짜: 19-09-11
문제: 분수 찾기
출처: 백준 알고리즘

[문제 설명]
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

[제한 사항]
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

[입출력 예]
입력		출력
14	 	2/4		
*/

package algorithm;

import java.util.Scanner;

public class findingFraction {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int X = Integer.parseInt(scanner.nextLine());
		
		String answer;
		
		int dominator;	//분모
		int numerator;	//분자

		int i = 0;			// 반복문 조건을 위한 변수
		int flagNum = 1;	// 범위 기준 숫자 
		
		while (true) {
			if (flagNum <= X && X <= flagNum + i) {
				if ((i + 1) % 2 == 0) {
					dominator = (i + 1) - (X - flagNum);
					numerator = 1 + (X - flagNum);			
				} else {
					dominator = 1 + (X - flagNum);
					numerator = (i + 1) - (X - flagNum);					
				}
				answer = numerator + "/" + dominator;
				break;
				
			} else {
				flagNum = flagNum + i + 1;
				i++;
			}
		}
		
		System.out.println(answer);

	}

}
