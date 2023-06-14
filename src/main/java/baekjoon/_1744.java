package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> negatives = new PriorityQueue<>();
		boolean existZero = false;
		PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number < 0) {
				negatives.add(number);
			} else if (number == 0) {
				existZero = true;
			} else {
				positives.add(number);
			}

		}
		br.close();

		System.out.println(solution(negatives, existZero, positives));
	}

	private static int solution(PriorityQueue<Integer> negatives, boolean existZero, PriorityQueue<Integer> positives) {
		int result = 0;

		while (!negatives.isEmpty()) {
			Integer first = negatives.poll();
			Integer second = negatives.poll();
			if (second == null) {
				// first만 존재
				// 0과 곱해 음수 제거 가능
				if (!existZero) {
					result += first;
				}
				break;
			}

			result += first * second;
		}

		while (!positives.isEmpty()) {
			Integer first = positives.poll();
			Integer second = positives.poll();

			if (second == null) {
				result += first;
				break;
			}

			if (first == 1 || second == 1) {
				result += first + second;
				continue;
			}

			result += first * second;
		}

		return result;
	}
}
