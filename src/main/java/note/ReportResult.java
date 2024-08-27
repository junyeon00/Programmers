package note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // report를 HashSet 으로 만들어서 중복 제거
        HashSet<String> reportSet = new HashSet<>();
        for (String rep : report)
            reportSet.add(rep);

        // notifyListHash를 만들어 key 에는 reportee, value 에는 reporter
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for(String rep : reportSet){
            int blankIdx = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIdx);
            String reportee = rep.substring(blankIdx+1);

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if(reporterList == null) reporterList = new ArrayList<>();

            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }

        // k보다 많이 신고 당한 계정을 신고한 계정을 담는 reporterHash 생성
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for(ArrayList<String> notifyList : notifyListHash.values())
            if(notifyList.size() >= k)
                for(String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);

        // reporterHash 에서 answer 배열로 값 옮겨담기
        for(int i=0; i<id_list.length; i++)
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);

        return answer;
    }

    public static void main(String[] args) {
        ReportResult rr = new ReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        String answer = Arrays.toString(rr.solution(id_list, report, k));
        System.out.println(answer);
    }
}