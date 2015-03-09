package Datatool;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory; 
import net.sf.jsr107cache.CacheManager;

public class CacheServerData {
	private static final Logger log = Logger.getLogger(CacheServerData.class.getName());
	private static Cache cache;
	
	public static Cache getCacheServerData(){
		if(cache==null){
			try {
	            CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
	            cache = cacheFactory.createCache(Collections.emptyMap());
	        } catch (CacheException e) {
	            log.log(Level.SEVERE,"Cache Error in Creating CacheServerData "+e.toString());
	        }
		}
		return cache;	
	}
	
	public static void putCachedata(){}
	
	public static void getCachedata(String queryhashstr)
	{
		
	}
	
}
