package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTextPane tpOutput = new JTextPane();
		tpOutput.setBounds(219, 23, 542, 506);
		contentPane.add(tpOutput);

		JButton btnNufusTop10 = new JButton("Yuz Olcumu Top 10 Getir");
		btnNufusTop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpOutput.setText("");
				try {
					HttpClient client = new DefaultHttpClient();
					HttpGet request = new HttpGet("http://localhost:8080/RESTfulExample/api/data/getTopYuzOlcumu");
					HttpResponse response = client.execute(request);
					BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					String line = "";
					while ((line = rd.readLine()) != null) {
						tpOutput.setText(tpOutput.getText() + line);
					}
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		});
		btnNufusTop10.setBounds(10, 23, 199, 23);
		contentPane.add(btnNufusTop10);

		textField = new JTextField();
		textField.setBounds(10, 57, 199, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnGetir = new JButton("Ada Göre Getir");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpOutput.setText("");
				try {
					HttpClient client = new DefaultHttpClient();
					String link = "http://localhost:8080/RESTfulExample/api/data/" + textField.getText();
					HttpGet request = new HttpGet(link);
					HttpResponse response = client.execute(request);
					BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					String line = "";
					while ((line = rd.readLine()) != null) {
						tpOutput.setText(tpOutput.getText() + line);
					}
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnGetir.setBounds(67, 88, 142, 23);
		contentPane.add(btnGetir);

	}
}
