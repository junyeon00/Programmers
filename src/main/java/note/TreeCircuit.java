package note;

public class TreeCircuit {
    // 전위순회
    public static String preorder(int[] nodes, int idx){
        if(idx >= nodes.length)
            return "";

        return nodes[idx] + " " + preorder(nodes, 2*idx+1)
                + preorder(nodes, 2*idx+2);
    }

    // 중위순회
    public static String inorder(int[] nodes, int idx){
        if(idx >= nodes.length)
            return "";

        return inorder(nodes, 2*idx+1) + nodes[idx] + " "
                + inorder(nodes, 2*idx+2);
    }

    // 후위순회
    public static String postorder(int[] nodes, int idx){
        if(idx >= nodes.length)
            return "";

        return postorder(nodes, 2*idx+1) + postorder(nodes, 2*idx+2)
                + nodes[idx] + " ";
    }

    public static String[] solution(int[] nodes){
        String[] answer = new String[3];
        answer[0] = preorder(nodes, 0);
        answer[1] = inorder(nodes, 0);
        answer[2] = postorder(nodes, 0);

        return answer;
    }

    public static void main(String[] args) {
        TreeCircuit tc = new TreeCircuit();
        int[] nodes = {1,2,3,4,5,6,7};
        String[] answer = tc.solution(nodes);
        for(String s : answer)
            System.out.println(s);
    }
}