package Datatool;

import java.util.Stack;

public class Hashastring {
static String charset="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
static public String Hashstr(String ss)
	{
		int strlen=ss.length();
		int hash=7;
		for (int i=0;i<strlen;i++)
		{			hash=hash+ss.charAt(i)*31*i;		}
		Stack st=new Stack();
		cal64(hash,st);
		StringBuilder sb=new StringBuilder();
		for(;;)
		{
			if(st.empty()) break;
			int pos=(Integer)st.pop();
			sb.append(charset.charAt(pos));		
		}
		return sb.toString();
	}
static public int cal64(int dec,Stack st)
	{
		int x=dec>>6;
		int y=x<<6;
		if(y==0){st.push(dec);return dec;}
		else{st.push(dec-y);return cal64(x,st);}
	}
static public void main(String[] args)
		{
			System.out.println(Hashstr("select r from b tale"));
		}
}
