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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.addNeighbours(n2);
        n1.addNeighbours(n3);

        n2.addNeighbours(n4);
        n2.addNeighbours(n5);

        n3.addNeighbours(n6);

        System.out.println(dfsUsingStack(n1, 5));

    }
}
