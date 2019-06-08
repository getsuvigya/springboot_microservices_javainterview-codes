package random;

import java.io.IOException;
import java.sql.SQLException;

public class b implements test
{

	@Override
	public void exceptionTest() throws SQLException {
		// TODO Auto-generated method stub
		throw new SQLException();
	}
	 
}


class A extends b{
	
}
interface test 
{
	public void exceptionTest () throws SQLException, IOException;
}



class d{
	public A m1(){
		return null;
		
	}
}
class c extends d implements test
{
	public b m1(){
		return null;
		
	}

	@Override
	public void exceptionTest() throws IOException {
		// TODO Auto-generated method stub
		throw new IOException();
	}
}