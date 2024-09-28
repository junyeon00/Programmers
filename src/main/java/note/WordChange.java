package note;

public class WordChange {
    public int solution(String s) {
        while(s.contains("zero") || s.contains("one") || s.contains("two") || s.contains("three")
        || s.contains("four") || s.contains("five") || s.contains("six")
        || s.contains("seven") || s.contains("eight") || s.contains("nine")){
            if(s.contains("zero"))
                s = s.replace("zero", "0");
            else if(s.contains("one"))
                s = s.replace("one", "1");
            else if(s.contains("two"))
                s = s.replace("two", "2");
            else if(s.contains("three"))
                s = s.replace("three", "3");
            else if(s.contains("four"))
                s = s.replace("four", "4");
            else if(s.contains("five"))
                s = s.replace("five", "5");
            else if(s.contains("six"))
                s = s.replace("six", "6");
            else if(s.contains("seven"))
                s = s.replace("seven", "7");
            else if(s.contains("eight"))
                s = s.replace("eight", "8");
            else if(s.contains("nine"))
                s = s.replace("nine", "9");
        }

        int answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        WordChange wc = new WordChange();
        String s = "oneoneseveneight";
        System.out.println(wc.solution(s));
    }
}