package datastructure.algorithms.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
int V;
List<Edge> adjacencyList[];
public Graph(int v){
	this.V=v;
	adjacencyList = new LinkedList[V];
	for(int i=0;i<V;i++){
		adjacencyList[i] = new LinkedList<>();
	}
}

public void addEdge(int s, int d, int w){
	Edge e = new Edge(s, d, w);
	adjacencyList[s].add(e);
}

public void printGraph(){
	for(int i=0; i<V; i++){
		List<Edge> edgeList = adjacencyList[i];
		for(int j=0; j<edgeList.size();j++){
			System.out.println("vertex "+i+" is connected to "+edgeList.get(j).destination+" with weight "+edgeList.get(j).weight);
		}
	}
}
}

class Edge{
	int source;
	int destination;
	int weight;
	
	public Edge(int s, int d, int w){
		this.source = s;
		this.destination = d;
		this.weight = w;
		
	}
}