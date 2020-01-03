package kjlasdhf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;
	String selectedAuto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
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
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {WritingToFiles.commands.getClass().getName()}));
		comboBox.setBounds(125, 73, 150, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnLoadAuto = new JButton("Load Auto");
		btnLoadAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedAuto = comboBox.getSelectedItem().getClass().getName();
			}
		});
		
		btnLoadAuto.setBounds(86, 141, 120, 23);
		frame.getContentPane().add(btnLoadAuto);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(220, 141, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
	}
}
