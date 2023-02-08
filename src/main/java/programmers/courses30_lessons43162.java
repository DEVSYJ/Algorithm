package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class courses30_lessons43162 {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}

	public static int solution(int n, int[][] computers) {
		// key = 가장 먼저 체크된 computer
		// value = key computer 에 연결된 computerSet
		Map<Integer, Set<Integer>> networkMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (computers[i][i] == 1) {
				Queue<Integer> checkQueue = new LinkedList<>();
				checkQueue.add(i);
				Set<Integer> set = checkNetworkComputer(checkQueue, n, computers);
				networkMap.put(i, set);
			}
		}

		return networkMap.size();
	}

	/**
	 * @param checkQueue
	 * @param computers 전체 컴퓨터 연결 상태 배열
	 * @return checkQueue 에 연관된 computer Set return
	 */
	private static Set<Integer> checkNetworkComputer(Queue<Integer> checkQueue, int n, int[][] computers) {
		Set<Integer> result = new HashSet<>();
		while (!checkQueue.isEmpty()) {
			Integer i = checkQueue.poll();

			for (int j = 0; j < n; j++) {

				if (computers[i][j] == 1) {
					result.add(j);
					computers[i][j] = 0;
					computers[j][i] = 0;

					if (i == j) {
						continue;
					}

					checkQueue.add(j);
				}
			}
		}

		return result;
	}
}
