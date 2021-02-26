package trabalho3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente implements ActionListener {

  static Cliente j = new Cliente();
  static JFrame jan1 = new JFrame();

  static JLabel rtl1 = new JLabel();
  static JLabel rtl2 = new JLabel();

  static JTextField cx2 = new JTextField(10);
  static JTextField cx1 = new JTextField(10);
  static JTextField cx3 = new JTextField(10);
  

  static JButton bt1 = new JButton();
  static JButton bt2 = new JButton();
  static JButton bt3 = new JButton();
  static JTextArea textArea = new JTextArea(5, 15);
  
  public static void main(String[] args) {

    jan1.setVisible(true);
    jan1.setSize(190,280);
    jan1.setLocation(555,555);
    jan1.setTitle("Cliente / servidor");
    jan1.setDefaultCloseOperation(jan1.EXIT_ON_CLOSE);

    cx1.setText("");
    cx2.setText("");
    
    bt1.setText("Enviar Dados");
    bt2.setText("Limpar");
    bt3.setText("Sair");

    rtl1.setText("Nome");
    rtl2.setText("Idade");
    textArea.setEditable(true);

    jan1.add(rtl1);
    jan1.add(cx1);
    jan1.add(rtl2);
    jan1.add(cx2);
    jan1.add(bt1);
    jan1.add(bt2);
    jan1.add(textArea);
    jan1.add(bt3);
      
    bt1.addActionListener(j);
    bt2.addActionListener(j);
    // bt3.addActionListener(j);

    jan1.setLayout(new FlowLayout());
    jan1.setVisible(true); // final
  }
  
  //saida de dados
  private static Socket socket;
  private static ObjectOutputStream saida; 
  private static ObjectInputStream entrada;

  @Override
  public void actionPerformed(ActionEvent evt) {
    Object obj = evt.getSource();
    if (obj.equals(bt1)) {
    //saida de dados 
    try {
      
      socket = new Socket("127.0.0.1", 51000);
      
      saida = new ObjectOutputStream(socket.getOutputStream());
      
      Pessoa pessoa = new Pessoa();
      pessoa.setNome(cx1.getText());
      pessoa.setIdade(cx2.getText());
        
      saida.writeObject(pessoa);
      
      entrada = new ObjectInputStream(socket.getInputStream());
	  String teste;
      teste= (String) entrada.readObject();
      textArea.setText(teste);

      socket.close();
      
    }catch(Exception e) {
    }
     
    }
    if (obj.equals(bt2)) {
    	cx1.setText(null);
    	cx2.setText(null);
    	cx1.requestFocus();
    }
    
   
	if (obj.equals(bt3)) {
    	System.exit(0);
    	
    }
    
    
    
    }
}
  


  
  

