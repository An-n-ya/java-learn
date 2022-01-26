package java_vscode.HelloWorld.src.GraphApp;

import java.util.Arrays;

public class GraphTest {
    public static void main(String args[]) {
        String[] nodes = { "A", "B", "C", "D", "E" };
        int[][] m = new int[nodes.length][nodes.length]; // 根据节点数目生成邻接矩阵

        // 邻接矩阵初始化
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (j == i) {
                    m[i][j] = 0;
                } else {
                    m[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 定义边的关系
        m[0][1] = 5;
        m[1][4] = 3;
        m[1][2] = 2;
        m[4][2] = 4;
        m[0][3] = 6;
        m[3][4] = 8;

        GraphMatrix mg = new GraphMatrix(m, nodes);
        Graph g = new Graph();
        g.graphFromMatrix(mg);
        GraphMatrix mg2 = g.graphToMatrix();

        System.out.println(Arrays.deepToString(mg2.getEdges()));
        System.out.println(Arrays.deepToString(mg.getEdges()));
    }
}
