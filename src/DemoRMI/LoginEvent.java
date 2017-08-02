package DemoRMI;

import java.rmi.server.ServerNotActiveException;
import java.util.Random;

public class LoginEvent {
	
	public int id;
	
	public LoginEvent(int Lid){
		
		this.id = Lid;
	}
	
	public String serialize() throws ServerNotActiveException {
		
		return "id = " + id;
	}
	
	public static LoginEvent deserialize(){
		Random rnd = new Random();
		int Rid = rnd.nextInt(100);
		return new LoginEvent(Rid);
	
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 3fe548f472a37a676322fe6b3fc98d14d04fcb66
