package com.elutra.aai.daoimpl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elutra.aai.dao.EmployeeDAO;
import com.elutra.aai.enums.ColumnEnums;
import com.elutra.aai.model.Employee;
import com.elutra.aai.utility.UserQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	SessionFactory factory;
	private static Map<String, ColumnEnums> columnMap =new HashMap<String, ColumnEnums>();
	static{
		columnMap.put("personnelNumber", ColumnEnums.PERSONNEL_NUMBER);
		columnMap.put("firstName", ColumnEnums.FIRST_NAME);
		columnMap.put("lastName", ColumnEnums.LAST_NAME);
		columnMap.put("dateOfBirth", ColumnEnums.DATE_OF_BIRTH);
		columnMap.put("email", ColumnEnums.EMAIL);
		columnMap.put("gender", ColumnEnums.GENDER);
	}

	public Integer createEmployee(Employee employee) {
		Transaction tx = null;  
		Session session = null; 
		Integer id = null;
		try {  
		session = factory.openSession();  
		tx = session.beginTransaction();  
		 id =(Integer) session.save(employee);
		tx.commit();  
		  
		}catch (Exception ex) {  
		ex.printStackTrace();  
		tx.rollback();  
		}  
		finally {session.close();}
		return id; 
	}

	public List<Employee> getEmployees() {

		Transaction tx = null;  
		Session session = null; 
		 List<Employee> list = null;
		try {  
		session = factory.openSession();  
		tx = session.beginTransaction();  
		list = session.createCriteria(Employee.class).list();
		tx.commit();  
		  
		}catch (Exception ex) {  
		ex.printStackTrace();  
		tx.rollback();  
		}  
		finally {session.close();} 
	
       
        return list;
	}

	public Employee findById(long id) {
		Transaction tx = null;  
		Session session = null; 
		Employee employee= null;
		try {  
		session = factory.openSession();  
		tx = session.beginTransaction();  
		employee = (Employee) session.get(Employee.class,id);
		tx.commit();  
		  
		}catch (Exception ex) {  
		ex.printStackTrace();  
		tx.rollback();  
		}  
		finally {session.flush();
		session.close();
		} 
        return employee;
	}
	
	private Criteria getHibernateQueryFromUserQuery(List<UserQuery> queries, Criteria criteria) throws ParseException{
		for(UserQuery query : queries){
			ColumnEnums enums = columnMap.get(query.getColumn());
			if(query.getOperator().equalsIgnoreCase("equals")){
				criteria.add(Restrictions.eq(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("like")){
				criteria.add(Restrictions.like(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("in")){
				criteria.add(Restrictions.in(enums.getColumnName(), enums.convertValues(query.getValues())));
			}
			if(query.getOperator().equalsIgnoreCase("gt")){
				criteria.add(Restrictions.gt(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("lt")){
				criteria.add(Restrictions.lt(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("ge")){
				criteria.add(Restrictions.ge(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("le")){
				criteria.add(Restrictions.le(enums.getColumnName(), enums.convertValues(query.getValues()).get(0)));
			}
			if(query.getOperator().equalsIgnoreCase("btw")){
				criteria.add(Restrictions.between(enums.getColumnName(), enums.convertValues(query.getValues()).get(0), enums.convertValues(query.getValues()).get(1)));
			}
		}
		return criteria;
		
	}

	public List<Employee> getEmployeesByUserQuery(List<UserQuery> userQueryList) {
		Transaction tx = null;  
		Session session = null; 
		List<Employee> employees = null;
		try {  
		session = factory.openSession();  
		tx = session.beginTransaction();  
		Criteria criteria = session.createCriteria(Employee.class);
		employees = getHibernateQueryFromUserQuery(userQueryList, criteria).list();
		tx.commit();  
		  
		}catch (Exception ex) {  
		ex.printStackTrace();  
		tx.rollback();  
		}  
		finally {session.flush();
		session.close();
		} 
        return employees;
	}

}













