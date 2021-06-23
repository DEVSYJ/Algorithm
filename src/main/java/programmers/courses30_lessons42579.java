package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    static class Song {
        int number; // 고유 번호
        String genre;
        int playCount;

        Song(int number, String genre, int playCount) {
            this.number = number;
            this.genre = genre;
            this.playCount = playCount;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        // 장르 별 플레이 횟수 합
        Map<String, Integer> genrePlayCountSum = new HashMap<>();
        // Song은 2개만..
        Map<String, List<Song>> top2SongList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer playCount = plays[i];

            // 장르 별 플레이 횟수 계산
            if (!genrePlayCountSum.containsKey(genre)) {
                genrePlayCountSum.put(genre, playCount);
            } else {
                genrePlayCountSum.replace(genre, genrePlayCountSum.get(genre) + playCount);
            }

            // 장르 별 top 2 곡 선정
            List<Song> songList;

            if (!top2SongList.containsKey(genre)) {
                songList = new ArrayList<>();
                songList.add(new Song(i, genre, playCount));

            } else {
                songList = top2SongList.get(genre);

                if (songList.size() == 1) {
                    songList.add(new Song(i, genre, playCount));
                } else {
                    if (songList.get(1).playCount < playCount) {
                        songList.remove(1);
                        songList.add(new Song(i, genre, playCount));
                    }
                }

                if (songList.get(0).playCount < playCount) {
                    Collections.swap(songList, 0, 1);
                }

            }

            top2SongList.put(genre, songList);
        }

        List<String> sortedGenreKeySetByPlays = new ArrayList<>(genrePlayCountSum.keySet());
        sortedGenreKeySetByPlays.sort((o1, o2) -> genrePlayCountSum.get(o2) - genrePlayCountSum.get(o1));

        List bestSongList = new ArrayList<Integer>();
        System.out.println(sortedGenreKeySetByPlays);
        for (int i = 0; i < sortedGenreKeySetByPlays.size(); i++) {
            String genre = sortedGenreKeySetByPlays.get(i);
            List<Song> songList = top2SongList.get(genre);
            for (int j = 0; j < songList.size(); j++) {
                System.out.println("genre : " + genre + " / number : " + songList.get(j).number);
                bestSongList.add(songList.get(j).number);
            }
        }


        answer = bestSongList.stream().mapToInt(i -> (int) i).toArray();;
        return answer;
    }
}