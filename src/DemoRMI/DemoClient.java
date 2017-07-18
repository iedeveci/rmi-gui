package DemoRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoClient {

	
	 public static void main(String[] args){
		try{
			Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
			final IDemoButton stub = (IDemoButton) registry.lookup("Button");
			
			JFrame frame = new JFrame("RMI-GUI");
			
			JPanel GUI = new JPanel();
			GUI.setLayout(null);
			
			JPanel buttons = new JPanel();
			buttons.setLayout(null);
			buttons.setLocation(10,10);
			buttons.setSize(250,275);
			GUI.add(buttons);
			
			JButton bta = new JButton();
			bta.setText("A");
			bta.setSize(120,20);
			bta.setLocation(70,20);
			bta.setHorizontalAlignment(0);
			bta.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					String response = null;
					try {
						Event iEvent = new Event(Event.TYPE1, "A Button");
						response = stub.doaction(iEvent.serialize());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					System.out.println("Response: " + response);
					
				}
			});
			buttons.add(bta);
			
			JButton btb = new JButton();
			btb.setText("B");
			btb.setSize(120,20);
			btb.setLocation(70,50);
			btb.setHorizontalAlignment(0);
			btb.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					String response = null;
					try {
						Event iEvent = new Event(Event.TYPE2, "B Button");
						response = stub.doaction(iEvent.serialize());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					System.out.println("Response: " + response);
				}
			});
			buttons.add(btb);
			
			frame.setSize(280, 150);
			frame.setContentPane(GUI);
			frame.setResizable(false);
			frame.setVisible(true);
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	  }
}
