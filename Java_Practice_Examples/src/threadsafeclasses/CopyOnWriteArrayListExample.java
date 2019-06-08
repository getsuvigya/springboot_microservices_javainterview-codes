package threadsafeclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
public static void main(String[] args) {
	List<String> lis = new ArrayList<>();
	lis.add("a");
	lis.add("b");
	lis.add("c");
	List<String> concurrentList = new CopyOnWriteArrayList<>(lis);
	for(String s : concurrentList){
		System.out.println(s);
		if(s.equals("b")){
			concurrentList.remove(s);
		}
		if(s.equals("c")){
			concurrentList.add("k");
		}
	}
	
	Iterator<String> itr = concurrentList.iterator();
	while (itr.hasNext()) {
		System.out.println(itr.next());
		
	}
}
}
