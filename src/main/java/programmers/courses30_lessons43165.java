package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/43165
/*
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
입출력 예 설명
문제에 나온 예와 같습니다.
 */
public class courses30_lessons43165 {
    static int[] testNumbers1 = {1, 1, 1, 1, 1};
    static int testTarget1 = 3;
    static int[] testNumbers2 = {1, 1, 1};
    static int testTarget2 = 1;

    public static void main(String[] args) {
        System.out.println(solution(testNumbers1, testTarget1));
        System.out.println(solution(testNumbers2, testTarget2));
    }

    public static int solution(int[] numbers, int target) {
        /*
        생각보다 제한사항이 널널함. 사실상 완탐 가능!
        재귀를 연습해보자. 스택보다는..?
         */

        /*
        시간 복잡도 및 타입 오버플로우 체크
        개수 최대 20개
        크기 최대 50
        > 아무리 커도 1000 이상 넘어가지 않음
         */

        return recursiveCall(0, numbers,0, target);
    }

    public static Integer recursiveCall(int index, int[] numbers, int currentSum, int target) {
        System.out.println("index : " + index);
        System.out.println("currentSum : " + currentSum);
        System.out.println();

        // 한개의 input은 두개의 +,- output이 될 수 있음
        if (index == numbers.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }

        return
            recursiveCall(index + 1, numbers, currentSum + numbers[index], target) +
            recursiveCall(index + 1, numbers, currentSum - numbers[index], target);
    }
}
