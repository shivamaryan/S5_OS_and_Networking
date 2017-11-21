import java.io.*;
import java.net.*;

class SimpleClient
{
	public static void main(String args[])throws IOException
	{
		Socket s1 = new Socket("192.168.0.16", 5001);
		
		InputStream isr = s1.getInputStream();
		DataInputStream dis = new DataInputStream(isr);
		
		String st = new String(dis.readUTF());
		System.out.println(st);
		
	}

}

