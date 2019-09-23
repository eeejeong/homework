/*
날짜: 19-09-18
문제: 괄호 문자열
출처: 백준 알고리즘

[문제 설명]
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 
한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 
만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 
그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 
예를 들어 “(())()”와 “((()))” 는 VPS 이지만 
“(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 

[입력]
입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 
입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 
하나의 괄호 문자열의 길이는 2 이상 50 이하이다. 

[출력]
출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다. 

[입출력 예]
입력
6
()()())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

출력
NO
NO
YES
NO
YES
NO

*/


package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisString {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		
		// 문장 입력 개수 t
		int t = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < t; i++) {
			// 괄호 문자열 입력
			String input = scanner.nextLine();
			char[] inputArr = input.toCharArray();
			
			// 괄호 문자를 하나씩 스택에 쌓음
			for(int j = 0; j < inputArr.length; j++) {
				stack.push(inputArr[j]);
			}
			
			int close = 0;	// ) 개수
			boolean flag = true;	// 판단을 위한 flag
			
			
			while(!stack.isEmpty()) {
				char now = stack.pop();
				// )가 없이 (가 있는 경우는 false
				if(close == 0 && now == '(') {
					flag = false;
					break;
				// () 한 쌍이 만난 경우 )개수 하나 감소
				} else if(close != 0 && now == '(') {
					close--;
				// )면 개수 추가
				} else if(now == ')') {
					close++;
				}
			}
			
			if(close == 0 && flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}	
			stack.clear();
		}

	}

}
