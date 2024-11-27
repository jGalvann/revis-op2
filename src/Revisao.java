import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Revisao {
    private JTextField txtCampoTexto;
    private JTextArea txtArea;
    private JList listLista;
    private JTable tblTable;
    private JSpinner spnSpinner;
    private JLabel lblLabel;
    private JPanel panelMain;
    private JButton btnBotone;
    //----------------------------------------------------------------------
        // configurando o Spinner
        // cria uma função pra essa fita aq
        private void configurandoSpinner() {
            // spinner trabalha COM UM MODELO
            // o modelo que to usando é O DE DATA
            spnSpinner.setModel(new SpinnerDateModel());
            // .dateEditor edita esse modelo seu porra
            // este recebe 2 argumentos, spnSpinner( sendo a fita que tu vai mexer)
            // e o formato qual vai ser exibido ( dd/MM/yyyy) ou (HH:mm) tem uns outros mas se quiser saber procure
            JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnSpinner, "dd/MM/yyyy");
            // e não esquece de atribuir o modelo que se criou
            spnSpinner.setEditor(editorData);

        }
    //----------------------------------------------------------------------

    public Revisao(){
    //----------------------------------------------------------------------
        // JLIST AQUI
    // o JList n pode ser utilizado no seco, precisa fazer isso antes:
        DefaultListModel<String> modelo = new DefaultListModel<>();
        listLista.setModel(modelo);
    // ----------------------------------------------------------------------
    // JTABLE AQUI
        // como a JTABLE tabalha com tabelas, tu precisa confirar essa fita
        DefaultTableModel modeloTable = new DefaultTableModel(
                // aqui tem 3 COLUNAS( texto 1, texto2, texto3, mais o 0, que faz com que comece zerado)
                new String[] {"texto1", "texto2","texto3"}, 0
        );
        // atribuindo o modelo a table
        tblTable.setModel(modeloTable);
    //----------------------------------------------------------------------

    configurandoSpinner();

    //----------------------------------------------------------------------

    btnBotone.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String texto = txtCampoTexto.getText();




            if(texto.contains("label")){
                lblLabel.setText(texto);
            } else if (texto.contains("textArea")) {
               // txtArea.setText(texto + "\n"); // aqui seta o texto
               // txtArea.append(texto); // aqui seta o texto NO FINAL DO TEXTO QUE JÁ TEM

                // PARA ADICIONAR TEXTO UM EM BAIXO DO OUTRO, FAZ O SEGUINTE
                txtArea.append(texto + "\n"); // append = concatenar
            } else if (texto.contains("lista")) {
                // aqui estou tirando a palavra lista da variavel
                String textoParaLista = texto.replace("lista", "");
                // aqui concatenando 2 variaveis ( aq são iguais, mas acho que o cleiton pode pedir mais de
                // 1 item para ser concatenado)
                String addLista = textoParaLista + textoParaLista;
                // como o JList segue um modelo, primeiro tu crias o modelo, e depois muda ele aqui, logo, muda o JList
                modelo.addElement(addLista);

            } else if (texto.contains("table")){
                String textoTable = texto.replace("table", "");
                modeloTable.addRow(new Object[]{textoTable,textoTable,textoTable});
                // estou usando somente 1 variavel para dar o exemplo, mas se o cleiton pedir mais de uma, é só mudar.
            }else{
                // aqui, caso não especifique onde quer que mande o texto, ele manda em todos
                lblLabel.setText(texto);
                txtArea.append(texto + "\n"); // append = concatenar
                modelo.addElement(texto);
                modeloTable.addRow(new Object[]{texto,texto,texto});
            }


        }
    });


    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Revisao().panelMain);
        frame.setVisible(true);
        frame.setSize(500,500);

    }

}