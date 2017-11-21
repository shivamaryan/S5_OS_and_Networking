import java.io.*;
import java.net.*;
import java.util.Scanner;
class Tcp_Client
{
	public static void main(String args[])throws IOException
	{
		Socket s1 = new Socket("192.168.0.16",5001);
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream os = s1.getOutputStream();
		
		PrintWriter pwrite = new PrintWriter(os,true);
		
		InputStream in = s1.getInputStream();	
		BufferedReader rec = new BufferedReader(new InputStreamReader(in));
		
		String r,s;
		while(true)
		{
			s = key.readLine();
			pwrite.println(s);
			pwrite.flush();
			
			r = rec.readLine();
			if(!(r.equals("bye")))
				System.out.println(r);
			else
				break;
		}
	}
}
