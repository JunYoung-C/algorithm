package test;

import java.awt.*;
import java.util.*;


class Node {
    int a;
    int b;
    int c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return a == node.a && b == node.b && c == node.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
public class test {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        nodes.add(new Node(1, 1, 1));
        System.out.println(nodes.contains(new Node(1, 1, 1)));
    }


}
