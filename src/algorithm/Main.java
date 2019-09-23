/*
5
1 1
2 3
3 4
9 8
5 2

Case #1: 1 + 1 = 2
Case #2: 2 + 3 = 5
Case #3: 3 + 4 = 7
Case #4: 9 + 8 = 17
Case #5: 5 + 2 = 7
*/

package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = in.readLine();
		str = str.trim();
		String[] arr = str.split(" ");
		if (arr[0].equals("")) {
			out.write(String.valueOf(0));
		} else {
			out.write(String.valueOf(arr.length));
		}
		out.close();
	}
}
