/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anadiapp.ui;

import anadiapp.controller.AppController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import anadiapp.model.ConnectData;
import anadiapp.model.JobLauncher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author skimi
 */
public class AppUi extends javax.swing.JFrame {

    /**
     * Creates new form AppUi
     */
    AppController ac = new AppController(this);
    ArrayList<ConnectData> connectdata = new ArrayList<ConnectData>();

    public AppUi() {
        initComponents();
        setResizable(false);
        ((DefaultCaret) txtResults.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAmostragem = new javax.swing.JTextField();
        txtPorto = new javax.swing.JTextField();
        txtNoRede = new javax.swing.JTextField();
        txtTempoLimite = new javax.swing.JTextField();
        txtDuracaoTeste = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnExecutar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResults = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTestes = new javax.swing.JList<ConnectData>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        labelTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMaximumSize(null);
        setMinimumSize(null);
        setResizable(false);

        jPanel1.setMaximumSize(null);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("Intervalo de Amostragem (seg)");

        jLabel2.setText("Número do Porto do Serviço (Entre 0 e 65535)");

        jLabel3.setText("Identificação do nó de rede ");

        jLabel4.setText("Tempo máximo para estabelecer a ligação TCP (seg)");

        jLabel5.setText("Tempo de duração do teste (min)");

        txtAmostragem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmostragem.setText("5");
        txtAmostragem.setToolTipText("em segundos");

        txtPorto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPorto.setText("80");
        txtPorto.setToolTipText("Entre 0 e 65535");

        txtNoRede.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNoRede.setText("www.isep.ipp.pt");
        txtNoRede.setToolTipText("(endereço IPv4, endereço IPv6 ou nome DNS) ");

        txtTempoLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempoLimite.setText("50");
        txtTempoLimite.setToolTipText("em segundos");

        txtDuracaoTeste.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuracaoTeste.setText("1");
        txtDuracaoTeste.setToolTipText("em minutos");

        btnAdd.setText("Adicionar");
        btnAdd.setMaximumSize(new java.awt.Dimension(90, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(90, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(90, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remover");
        btnRemove.setMaximumSize(new java.awt.Dimension(90, 23));
        btnRemove.setMinimumSize(new java.awt.Dimension(90, 23));
        btnRemove.setPreferredSize(new java.awt.Dimension(90, 23));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnExecutar.setText("Executar");
        btnExecutar.setMaximumSize(new java.awt.Dimension(90, 23));
        btnExecutar.setMinimumSize(new java.awt.Dimension(90, 23));
        btnExecutar.setPreferredSize(new java.awt.Dimension(90, 23));
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(90, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(90, 23));
        btnCancelar.setPreferredSize(new java.awt.Dimension(90, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Testes a executar:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Estado dos testes a decorrer:");

        txtResults.setColumns(20);
        txtResults.setRows(5);
        txtResults.setToolTipText("Detalhes de execução dos testes");
        jScrollPane2.setViewportView(txtResults);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("ANADI Recolha de dados");

        txtTestes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        txtTestes.setToolTipText("Ligações para execução");
        jScrollPane3.setViewportView(txtTestes);

        jButton1.setLabel("Limpar");
        jButton1.setMaximumSize(new java.awt.Dimension(90, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(90, 23));
        jButton1.setName(""); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(90, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2)
                                    .addComponent(jScrollPane3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTempoLimite, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNoRede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addComponent(txtPorto, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDuracaoTeste)
                                            .addComponent(txtAmostragem, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 6, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAmostragem)
                        .addComponent(jLabel1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPorto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoRede, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTempoLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDuracaoTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if ((txtAmostragem.getText().equals("")) || (txtDuracaoTeste.getText().equals("")) || (txtNoRede.getText().equals("")) || (txtPorto.getText().equals("")) || (txtTempoLimite.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Tem de preencher todos os dados para a ligação.");
        } else if ((Integer.parseInt(txtAmostragem.getText()) < 1)) {
            JOptionPane.showMessageDialog(this, "Amostragem tem de ser maior que 0.");
        } else if ((Integer.parseInt(txtPorto.getText()) < 1) || (Integer.parseInt(txtPorto.getText()) > 65535)) {
            JOptionPane.showMessageDialog(this, "Porto tem de ser maior que 0 e menor do que 65535.");
        } else if ((Integer.parseInt(txtTempoLimite.getText()) < 1)) {
            JOptionPane.showMessageDialog(this, "Tempo Limite tem de ser maior que 0.");
        } else if ((Float.parseFloat(txtDuracaoTeste.getText()) < 1)) {
            JOptionPane.showMessageDialog(this, "Duração do teste tem de ser maior que 0.");
        } else {
            int timeInterval = Integer.parseInt(txtAmostragem.getText());
            int port = Integer.parseInt(txtPorto.getText());
            String node = txtNoRede.getText();
            int timeout = Integer.parseInt(txtTempoLimite.getText());
            float duration = Float.parseFloat(txtDuracaoTeste.getText());

            ConnectData cd = new ConnectData(timeInterval, port, node, timeout, duration);
            DefaultListModel Jlista = new DefaultListModel();
            connectdata.add(cd);

            for (ConnectData connectData : connectdata) {
                Jlista.addElement(connectData);
            }
            txtTestes.setModel(Jlista);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        connectdata.remove(txtTestes.getSelectedValue());
        DefaultListModel Jlista = new DefaultListModel();
        for (ConnectData connectData : connectdata) {
            Jlista.addElement(connectData);
        }
        txtTestes.setModel(Jlista);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
        if (connectdata.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tem de adicionar testes para execução.");
        } else {
            time();
            DisableForm();
            // ATENCAO: Lançar thread aqui para manter UI livre para ações
            new Thread(new Runnable() {
                @Override
                public void run() {
                    setText("A iniciar a recolha de dados..." + "\n");
                    if (ac.executeTest(connectdata)) {
                    } else {
                        setText(getTextResult() + "O teste falhou devido a erros de concorrência!" + "\n");
                        return;
                    }

                    setText(getTextResult() + "A iniciar a exportação de dados..." + "\n");
                    ac.export(txtResults);
                }

            }).start();

        }
    }//GEN-LAST:event_btnExecutarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        enableForm();
        clearForm();
        this.ac.stopThreads();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtTestes.setModel(new DefaultListModel<ConnectData>());
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppUi().setVisible(true);
            }
        });
    }

    private String returnResult() {
        return this.txtResults.getText();
    }

    private String getTextResult() {
        return returnResult();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelTime;
    private javax.swing.JTextField txtAmostragem;
    private javax.swing.JTextField txtDuracaoTeste;
    private javax.swing.JTextField txtNoRede;
    private javax.swing.JTextField txtPorto;
    private javax.swing.JTextArea txtResults;
    private javax.swing.JTextField txtTempoLimite;
    private javax.swing.JList<ConnectData> txtTestes;
    // End of variables declaration//GEN-END:variables

    public void setText(String string) {
        String test = getTextResult();
        this.txtResults.setText(test + string);
    }

    public void DisableForm() {
        this.txtAmostragem.setEnabled(false);
        this.txtDuracaoTeste.setEnabled(false);
        this.txtNoRede.setEnabled(false);
        this.txtPorto.setEnabled(false);
        this.txtTempoLimite.setEnabled(false);
        this.txtTestes.setEnabled(false);
        this.btnAdd.setEnabled(false);
        this.btnRemove.setEnabled(false);
        this.btnExecutar.setEnabled(false);
        this.jButton1.setEnabled(false);
    }

    public void enableForm() {
        this.txtAmostragem.setEnabled(true);
        this.txtDuracaoTeste.setEnabled(true);
        this.txtNoRede.setEnabled(true);
        this.txtPorto.setEnabled(true);
        this.txtTempoLimite.setEnabled(true);
        this.txtTestes.setEnabled(true);
        this.btnAdd.setEnabled(true);
        this.btnRemove.setEnabled(true);
        this.btnExecutar.setEnabled(true);
        this.jButton1.setEnabled(true);
    }

    public void clearForm() {
        this.txtAmostragem.setText("");
        this.txtDuracaoTeste.setText("");
        this.txtNoRede.setText("");
        this.txtPorto.setText("");
        setText("");
        this.txtTempoLimite.setText("");
        this.txtTestes.setModel(new DefaultListModel<ConnectData>());
    }

    public void time() {
        this.labelTime.setText("Inciar contagem...");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = Integer.parseInt(txtDuracaoTeste.getText()) * 60;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                labelTime.setText(format(time / 60) + ":" + format(time % 60));
                if (time == 0) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                }
            }
        });
        t.start();
    }

    private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
}
