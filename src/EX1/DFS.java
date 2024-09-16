package EX1;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class DFS {
    public static List<Node> dfsUsingStack(Node initial, int goal) {
        Stack<Node> st = new Stack<>();
        st.push(initial);
        List<Node> result = new LinkedList<>();
        while (!st.isEmpty()) {
            Node temp = st.pop();
            result.add(temp);
            for (Node n : temp.getNeighbours()) {
                if (n.state == goal) {
                    result.add(n);
                    return result;
                }
                if (!st.contains(n)) {
                    st.push(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("hello world !");
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        System.out.println(dfsUsingStack(node40, 70));

    }
}
