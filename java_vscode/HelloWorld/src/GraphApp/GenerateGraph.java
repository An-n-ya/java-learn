package java_vscode.HelloWorld.src.GraphApp;

import java.util.Arrays;
import java.util.Random;

public class GenerateGraph {
    public static void main(String args[]) {
        random(10);
    }

    public static Graph random(int n) {
        if (n < 1 || n > 26) {
            return null;
        }
        String[] alphabet = new String[26];
        for (int i = 65; i < 91; i++) {
            alphabet[i - 65] = String.valueOf((char) i);
        }

        // System.out.println(Arrays.toString(alphabet));
        String[] nodes = Arrays.copyOfRange(alphabet, 0, n);
        // System.out.println(Arrays.toString(nodes));
        Random generator = new Random();

        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (generator.nextFloat() < 0.15 && i != j) {
                    // every element has 20% potential to have value
                    m[i][j] = generator.nextInt(9) + 1;
                } else {
                    m[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // System.out.println(Arrays.deepToString(m));

        GraphMatrix mg = new GraphMatrix(m, nodes);
        String graph = mg.generateDG();

        String html = WriteHtml.generateHTML(graph);
        String file = "/Users/zhanghuanyu/Documents/backend/java_learn/java_vscode/有向图.html";
        WriteHtml.writeHTML(file, html); // 输出为html文件

        Graph g = new Graph();
        g.graphFromMatrix(mg);

        return g;
    }
}
