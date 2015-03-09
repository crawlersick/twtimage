package Datatool;


import javax.jdo.PersistenceManager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.Query;




public class CheckEmpty {
	private static final Logger log = Logger.getLogger(CheckEmpty.class.getName());
	public static List docheck(String classname){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery(Class.forName(classname));
			try {
				  List results = (List) q.execute();
				  if (!results.isEmpty()) {
					  return results;
				  } else {
				      return null;
				  }
				} finally {
				  q.closeAll();
				}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE,"Class not found!");
			e.printStackTrace();
			return null;
		}

	}
	
}
