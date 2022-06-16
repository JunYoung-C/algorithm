package template.graph.unionfind;

public class Main {
    static int[] parent;

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public void unite(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fb] = fa;
        }
    }
}
