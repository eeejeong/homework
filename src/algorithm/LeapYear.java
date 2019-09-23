/*
[문제]
연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때 이다.
예를들어, 2012년은 4의 배수라서 윤년이지만, 1900년은 4의 배수이지만, 100의 배수이기 때문에 윤년이 아니다.
하지만, 2000년은 400의 배수이기 때문에 윤년이다.

[입력]
첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.

[출력]
첫째 줄에 윤년이면 1, 아니면 0을 출력한다.

*/

package algorithm;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//연도 입력 받기
		int year = Integer.parseInt(scanner.nextLine());
		//연도 입력 범위 오류 처리
		if(year < 1 || year > 4000) {
			System.out.println("입력 오류: 연도는 1보다 크거나 같고, 4000보다 작거나 같아야 합니다.");
		}
		
		int test = -1;
		//주어진 조건에 맞는지 처리
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			test = 1;
		} else {
			test = 0;
		}
		
		System.out.println(test);

	}

}



