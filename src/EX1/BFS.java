package EX1;

import java.util.*;

public class BFS {
    public static List<Node> bfsUsingQueue(Node initial, int goal) {
        Queue<Node> listQueue = new LinkedList<>();
        listQueue.offer(initial);
        List<Node> explored = new LinkedList<>();


        while (!listQueue.isEmpty()) {
            Node temp = listQueue.poll();
            explored.add(temp);
            for (Node n : temp.getNeighbours()) {
                if (n.state == goal) {
                    explored.add(n);
                    return explored;
                }
                if (!listQueue.contains(n)) {
                    listQueue.offer(n);
                }
            }
        }

        return new LinkedList<>();
    }

    public static void main(String[] args) {
        System.out.println("hello world !");
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

        System.out.println(bfsUsingQueue(n1, 5));

    }
}
