import java.io.*;
import java.net.*;

class TwoServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket s = new ServerSocket(5001);
		Socket s1 = s.accept();
		
		InputStream in = s1.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		String s2 = new String(dis.readUTF());
		System.out.println(s2);
		
		OutputStream os = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Fuck off client bitch");
		
		
	}
}
