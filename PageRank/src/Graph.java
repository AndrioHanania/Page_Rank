import java.util.ArrayList;

public class Graph {
    private int m_NumOfVertex;
    private boolean[][] m_Graph;

    public Graph(int numOfVertex) {
        m_NumOfVertex = numOfVertex;
        m_Graph = new boolean[numOfVertex][numOfVertex];
    }

    public int getNumOfVertex() {
        return m_NumOfVertex;
    }

    public int getExitRank(int vector) {
        int exitRank = 0;
        for (int i = 0; i < m_NumOfVertex; i++) {
            if (m_Graph[vector][i])
                exitRank++;
        }
        return exitRank;
    }

    public boolean[][] getGraph() {
        return m_Graph;
    }

    public ArrayList<Integer> getNeighbors(int vector) {
        ArrayList<Integer> neighbors = new ArrayList<>(m_NumOfVertex);
        for (int i = 0; i < m_NumOfVertex; i++) {
            if (m_Graph[vector][i])
                neighbors.add(i);
        }

        return neighbors;
    }

    public int getRankVertex(int vector) {
        int dOut = getNeighbors(vector).size();
        int dIn = 0;
        for (int i = 0; i < m_NumOfVertex; i++) {
            if (i != vector) {
                if (m_Graph[i][vector])
                    dIn++;

            }
        }

        return dOut + dIn;
    }

    public double getRankVertexAvg() {
        double RankVertexAvg = 0;
        for (int i = 1; i < m_NumOfVertex; i++) {
            RankVertexAvg += getRankVertex(i);
        }

        RankVertexAvg /= m_NumOfVertex;
        return RankVertexAvg;
    }

    public void addCircle64(boolean flag, int vertex) {
        Graph graph = new Graph(m_NumOfVertex + 64);
        for (int i = 0; i < m_NumOfVertex; i++) {
            for (int j = 0; j < m_NumOfVertex; j++) {
                graph.m_Graph[i][j] = m_Graph[i][j];
            }
        }

        for (int i = m_NumOfVertex; i < m_NumOfVertex + 63; i++) {
            graph.m_Graph[i][i + 1] = true;
        }

        graph.m_Graph[m_NumOfVertex + 63][m_NumOfVertex] = true;

        if(!flag) {
            int randomOldVertex = MyMath.randomInRange(0, m_NumOfVertex - 1);
            graph.m_Graph[randomOldVertex][m_NumOfVertex] = true;
        }
        else{
            graph.m_Graph[vertex - 1][m_NumOfVertex] = true;
        }

        m_Graph = graph.m_Graph;
        m_NumOfVertex = graph.m_NumOfVertex;
    }

    public static Graph createRandomGraph(int numOfVertex, double probabilityToEdge) {
        Graph graph = new Graph(numOfVertex);
        double p;
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                graph.getGraph()[i][j] = MyMath.randomDouble() <= probabilityToEdge;
            }
        }

        return graph;
    }

    public static Graph create3FamGraph(int numOfVertex)
    {
        double p;
        double random;
        Graph graph = new Graph(numOfVertex);
        for (int i = 0; i < numOfVertex; i++)
        {
            for (int j = 0; j < numOfVertex; j++)
            {
                p = 1.0 / (Math.log(j + 1 + 1) / Math.log(2));
                random = MyMath.randomDouble();
                if(random <= p)
                    graph.m_Graph[i][j] = true;
            }
        }

        return graph;
    }
}