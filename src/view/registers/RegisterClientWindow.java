package view.registers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.MySQLDatabase;
import java.awt.Toolkit;

public class RegisterClientWindow {
	MySQLDatabase databaseActions = new MySQLDatabase();
	private JFrame frmPetshopGoodPet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterClientWindow window = new RegisterClientWindow();
					window.frmPetshopGoodPet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterClientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPetshopGoodPet = new JFrame();
		frmPetshopGoodPet.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\EstudoJava\\petshop\\img\\icon_pet.png"));
		frmPetshopGoodPet.setTitle("Petshop Lovely Pet");
		frmPetshopGoodPet.setBounds(100, 100, 450, 300);
		frmPetshopGoodPet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				databaseActions.startDB();
				databaseActions.insertOnClientTable("Vanderson", "111", "Male", "Av. Tutoia, 1157", "222");
				databaseActions.closeDB();				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmPetshopGoodPet.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(143)
					.addComponent(btnNewButton)
					.addContainerGap(202, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(44))
		);
		frmPetshopGoodPet.getContentPane().setLayout(groupLayout);
	}
}
