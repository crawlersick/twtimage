package Datatool;

import javax.jdo.PersistenceManager;

public class PutData {
public static void put(Object obj)
{
	PersistenceManager pm = PMF.get().getPersistenceManager();	
	try {
        pm.makePersistent(obj);
    } finally {
        pm.close();
    }
}

public static void put(Object[] obj)
{
	PersistenceManager pm = PMF.get().getPersistenceManager();	
	try {
		for(int i=0;i<obj.length;i++)
        pm.makePersistent(obj);
    } finally {
        pm.close();
    }
}

}
