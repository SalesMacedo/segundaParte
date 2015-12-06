/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeparte2;


import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sales
 */
public class Login extends JFrame implements ActionListener {

    public Login() {
        super("Tela de login de usuário");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 170);
        setVisible(true);
        setResizable(false);
        setLocation(450, 300);
        formulario();
    }
    private String L = "Sales";
    private String S = "Sales";

    JButton entrar = new JButton("Login");
    JTextField loginTexto = new JTextField(40);
    JTextField senhaTexto = new JPasswordField(39);

    private void formulario() {
        setLayout(new BorderLayout());

        JPanel Ptitulo = new JPanel();
        Ptitulo.setLayout(new FlowLayout());

        JLabel titulo = new JLabel("FAÇA SEU LOGIN!");
        titulo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));

        Ptitulo.add(titulo);

        JPanel dados = new JPanel();
        dados.setLayout(new FlowLayout());

        JLabel loginLabel = new JLabel("Login: ");

        JLabel senhaLabel = new JLabel("Senha: ");

        dados.add(loginLabel);
        dados.add(loginTexto);
        dados.add(senhaLabel);
        dados.add(senhaTexto);

        JPanel botao = new JPanel();
        botao.setLayout(new FlowLayout());

        botao.add(entrar);
        dados.setBackground(Color.getHSBColor(219, 112, 147));
        Ptitulo.setBackground(Color.getHSBColor(219, 112, 147));
        botao.setBackground(Color.getHSBColor(219, 112, 147));

        add(Ptitulo, BorderLayout.NORTH);
        add(dados, BorderLayout.CENTER);
        add(botao, BorderLayout.SOUTH);

        entrar.addActionListener(this);

    }
    FormularioPreenchimentoNull fm;
    Confirma cf;
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entrar) {
            if (loginTexto.getText().equals(this.L) && senhaTexto.getText().equals(this.S)) {
                fm = new FormularioPreenchimentoNull();
                this.setVisible(false);
                this.fm.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "USUÁRIO OU SENHA INCORRETA!" + "\n" + "\t" + "Tente novamente!");
                loginTexto.setText("");
                senhaTexto.setText("");
                this.setVisible(true);
            }
        }

    }
}
