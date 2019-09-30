package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int answer = 1;
		answer *= factorial(N);
		
		out.write(answer + "");
		out.close();

	}

	static int factorial(int n) {
		if (n <= 1) return 1;
		else return n * factorial(n - 1);
	}

}
