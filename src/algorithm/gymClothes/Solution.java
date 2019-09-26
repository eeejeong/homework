package algorithm.gymClothes;

class Solution {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		// 체육복 빌려준 여부를 저장하는 배열. 남은 체육복 수에 맞게 생성(초기값은 자동으로 false)
		boolean[] isBorrowed = new boolean[reserve.length];
		// 도난 당했지만 여분의 옷을 가져와 자신의 옷을 입은 경우를 저장하는 배열.
		boolean[] getMine = new boolean[lost.length];

		// 도난 당하지 않은 학생(체육복) 수
		answer = n - lost.length;

		// 1. 여분의 옷을 가져온 학생이 도난 당한 경우, 자신의 옷을 입도록 먼저 처리
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer += 1;
					isBorrowed[j] = true;
					getMine[i] = true;
				}
			}
		}
		// 2. 앞, 뒤 학생이 빌려줄 수 있는지 처리
		for (int i = 0; i < lost.length; i++) {
			// 1번 처리에서 자신의 여분 옷을 입은 학생은 검사 생략
			if (getMine[i] == true) {
				continue;
			}
			for (int j = 0; j < reserve.length; j++) {
				// 앞 번호 학생이 여분의 옷을 빌려줄 수 있는 경우
				if ((lost[i] == reserve[j] - 1) && isBorrowed[j] == false) {
					isBorrowed[j] = true;
					answer += 1;
					break;
				// 뒷 번호 학생이 여분의 옷을 빌려줄 수 있는 경우
				} else if ((lost[i] == reserve[j] + 1) && isBorrowed[j] == false) {
					isBorrowed[j] = true;
					answer += 1;
					break;
				}
			}
		}

		return answer;
	}

}
