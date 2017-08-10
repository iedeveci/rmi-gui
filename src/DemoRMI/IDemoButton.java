package DemoRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDemoButton extends Remote {
	
	public String doaction(String ss) throws RemoteException;
	
}
