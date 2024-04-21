import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	
	int index;
	int cost;
	
	public Node(int index, int cost) {
		super();
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Main {
	
	static List<Node>[] graph;
	static int N, M, dist[];
	static boolean[] check;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		check = new boolean[N+1];
		dist = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int INF = 1_000_000_000;
		Arrays.fill(dist, INF);
		
		dist[s] = 0;
		pq.add(new Node(s, 0));
		
		dijkstra();
		System.out.println(dist[e]);
		
	}
	
	static void dijkstra() {
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if (check[node.index]) continue;
			check[node.index]= true; 
			for (int i = 0; i < graph[node.index].size(); i++) {
				Node n = graph[node.index].get(i);
				
				if (dist[n.index] > dist[node.index] + n.cost) {
					dist[n.index] = dist[node.index] + n.cost;
					
					pq.add(new Node(n.index, dist[n.index]));
				}
			}
		}
	}
}
