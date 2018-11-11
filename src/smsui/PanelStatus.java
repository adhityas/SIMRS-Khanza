/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelStatus.java
 *
 * Created on 20 Jun 10, 16:20:00
 */

package smsui;

import javax.swing.ImageIcon;

/**
 *
 * @author perpustakaan
 */
public class PanelStatus extends javax.swing.JPanel {
    public static final int KONEKSI_Catatan = 0;
    public static final int TERSAMBUNG = 1;
    public static final int TERPUTUS = 3;

    /** Creates new form PanelStatus */
    public PanelStatus() {
        initComponents();
    }

    public void setStatusKoneksi(int status, String s){
        if(status == KONEKSI_Catatan ){
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/smsimage/Catatan.png")));
            jLabel1.setText(s);
        }else if(status == TERSAMBUNG ){
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/smsimage/mobile_phone.png")));
            jLabel1.setText(s);
        }else if(status == TERPUTUS ){
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/smsimage/mobile_phone_off.png")));
            jLabel1.setText(s);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 250, 240));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 242, 232), 1, true));
        setOpaque(false);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100,80,80));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smsimage/mobile_phone.png"))); // NOI18N
        jLabel1.setText("Tidak ada Service");
        jLabel1.setName("jLabel1"); // NOI18N
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
