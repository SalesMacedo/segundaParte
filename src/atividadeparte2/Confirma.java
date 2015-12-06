/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeparte2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sales
 */
public class Confirma extends JFrame implements ActionListener {

    FormularioPreenchimentoNull fm;

    public void MOSTRAR() {
        JOptionPane.showMessageDialog(null, "NOME: " + fm.NOME + "\n" + "SEXO: " + fm.SEXO + "\n" + "\n[ DISCIPLINAS ]" + fm.LISTADISC + "\n\n" + "COMENTARIO: " + fm.COMENTARIO);
        
        
    }

    public Confirma() {
        super("Confirmação");
        this.setVisible(true);
        this.setSize(400, 130);
        this.setResizable(false);
        this.setLocation(450, 300);
        //fm.mostraTudo();
        responde();
    }
    JButton sim = new JButton("Confirmar");
    JButton nao = new JButton("Cancelar");

    private void responde() {

        JLabel pergunta = new JLabel("Deseja realmente cadastrar estas informações?");
        pergunta.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));

        JPanel confirmacao = new JPanel();
        confirmacao.setLayout(null);

        sim.setFont(new Font("Arial", Font.BOLD, 14));
        nao.setFont(new Font("Arial", Font.BOLD, 14));

        sim.setSize(130, 25);
        sim.setLocation(30, 60);

        nao.setSize(130, 25);
        nao.setLocation(234, 60);

        pergunta.setSize(400, 30);
        pergunta.setLocation(18, 10);

        confirmacao.add(pergunta);
        confirmacao.add(sim);
        confirmacao.add(nao);

        confirmacao.setBackground(Color.getHSBColor(219, 112, 147));

        //add(Panelpergunta, BorderLayout.NORTH);
        add(confirmacao, BorderLayout.CENTER);

        sim.addActionListener(this);
        nao.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nao) {
            this.dispose();
        } else if (e.getSource() == sim) {
            this.setVisible(false);
            MOSTRAR();
          
        }
    }

}
