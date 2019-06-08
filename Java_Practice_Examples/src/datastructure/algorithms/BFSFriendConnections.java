package datastructure.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BFSFriendConnections {
	
	public static void main(String[] args) {
		Graph1 g = new Graph1(9);
		g.addNode(0, 1);
		g.addNode(0, 2);
		//g.addNode(0, 3);
		g.addNode(1, 5);
		g.addNode(1, 3);
		g.addNode(1, 4);
		g.addNode(2, 6);
		g.addNode(2, 7);
		g.addNode(3, 8);
		
		List<Integer> l = new ArrayList<>();
		 l.add(1);
		 g.findLevel(l);
		 g.printConnectionsForLevel(2);
	}

	}
	 class Graph1{
		 int V;
		 LinkedList<Integer> adj[];
		 Map<Integer, List<Integer>> map;
		 public Graph1(int v) {
			 this.V = v;
			 adj=new LinkedList[V];
			 map = new HashMap<>();
			 for (int i = 0; i < adj.length; i++) {
				adj[i]= new LinkedList<>();
			}
		 }
		 
		 public void addNode(int s, int w){
			 adj[s].add(w);
		 }
		 
		
		 int i=0;
		  public void findLevel(List<Integer> l){
			  i++;
			  map.put(i, l);
			  findLevelUtil(l);
			  
		  }
		  
		  public void findLevelUtil(List<Integer>l){
			  Iterator<Integer> itr = l.iterator();
			  List<Integer> subList = new ArrayList<>();
			  while(itr.hasNext()){
				  int k = itr.next();
				  subList.addAll(adj[k]);
				  map.put(i, subList);
			  }
			  if(!subList.isEmpty()){
				  findLevel(subList);
			  }
		  }
		  
		  public void printConnectionsForLevel(int k){
			  List<Integer> list = map.get(k);
			  for (Integer integer : list) {
				System.out.println(integer);
			}
		  }
	 }