package Servion;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



public class HiberOperations {
	Session session;
	
	public boolean checkuser(String uname)
	{
		 session=SessionUtility.GetSessionConnection();
		
		String hql = "FROM UserEntity where uname = :username";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("username",uname);
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();
		
		Iterator<UserEntity> it=results.iterator();
		
		if (it.hasNext()) {
			
			return true;
		}
		else
		{
			
		return false;
		}
	
	}
	
	
	public boolean changestatus(String uname,int status)
	{
		 session=SessionUtility.GetSessionConnection();
		
		Query query = session.createQuery("update UserEntity set status = :statusval where uname = :unameval");
		
		query.setParameter("statusval",status);
		query.setParameter("unameval",uname);
		
		if (query.executeUpdate()==1) {
			
			SessionUtility.closeSession(null);
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	
	
	public boolean changepassword(String uname,String password)
	{
		 session=SessionUtility.GetSessionConnection();
		
		Query query = session.createQuery("update UserEntity set pass = :statusval where uname = :unameval");
		
		query.setParameter("statusval",password);
		query.setParameter("unameval",uname);
		
		if (query.executeUpdate()==1) {
			
			SessionUtility.closeSession(null);
			return true;
		}
		else
		{
			System.out.println("error in update");
			return false;
		}
		
		
		
	}
	
	
	
	public boolean checkUserAndPassword(String uname,String password){
		
		
		 session=SessionUtility.GetSessionConnection();	
		String hql = "FROM UserEntity where uname = :username AND pass= :password";
		Query query = session.createQuery(hql);
		query.setParameter("username",uname);
		query.setParameter("password",password);
		
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();
		
		Iterator<UserEntity> it=results.iterator();	
		
		if (it.hasNext()) {
			
			return true;
		}
		else
		{
			
		return false;
		}	
	}
	
	
	public boolean checkstatus(String uname)
	{
		
		 session=SessionUtility.GetSessionConnection();
		
		String hql = "FROM UserEntity where uname = :username";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("username",uname);
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();	
		Iterator<UserEntity> it=results.iterator();
		
		
		UserEntity un=it.next();
		
		if (un.getStatus()==1) {
			
			return true;
		}
		else
		{
			
		return false;
		}
		
	}
	
	
	
	public boolean InsertDatabase(String fname,String lname,String uname,String password,int status)
	{
		 session=SessionUtility.GetSessionConnection(); 
		 UserEntity e=new UserEntity();
		 
		 e.setFname(fname);
		 e.setLname(lname);
		 e.setUname(uname);
		 e.setPass(password);
		 e.setStatus(0);
		 
		 try{
		 session.save(e);	 
		 SessionUtility.closeSession(null);
		 return true;
		 }
		 catch(Exception e1)
		 {
			 System.out.println("failed insert"+e1);
			 return false;
		 }
		 
		
	
	}
	
	
	
	public String GetproductImage(String pname)
	{
		 session=SessionUtility.GetSessionConnection();
		
		Query query = session.createQuery("From ProductDescBean where p_name = :pnameval");
		
		
		query.setParameter("pnameval",pname);
		
		@SuppressWarnings("unchecked")
		List<ProductDescBean> results = query.list();	
		Iterator<ProductDescBean> it=results.iterator();

		ProductDescBean un=it.next();
		
		return un.getP_img();
		
		
		
	}
	public String GetproductDes(String pname)
	{
		 session=SessionUtility.GetSessionConnection();
		
		Query query = session.createQuery("From ProductDescBean where p_name = :pnameval");
		
		
		query.setParameter("pnameval",pname);
		
		@SuppressWarnings("unchecked")
		List<ProductDescBean> results = query.list();	
		Iterator<ProductDescBean> it=results.iterator();

		ProductDescBean un=it.next();
		
		return un.getP_desc();
		
		
		
	}

//
//	public static void main(String[] args) {
//		HiberOperations h=new HiberOperations();
//		
//		System.out.println(h.GetproductImage("apple"));
//		
//	}
//	
	
	
	
	

}
