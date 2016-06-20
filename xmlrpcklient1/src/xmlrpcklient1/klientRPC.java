package xmlrpcklient1;

import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;

public class klientRPC {
	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			
			XmlRpcClient srv = new XmlRpcClient("http://localhost:1014");
			Vector<Object> params = new Vector<Object>();
			Object result = srv.execute("mojserwer.showServices", params);
			System.out.println(result);
			
			String command = sc.next();
			while(!command.equals("exit")){
				params.clear();
				
				if(command.equals("ShowServices")){
					result = srv.execute("mojserwer.showServices", params);
					System.out.println(result);
				}
				else if(command.equals("Add")){
					int x = sc.nextInt();
					int y = sc.nextInt();
					params.add(x);
					params.add(y);
					result = srv.execute("mojserwer.add", params);
					System.out.println(result);
				}
				else if(command.equals("IndexOf")){
					sc.nextLine();
					String text = sc.nextLine();
//					System.out.println(text);
					String target = sc.nextLine();
//					System.out.println(target);
					int fromIndex = sc.nextInt();
//					System.out.println(fromIndex);
					params.add(text);
					params.add(target);
					params.add(fromIndex);
					result = srv.execute("mojserwer.indexOf", params);
					System.out.println(result);
				}
				else if(command.equals("Replace")){
					sc.nextLine();
					String text = sc.nextLine();
					String target = sc.nextLine();
					String replacement = sc.nextLine();
					params.add(text);
					params.add(target);
					params.add(replacement);
					result = srv.execute("mojserwer.replace", params);
					System.out.println(result);
				}
				
				//System.out.println(command);
				command = sc.next();
			}
			
		} catch (Exception exception) {
			System.err.println("Klient XML-RPC: " + exception);
		}

	}
}
