import java.util.Comparator;

public class NameSort implements Comparator<Info>

{

	@Override
	public int compare(Info o1, Info o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getId(), o2.getId());
	}
	
}
