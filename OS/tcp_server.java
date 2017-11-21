import java.io.*;
import java.net.*;
import java.util.Scanner;
class Tcp_Server
{
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		ServerSocket s = new ServerSocket(5001);
		Socket s1 = s.accept();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		OutputStream os = s1.getOutputStream();
		PrintWriter pw = new PrintWriter(os,true);
		
		
		InputStream in = s1.getInputStream();
		BufferedReader inn = new BufferedReader(new InputStreamReader(in));
		
		String r,str;
		//val = new String(dis.readUTF());
		System.out.println("Chatting begins");
		while(true)
		{
			r=inn.readLine();
			if(!(r.equals("bye")))
				System.out.println(r);
			
			else
				break;
			
			str = bf.readLine();
			pw.println(str);
			pw.flush();
		}	
	}
}
