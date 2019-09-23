/*
날짜: 19-09-05
문제: 체육복
출처: 프로그래머스

[문제 설명]
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

[제한 사항]
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

[입출력 예]
n	lost	reserve		return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]			4
3	[3]		[1]			2

*/

package gymClothes;

import java.util.Scanner;

public class GymClothes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("전체 학생 수(2 ~ 30명): ");
		int n = Integer.parseInt(scanner.nextLine());
		
		int lostNum = (int) (Math.random() * n) + 1;
		int reserveNum = (int) (Math.random() * n) + 1;
		
		int[] lost = new int[lostNum];
		int[] reserve = new int[reserveNum];
		
		// lost[]: 도난 당한 학생 번호 랜덤 부여. 중복 체크.
		for(int i = 0; i < lost.length; i++) {
			int num = (int) (Math.random() * 30) + 1;
			lost[i] = num;
			for(int j = 0; j < i; j++) {
				if(lost[j] == lost[i]) {
					i--;
					break;
				}
			}	
		}
		
		// reserve[]: 여분 옷을 가져온 학생 번호 랜덤 부여. 중복 체크.
		for(int i = 0; i < reserve.length; i++) {
			int num = (int) (Math.random() * 30) + 1;
			reserve[i] = num;
			for(int j = 0; j < i; j++) {
				if(reserve[j] == reserve[i]) {
					i--;
					break;
				}
			}	
		}
		
		System.out.print("잃어 버린 학생: ");
		for(int i = 0; i < lost.length; i++) {
			System.out.print(lost[i] + " ");
		}
		System.out.println();
		
		System.out.print("여분 옷 학생: ");
		for(int i = 0; i < reserve.length; i++) {
			System.out.print(reserve[i] + " ");
		}
		
		System.out.println();

		
		Solution solution = new Solution();
		int answer = solution.solution(n, lost, reserve);
		System.out.println(answer);
	
	}

}
