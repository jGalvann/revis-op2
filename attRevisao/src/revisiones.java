import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
    add titulo da tarefa txtField
    add a tarefa na lista
    exibir na table com o numero da att e o nome
    mostrar a quantidade total de tarefas com jlabel



 */
public class revisiones {
    private JTextField txtEntrada;
    private JButton btnAddAtt;
    private JList listLista;
    private JTable tblTable;
    private JLabel lblQuantiaAtt;
    private JPanel mainPanel;

private int id = 1;
    revisiones(){
        String texto1 = "";
        String texto2 = "";

        // criando modelo e atribuindo noq precisa
        DefaultListModel modeloLista = new DefaultListModel();
        listLista.setModel(modeloLista);

        DefaultTableModel modeloTable = new DefaultTableModel(
           new String[]{texto1,texto2},0
        );
        tblTable.setModel(modeloTable);

    btnAddAtt.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            String att = txtEntrada.getText();

            if(!att.isEmpty()){
            modeloLista.addElement(att);

            modeloTable.addRow(new Object[]{id,att});

              lblQuantiaAtt.setText("a quantidade de atividades é " + id);
                id++;
            }















        }
    });



    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Atividade");
        frame.setContentPane(new revisiones().mainPanel);
        frame.setSize(500,500);
        frame.setVisible(true);

    }




}
