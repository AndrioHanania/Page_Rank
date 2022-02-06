import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        //tr1 + tr7
        /*
        int numOfVertex = 1024;
        double probabilityToEdge = 0.015625;
        int N = 128;
        double Epsilon = 0;
        int t = 2;
         PageRank pageRank = new PageRank(N, Epsilon, t);
        Graph graph = Graph.createRandomGraph(numOfVertex, probabilityToEdge);
        ArrayList<Double> vector = pageRank.runAlgorithm(graph);
        double sumOfVector = vector.get(0);
        System.out.println("the vector is: ");
        System.out.print(vector.get(0));
        for (int i = 1;i < vector.size();i++)
        {
            sumOfVector += vector.get(i);
            System.out.print(", " + vector.get(i));
        }
        System.out.println("\nsum of the vector is: " + Math.round(sumOfVector));
        System.out.println("The avg rank is: " + graph.getRankVertexAvg());
*/

        //tr 8
        /*int numOfVertex = 1024;
        double probabilityToEdge = 0.015625;
        int N = 128; // also for 64
        double Epsilon = 0;
        int t = 2;
        int pow = 2;
        PageRank pageRank = new PageRank(N, Epsilon, t);
        Graph graph = Graph.createRandomGraph(numOfVertex, probabilityToEdge);

        ArrayList<Double> vector1 = pageRank.runAlgorithm(graph);
        ArrayList<Double> vector2;
        while (true)
        {
            pageRank.setT((int) Math.pow(t, pow));
            vector2 = pageRank.runAlgorithm(graph);
            ArrayList<Double> vectorMinus = MyMath.minusArrays(vector2, vector1);
            if (MyMath.vectorLength(vectorMinus) < 0.00390625)
                break;
            pow++;
            vector1 = vector2;
        }
        System.out.println("the t is : " + pageRank.getT());
        System.out.println("the vector is: ");
        System.out.print(", ");
        System.out.printf("%.10f", vector2.get(0));
        for (int i = 1;i < vector2.size();i++)
         {
             System.out.print(", ");
             System.out.printf("%.10f", vector2.get(i));
         }*/

        //tr 9
        /*
        int numOfVertex = 1024;
        double probabilityToEdge = 0.015625;
        int N = 64;
        double Epsilon = 0;
        int t = 2;
        int pow = 2;
        PageRank pageRank = new PageRank(N, Epsilon, t);
        Graph graph = Graph.createRandomGraph(numOfVertex, probabilityToEdge);

        graph.addCircle64();
        ArrayList<Double> vector1 = pageRank.runAlgorithm(graph);
        ArrayList<Double> vector2;
        while (true)
        {
            pageRank.setT((int) Math.pow(t, pow));
            vector2 = pageRank.runAlgorithm(graph);
            ArrayList<Double> vectorMinus = MyMath.minusArrays(vector2, vector1);
            if (MyMath.vectorLength(vectorMinus) < 0.00390625)
                break;
            pow++;
            vector1 = vector2;
        }
        System.out.println("the t is : " + pageRank.getT());
        System.out.println("the vector is: ");
        System.out.print(", ");
        System.out.printf("%.10f", vector2.get(0));
        double sum = 0;
        double sumOldVertex = 0;
        double sumNewVertex = 0;
        for (int i = 0;i < vector2.size();i++)
        {
            System.out.print(", ");
            System.out.printf("%.10f", vector2.get(i));
            sum += vector2.get(i);

            if(i < 1024)
                sumOldVertex += vector2.get(i);
            else
                sumNewVertex += vector2.get(i);
        }

        System.out.println("\nsum of the array: " + sum);
        System.out.println("sum Old Vertex: " + sumOldVertex);
        System.out.println("sum New Vertex: " + sumNewVertex);
        System.out.println("avg Old Vertex: " + sumOldVertex / (double)1024);
        System.out.println("avg New Vertex: " + sumNewVertex / (double)64);
*/

        //tr 11
        /*
        int numOfVertex = 1024;
        int N = 128;
        double Epsilon = 0;
        int t = 2;
        int pow = 2;
        PageRank pageRank = new PageRank(N, Epsilon, t);
        Graph graph = Graph.create3FamGraph(numOfVertex);
        ArrayList<Double> vector1 = pageRank.runAlgorithm(graph);
        ArrayList<Double> vector2;
        while (true)
        {
            pageRank.setT((int) Math.pow(t, pow));
            vector2 = pageRank.runAlgorithm(graph);
            ArrayList<Double> vectorMinus = MyMath.minusArrays(vector2, vector1);
            if (MyMath.vectorLength(vectorMinus) < 0.00390625)
                break;
            pow++;
            vector1 = vector2;
        }
        System.out.println("the t is : " + pageRank.getT());
        System.out.println("the vector is: ");
        double sum = 0;
        for (int i = 0;i < vector2.size();i++)
        {
            System.out.println(i + ". ");
            System.out.printf("%.10f", vector2.get(i));
            sum += vector2.get(i);
            System.out.println();
        }
        System.out.println("\nsum of the array: " + sum);
        */

        //tr 13
        /*
        int numOfVertex = 1024;
        int N = 2048;
        double Epsilon = 9.765625E-4;
        int t = 2;
        int pow = 2;
        PageRank pageRank = new PageRank(N, Epsilon, t);
        Graph graph = Graph.create3FamGraph(numOfVertex);
        graph.addCircle64(true, 1);
        ArrayList<Double> vector1 = pageRank.runAlgorithm(graph);
        ArrayList<Double> vector2;
        while (true)
        {
            pageRank.setT((int) Math.pow(t, pow));
            vector2 = pageRank.runAlgorithm(graph);
            ArrayList<Double> vectorMinus = MyMath.minusArrays(vector2, vector1);
            if (MyMath.vectorLength(vectorMinus) < 0.00390625)
                break;
            pow++;
            vector1 = vector2;
        }
        System.out.println("the t is : " + pageRank.getT());
        System.out.println("the vector is: ");
        double sum = 0;
        double sumOldVertex = 0;
        double sumNewVertex = 0;
        for (int i = 0;i < vector2.size();i++)
        {
            System.out.println(i + ". ");
            System.out.printf("%.10f", vector2.get(i));
            System.out.println();
            sum += vector2.get(i);

            if(i < 1024)
                sumOldVertex += vector2.get(i);
            else
                sumNewVertex += vector2.get(i);
        }
        System.out.println("\nsum of the array: " + sum);
        System.out.println("sum Old Vertex: " + sumOldVertex);
        System.out.println("sum New Vertex: " + sumNewVertex);
        System.out.println("avg Old Vertex: " + sumOldVertex / (double)1024);
        System.out.println("avg New Vertex: " + sumNewVertex / (double)64);
        */
    }
}