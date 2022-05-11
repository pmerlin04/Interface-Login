package ExemploJanela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JOptionPane;


public class Login extends JFrame implements ActionListener{
	
	Username meuUser = new Username();
	
	JTextField txtLogin;
	JButton bntOk, bntLimpar;
	JLabel lblresult, lblTitulo, lblUsuario, lblSenha;
	JPasswordField JPsenha;
	int t =0;
	int userName,senhaUsername;
	
	String opcMenu [] = {"Entrar na conta", "Sair"};
	
	public Login() {
		
		int opcPrinc = JOptionPane.showOptionDialog(null, "Selecione uma opção","Menu Principal", 0, JOptionPane.WARNING_MESSAGE, null, opcMenu, opcMenu[0]);
		
		switch(opcPrinc) {
		case 0: 
			meuUser.setNomeUsuario(JOptionPane.showInputDialog(null, "Digite seu username: ", "Login", JOptionPane.QUESTION_MESSAGE));
			meuUser.setSenhaUsuario(JOptionPane.showInputDialog(null, "Digite sua senha: ", "Login", JOptionPane.QUESTION_MESSAGE));
			
			setVisible(true);
			setSize(450,300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//APERTAR NO "X" E FECHAR JANELA
			setTitle("Login");//TITULO DA PAGINA
			
			
			Container d = getContentPane();//conteiner para armazenar os campos e botoes
			
			//PARTE DO LAYOUT DOS CONTEINERS;
			d.setLayout(null);
			setBounds(10,  80, 450, 300);//ajuste do layout
			
			//TITULO DO LOGIN
			lblTitulo = new JLabel("Login de usuário");
			lblTitulo.setForeground(new java.awt.Color(0,0,255));
			lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 25));
			lblTitulo.setBounds(80, 10, 300, 30);
			d.add(lblTitulo);
			
			
			//LABEL PARA USUARIO
			lblUsuario = new JLabel("Email: ");
			lblUsuario.setFont(new java.awt.Font("Serif", 1, 20));
			lblUsuario.setBounds(20, 60, 300, 30);
			d.add(lblUsuario);
			
			//EMAIL DO LOGIN
			txtLogin = new JTextField();
			txtLogin.setFont(new java.awt.Font("Serif", 1, 20));
			txtLogin.setBounds(90, 60, 200, 30);
			d.add(txtLogin);
			
			//LABEL PARA SENHA
			lblSenha = new JLabel("Senha: ");
			lblSenha.setFont(new java.awt.Font("Serif", 1, 20));
			lblSenha.setBounds(20, 90, 200, 30);
			d.add(lblSenha);
			
			
			//SENHA DO LOGIN
			JPsenha = new JPasswordField();
			JPsenha.setFont(new java.awt.Font("Serif", 1, 20));
			JPsenha.setBounds(90, 95, 200, 30);
			d.add(JPsenha);
			
			
			//BOTAO OK DO LOGIN
			bntOk = new JButton("Entrar");
			bntOk.addActionListener(this); 
			bntOk.setBackground(Color.WHITE);
			bntOk.setForeground(new java.awt.Color(0,0,255));
			bntOk.setBounds(30, 130, 150, 40);
			d.add(bntOk);
			
			
			//BOTAO LIMPAR DO LOGIN
			bntLimpar = new JButton("Limpar");
			bntLimpar.setBounds(190, 130, 150, 40);
			bntLimpar.setBackground(Color.WHITE);
			bntLimpar.setForeground(new java.awt.Color(0,0,255));
			d.add(bntLimpar);
			bntLimpar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == bntLimpar){
						if(txtLogin.getText()!= "") {
							txtLogin.setText("");
							JPsenha.setText("");
							lblresult.setText("");
						}
						}

					
				}
			});
			
			
			//LABEL DO RESULTADO SE O EMAIL É VALIDO OU NÃO
			lblresult = new JLabel();
			lblresult.setBounds(45, 170, 400, 80);
			lblresult.setFont(new java.awt.Font("Serif", 1, 20));
			d.add(lblresult);
		
		
		
		
		break;
		}
		}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bntOk){
			if(txtLogin.getText().equals(meuUser.getNomeUsuario()) && JPsenha.getText().equals(meuUser.getSenhaUsuario())) {
				lblresult.setForeground(Color.GREEN);
				lblresult.setBounds(110, 150, 400, 80);
				lblresult.setText("Bem vindo " + txtLogin.getText());	
			}else{
				lblresult.setForeground(Color.RED);
				lblresult.setText("Error... Usuario ou senha incorreto");
				lblresult.setBounds(40, 150, 400, 80);
				txtLogin.setText("");
				JPsenha.setText("");
				t++;	
			}	
			if(t == 3) {
				lblresult.setText("Você atingiu o limite de tentativas");
				txtLogin.setText("");
				txtLogin.requestFocus();
				JPsenha.setText("");
					//lblresult.setText("");
				txtLogin.requestFocus(); 
				bntOk.setEnabled(false);
			}
			
		}//final do if la em cima
	}
		
}
		
	


 
