package EX1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int state;
    boolean visited;
    List<Node> neighbours;
    Node parent;

    public Node(int state) {
        // initial state
        this.state = state;
        this.neighbours = new ArrayList<>();
        this.parent = null;
    }

    public void addNeighbours(Node childerNode) {
        childerNode.setParent(this);
        this.neighbours.add(childerNode);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder printNeighbours  = new StringBuilder();
        if (!neighbours.isEmpty()) {
            for (Node  n: neighbours
                 ) {
                printNeighbours.append(n.state);
            }
        }

        return this.state +" ";
    }

    public static void main(String[] args) {

    }

}
