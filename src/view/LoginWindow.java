package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MySQLDatabase;

import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.MySQLDatabase;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFormattedTextField;

public class LoginWindow extends JDialog {

	MainWindow mainWindow = new MainWindow();
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	JLabel lblUsernamePasswordNotFound;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginWindow dialog = new LoginWindow();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doLogin(String username, String password) {
	
		MySQLDatabase databaseAction = new MySQLDatabase();
		databaseAction.startDB();
		String [] usernamePassword = databaseAction.queryUsersTable(username, password);
		if (usernamePassword[0].equals(username) && usernamePassword[1].equals(password)) {
			this.setVisible(false);
			mainWindow.setVisible(true);

		} else {
			this.lblUsernamePasswordNotFound.setVisible(false);
			this.lblUsernamePasswordNotFound.setVisible(true);
			txtUsername.setText("");
			txtPassword.setText("");
		}
		databaseAction.closeDB();
	}


	/**
	 * Create the dialog.
	 */
	public LoginWindow() {
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainWindow.setVisible(false);
		setUndecorated(true);
		setType(Type.UTILITY);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");

		JLabel lblPassword = new JLabel("Password:");

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				System.out.println(password);
				doLogin(username, password);
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);

			}
		});

		lblUsernamePasswordNotFound = new JLabel("Username or password not found");
		lblUsernamePasswordNotFound.setForeground(new Color(255, 0, 0));
		lblUsernamePasswordNotFound.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		txtPassword = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPassword)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsernamePasswordNotFound, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignIn)
						.addComponent(btnCancel))
					.addGap(18)
					.addComponent(lblUsernamePasswordNotFound)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		lblUsernamePasswordNotFound.setVisible(false);

	}
}
