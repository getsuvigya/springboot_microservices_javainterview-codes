package random;

import java.util.List;

public class generictestclass<T> {
T t;
public generictestclass() {
	// TODO Auto-generated constructor stub
}
public generictestclass(T t) {
	this.t = t;
}

}
class M<K,T,N> extends generictestclass<T>{
	K k;
	
	M(K k){
		super();
		this.k = k;
	}
	List<N extends generictestclass<T>;M> l1;
}