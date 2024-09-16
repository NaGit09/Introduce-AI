package EX1;

import java.util.*;

public class BFS {
    public static List<Node> bfsUsingQueue(Node initial, int goal) {
        Queue<Node> listQueue = new LinkedList<>();
        listQueue.offer(initial);
        List<Node> explored = new LinkedList<>();
explored.add(initial);

        while (!listQueue.isEmpty()) {
            Node temp = listQueue.poll();
            for (Node n : temp.getNeighbours()) {
                if (n.state == goal) {
                    explored.add(n);
                    return explored;
                }
                if (!listQueue.contains(n) && !explored.contains(n)) {
                    listQueue.offer(n);
                    explored.add(n);
                }
            }
        }

        return new LinkedList<>();
    }

    public static List<Node> bfsUsingQueue2(Node initial, int goal) {
        if (initial.state == goal) {
            return List.of(initial); // Goal is the initial node itself
        }

        Queue<Node> listQueue = new LinkedList<>();
        listQueue.offer(initial);

        Set<Node> explored = new HashSet<>(); // Using Set for faster lookup
        explored.add(initial);

        while (!listQueue.isEmpty()) {
            Node temp = listQueue.poll();

            for (Node n : temp.getNeighbours()) {
                if (n.state == goal) {
                    explored.add(n);
                    return new LinkedList<>(explored); // Return explored nodes
                }
                if (!explored.contains(n) && !listQueue.contains(n)) {
                    listQueue.offer(n);
                    explored.add(n); // Mark node as explored as soon as it's added to the queue
                }
            }
        }

        return new LinkedList<>(); // Goal not found
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

        System.out.println("The BFS traversal of the graph using queue ");




        System.out.println(   bfsUsingQueue(node40,70));
//        System.out.println(   bfsUsingQueue2(node40,70));

    }
}
