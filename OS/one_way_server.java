import java.io.*;
import java.net.*;

class SimpleServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket s = new ServerSocket(5001);
		Socket s1 = s.accept();
		
		OutputStream ins = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream(ins);
		
		dos.writeUTF("Hey there!!! What's up?");
		
	}
}
