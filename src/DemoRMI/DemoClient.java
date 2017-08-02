package DemoRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoClient {

	static String input1;
	static String input2;
	static JFrame frame = new JFrame("RMI-GUI");
	 
	public static void main(String[] args) {

		try {

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			final IDemoButton stub = (IDemoButton) registry.lookup("Button");
			String id = LoginEvent.deserialize().serialize();

			JPanel GUI = new JPanel();
			GUI.setLayout(null);

			JPanel buttons = new JPanel();
			buttons.setLayout(null);
			buttons.setLocation(10, 10);
			buttons.setSize(250, 400);
			GUI.add(buttons);

			JButton bta = new JButton();
			bta.setText("A");
			bta.setSize(120, 20);
			bta.setLocation(70, 20);
			bta.setHorizontalAlignment(0);
			buttons.add(bta);

			JButton btb = new JButton();
			btb.setText("B");
			btb.setSize(120, 20);
			btb.setLocation(70, 50);
			btb.setHorizontalAlignment(0);
			buttons.add(btb);

			JTextField jt1 = new JTextField();
			jt1.setLocation(60, 90);
			jt1.setSize(30, 30);
			jt1.setVisible(true);
			buttons.add(jt1);
			JTextField jt2 = new JTextField();
			jt2.setLocation(110, 90);
			jt2.setSize(30, 30);
			jt2.setVisible(true);
			buttons.add(jt2);

			JButton btc = new JButton();
			btc.setText("*");
			btc.setSize(40, 30);
			btc.setLocation(160, 90);
			btc.setHorizontalAlignment(0);
			buttons.add(btc);

			bta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String response = null;
					try {
						Event iEvent = new Event(Event.TYPE1, " " + "A Button");
						response = stub.doaction(iEvent.serialize() + " " + id);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					System.out.println("Response: " + response + " " + id);
				}
			});

			btb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String response = null;
					try {
						Event iEvent = new Event(Event.TYPE2, " " + "B Button");
						response = stub.doaction(iEvent.serialize() + " " + id);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					System.out.println("Response: " + response + " " + id);
				}
			});

			btc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String response = null;
					input1 = jt1.getText();
					input2 = jt2.getText();
					int result = multiplication(input1, input2);
					EventCal cEvent = new EventCal(EventCal.TYPE3, result);
					try {
						response = stub.doaction(cEvent.cserialize() + " " + id);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

					System.out.println("Response: " + response + " " + id);
				}
			});

			frame.setSize(280, 200);
			frame.setContentPane(GUI);
			frame.setResizable(false);
			frame.setVisible(true);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public static int multiplication(String str1, String str2) {

		int t1 = Integer.parseInt(str1);

		int t2 = Integer.parseInt(str2);

		return t1 * t2;
	}

}