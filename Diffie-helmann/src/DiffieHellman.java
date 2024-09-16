import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DiffieHellman extends JFrame {
	
	//constantes da classe
	private static final long serialVersionUID = 1L;
	private static final BigInteger p = new BigInteger(
							"102031405123416071809152453627382938465749676859789");	
	private static final BigInteger g = new BigInteger(
							"1234567890123456789012345");
	//propriedades da class
	private JLabel lblChaveSecretaRemetente = new JLabel("Chave Secreta do Remetente");
	private JTextField txtChaveSecretaRemetente = new JTextField();
	
	private JLabel lblChavePublicaRemetente = new JLabel("Chave publica do Remetente");
	private JTextField txtChavePublicaRemetente = new JTextField();
	
	private JLabel lblChavePublicaDestinatario = new JLabel("Chave publica do destinatario");
	private JTextField txtChavePublicaDestinatario = new JTextField();
	
	private JLabel lblChaveComunicacao = new JLabel("Chave de comunicacão");
	private JTextField txtChaveComunicacao = new JTextField();
	
	private JButton btnDerivarChavePublica = new JButton("Derivar Chave Pública");
	private JButton btnCalcularChaveComunicacao = new JButton("Calcular Chave de Comunicacão");
	
	//metodo principal de execucao da classe
	public static void main (String[] args) {
		new DiffieHellman().setVisible(true);		
}
	//metodo construtor da classe
	public DiffieHellman() {
		
		//configuracao da janela
		setTitle("Distribuição de Chaves por DIffiei-Hellman");
		setSize(420, 310);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//Chave secreta do remetente
		lblChaveSecretaRemetente.setBounds(10, 10, 200, 20);
		add(lblChaveSecretaRemetente);
		txtChaveSecretaRemetente.setBounds(10, 30, 380, 20);
		add(txtChaveSecretaRemetente);
		
		//botao da derivacao da chave publica
		btnDerivarChavePublica.setBounds(110, 60, 200, 20);
		add(btnDerivarChavePublica);
		btnDerivarChavePublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger numero = new BigInteger(txtChaveSecretaRemetente.getText());
					
					txtChavePublicaRemetente.setText(g.modPow(numero, p).toString());
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		});
		
		//Chave publica do remetente
		lblChavePublicaRemetente.setBounds(10, 90, 200, 20);
		add(lblChavePublicaRemetente);
		txtChavePublicaRemetente.setBounds(10, 110, 380, 20);
		add(txtChavePublicaRemetente);
		
		//Chave publica do destinatario
		lblChavePublicaDestinatario.setBounds(10, 140, 200, 20);
		add(lblChavePublicaDestinatario);
		txtChavePublicaDestinatario.setBounds(10, 160, 380, 20);
		add(txtChavePublicaDestinatario);
		
		//botao do calculo da chave de comunicacao
		btnCalcularChaveComunicacao.setBounds(110, 190, 200, 20);
		add(btnCalcularChaveComunicacao);
		btnCalcularChaveComunicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				BigInteger numeroRemetente = new BigInteger(
						txtChaveSecretaRemetente.getText());
				BigInteger numeroDestinatario = new BigInteger(
						txtChavePublicaDestinatario.getText());
				
				txtChaveComunicacao.setText(
						numeroDestinatario.modPow(numeroRemetente, p).toString());	
				}	catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		});
		
		//Chave de comunicacao
		lblChaveComunicacao.setBounds(10, 220, 200, 20);
		add(lblChaveComunicacao);
		txtChaveComunicacao.setBounds(10, 240, 380, 20);
		add(txtChaveComunicacao);
	}
}






