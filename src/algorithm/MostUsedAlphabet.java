/*
날짜: 19-09-16
문제: 단어 공부
출처: 백준 알고리즘

[문제 설명]
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
단, 대문자와 소문자를 구분하지 않는다.

[입력]
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

[출력]
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

[입출력 예]
입력				출력
Mississipi		?
zZa				Z
z				Z
baaa			A

*/

package algorithm;

import java.util.Scanner;

public class MostUsedAlphabet {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		input = input.toUpperCase();
		
		char[] inputArr = input.toCharArray();
		int[] countArr = new int[26];
		char answer = '0';
		
		for(int i = 0; i < inputArr.length; i++) {
			countArr[(int) (inputArr[i] - 'A')]++;
		}
		
		int max = 0;
		
		for(int i = 0; i < countArr.length; i++) {
			if(countArr[i] > countArr[max]) {
				max = i;
			}
		}
		
		answer = (char) (max + 'A');
		
		for(int i = 0; i < countArr.length; i++) {
			if(i == max) {
				continue;			
			} else if (countArr[max] == countArr[i]) {
				answer = '?';
				break;
			}
		}
		
			
		System.out.println(answer);
		
	}

}
