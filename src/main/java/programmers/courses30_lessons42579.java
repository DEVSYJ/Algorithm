package programmers;

import java.util.*;

// TODO : PROGRAMMERS 사이트에서는 채점이 제대로 안됨 ㅠㅠ
// https://programmers.co.kr/learn/courses/30/lessons/42579
/*
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
genres	plays	return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */
public class courses30_lessons42579 {
    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 600, 150, 800, 2500};

    static HashMap<String, Integer> genresTotalPlays;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static class GenrePlays implements Comparable<GenrePlays> {
        String genres;
        int plays;
        int number;

        public GenrePlays(String genres, int plays, int number) {
            this.genres = genres;
            this.plays = plays;
            this.number = number;
        }

        @Override
        public int compareTo(GenrePlays o) {
            int genresDiff = genresTotalPlays.get(genres).compareTo(genresTotalPlays.get(o.genres));
            if (genresDiff == 0) {
                return plays - o.plays;
            }

            return genresDiff;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 장르 별 총 재생 횟수
        // 장르 중에서 노래 별 총 재생 횟수 TOP 2

        // 모든 책을 훑었을 떄,
        // 장르의 개수
        // 장르의 총 재생 횟수 를 알 수 있다
        // 0. HashMap 으로 장르 별 총 재생 횟수 {장르, 장르 총 재생 횟수}

        // 1. 장르, 플레이 횟수, 고유 번호를 넣어서 객체로 변경
        // 2. 객체 리스트를 장르의 총 재생 횟수, 곡의 플레이 횟수로 정렬
        // 3. 이걸 어떻게 top 2만 뽑을 것이냐....


        genresTotalPlays = new HashMap<>();
        GenrePlays[] genrePlays = new GenrePlays[genres.length];
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            genrePlays[i] = new GenrePlays(genre, playCount, i);

            if (!genresTotalPlays.containsKey(genre)) {
                genresTotalPlays.put(genre, playCount);
            } else {
                genresTotalPlays.replace(genre, genresTotalPlays.get(genre) + playCount);
            }
        }

        Arrays.sort(genrePlays, Collections.reverseOrder());

        List<Integer> answer = new ArrayList<>();

        String checkGenre = genrePlays[0].genres;
        int checkNum = 0;

        for (GenrePlays genrePlay:genrePlays) {
            if (checkNum == 2) {
                if(checkGenre == genrePlay.genres) {
                    continue;
                } else {
                    checkNum = 0;
                    checkGenre = genrePlay.genres;
                }
            }

            if (checkNum < 2 && checkGenre == genrePlay.genres) {
                answer.add(genrePlay.number);

                checkNum++;
            }
        }

        int[] answerArray = answer.stream().mapToInt(i->i).toArray();
        return answerArray;
    }
}