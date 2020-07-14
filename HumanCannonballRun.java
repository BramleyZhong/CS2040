// A0194519U Zhong Zhaoping
import java.util.*;

public class HumanCannonballRun{
    public static void main(String args[]) {
        Kattio io = new Kattio(System.in, System.out);
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        vertices.add(new Vertex(io.getDouble(), io.getDouble())); // start point
        vertices.add(new Vertex(io.getDouble(), io.getDouble())); // destination
        Vertex destination = vertices.get(1);
        int num = io.getInt();
        for (int i = 0; i < num; i++) {
          vertices.add(1, new Vertex(io.getDouble(), io.getDouble())); // add vertex behind the start point
        }
        // constructing AL
        num += 2;
        for (int i = 0; i < num; i++) {
            Vertex p = vertices.get(i);
            for (int j = 0; j < num; j++) {
                if (i != j) {
                    Vertex q = vertices.get(j);
                    vertices.get(i).neighbors.add(q);
                    double runTime = 0;
                    if (i == 0) {
                        runTime = p.distance(q)/5;
                    }
                    else {
                        runTime = (Math.abs(p.distance(q)-50)/5) + 2;
                    }
                    vertices.get(i).times.add(runTime);
                }
            }
        }
    io.println(dijkstra(vertices.get(0), destination)); // run dijkstra algorithm
    io.close();

    }

private static double dijkstra(Vertex a, Vertex b) {
    PriorityQueue<Vertex> pq = new PriorityQueue<>(new newComparator());
    a.time = 0;
    pq.add(a);
    while (!pq.isEmpty()) {
        Vertex c = pq.poll();
        c.visited = true;
        if (c == b) {
            return b.time;
        }
        for (int i = 0; i < c.neighbors.size(); i++) {
            Vertex d = c.neighbors.get(i);
            double thisTime = c.times.get(i);
            double newTime = c.time + thisTime;
            // Remove the vertex from pq and add it back with the better time
            if (newTime < d.time) {
                pq.remove(d);
                d.time = newTime;
                pq.add(d);
            }
        }
    }
    return -1;
}

public static class Vertex {
    List<Vertex> neighbors = new ArrayList<Vertex>();
    List<Double> times = new ArrayList<Double>();
    public double X;
    public double Y;
    public double time;
    public boolean visited = false;

    public Vertex(double a, double b) {
        X = a;
        Y = b;
        time = 10000000.0; // set time to be bery big
    }  

    public double distance(Vertex that) {
        return Math.sqrt(Math.pow(this.X - that.X, 2) + Math.pow(this.Y - that.Y, 2));
    }
  }
  
  public static class newComparator implements Comparator<Vertex> {
    public int compare(Vertex m, Vertex n) {
        if(m.time - n.time < 0 ) 
            return -1;
        if(m.time - n.time > 0 ) 
            return 1;
        return 0;
    }
  }
}


