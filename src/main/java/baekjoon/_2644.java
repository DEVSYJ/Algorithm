package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2644 {
	private static int theX;
	private static int theY;
	private static Stack<CheckData> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] questionLine = br.readLine().split(" ");
		theX = Integer.parseInt(questionLine[0]) - 1;
		theY = Integer.parseInt(questionLine[1]) - 1;

		int m = Integer.parseInt(br.readLine());

		// 1이면 연결 (1촌)
		int[][] relation = new int[n][n];

		String[] relationLine;
		for (int i = 0; i < m; i++) {
			relationLine = br.readLine().split(" ");
			relation[Integer.parseInt(relationLine[0]) - 1][Integer.parseInt(relationLine[1]) - 1] = 1;
			relation[Integer.parseInt(relationLine[1]) - 1][Integer.parseInt(relationLine[0]) - 1] = 1;
		}
		br.close();

		if (relation[theX][theY] == 1) {
			System.out.println(1);
		} else {
			stack.push(new CheckData(relation.clone(), theX, 0));
			while (!stack.empty()) {
				checkKinship(stack.pop());
			}
		}
	}

	private static void checkKinship(CheckData checkData) {
		if (checkData.checkY == theY) {
			System.out.println(checkData.now);
			stack.clear();
			return;
		}

		for (int i = 0; i < checkData.relation.length; i++) {
			// System.out.println("visit (" + checkData.checkY + "," + i + ")");
			if (checkData.relation[checkData.checkY][i] == 1) {
				checkData.relation[checkData.checkY][i] = -1;
				checkData.relation[i][checkData.checkY] = -1;
				stack.push(new CheckData(checkData.relation.clone(), i, checkData.now + 1));
			}
		}

		if(stack.empty()) {
			System.out.println(-1);
		}
	}

	private static class CheckData {
		int[][] relation;
		int checkY;
		int now;

		public CheckData(int[][] relation, int checkY, int now) {
			this.relation = relation;
			this.checkY = checkY;
			this.now = now;
		}
	}
}

/*
9
7 9
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */
