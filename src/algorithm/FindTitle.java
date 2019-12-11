/*
문제: 정사각형
출처: 구름 코딩
날짜: 2019-12-08

[문제 설명]
신인 작가 동이는 자신이 프로그래밍을 공부했던 경험과 노하우를 실어 초보 프로그래머들을 위한 가이드북의 초고를 완성했다. 
출판사와의 회의를 통해 책의 출판이 결정되었고, 동이는 자신의 첫 책에 의미있는 제목을 지어주려고 한다. 
책 제목에 대한 영감을 얻기 위해 방문한 IT 전문 도서관 '라이브러리즈'에는 책들이 수평방향으로 한 줄에 정렬되어 있었다. 
모든 책의 제목은 알파벳 대문자로 이루어져 있었으며 모든 책들은 사전순으로 정렬되어 있었다. 
대부분의 도서관이 그러하듯 라이브러리즈에서도 책들을 첫 알파벳 글자를 기준으로 구간을 나누고는 한다. 
동이는 책 제목의 첫 글자가 무엇이 되느냐가 자신의 책이 얼마나 눈에 띄게 될 지를 결정할 수 있다는 사실을 발견했다. 
동이는 사람들이 주로 책장의 책들을 바라보는 위치와 각도를 수집하여 각 위치에서 가장 많은 책들이 제목의 첫 글자로 사용한 알파벳은 무엇인지 조사하고자 한다. 

사전순으로 정렬된 책들의 제목의 첫 글자가 모두 주어질 때 동이가 바라본 구간에서 제목의 첫 글자로 가장 많이 등장한 알파벳을 계산하는 프로그램을 작성해주자.

[입력]
첫 줄에는 두 자연수가 N Q형식으로 주어진다.
- N은 전시되어 있는 책의 권 수를 나타내는 10만이하의 자연수이다.
- Q는 동이가 조사 할 구간의 수를 나타내는 20만이하의 자연수이다.

두 번째 줄에는 책들이 놓여진 순서대로 각 책의 첫 글자만을 이어붙여 만든 N글자의 문자열이 주어진다.
- 문자열은 정확히 N글자이며 알파벳 대문자로만 구성되어 있다.
- 모든 알파벳은 왼쪽에서 오른쪽으로 사전순으로 정렬되어 있다.
- 가장 왼쪽부터 1, 2, 3, ... , N번으로 책에 번호를 붙인다. 

이후 총 Q줄에 걸쳐서 동이가 조사하고자 하는 구간에 대한 정보가 각 줄에 두 자연수로 주어진다.
- 각 줄은 L R형식의 두 자연수로 구성된다. L은 항상 R이하의 값을 가진다. 
- L은 동이가 조사하고자 하는 연속된 구간에서 왼쪽 끝에 있는 책의 번호를 나타낸다.
- R은 동이가 조사하고자 하는 연속된 구간에서 오른쪽 끝에 있는 책의 번호를 나타낸다.

[출력]
동이가 조사하고자 하는 Q개의 구간에 대하여 각각 한 줄에 정답을 출력한다. 
해당 구간에서 책 제목의 첫 글자로 가장 많이 등장한 알파벳을 출력한다.
등장 횟수가 같은 알파벳이 여러개라면 사전순으로 가장 앞서는 알파벳을 출력한다.

[입력 예시]
30 5
AAAAABBBBBBCDDEFIJLMPQRSTUVWYZ
11 12
7 24
12 23
13 29
1 19

[출력 예시]
B
B
D
D
B

*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FindTitle {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] NQ = br.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);
		int Q = Integer.parseInt(NQ[1]);
		
		// 책의 첫 글자 목록 
		char[] books = br.readLine().toCharArray();
		
		for(int i = 0; i < Q; i++) {
			String[] LR = br.readLine().split(" " );
			// 배열은 0부터 시작하므로 책 번호에서 1을 빼서 넣어 줌.
			int L = Integer.parseInt(LR[0]) - 1;	
			int R = Integer.parseInt(LR[1]) - 1;
			int[] count = new int[26];
			
			// L번째부터 R번째까지 책의 첫 글자 count
			for(int j = L; j <= R; j++) {
				char nowChar = books[j];
				count[nowChar - 'A']++;
			}
			
			int maxValue = 0;
			int maxIndex = 0;
			for(int j = 0; j < 26; j++) {
				if(maxValue < count[j]) {
					maxIndex = j;
					maxValue = count[j];
				}
			}
			char answer = (char) ('A' + maxIndex);
			bw.write(answer + "\n");
			bw.flush();
		}	
		br.close();
		bw.close();
	}
}

