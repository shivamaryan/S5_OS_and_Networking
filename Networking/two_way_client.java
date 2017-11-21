import java.io.*;
import java.net.*;

class TwoClient
{
	public static void main(String args[])throws IOException
	{
		Socket s = new Socket("192.168.0.16",5001);
		
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Please behave properly and mind the language Server");
		
		InputStream in = s.getInputStream();
		DataInputStream d = new DataInputStream(in);
		String s1 = new String(d.readUTF());
		System.out.println(s1);
		
		
		
	}
}
