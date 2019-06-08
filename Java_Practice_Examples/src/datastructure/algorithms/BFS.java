package datastructure.algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
public static void main(String[] args) {
	Graph g = new Graph(6);
	g.addNode(0, 1);
	g.addNode(0, 2);
	g.addNode(0, 3);
	g.addNode(1, 5);
	g.addNode(3, 1);
	g.addNode(3, 2);
	g.addNode(4, 1);
	g.addNode(4, 5);
	g.bfs(0);
}

}
 class Graph{
	 int V;
	 LinkedList<Integer> adj[];
	 public Graph(int v) {
		 this.V = v;
		 adj=new LinkedList[V];
		 for (int i = 0; i < adj.length; i++) {
			adj[i]= new LinkedList<>();
		}
	 }
	 
	 public void addNode(int s, int w){
		 adj[s].add(w);
	 }
	 
	 public void bfs(int n){
		 boolean visited[] = new boolean[V];
		 visited[n]=true;
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(n);
		 
		 while (queue.size()!=0) {
			 n= queue.poll();
			 System.out.print(n +"->");
			 Iterator<Integer> itr = adj[n].iterator();
			 while (itr.hasNext()) {
				int k = itr.next();
				if(!visited[k]){
					visited[k] = true;
					queue.add(k);
				}
			}
		}
	 }
 }