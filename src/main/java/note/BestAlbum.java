package note;

import java.util.*;
import java.util.stream.Stream;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        // 각 장르에 속한 곡들 저장하는 해쉬맵 genreMap 생성
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        // 각 장르의 총 재생 수 저장하는 해쉬맵 playMap 생성
        HashMap<String, Integer> playMap = new HashMap<>();

        for(int i =0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            // genreMap에 해당 장르가 없으면 초기화
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            // 해당 장르의 곡 정보를 genreMap에 저장
            genreMap.get(genre).add(new int[]{i, play});
            // 재생한 곡의 횟수 추가
            playMap.put(genre, playMap.get(genre)+play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 총 재생 수를 기준으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream()
                .sorted((o1, o2)->Integer.compare(o2.getValue(), o1.getValue()));

        // 각 장르별로 상위 두 곡의 인덱스를 answer에 추가
        sortedGenre.forEach(entry->{
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                    .sorted((o1,o2)->Integer.compare(o2[1], o1[1])).limit(2);
            sortedSongs.forEach(song->answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = bestAlbum.solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
}