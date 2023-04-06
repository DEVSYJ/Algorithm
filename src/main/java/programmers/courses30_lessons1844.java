package programmers;

import java.util.LinkedList;
import java.util.Queue;

// courses/30/lessons/1844
public class courses30_lessons1844 {

	public static void main(String[] args) {
		System.out.println(solution(
			new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
		System.out.println(solution(
			new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
	}

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	//0이 있는거 1이 벽 없는거
	public static int solution(int[][] maps) {
		boolean[][] visited = new boolean[maps.length][maps[0].length];

		return bfs(maps, visited, new Node(0, 0, 1));
	}

	private static int bfs(int[][] maps, boolean[][] visited, Node now) {
		Queue<Node> q = new LinkedList();
		q.add(now);
		visited[now.x][now.y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();   // (0, 0) 1

			// 종료 조건
			if (node.x == maps.length - 1 && node.y == maps[0].length - 1) {
				return node.count;
			}

			// 동 -> (1, 0)
			// 서 -> (-1, 0)
			// 남 -> (0, 1)
			// 북 -> (0, -1)
			for (int i = 0; i < 4; i++) {
				int moveX = node.x + dx[i];
				int moveY = node.y + dy[i];

				// map 범위 예외처리
				if (moveX < 0 || moveY < 0 || moveX > maps.length - 1 || moveY > maps[0].length - 1) {
					continue;
				}

				// 이미 가본 곳 예외처리
				if (visited[moveX][moveY]) {
					continue;
				}

				// 벽 예외처리
				if (maps[moveX][moveY] == 0) {
					continue;
				}

				q.add(new Node(moveX, moveY, node.count + 1));
				visited[moveX][moveY] = true;
			}
		}

		return -1;
	}

	static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

