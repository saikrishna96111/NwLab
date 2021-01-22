import java.io.*;
import java.net.*;
import java.util.*;
class server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(3000);
			System.out.println("System ready for connection");
			Socket sock = ss.accept();
			System.out.println("Connection Established");
			InputStream is = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String fname = br.readLine();
			System.out.println("The FileName is "+fname);
			BufferedReader br1 = new BufferedReader(new FileReader(fname));
			OutputStream os = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			String str ="";
			while((str=br1.readLine())!=null)
				pw.println(str);
			is.close();
			os.close();
			sock.close();
			ss.close();
			System.out.println("Connection terminated");
		}
		catch(Exception e)
		{}
	}
}



