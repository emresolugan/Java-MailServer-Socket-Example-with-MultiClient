import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

class ServerApp {

    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(3000);
        System.out.println("dinleniyor..");


        while (true) {
        	try
        	{
        		Socket connectionSocket = welcomeSocket.accept();
        		System.out.println("Client giriþ yaptý");
        		Client c = new Client(connectionSocket);
        		c.start();
        	}
        	catch(IOException ex)
        	{
        		ex.printStackTrace();
        		System.out.println(ex.toString());
        	}
        }
    }
}


class Client extends Thread{

    private Socket connectionSocket;
    private String clientSentence;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    public Client(Socket c) throws IOException {
        connectionSocket = c;
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());

    }
    
    public void run() {
        try {
            while (true) {
                clientSentence = inFromClient.readLine();

               if (clientSentence.toString().equals("register")) {
                    Register();
                } else if (clientSentence.toString().equals("login")) {
                    Login();
                } else if (clientSentence.toString().equals("mail_gonder")) {
                    mailGonder();
                } else if (clientSentence.toString().equals("gelen_mail")) {
                	GelenMail();
                } else if (clientSentence.toString().equals("giden_mail")) {
                    GidenMail();
                } 

            }

            	

        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
    
    private void GelenMail() throws IOException {
		// TODO Auto-generated method stub
    	ArrayList<String> list = new ArrayList<String>();
    	
    	outToClient.writeBytes("ok" + "\n");
    	clientSentence = inFromClient.readLine();
    	
   	    Scanner s = new Scanner(new File(".\\Users\\" + clientSentence + "\\Gelen.txt"));
	  
		  while (s.hasNextLine())
		  {
		      list.add(s.nextLine());
		  }
		  
		  String str = " ";
		  
		  for(int i = list.size(); i>0; i--)
		  {
			  str = str + list.get(i-1) + "\n";
		  }
		  
		  System.out.println(str);
		  outToClient.writeBytes(str + "\n");
	}
    
    private void GidenMail() throws IOException {
		// TODO Auto-generated method stub
    	ArrayList<String> list = new ArrayList<String>();
    	
    	outToClient.writeBytes("ok" + "\n");
    	clientSentence = inFromClient.readLine();
    	
   	    Scanner s = new Scanner(new File(".\\Users\\" + clientSentence + "\\Giden.txt"));
	  
		  while (s.hasNextLine())
		  {
		      list.add(s.nextLine());
		  }
		  
		  String str = " ";
		  
		  for(int i = list.size(); i>0; i--)
		  {
			  str = str + list.get(i-1) + "\n";
		  }
		  
		  System.out.println(str);
		  outToClient.writeBytes(str + "\n");
	}

    
	private void mailGonder() throws IOException {
		// TODO Auto-generated method stub
    	System.out.println("Mail gönderimi için istek geldi.");
    	outToClient.writeBytes("ok" + "\n");
    	
    	clientSentence = inFromClient.readLine();
    	
    	String [] str = clientSentence.split(" ");
    	String [] giden = str[0].split(":");
    	String [] gelen = str[1].split(":");

        PrintWriter pw = new PrintWriter(new FileWriter(new File(".\\Users\\" + giden[1] + "\\Giden.txt"), true));
        pw.println(clientSentence);
        pw.close();
        
        
        PrintWriter pw1 = new PrintWriter(new FileWriter(new File(".\\Users\\" + gelen[1] + "\\Gelen.txt"), true));
        pw1.println(clientSentence);
        pw1.close();
    	
    	outToClient.writeBytes("Mail_Gönderildi" + "\n");
        
		
	}

	private void Login() throws IOException {
		// TODO Auto-generated method stub
    	
    	System.out.println("Giriþ için istek geldi.");
    	outToClient.writeBytes("ok" + "\n");
    	
    	ArrayList<String> list = new ArrayList<String>();
    	
    	clientSentence = inFromClient.readLine();
    	
    	 Scanner s = new Scanner(new File(".\\Users\\Users.txt"));
	  
		  while (s.hasNextLine())
		  {
		      list.add(s.nextLine());
		  }
		  
		  if(list.contains(clientSentence))
		  {
			  outToClient.writeBytes("hesap_bulundu" +  "\n");
		  }
		  else 
		  {
			  outToClient.writeBytes("hesap_bulunamadý" + "\n");		
		  }
		
	}

	public void Register() throws IOException {
    	System.out.println("Kayýt için istek geldi.");
    	outToClient.writeBytes("ok" + "\n");
    	
    	clientSentence = inFromClient.readLine();
    	String [] str = clientSentence.split(" ");
    	
    	File dir = new File(".\\Users\\" + str[0]);
    	Boolean ok;
    	ok = dir.mkdir();
    	
        if(ok == true)
        {
            File gelen = new File(".\\Users\\" + str[0] + "\\" + "Gelen.txt");
            gelen.createNewFile();
            File giden = new File(".\\Users\\" + str[0] + "\\" + "Giden.txt");
            giden.createNewFile();	
        } 
        
        File f_user = new File(".\\Users\\Users.txt");
        if (!f_user.exists()) {
            f_user.createNewFile();
        }
        
        PrintWriter pw = new PrintWriter(new FileWriter(new File(".\\Users\\Users.txt"), true));
        pw.println(clientSentence);
        pw.close();
        
        
        outToClient.writeBytes("hesap_ok" +  "\n");
        
        
    }
    
}


