/*
문제: 정사각형
출처: 구름 코딩
날짜: 2019-12-08

[문제 설명]
개발자 동이는 모바일 전략게임 구름크래프트를 제작하고 있는 개인 개발자이다. 
구름크래프트는 다양한 요소로 승패가 결정될 수 있는 전략게임으로서 각 플레이어는 전략적 요충지를 선택해 방어선을 구축하고 상대를 공격하는 방식으로 게임이 진행된다.
하지만 구름크래프트는 사용자간의 대결이 기본이 되는 게임이다보니 사용자가 적은 초기에는 대전 상대를 찾기가 쉽지 않은게 현실이다. 
그래서 동이는 사용자들이 혼자서도 플레이할 수 있도록 인공지능 플레이어를 제작하여 싱글플레이기능을 만들고자 한다. 
인공지능 플레이어는 여러가지 컨셉 중 하나를 임의로 선택하여 주어진 방식대로 플레이를 하게된다. 

동이는 이번에는 항상 네 요충지를 선택해 정사각형 모양의 방어선을 구축하는 인공지능을 개발하고자 하는데, 
인공지능이 후보지로 현재 자신의 시야에 있는 네개의 요충지를 모서리로 하여 만들 수 있는 가장 큰 크기의 정사각형을 방어선으로 구축하고자 한다. 
하지만 다른 기능의 디버깅을 아직 끝내지 못한 동이는 당신에게 이 기능의 개발을 도와달라고 부탁하였다. 동이를 도와주자.

[입력]
첫 줄에는 현재 인공지능이 선택할 수 있는 전략적 요충지의 수 N이 4와 50사이의 자연수로 공백없이 주어진다.
그 후 총 N줄에 걸쳐서 한 줄에 하나의 요충지의 위치가 X Y 순서로 공백으로 구분된 좌표 형태로 주어진다. 
모든 좌표는 0~1,000사이의 정수이다. 모든 좌표는 서로 다르다.
항상 하나 이상의 정사각형은 만들 수 있는 데이터가 주어진다.

[출력]
네 개의 요충지를 모서리로하여 만들 수 있는 가장 큰 정사각형의 넓이를 소수점 세번째 자리에서 반올림하여 둘째자리까지 출력한다.

[입력 예시]
5
0 2
2 0
2 2
0 0
1 1

[출력 예시]
4.00

 */
package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MakeSquare {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		double answer = 0.0;
		int[][] coordinates = new int[N][2];
		
		// 주어진 좌표 저장
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			coordinates[i][0] = Integer.parseInt(input[0]);
			coordinates[i][1] = Integer.parseInt(input[1]);
		}
		
		ArrayList<Double> distances = new ArrayList<>();
		
		// 검사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				distances.add(getDistance(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]));
			}
			
			boolean candidate = false;
			double dist = 0.0;
			for(int j = 0; j < distances.size(); j++) {
				for(int k = j; k < distances.size(); k++) {
					if(distances.get(j) == distances.get(k)) {
						candidate = true;
						dist = distances.get(j);
					}
				}
				if(candidate) {
					for(int k = 0; k < distances.size(); k++) {
						if(distances.get(k) == dist * Math.sqrt(2)) {
							if(answer < dist * dist) {
								answer = dist * dist;
							 }
						}
					}
				}
			}
			distances.clear();
		}
		
		bw.write(Math.round(answer * 100) / 100.0 + "\n");
		bw.flush();

		br.close();
		bw.close();
	}

	// 두 좌표 사이의 거리 구하기
	public static double getDistance(int x1, int y1, int x2, int y2) {
		double distance = Math.sqrt(Math.pow(Math.abs(x1 - x1), 2) + Math.pow(Math.abs(y1 - y2), 2));
		return distance;
	}

}
