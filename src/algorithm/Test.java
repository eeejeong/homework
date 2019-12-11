/*
문제: 컴포넌트 개수 
출처: 케이코딩

[문제 설명]
어떤 회사의 한 공장에서는 여러 가지 다양한 제품들을 제품들을 생산하고 있다.
이 공장에서 생산되는 제품들은 여러 가지 컴포넌트를 조립하여 생산이 되며 이 컴포넌트들은 다시 부품을 조립하여 만들 수 있다.
즉 한 컴포넌트는 여러 가지 부품들을 조립하여 만들어 지며 한 제품은 부품들을 조립하여 만든 컴포넌트들을 다시 조립하여 만들게 된다.
이 공장은 부품의 고유식별 문자가 A 부터 Z 까지의 부품들을 공급받아
이 부품들로 다양하게 조합하여 만들 수 있는 컴포넌트와 제품을 생산하고 있다

한 컴포넌트의 조립에 필요한 부품 문자열이 조립 순으로 주어지고 또한 임의의 부품 문자열이 주어질 때
임의의 부품 문자열로 해당 컴포넌트를 생산 가능한지 여부는 다음과 같이 판단 가능하다.

조립공정의 특성 상 두 부품 문자열을 비교하여 첫 부품 문자와 마지막 부품 문자가 각각 같고
그 사이의 부품 문자는 종류와 그 개수가 같을 때 임의의 부품 문자열로 해당 컴포넌트를조립 가능하다고 판단한다.

가령 A 컴포넌트에 필요한 6 개 부품의 문자열이 조립 순으로 EEDHIA 이라고 할 때
EHIEDA 이라는 부품 문자열은 A 컴포넌트를 생산 가능 하다고 할 수 있지만 FEDHIA, EDDHIA, EEDBIA 등의
부품 문자열로는 A 컴포넌트를 생산할 수 없다고 판단할 수 있다.

이 공장에서 어떤 제품을 생산하기 위해 필요한 컴포넌트의 개수와 컴포넌트 별 필요한 부품 문자가 조립 순서대로 주어진 후 
컴포넌트 별 임의의 부품 문자의 열이 주어질 때 
임의의 부품 문자열로 만들 수 있는 컴포넌트의 개수를 출력하는 프로그램을 작성하시오.

[입력]
첫 줄에 테스트 케이스의 수 T 가 주어지며 다음 줄부터 T 개의 테스트 케이스가 주어진다.
각 테스트 케이스는 3줄로 구성이 되며 첫 줄에는 제품생산에 필요한 컴포넌트의 수 N이 주어진다.
다음 줄에는 각 컴포넌트 별로 생산에 필요한 부품 문자열이 공백으로 구분되어 주어지며
그 다음 줄에는 이전 줄과 같은 컴포넌트 컴포넌트 순서로 임의의 부품 문자열이 공백으로 구분되어 주어진다.    
단, N은 1이상 20이하의 자연수이다.

[출력]
각 줄은 #x 로 시작하고(x 는 테스트케이스 번호) 공백을 하나 둔 다음,
임의의 부품 문자열로 만들 수 있는 컴포넌트의 개수를 출력한다.

[입력 예시]
4
4
WUNYO EKHSLDK WNQRT MRTDN WNUYO AKHLSDD WNQRT MRTTN 4
VTKROS VHSNIYERK QIPJMMI MLPI
BTABED VSIYNREIK QPMJIMI MPLI
5
PXWXLMGI MSDTIXOJS GYJYTDEN AHQV VPHUMUIWE
PYWXMGLI MSDTIXOJU GYYEDTJN AQHV VHPMUIUWE
6
TRNMU PYES NEYTILM FAKPP MNRV EAYDI
TNRMU PEYS NTEYMIM FPAKQ MRRV EDAYI

[출력 예시]
#1 2
#2 2
#3 3
#4 3
 */
package algorithm;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 첫 줄에는 테스트케이스 T가 주어진다
		// int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {		
			// 제품생산에 필요한 컴포넌트의 수 N
			//int N = Integer.parseInt(br.readLine());
			int N = sc.nextInt();
			
			// 답 
			int answer = 0;
			
			// 각 컴포넌트 별로 생산에 필요한 부품 문자열이 공백으로 구분
			// String[] required = br.readLine().split(" ");
			String[] required = new String[N];
			
			// 이전 줄과 같은 컴포넌트 컴포넌트 순서로 임의의 부품 문자열이 공백으로 구분
			// String[] component = br.readLine().split(" ");
			String[] component = new String[N];
						
			
			for(int j = 0; j < N; j++) {
				required[j] = sc.next();
			}
			
			for(int j = 0; j < N; j++) {
				component[j] = sc.next();
			}
						
			// 검사 시작
			for(int j = 0; j < N; j++) {
				String nowRequired = required[j];
				String nowComponent = component[j];
				
				// 1. 첫 부품 문자와 마지막 부품 문자가 각각 같은가
				int lastIndex = nowRequired.length() - 1;
				if(nowRequired.charAt(0) == nowComponent.charAt(0) &&
						nowRequired.charAt(lastIndex) == nowComponent.charAt(lastIndex)) {
					// 2. 그 사이의 부품 문자는 종류와 그 개수가 같은가					
					// 필요한 문자의 종류와 개수 저장
					HashMap<Character, Integer> hashRequired = new HashMap<>();									
					for(int k = 1; k < lastIndex; k++) {
						char nowRequiredChar = nowRequired.charAt(k);
						
						// 필요한 부품의 문자 부품 종류와 개수 저장
						if(hashRequired.containsKey(nowRequiredChar)) {
							hashRequired.put(nowRequiredChar, hashRequired.get(nowRequiredChar) + 1);
						}
						else {
							hashRequired.put(nowRequiredChar, 1);
						}														
					}
					
					// 컴포넌트의 문자 부품 종류와 개수 비교해서 해쉬맵 반영
					boolean test = true;
					
					for(int k = 1; k < lastIndex; k++) {
						char nowComponentChar = nowComponent.charAt(k);						
						if(hashRequired.containsKey(nowComponentChar)) {
							hashRequired.put(nowComponentChar, hashRequired.get(nowComponentChar) - 1);
							if(hashRequired.get(nowComponentChar) < 0) {
								test = false;
								break;
							}						
						}
						else {
							test = false;
							break;
						}
					}
					
					if(test) {
						for (Character key : hashRequired.keySet() ) {
						   if(hashRequired.get(key) != 0) {
							   test = false;
						   }
						}
					}
					
					if(test) {					
						answer++;
					}
				}				
			}
			//System.out.println("#" + (i + 1) + " " + answer);
			bw.write("#" + Integer.toString(i + 1) + " " + Integer.toString(answer) + "\n");			
		}
		
		bw.flush();
		bw.close();
		
	}
}

