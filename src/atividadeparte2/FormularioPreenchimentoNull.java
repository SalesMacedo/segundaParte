/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeparte2;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sales
 */
public class FormularioPreenchimentoNull extends JFrame implements ActionListener {

    public FormularioPreenchimentoNull() {
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setSize(550, 550);
        this.setResizable(false);
        preenchimento();
    }

    JButton cad = new JButton("CADASTRAR INFORMAÇÕES");
    JButton sair = new JButton("SAIR");
    JTextArea coment = new JTextArea(8, 50);
    JTextField nome = new JTextField(40);
    JRadioButton Masculino = new JRadioButton("Masculino");
    JRadioButton Feminino = new JRadioButton("Feminino");
    List disc = new List(8, true);
    ButtonGroup sexo = new ButtonGroup();

    ImageIcon icon = new ImageIcon("C:\\Users\\Sales\\Documents\\NetBeansProjects\\AtividadeParte2\\src\\atividadeparte2\\SMF.jpeg");

    public static String NOME = null;
    public static String SEXO = null;
    public static String LISTADISC = null;
    public static String COMENTARIO = null;

    private void preenchimento() {
        JLabel INC = new JLabel(icon);
        INC.setSize(100, 100);
        INC.setLocation(400, 100);
        //////nome
        JPanel dados1 = new JPanel();
        dados1.setLayout(null);
        dados1.add(INC);
        JLabel Labelnome = new JLabel("Nome: ");
        Labelnome.setForeground(Color.black);
        Labelnome.setSize(50, 25);
        Labelnome.setLocation(10, 10);

        nome.setSize(450, 25);
        nome.setLocation(50, 10);
        dados1.add(Labelnome);
        dados1.add(nome);
        ////////////

        /////////sexo
        JLabel sexoTipo = new JLabel("Sexo: ");
        sexoTipo.setForeground(Color.black);

        Masculino.setForeground(Color.black);
        Feminino.setForeground(Color.black);
        sexo.add(Masculino);
        sexo.add(Feminino);

        Masculino.setSize(88, 25);
        Feminino.setSize(100, 25);
        Masculino.setLocation(195, 50);
        Feminino.setLocation(280, 50);
        sexoTipo.setSize(50, 25);
        sexoTipo.setLocation(160, 50);

        Masculino.setBackground(Color.getHSBColor(219, 112, 147));
        Feminino.setBackground(Color.getHSBColor(219, 112, 147));
        dados1.add(sexoTipo);
        dados1.add(Masculino);
        dados1.add(Feminino);

        ///////////
        ///////disciplinas
        JLabel discP = new JLabel("DISCIPLINAS DESEJADAS");
        discP.setForeground(Color.black);

        disc.add("Cálculo");
        disc.add("Algol I");
        disc.add("Algol II");
        disc.add("Redes I");
        disc.add("Redes 2");
        disc.add("Circuitos");
        disc.add("Prolog");
        disc.add("IHC");

        discP.setSize(200, 25);
        discP.setLocation(205, 85);
        disc.setSize(100, 130);
        disc.setLocation(228, 110);
        dados1.add(discP);
        dados1.add(disc);
        ////////////
        ////////////Comenteario

        JLabel msg = new JLabel("DEIXE UM COMENTÁRIO");
        msg.setForeground(Color.black);

        msg.setSize(200, 25);
        msg.setLocation(210, 260);
        coment.setSize(400, 80);
        coment.setLocation(80, 300);
        //coment.setBackground(Color.LIGHT_GRAY);
        coment.setForeground(Color.black);
        dados1.add(msg);
        dados1.add(coment);
        //////////
        /////////cadastrar

        cad.setSize(200, 25);
        cad.setLocation(165, 420);
        //cad.setBackground(Color.GREEN);  
        cad.setForeground(Color.black);
        dados1.add(cad);
        ////////
        sair.setSize(90, 25);
        sair.setLocation(400, 420);
        sair.setBackground(Color.black);
        sair.setForeground(Color.red);
        dados1.add(sair);
        //////////

        //////////
        dados1.setBackground(Color.getHSBColor(219, 112, 147));
        add(dados1);
        sair.addActionListener(this);
        cad.addActionListener(this);
    }

    public String OpcSexual() {
        String opcSex = null;
        if (this.Masculino.isSelected() == true) {
            opcSex = "Masculino ";
        } else if (this.Feminino.isSelected() == true) {
            opcSex = "Feminino ";
        }
        return opcSex;
    }

    public String Discs() {
        String disciplinas_s = "  ";

        for (String i : disc.getSelectedItems()) {

            disciplinas_s = disciplinas_s + "\n" + i;
        }
        return disciplinas_s;
    }

    public void Limpeza() {
        coment.setText("");
        nome.setText("");
        sexo.clearSelection();
        disc.deselect(0);
        disc.deselect(1);
        disc.deselect(2);
        disc.deselect(3);
        disc.deselect(4);
        disc.deselect(5);
        disc.deselect(6);
        disc.deselect(7);
        coment.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        NOME = nome.getText();
        SEXO = OpcSexual();
        LISTADISC = Discs();
        COMENTARIO = coment.getText();

        boolean clicado = true;

        if (cad.hasFocus() == clicado) {

            if (nome.getText().trim().equals("") || sexo.getSelection() == null || disc.getSelectedItems() == null || coment.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Algum Campo está vazio!");
            } else {
                Confirma cf = new Confirma();
            }
        }
        if (sair.hasFocus() == clicado) {
            this.setVisible(false);
            Login l = new Login();
        }

    }

}
