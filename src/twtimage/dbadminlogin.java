package twtimage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import dataobj.users;
import net.sf.jsr107cache.Cache;
import Datatool.CacheServerData;
import Datatool.CheckEmpty;
import Datatool.PutData;


public class dbadminlogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doPost( req,  resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String outputmsg="dbadminlogin ";
		String id=req.getParameter("inputtext");
		String ps=req.getParameter("inputPassword");
		if(id==null||ps==null)
		{
			resp.getWriter().println("Error parameter");
			return;
		}
		users us=new users();
		us.setUsername(id);
		us.setPasswd(ps);
		
		List ls=CheckEmpty.docheck("dataobj.users");
		if(ls==null)
		{
			PutData.put(us);
			outputmsg=outputmsg+us.getUsername()+" is first user created";
		}
		else
		{
			
			boolean flag=false;
			for(Object tempus:ls)
			{
				users tempuser=(users)tempus;
				if(
						tempuser.getUsername().equals(us.getUsername())&&
						tempuser.getPasswd().equals(us.getPasswd())
					)
				{
					outputmsg=outputmsg+us.getUsername()+" logined";
					flag=true;
				}
			}
			if(!flag)
			{
				outputmsg=outputmsg+us.getUsername()+" failed";
			}
			
			
		}

		resp.getWriter().println(outputmsg);

	}
}
