package lifeBoat;

public class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;

		// 구출 여부를 저장하는 boolean 배열
		boolean[] isSaved = new boolean[people.length];

		// 0번 인덱스부터 검사 시행
		for (int i = 0; i < people.length; i++) {
			// 최대한 제한 무게에 가깝게 태우기 위한 변수 설정. 초기값 -1. 
			int maxIndex = -1;
			// i 인덱스 사람이 구출이 안 된 경우에만 검사 시행
			if (isSaved[i] == false) {
				for (int j = i + 1; j < people.length; j++) {
					// j 인덱스 사람이 구출 안 된 경우에만 검사 시행
					if (isSaved[j] == true) {
						continue;
						// i와 j의 합이 제한 무게 이하인 경우 
					} else if (people[i] + people[j] <= limit) {
						// 만약 j가 처음으로 조건에 충족한 경우, 
						if (maxIndex == -1) {
							maxIndex = j;
						// 앞서 조건을 만족한 사람이 있지만, 해당 j가 제한 무게에 더 가까운 경우,
						} else if (people[i] + people[maxIndex] < people[i] + people[j]) {
							maxIndex = j;
						}
					}
				}
				// i 인덱스와 함께 태울 수 있는 사람이 있는 경우, 둘 모두 true 저장 
				if (maxIndex != -1) {
					isSaved[i] = true;
					isSaved[maxIndex] = true;
					answer++;
				// i 사람과 함께 태울 수 있는 사람이 없는 경우, i만 true 저장
				} else {
					isSaved[i] = true;
					answer++;
				}
			// 구출이 이미 된 경우 검사 건너 뛰기
			} else {
				continue;
			}
		}
		return answer;
	}
}
