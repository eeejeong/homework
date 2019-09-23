/*
날짜: 19-09-06
문제: 숫자 야구	
출처: 프로그래머스

[문제 설명]
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다.
각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 
그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃

예를 들어, 아래의 경우가 있으면
A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.

이때 가능한 답은 324와 328 두 가지입니다.
질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 
가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

[제한 사항]
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

[입출력 예]
baseball												 return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	 2
*/

package algorithm;

public class baseball {

	public static void main(String[] args) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		int answer = 0;

		// 123부터 987까지 답이 될 수 있는 숫자 검사
		for (int i = 123; i <= 987; i++) {
			// 쉽게 비교하기 위해 i번 숫자의 각 자리수 숫자를 배열에 저장 	
			int[] testNum = new int[3];
			testNum[0] = i / 100;	// 100의 자리
			testNum[1] = (i - 100 * testNum[0]) / 10;	// 10의 자리 
			testNum[2] = i % 10;	// 1의 자리

			// 제한 사항에 어긋나는 숫자 건너 뛰기 
			// 1. 세 자리수는 전부 다 다른 숫자여야 함
			if (testNum[0] == testNum[1] || testNum[1] == testNum[2] || testNum[0] == testNum[2]) {
				continue;
			}
			// 2. 숫자 중 0이 있으면 검사 건너 뛰기
			if (testNum[0] == 0 || testNum[1] == 0 || testNum[2] == 0) {
				continue;
			}

			// 스트라이크, 볼 기준에 맞는지 여부 저장하는 변수
			boolean test = false;
			
			// 주어진 조건에 맞는지 검사 시작
			for (int j = 0; j < baseball.length; j++) {
				
				int strike = 0;
				int ball = 0;
				
				// 주어진 수를 비교하기 쉽게 배열에 저장 
				int[] baseballNum = new int[3];
				baseballNum[0] = baseball[j][0] / 100;
				baseballNum[1] = (baseball[j][0] - 100 * baseballNum[0]) / 10;
				baseballNum[2] = baseball[j][0] % 10;
				
				// 1. i와 주어진 수를 비교하여 스트라이크 개수 저장
				for (int m = 0; m < 3; m++) {
					if (testNum[m] == baseballNum[m]) {
						strike++;
					}
				}
				
				// 2. i와 주어진 수를 비교하여 볼 개수 저장
				if (testNum[0] == baseballNum[1] || testNum[0] == baseballNum[2]) {
					ball++;
				}
				if (testNum[1] == baseballNum[0] || testNum[1] == baseballNum[2]) {
					ball++;
				}
				if (testNum[2] == baseballNum[0] || testNum[2] == baseballNum[1]) {
					ball++;
				}

				// 만약 주어진 조건과 해당 숫자의 스트라이크, 볼 개수가 맞다면 true	
				if (strike == baseball[j][1] && ball == baseball[j][2]) {
					test = true;
				// 개수가 맞지 않으면 해당 숫자는 더 이상 검사하지 않음
				} else {
					test = false;
					break;
				}

			}
			
			// 모든 조건을 통과한 경우, 답이 될 수 있음
			if (test == true) {
				answer++;
			}
		}

		System.out.println(answer);

	}

}