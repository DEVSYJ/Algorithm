package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
public class _154538 {
	public static void main(String[] args) {
		System.out.println(solution(10, 40, 5));
		System.out.println(solution(10, 40, 30));
		System.out.println(solution(2, 5, 4));
	}

	/**
	 * bfs -> q 사용
	 *
	 * @param x
	 * @param y
	 * @param n
	 * @return
	 */
	public static int solution(int x, int y, int n) {
		// y의 최대값은 1_000_000, *3까지 되므로 넉넉히 3백만으로 (배열은 0부터 시작하니 3000001)
		boolean[] isChecked = new boolean[3_000_001];

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, 0));

		while (!q.isEmpty()) {
			Node c = q.poll();
			if (c.x == y) {
				return c.count;
			}
			if (!isChecked[c.x + n] && c.x + n <= 1_000_000) {
				isChecked[c.x + n] = true;
				q.add(new Node(c.x + n, c.count + 1));
			}
			if (!isChecked[c.x * 2] && c.x * 2 <= 1_000_000) {
				isChecked[c.x * 2] = true;
				q.add(new Node(c.x * 2, c.count + 1));
			}
			if (!isChecked[c.x * 3] && c.x * 3 <= 1_000_000) {
				isChecked[c.x * 3] = true;
				q.add(new Node(c.x * 3, c.count + 1));
			}
		}

		return -1;
	}

	static class Node {
		int x;
		int count;

		public Node(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
}
