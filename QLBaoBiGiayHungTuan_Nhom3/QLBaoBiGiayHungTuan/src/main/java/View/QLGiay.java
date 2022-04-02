/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ControlData.Giay;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public final class QLGiay extends javax.swing.JFrame {
    public boolean cothem = true ;
    public Giay GiayDB = new Giay();
    public DefaultTableModel tableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
          return false;
        }
    };

   
    public QLGiay() throws SQLException {
        initComponents();
        String [] colName = {"Mã loại Giấy", "Tên Giấy", "Giá"};
        tableModel.setColumnIdentifiers(colName);
        tblQLGiay.setModel(tableModel);
        ShowData();
        SetKhoa(true);
        SetButton(false);
    }
    public void ShowData() throws SQLException{
        ResultSet rs = GiayDB.ShowGiay();
        try {
            while (rs.next()){
                String row[] = new String[3];
                row[0]= rs.getString(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
        }
    }
    public void ClearData() throws  SQLException{
        //Lay chi so dong cuoi cung
        int n= tableModel.getRowCount()-1;
        for(int i=n;i>=0; i--)
            tableModel.removeRow(i);//Remove tung dong
    }
    public void SetKhoa(boolean a){
        txtTenGiay.setEnabled(!a);
        txtGia.setEnabled(!a);
    }
    public void SetNull (){
        txtMaGiay.setText(null);
        txtTenGiay.setText(null);
        txtGia.setText(null);
    }
    public void SetButton (boolean a){
        btnLuu.setEnabled(a);
        btnKhongLuu.setEnabled(a);
        btnSua.setEnabled(!a);
        btnXoa.setEnabled(!a);
        btnThem.setEnabled(!a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnKhongLuu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaGiay = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLGiay = new javax.swing.JTable();
        txtTenGiay = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ GIẤY");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Mã Giấy :");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tên Giấy :");

        btnKhongLuu.setText("Không Lưu");
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Giá :");

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel6.setText("VNĐ");

        txtMaGiay.setEnabled(false);

        tblQLGiay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        tblQLGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLGiayMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLGiay);

        txtGia.setText("Nhập giá Giấy");
        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenGiay, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                        .addComponent(txtMaGiay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhongLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnKhongLuu)
                    .addComponent(btnThoat)
                    .addComponent(btnSua)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLGiayMouseClicked

        SetKhoa(true);
        int row = this.tblQLGiay.getSelectedRow();
        String MaGiay = this.tblQLGiay.getModel().getValueAt(row, 0).toString();
        try {
            ResultSet rs = GiayDB.Show1Giay(MaGiay);
            if (rs.next()){
                txtMaGiay.setText(rs.getString("MaGiay"));
                txtTenGiay.setText(rs.getString("TenGiay"));
                txtGia.setText(rs.getString("GiaGiay"));
            }          
        } catch (SQLException ex) {
            Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblQLGiayMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            ClearData();
        } catch (SQLException ex) {
            Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
        }
        SetKhoa(false);
        SetButton(true);   
        SetNull();
        cothem= true;
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        String Ten = txtTenGiay.getText();
        String Ma = txtMaGiay.getText();
        String Gia = txtGia.getText();
        if (cothem == true){
            if(txtTenGiay.getText().isEmpty()||txtGia.getText().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Vui lòng điền đủ thông tin cần thêm", "Thông báo", JOptionPane.CLOSED_OPTION);
                SetNull();
                SetButton(true);
                try {
                    ClearData();
                } catch (SQLException ex) {
                    Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 int sz = Gia.length();
                boolean KTso = true;
                for (int i = 0; i < sz; i++) {
                    if (!Character.isDigit(Gia.charAt(i)) ) {                  
                        KTso=false;
                    }
                }
                if(KTso==false){
                    JOptionPane.showConfirmDialog(null, "Vui lòng nhập giá đúng", "Thông báo", JOptionPane.CLOSED_OPTION);
                }
                else{
                    try {
                        int gias = Integer.parseInt(Gia);
                        GiayDB.ThemGiay(Ten, gias);
                        ClearData();
                        ShowData();
                        SetNull();
                        SetKhoa(true);
                        SetButton(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if (cothem==false){
            try {  
                int gias = Integer.parseInt(Gia);
                GiayDB.SuaGiay(Ma, Ten, gias);
                ClearData();
                ShowData();
                SetNull();
                SetKhoa(true);
                SetButton(false);
                cothem = true;
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed

        JOptionPane.showConfirmDialog(null,"Kết quả sẽ bị hủy", "Thông báo",JOptionPane.CLOSED_OPTION );
        try {
            ClearData();
            ShowData();
        } catch (SQLException ex) {
            Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
        }
        SetKhoa(true);
        SetButton(false);
        SetNull();
    }//GEN-LAST:event_btnKhongLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        String TenGiay = txtTenGiay.getText();
        if (txtMaGiay.getText().isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn một sản cần xóa", "Thông báo", JOptionPane.CLOSED_OPTION);
        }else{
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa "+TenGiay+" không ?", "Thông báo",JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                     // yes option
                String MaGiay = txtMaGiay.getText();
                try {
                    GiayDB.XoaGiay(MaGiay);
                    ClearData();
                    ShowData();
                    SetKhoa(true);
                    SetNull();
                } catch (SQLException ex) {
                    Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {       
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        if (txtMaGiay.getText().isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn một sản cần sửa", "Thông báo", JOptionPane.CLOSED_OPTION);
        }else{
            SetKhoa(false);
            SetButton(true);
            cothem=false;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TrangChu frmtrTrangChu = new TrangChu();
        frmtrTrangChu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txtGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_txtGiaKeyTyped

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
            java.util.logging.Logger.getLogger(QLGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new QLGiay().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(QLGiay.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhongLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblQLGiay;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaGiay;
    private javax.swing.JTextField txtTenGiay;
    // End of variables declaration//GEN-END:variables
}
