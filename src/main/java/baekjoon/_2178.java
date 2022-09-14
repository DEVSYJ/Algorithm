package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/2178
 */
public class _2178 {
	private static int[][] array;
	private static int n;
	private static int m;
	private static Queue<Node> q = new LinkedList<>();

	static class Node {
		int x;
		int y;
		int movement;

		public Node(int x, int y, int movement) {
			this.x = x;
			this.y = y;
			this.movement = movement;
		}
	}

	// (0,0)에서 (n-1, m-1) 로 가는 최단거리
	private static int bfs() {
		while (!q.isEmpty()) {
			Node checkNode = q.poll();

			if (checkNode.x == n - 1 && checkNode.y == m - 1) {
				return checkNode.movement;
			}

			if (checkNode.x < 0 || checkNode.y < 0 || checkNode.x == n || checkNode.y == m) {
				continue;
			}

			// 갈 수 없는 노드 || 이미 체크한 노드
			if (array[checkNode.x][checkNode.y] == 0 || array[checkNode.x][checkNode.y] == -1) {
				continue;
			}

			if (array[checkNode.x][checkNode.y] == 1) {
				array[checkNode.x][checkNode.y] = -1;
				q.add(new Node(checkNode.x - 1, checkNode.y, checkNode.movement + 1));
				q.add(new Node(checkNode.x + 1, checkNode.y, checkNode.movement + 1));
				q.add(new Node(checkNode.x, checkNode.y - 1, checkNode.movement + 1));
				q.add(new Node(checkNode.x, checkNode.y + 1, checkNode.movement + 1));
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);

		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}

		// input 체크용
		/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		*/

		q.add(new Node(0,0, 1));

		System.out.println(bfs());
	}
}
