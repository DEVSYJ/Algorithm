package programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42840
/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.

=================================

테스트 1 〉	통과 (0.02ms, 75.7MB)
테스트 2 〉	통과 (0.02ms, 74.9MB)
테스트 3 〉	통과 (0.01ms, 76.6MB)
테스트 4 〉	통과 (0.03ms, 74MB)
테스트 5 〉	통과 (0.02ms, 80.9MB)
테스트 6 〉	통과 (0.03ms, 79.7MB)
테스트 7 〉	통과 (0.41ms, 77.6MB)
테스트 8 〉	통과 (0.15ms, 76.5MB)
테스트 9 〉	통과 (0.74ms, 80.2MB)
테스트 10 〉	통과 (0.26ms, 74.5MB)
테스트 11 〉	통과 (0.51ms, 72.8MB)
테스트 12 〉	통과 (0.45ms, 78.1MB)
테스트 13 〉	통과 (0.04ms, 77.1MB)
테스트 14 〉	통과 (0.48ms, 78.5MB)
 */
public class courses30_lessons42840 {
    static int[] answer1 = {1,2,3,4,5};
    static int[] answer2 = {1,3,2,4,2};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(answer1)));
        System.out.println(Arrays.toString(solution(answer2)));
    }

    public static int[] solution(int[] answers) {
        int[] result = new int[0];

        int[] supo1pick = {1,2,3,4,5};
        int[] supo2pick = {2,1,2,3,2,4,2,5};
        int[] supo3pick = {3,3,1,1,2,2,4,4,5,5};

        int supo1right = 0;
        int supo2right = 0;
        int supo3right = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            if (answer == supo1pick[i%5]) {
                supo1right++;
            }
            if (answer == supo2pick[i%8]) {
                supo2right++;
            }
            if (answer == supo3pick[i%10]) {
                supo3right++;
            }
        }

        if (supo1right > supo2right) {
            // 1>2
            if (supo1right > supo3right) {
                // 1>2?3
                result = new int[]{1};
            } else if (supo1right == supo3right) {
                // 1=3>2
                result = new int[]{1,3};
            } else if (supo1right < supo3right) {
                // 3>1>2
                result = new int[]{3};
            }
        } else if (supo1right == supo2right) {
            // 1=2
            if (supo1right > supo3right) {
                // 1=2>3
                result = new int[]{1,2};
            } else if (supo1right == supo3right) {
                // 1=3=2
                result = new int[]{1,2,3};
            } else if (supo1right < supo3right) {
                // 3>1=2
                result = new int[]{3};
            }
        } else {
            // 2>1
            if (supo2right > supo3right) {
                // 2>1?3
                result = new int[]{2};
            } else if (supo2right == supo3right) {
                // 2=3>1
                result = new int[]{2,3};
            } else if (supo2right < supo3right) {
                // 3>2>1
                result = new int[]{3};
            }
        }

        // 리턴할 때 이미 정렬된 상태로 셋팅하기 때문에 정렬 필요 없음.
        // Arrays.sort(result);
        return result;
    }
}
