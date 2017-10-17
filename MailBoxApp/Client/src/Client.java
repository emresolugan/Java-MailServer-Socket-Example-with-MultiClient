import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread{

	public static Socket clientSocket;
	public static BufferedReader inFromServer;
	public static DataOutputStream outToServer;
	
	
	  public static void main(String [] args) throws Exception {

	        Login login = new Login();
	        login.setVisible(true);


	        clientSocket = new Socket("localhost", 3000);

	        outToServer = new DataOutputStream(clientSocket.getOutputStream());
	        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    }
	  
	  
	  public static String gelen_maili_goster(String s) throws IOException
	  {
	  outToServer.writeBytes("gelen_mail" + "\n");
		  
		  if(inFromServer.readLine().equals("ok"))
		  {
			  outToServer.writeBytes(s + "\n");
		  }

		  ArrayList<String> arr = new ArrayList<String>();
		  int count = 0;
		  String str = " ";
		  String line = " ";
		  while ((str = inFromServer.readLine()) != null) {
			    
			    line = line + str + "\n";
			    
			    count++;
			    
			    if(count == 7)  //son 7 mesaj
			    {
			    	break;
			    }
		  }
		 
		  return line;		  
		  
	  }
	  
	  
	  public static boolean mail_gonder(String kimden, String kime, String konu, String mesaj) throws IOException
	  {
		  outToServer.writeBytes("mail_gonder"+ "\n");
		  
		  if(inFromServer.readLine().equals("ok"))
		  {
			  String s ="From:" + kimden + " " + "To:" + kime + " " + "Subject:" + konu + " " + "Message:" + mesaj + "\n";
		      outToServer.writeBytes(s + "\n");
		  }
		  
		  if(inFromServer.readLine().equals("Mail_Gönderildi"))
		  {
			 System.out.println("Mail Gönderildi.");
			 return true;
		  }
		  
		  return false;
	  }


	public static void Register(String s) throws IOException {
		// TODO Auto-generated method stub
		
	    outToServer.writeBytes("register" + "\n");

	    
	    if(inFromServer.readLine().equals("ok"))
	    {
	    	System.out.println("Kayýt için ortam müsait.");
	    	outToServer.writeBytes(s + "\n");

	    }
	    
	    if(inFromServer.readLine().equals("hesap_ok"))
	    {
	    	System.out.println("Kayýt gerçekleþti.");
	    	String [] str = s.split(" ");
	    	MainMenu m = new MainMenu(str[0]);
	    	m.setVisible(true);
	    }
		
	}


	public static boolean Login(String s) throws IOException {
		// TODO Auto-generated method stub
		
		outToServer.writeBytes("login" + "\n");
		
	    if(inFromServer.readLine().equals("ok"))
	    {
	    	System.out.println("Giriþ için ortam müsait.");
	    	outToServer.writeBytes(s + "\n");
	    }
	    
	    if(inFromServer.readLine().equals("hesap_bulundu"))
	    {
	    	System.out.println("Kullanýcý giriþ yaptý.");
	    	return true;
	    }

	    return false;
		
	}


	public static String giden_maili_goster(String s) throws IOException {
		// TODO Auto-generated method stub
		
	  outToServer.writeBytes("giden_mail" + "\n");
		  
		  if(inFromServer.readLine().equals("ok"))
		  {
			  outToServer.writeBytes(s + "\n");
		  }

		  ArrayList<String> arr = new ArrayList<String>();
		  int count = 0;
		  String str = " ";
		  String line = " ";
		  while ((str = inFromServer.readLine()) != null) {
			    
			    line = line + str + "\n";
			    
			    count++;
			    
			    if(count == 7)  //son 7 mesaj
			    {
			    	break;
			    }
		  }
		 
		  return line;	
	}
	  
	  
	
}
