package view.registers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.MySQLDatabase;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.GridLayout;
import javax.swing.SpringLayout;

public class UserRegistrationWindow {
	MySQLDatabase databaseAction = new MySQLDatabase();
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtUsername;
	private JLabel lblrepeatPasswordError;
	private JPasswordField txtPassword;
	private JPasswordField txtRepeatPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistrationWindow window = new UserRegistrationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserRegistrationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 501, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel lblNewLabel = new JLabel("Name:");
		frame.getContentPane().add(lblNewLabel);

		txtName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtName, 105, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, txtName, -104, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, txtName);
		springLayout.putConstraint(SpringLayout.NORTH, txtName, 84, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 25, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 31, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -385, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_1);

		txtUsername = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsername, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtUsername, 67, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 25, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 31, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("OK");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 29, SpringLayout.WEST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblrepeatPasswordError.setVisible(false);
				String name = txtName.getText();
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				String repeatPassword = new String(txtRepeatPassword.getPassword());
				if (password.equals(repeatPassword)) {
					databaseAction.startDB();
					databaseAction.insertOnUserTable(name, username, repeatPassword);
					databaseAction.closeDB();
				} else {

					lblrepeatPasswordError.setVisible(true);

				}
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 140, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -20, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -249, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);

		lblrepeatPasswordError = new JLabel("Passwords do not match. Please type the same password in both fields.");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -17, SpringLayout.NORTH, lblrepeatPasswordError);
		springLayout.putConstraint(SpringLayout.NORTH, lblrepeatPasswordError, 283, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblrepeatPasswordError, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblrepeatPasswordError, 475, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblrepeatPasswordError, 24, SpringLayout.WEST, frame.getContentPane());
		lblrepeatPasswordError.setVisible(false);
		frame.getContentPane().add(lblrepeatPasswordError);
		
		JLabel lblNewLabel_3 = new JLabel("Repeat Password:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, -88, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, txtUsername, 0, SpringLayout.EAST, txtPassword);
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, txtPassword, 167, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(txtPassword);
		
		txtRepeatPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, txtRepeatPassword, 167, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtRepeatPassword, -104, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -6, SpringLayout.WEST, txtRepeatPassword);
		springLayout.putConstraint(SpringLayout.NORTH, txtRepeatPassword, 9, SpringLayout.SOUTH, txtPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, txtRepeatPassword);
		springLayout.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtRepeatPassword);
		frame.getContentPane().add(txtRepeatPassword);
	}
}
