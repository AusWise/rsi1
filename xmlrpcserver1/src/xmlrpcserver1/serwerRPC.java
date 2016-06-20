package xmlrpcserver1;

import java.util.LinkedList;
import java.util.List;

import org.apache.xmlrpc.WebServer;

public class serwerRPC{
	
	private List<Service> services; 
	
	public serwerRPC(){
		Service add = new Service("Add", "dodaje dwie liczby rzeczywiste");
		Parameter x = new Parameter("x", "liczba rzeczywista");
		Parameter y = new Parameter("y", "liczba rzeczywista");
		add.parameters.add(x);
		add.parameters.add(y);
		
		Service indexOf = new Service("IndexOf", "szuka odpowiedniego fragmetu w tekscie");
		Parameter text = new Parameter("text", "tekst w ktorym szukamy");
		Parameter target = new Parameter("target", "fragment ktorego szukamy");
		Parameter fromIndex = new Parameter("fromIndex", "indeks miejsca od ktorej rozpoczynamy przeszukiwanie(liczone od zera)");
		indexOf.parameters.add(text);
		indexOf.parameters.add(target);
		indexOf.parameters.add(fromIndex);
		
		Service replace = new Service("Replace", "szuka fragmentu w tekscie i zamienia go na inny");
		Parameter replacement = new Parameter("replacement", "tekst, ktory wstawiamy zamiast poszukiwanego fragmentu");
		replace.parameters.add(text);
		replace.parameters.add(target);
		replace.parameters.add(replacement);
		
		Service showServices = new Service("ShowServices", "wypisuje dostepne uslugi");
		
		services = new LinkedList<Service>();
		services.add(add);
		services.add(indexOf);
		services.add(replace);
		services.add(showServices);
	}
	
	public String showServices(){
		String result = "";
		
		for(Service service: services)
			result += String.format("%s \n", service);
		
		return result;
	}
	
	public Integer add(int x, int y){
		return x + y;
	}
	
	public Integer indexOf(String text, String target, int fromIndex){
		int result = text.indexOf(target, fromIndex);
		return result;
	}
	
	public String replace(String text, String target, String replacement){
		return text.replace(target, replacement);
	}
	
	public static void main(String [] args){
		try {
			System.out.println("Startuje serwer XML-RPC...");
			int port = 1000 + 14;
			WebServer serwer = new WebServer(port);
			serwer.addHandler("mojserwer", new serwerRPC());
			serwer.start();
			System.out.println("Serwer wystartowal pomyslnie");
			System.out.println("Nasluchuje na porcie: " + port);
			System.out.println("Aby zatrzymac serwer nacisnij ctrl + c");
		} catch (Exception exception) {
			System.err.println("Serwer XML-RPC: " + exception);
		}
	}
}