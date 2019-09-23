/*
날짜: 2019-09-04
문제: 이상한 문자 만들기
출처: 프로그래머스
*/

/*
[문제 설명]
문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 
[제한 사항]
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

[입출력 예]
"try hello world"	
"TrY HeLlO WoRlD"

[입출력 예 설명]
try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 
각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 
따라서 TrY HeLlO WoRlD 를 리턴합니다.
*/

package algorithm;

import java.util.Scanner;

public class StrangeString {

	public static void main(String[] args) {
		String answer = "";

		// 사용자에게 문자열 입력
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		// 문자열을 공백 기준으로 나누어 문자열 배열에 저장
		String[] strArr = str.split(" ");

		// 조건에 맞게 검사 및 대소문자 변환
		for (int i = 0; i < strArr.length; i++) {
			// 공백을 기준으로 나뉜 각 단어를 char 배열로 저장
			char[] charArr = strArr[i].toCharArray();
			// 단어 속 문자를 하나씩 검사
			for (int j = 0; j < charArr.length; j++) {
				// 짝수 인덱스: 대문자로
				if (j % 2 == 0) {
					// 만약 짝수 인덱스 문자가 소문자인 경우, 대문자로 변환하여 저장
					if (!('A' <= charArr[j] && charArr[j] <= 'Z')) {
						charArr[j] = (char) (charArr[j] - ('a' - 'A'));
					}
				// 홀수 인덱스: 소문자로
				} else {
					// 만약 홀수 인덱스 문자가 대문자인 경우, 소문자로 변환하여 저장
					if (!('a' <= charArr[j] && charArr[j] <= 'z')) {
						charArr[j] = (char) (charArr[j] + ('a' - 'A'));
					}
				}
				// 문자 대소문자 변환이 끝난 후 answer 문자열에 추가
				answer += charArr[j];
			}
			// 각 단어의 대소문자 변환이 끝난 후 answer 문자열에 추가
			answer += " ";
		}

		// 정답 출력
		System.out.println(answer);
	}
}
