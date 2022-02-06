import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PageRank {

    private int m_N;
    private double m_Epsilon;
    private int m_t;

    public PageRank(int N, double Epsilon ,int t)
    {
        m_N = N;
        m_Epsilon = Epsilon;
        m_t = t;
    }

    public void setT(int t) {
        this.m_t = t;
    }

    public int getT() {
        return m_t;
    }

    public void setEpsilon(double Epsilon) {
        this.m_Epsilon = m_Epsilon;
    }

    public void setN(int N) {
        this.m_N = m_N;
    }

    public ArrayList<Double> runAlgorithm(Graph graph) {
        ArrayList<Double> RatingVectors = new ArrayList<>(graph.getNumOfVertex());
        for(int i = 0;i < graph.getNumOfVertex();i++)
        {
            RatingVectors.add(i, 0.0);
        }

        for(int i = 0;i < m_t;i++)
        {
            int currentVector = MyMath.randomInRange(0, graph.getNumOfVertex()-1);
            int nextVector;
            for(int j = 0;j < m_N;j++)
            {
                double p = MyMath.randomDouble();
                if(p < m_Epsilon)// move to random vertex
                {
                    nextVector = MyMath.randomInRange(0, graph.getNumOfVertex()-1);
                }
                else
                {
                    if (graph.getExitRank(currentVector) == 0)// move to random vertex
                    {
                        nextVector = MyMath.randomInRange(0, graph.getNumOfVertex()-1);

                    }
                    else// move to random neighbor vertex
                    {
                        ArrayList<Integer> neighbors = graph.getNeighbors(currentVector);
                        int randomIndexNeighbor = MyMath.randomInRange(0, neighbors.size() - 1);
                        nextVector = neighbors.get(randomIndexNeighbor);
                    }
                }

                currentVector = nextVector;
            }

            RatingVectors.set(currentVector, RatingVectors.get(currentVector) + 1.0);
        }

        for(int i = 0;i < RatingVectors.size();i++)
        {
            RatingVectors.set(i, RatingVectors.get(i) / m_t);
        }

        return RatingVectors;
    }
}