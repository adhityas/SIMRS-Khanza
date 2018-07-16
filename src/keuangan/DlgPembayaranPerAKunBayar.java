/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgLhtBiaya.java
 *
 * Created on 12 Jul 10, 16:21:34
 */

package keuangan;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author perpustakaan
 */
public final class DlgPembayaranPerAKunBayar extends javax.swing.JDialog {
    private final Connection koneksi=koneksiDB.condb();
    private final sekuel Sequel=new sekuel();
    private final validasi Valid=new validasi();
    private PreparedStatement ps,psjamshift,psakunbayar;
    private ResultSet rs,rsjamshift,rsakunbayar;
    private double all=0,bayar=0;
    private int i,kolom=0,no=0;
    private String shift="",tanggal2="",nonota="",petugas="",norawatjalan="",norawatinap="",notajual="";
    private StringBuilder htmlContent;
    private String[] akunbayar;
    private double[] totalbayar;

    /** Creates new form DlgLhtBiaya
     * @param parent
     * @param modal */
    public DlgPembayaranPerAKunBayar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,674);

        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        User.setDocument(new batasInput((byte)100).getKata(User));
        if(koneksiDB.cariCepat().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {tampil();}
                @Override
                public void removeUpdate(DocumentEvent e) {tampil();}
                @Override
                public void changedUpdate(DocumentEvent e) {tampil();}
            });
            User.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {tampil();}
                @Override
                public void removeUpdate(DocumentEvent e) {tampil();}
                @Override
                public void changedUpdate(DocumentEvent e) {tampil();}
            });
        }  
        InputModalAwal.setDocument(new batasInput((byte)16).getOnlyAngka(InputModalAwal));
        LoadHTML.setEditable(true);
        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{border-right: 1px solid #edf2e8;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi2 td{font: 8.5px tahoma;height:12px;background: #ffffff;color:#826464;}"+
                ".head td{border-right: 1px solid #777777;font: 8.5px tahoma;height:10px;border-bottom: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi3 td{border-right: 1px solid #edf2e8;font: 8.5px tahoma;height:12px;border-top: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi4 td{font: 11px tahoma;height:12px;background: #ffffff;color:#826464;}"
        );
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);
    }    
    
     

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WindowModalAwal = new javax.swing.JDialog();
        internalFrame2 = new widget.InternalFrame();
        InputModalAwal = new widget.TextBox();
        jLabel8 = new widget.Label();
        BtnCloseIn = new widget.Button();
        BtnSimpan2 = new widget.Button();
        internalFrame1 = new widget.InternalFrame();
        panelGlass5 = new widget.panelisi();
        label17 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        jLabel11 = new javax.swing.JLabel();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass6 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        jLabel9 = new widget.Label();
        CmbStatus = new widget.ComboBox();
        label19 = new widget.Label();
        User = new widget.TextBox();
        Scroll = new widget.ScrollPane();
        LoadHTML = new widget.editorpane();

        WindowModalAwal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        WindowModalAwal.setName("WindowModalAwal"); // NOI18N
        WindowModalAwal.setUndecorated(true);
        WindowModalAwal.setResizable(false);

        internalFrame2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Input Modal Awal ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(130,100,100))); // NOI18N
        internalFrame2.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setWarnaBawah(new java.awt.Color(240, 245, 235));
        internalFrame2.setLayout(null);

        InputModalAwal.setHighlighter(null);
        InputModalAwal.setName("InputModalAwal"); // NOI18N
        InputModalAwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputModalAwalKeyPressed(evt);
            }
        });
        internalFrame2.add(InputModalAwal);
        InputModalAwal.setBounds(84, 27, 170, 23);

        jLabel8.setText("Modal Awal :");
        jLabel8.setName("jLabel8"); // NOI18N
        internalFrame2.add(jLabel8);
        jLabel8.setBounds(0, 27, 80, 23);

        BtnCloseIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnCloseIn.setMnemonic('U');
        BtnCloseIn.setText("Tutup");
        BtnCloseIn.setToolTipText("Alt+U");
        BtnCloseIn.setName("BtnCloseIn"); // NOI18N
        BtnCloseIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseInActionPerformed(evt);
            }
        });
        BtnCloseIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCloseInKeyPressed(evt);
            }
        });
        internalFrame2.add(BtnCloseIn);
        BtnCloseIn.setBounds(380, 25, 100, 30);

        BtnSimpan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan2.setMnemonic('S');
        BtnSimpan2.setText("Simpan");
        BtnSimpan2.setToolTipText("Alt+S");
        BtnSimpan2.setName("BtnSimpan2"); // NOI18N
        BtnSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan2ActionPerformed(evt);
            }
        });
        BtnSimpan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpan2KeyPressed(evt);
            }
        });
        internalFrame2.add(BtnSimpan2);
        BtnSimpan2.setBounds(275, 25, 100, 30);

        WindowModalAwal.getContentPane().add(internalFrame2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Pembayaran Per Akun Bayar ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(130,100,100))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass5.setName("panelGlass5"); // NOI18N
        panelGlass5.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label17.setText("Key Word :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(60, 23));
        panelGlass5.add(label17);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(195, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass5.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnAll);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(130,100,100));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setName("jLabel11"); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(30, 23));
        panelGlass5.add(jLabel11);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnKeluar);

        internalFrame1.add(panelGlass5, java.awt.BorderLayout.PAGE_END);

        panelGlass6.setName("panelGlass6"); // NOI18N
        panelGlass6.setPreferredSize(new java.awt.Dimension(55, 45));
        panelGlass6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Tanggal Tagihan :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(100, 23));
        panelGlass6.add(label11);

        Tgl1.setEditable(false);
        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass6.add(Tgl1);

        jLabel9.setText("Shift :");
        jLabel9.setName("jLabel9"); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass6.add(jLabel9);

        CmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua", "Pagi", "Siang", "Sore", "Malam" }));
        CmbStatus.setName("CmbStatus"); // NOI18N
        CmbStatus.setOpaque(false);
        CmbStatus.setPreferredSize(new java.awt.Dimension(100, 23));
        panelGlass6.add(CmbStatus);

        label19.setText("User :");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass6.add(label19);

        User.setName("User"); // NOI18N
        User.setPreferredSize(new java.awt.Dimension(150, 23));
        User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserKeyPressed(evt);
            }
        });
        panelGlass6.add(User);

        internalFrame1.add(panelGlass6, java.awt.BorderLayout.PAGE_START);

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N
        Scroll.setViewportView(LoadHTML);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {            
            File g = new File("fileakunbayar.css");            
            BufferedWriter bg = new BufferedWriter(new FileWriter(g));
            bg.write(
                ".isi td{border-right: 1px solid #edf2e8;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi2 td{font: 8.5px tahoma;height:12px;background: #ffffff;color:#826464;}"+
                ".head td{border-right: 1px solid #777777;font: 8.5px tahoma;height:10px;border-bottom: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi3 td{border-right: 1px solid #edf2e8;font: 8.5px tahoma;height:12px;border-top: 1px solid #edf2e8;background: #ffffff;color:#826464;}"+
                ".isi4 td{font: 11px tahoma;height:12px;background: #ffffff;color:#826464;}"
            );
            bg.close();
            
            File f = new File("PembayaranPerAkunBayar.html");            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));            
            bw.write(LoadHTML.getText().replaceAll(
                    "<head>","<head><link href=\"fileakunbayar.css\" rel=\"stylesheet\" type=\"text/css\" />"+
                        "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                            "<tr class='isi2'>"+
                                "<td valign='top' align='center'>"+
                                    "<font size='4' face='Tahoma'>"+var.getnamars()+"</font><br>"+
                                    var.getalamatrs()+", "+var.getkabupatenrs()+", "+var.getpropinsirs()+"<br>"+
                                    var.getkontakrs()+", E-mail : "+var.getemailrs()+"<br><br>"+
                                    "<font size='2' face='Tahoma'>PEMBAYARAN PER AKUN BAYAR<br>TANGGAL "+Tgl1.getSelectedItem()+"<br><br></font>"+        
                                "</td>"+
                           "</tr>"+
                        "</table>")
            );
            bw.close();                         
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            System.out.println("Notifikasi : "+e);
        }     
        
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, Tgl1,BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnKeluar,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnPrint);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            tampil();
            this.setCursor(Cursor.getDefaultCursor());
        }else{
            Valid.pindah(evt,TCari, BtnPrint);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void InputModalAwalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputModalAwalKeyPressed
        Valid.pindah(evt,BtnCloseIn,TCari);
    }//GEN-LAST:event_InputModalAwalKeyPressed

    private void BtnCloseInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseInActionPerformed
        WindowModalAwal.dispose();
    }//GEN-LAST:event_BtnCloseInActionPerformed

    private void BtnCloseInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCloseInKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            WindowModalAwal.dispose();
        }else{Valid.pindah(evt, BtnSimpan2, InputModalAwal);}
    }//GEN-LAST:event_BtnCloseInKeyPressed

    private void BtnSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan2ActionPerformed
        if(InputModalAwal.getText().trim().equals("")){
            Valid.textKosong(InputModalAwal,"Modal Awal");
        }else{
            Sequel.queryu("delete from set_modal_payment");
            Sequel.menyimpan("set_modal_payment","'"+InputModalAwal.getText()+"'","Modal Awal");
            WindowModalAwal.setVisible(false);
        }
    }//GEN-LAST:event_BtnSimpan2ActionPerformed

    private void BtnSimpan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpan2KeyPressed
        Valid.pindah(evt,InputModalAwal,BtnCloseIn);
    }//GEN-LAST:event_BtnSimpan2KeyPressed

    private void UserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgPembayaranPerAKunBayar dialog = new DlgPembayaranPerAKunBayar(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnCloseIn;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan2;
    private widget.ComboBox CmbStatus;
    private widget.TextBox InputModalAwal;
    private widget.editorpane LoadHTML;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.Tanggal Tgl1;
    private widget.TextBox User;
    private javax.swing.JDialog WindowModalAwal;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private javax.swing.JLabel jLabel11;
    private widget.Label jLabel8;
    private widget.Label jLabel9;
    private widget.Label label11;
    private widget.Label label17;
    private widget.Label label19;
    private widget.panelisi panelGlass5;
    private widget.panelisi panelGlass6;
    // End of variables declaration//GEN-END:variables

    public void tampil(){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
        try{        
            htmlContent = new StringBuilder();
            htmlContent.append(                             
                "<tr class='head'>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='27px'>No.</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='110px'>Tanggal</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='50px'>Shift</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='100px'>No.Rawat/No.Nota</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='220px'>Nama Pasien</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='80px'>Pembayaran</td>"+
                    "<td valign='middle' bgcolor='#fafff5' align='center' width='130px'>Petugas</td>");
            kolom=0;
            akunbayar=new String[Sequel.cariInteger("select count(nama_bayar) from akun_bayar")];
            psakunbayar=koneksi.prepareStatement("select nama_bayar from akun_bayar order by nama_bayar");
            try {
                rsakunbayar=psakunbayar.executeQuery();
                while(rsakunbayar.next()){
                    akunbayar[kolom]=rsakunbayar.getString("nama_bayar");
                    kolom++;
                    htmlContent.append("<td valign='middle' bgcolor='#fafff5' align='center' width='130px'>"+rsakunbayar.getString("nama_bayar")+"</td>");
                }
            } catch (Exception e) {
                System.out.println("Akun Bayar : "+e);
            } finally{
                if(rsakunbayar!=null){
                    rsakunbayar.close();
                }
                if(psakunbayar!=null){
                    psakunbayar.close();
                }
            }
            totalbayar=new double[kolom];            
            htmlContent.append(
                "</tr>"
            );   
            
            psjamshift=koneksi.prepareStatement("select * from closing_kasir");
            try {
                rsjamshift=psjamshift.executeQuery();
                all=0;
                while(rsjamshift.next()){ 
                    ps= koneksi.prepareStatement(
                            "select no_nota,tgl_bayar,nama_pasien,jumlah_bayar,petugas from tagihan_sadewa "+
                            "where tgl_bayar between ? and ? and nama_pasien like ? or "+
                            "tgl_bayar between ? and ? and no_nota like ? order by tgl_bayar,no_nota");
                    try {
                        ps.setString(1,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" "+rsjamshift.getString("jam_masuk"));                        
                        ps.setString(3,"%"+TCari.getText().trim()+"%");
                        ps.setString(4,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" "+rsjamshift.getString("jam_masuk"));
                        if(rsjamshift.getString("shift").equals("Malam")){
                            tanggal2=Sequel.cariIsi("select DATE_ADD('"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+" "+rsjamshift.getString("jam_pulang")+"',INTERVAL 1 DAY)");
                            ps.setString(2,tanggal2);
                            ps.setString(5,tanggal2);
                        }else{
                            ps.setString(2,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" "+rsjamshift.getString("jam_pulang"));
                            ps.setString(5,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" "+rsjamshift.getString("jam_pulang"));
                        }
                        ps.setString(6,"%"+TCari.getText().trim()+"%");
                        rs=ps.executeQuery();
                        no=1;
                        while(rs.next()){                            
                            petugas=rs.getString("petugas")+" "+Sequel.cariIsi("select nama from pegawai where nik=?",rs.getString("petugas"));
                            if(CmbStatus.getSelectedItem().toString().equals("Semua")){
                                norawatinap="";
                                norawatjalan="";
                                notajual="";
                                nonota=Sequel.cariIsi("select no_nota from nota_inap where no_rawat=?",rs.getString("no_nota"));
                                if(!nonota.equals("")){
                                    norawatinap=rs.getString("no_nota");
                                }else if(nonota.equals("")){
                                    nonota=Sequel.cariIsi("select no_nota from nota_jalan where no_rawat=?",rs.getString("no_nota"));
                                    if(!nonota.equals("")){
                                        norawatjalan=rs.getString("no_nota");
                                    }else if(nonota.equals("")){
                                        nonota=Sequel.cariIsi("select nota_jual from penjualan where nota_jual=?",rs.getString("no_nota"));
                                        if(!nonota.equals("")){
                                            notajual=rs.getString("no_nota");
                                        }else {
                                            notajual="";
                                        }                                            
                                    }
                                }
                                if(petugas.toLowerCase().trim().contains(User.getText().toLowerCase().trim())){
                                    all=all+rs.getDouble("jumlah_bayar");
                                    htmlContent.append(                             
                                        "<tr class='isi'>"+
                                            "<td valign='middle' align='center'>"+no+"</td>"+
                                            "<td valign='middle' align='center'>"+rs.getString("tgl_bayar")+"</td>"+
                                            "<td valign='middle' align='center'>"+rsjamshift.getString("shift")+"</td>"+
                                            "<td valign='middle' align='center'>"+nonota+"</td>"+
                                            "<td valign='middle' align='left'>"+rs.getString("nama_pasien")+"</td>"+
                                            "<td valign='middle' align='right'>"+Valid.SetAngka(rs.getDouble("jumlah_bayar"))+"</td>"+
                                            "<td valign='middle' align='left'>"+petugas+"</td>");
                                    for(i=0;i<kolom;i++){
                                        bayar=0;
                                        if(!norawatinap.equals("")){
                                            bayar=Sequel.cariIsiAngka("select besar_bayar from detail_nota_inap where no_rawat='"+norawatinap+"' and nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else if(!norawatjalan.equals("")){
                                            bayar=Sequel.cariIsiAngka("select besar_bayar from detail_nota_jalan where no_rawat='"+norawatjalan+"' and nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else if(!notajual.equals("")){
                                            bayar=Sequel.cariIsiAngka("select sum(total) from detailjual inner join penjualan on penjualan.nota_jual=detailjual.nota_jual where penjualan.nota_jual='"+notajual+"' and penjualan.nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else{
                                            bayar=0;
                                            htmlContent.append("<td valign='middle' align='right'>Pemasukan Lain</td>");
                                        }  
                                        totalbayar[i]=totalbayar[i]+bayar;
                                    }
                                    htmlContent.append( 
                                        "</tr>"
                                    ); 
                                }                                    
                            }else if(rsjamshift.getString("shift").equals(CmbStatus.getSelectedItem().toString())){
                                norawatinap="";
                                norawatjalan="";
                                notajual="";
                                nonota=Sequel.cariIsi("select no_nota from nota_inap where no_rawat=?",rs.getString("no_nota"));
                                if(!nonota.equals("")){
                                    norawatinap=rs.getString("no_nota");
                                }else if(nonota.equals("")){
                                    nonota=Sequel.cariIsi("select no_nota from nota_jalan where no_rawat=?",rs.getString("no_nota"));
                                    if(!nonota.equals("")){
                                        norawatjalan=rs.getString("no_nota");
                                    }else if(nonota.equals("")){
                                        nonota=Sequel.cariIsi("select nota_jual from penjualan where nota_jual=?",rs.getString("no_nota"));
                                        if(!nonota.equals("")){
                                            notajual=rs.getString("no_nota");
                                        }else {
                                            notajual="";
                                        }                                            
                                    }
                                }
                                if(petugas.toLowerCase().trim().contains(User.getText().toLowerCase().trim())){
                                    all=all+rs.getDouble("jumlah_bayar");
                                    htmlContent.append(                             
                                        "<tr class='isi'>"+
                                            "<td valign='middle' align='center'>"+no+"</td>"+
                                            "<td valign='middle' align='center'>"+rs.getString("tgl_bayar")+"</td>"+
                                            "<td valign='middle' align='center'>"+rsjamshift.getString("shift")+"</td>"+
                                            "<td valign='middle' align='center'>"+nonota+"</td>"+
                                            "<td valign='middle' align='left'>"+rs.getString("nama_pasien")+"</td>"+
                                            "<td valign='middle' align='right'>"+Valid.SetAngka(rs.getDouble("jumlah_bayar"))+"</td>"+
                                            "<td valign='middle' align='left'>"+petugas+"</td>");
                                    for(i=0;i<kolom;i++){
                                        bayar=0;
                                        if(!norawatinap.equals("")){
                                            bayar=Sequel.cariIsiAngka("select besar_bayar from detail_nota_inap where no_rawat='"+norawatinap+"' and nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else if(!norawatjalan.equals("")){
                                            bayar=Sequel.cariIsiAngka("select besar_bayar from detail_nota_jalan where no_rawat='"+norawatjalan+"' and nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else if(!notajual.equals("")){
                                            bayar=Sequel.cariIsiAngka("select sum(total) from detailjual inner join penjualan on penjualan.no_nota=detailjual.no_nota where penjualan.no_nota='"+notajual+"' and penjualan.nama_bayar='"+akunbayar[i]+"'");
                                            htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(bayar)+"</td>");
                                        }else{
                                            bayar=0;
                                            htmlContent.append("<td valign='middle' align='right'>Pemasukan Lain</td>");
                                        }  
                                        totalbayar[i]=totalbayar[i]+bayar;
                                    }
                                    htmlContent.append( 
                                        "</tr>"
                                    ); 
                                }                                    
                            }
                            no++;                            
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }                
                }
            } catch (Exception e) {
                System.out.println("Notifikasi : "+e);
            } finally{
                if(rsjamshift!=null){
                    rsjamshift.close();
                }
                if(psjamshift!=null){
                    psjamshift.close();
                }
            }
            
            htmlContent.append(                             
                "<tr class='isi'>"+
                    "<td valign='middle' align='center'></td>"+
                    "<td valign='middle' align='right'>Total :</td>"+
                    "<td valign='middle' align='center'></td>"+
                    "<td valign='middle' align='center'></td>"+
                    "<td valign='middle' align='left'></td>"+
                    "<td valign='middle' align='right'>"+Valid.SetAngka(all)+"</td>"+
                    "<td valign='middle' align='left'></td>");
            for(i=0;i<kolom;i++){
                htmlContent.append("<td valign='middle' align='right'>"+Valid.SetAngka(totalbayar[i])+"</td>"); 
            }
            htmlContent.append( 
                "</tr>"
            );            
            if(kolom==0){
                LoadHTML.setText(
                        "<html>"+
                          "<table width='100%' border='0' align='left' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                           htmlContent.toString()+
                          "</table>"+
                        "</html>");
            }else if(kolom>2){
                LoadHTML.setText(
                        "<html>"+
                          "<table width='1200px' border='0' align='left' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                           htmlContent.toString()+
                          "</table>"+
                        "</html>");
            }else if(kolom>6){
                LoadHTML.setText(
                        "<html>"+
                          "<table width='1700px' border='0' align='left' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                           htmlContent.toString()+
                          "</table>"+
                        "</html>");
            }else if(kolom>12){
                LoadHTML.setText(
                        "<html>"+
                          "<table width='2100px' border='0' align='left' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                           htmlContent.toString()+
                          "</table>"+
                        "</html>");
            }                
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }    

}
