/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ControlData.QLViTri;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class ViTri extends javax.swing.JFrame {

    /**
     * Creates new form ViTri
     */
    public ViTri() throws SQLException {
        initComponents();
        String[] colName = {"Mã Vị Trí", "Tên Vị Trí"};
        tableModel.setColumnIdentifiers(colName);
        tblViTri.setModel(tableModel);
        ShowData();
        setNull();
        setKhoa(true);
        setButton(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLuu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnKhongLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblViTri = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaVT = new javax.swing.JTextField();
        txtTenVT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("VỊ TRÍ NHÂN VIÊN");

        btnKhongLuu.setText("Không Lưu");
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tblViTri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblViTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViTriMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblViTri);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Mã Vị Trí :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tên Vị Trí :");

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

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaVT, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenVT, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKhongLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnKhongLuu)
                    .addComponent(btnSua)
                    .addComponent(btnThoat))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Code Chuc Nang">
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try{
            ClearData();
        }
        catch(SQLException e){
            
        }
        setNull(); //Xoa trang textfield
        setKhoa(false); //Mo khoa textfield
        setButton(false); //Goi ham khoa cac button
        cothem = true; //Gan them cothem = true de ghi nhan trang thai them moi 
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String mvt = txtMaVT.getText();
        try{
            if(mvt.length()==0){
                JOptionPane.showMessageDialog(null,"Chọn 1 vị trí để xóa", "Thông báo", 1);
            }
            else{
                if(JOptionPane.showConfirmDialog(null, "Ban chac chan muon xoa "+mvt+" khong ?","Thong bao",2)==0){
                    vt.DeleteData(mvt);//Goi ham xoa du lieu theo ma loai
                    ClearData();//Xoa du lieu trong table
                    ShowData();//Do du lieu vao table
                    setNull();//Xoa trang TextField
                }
            }   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Xoa that bai", "Thong bao", 1);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String mvt = txtMaVT.getText();  
        if(mvt.length()==0){
                JOptionPane.showMessageDialog(null,"Vui lòng chọn 1 vị trí để sửa", "Thong bao", 1);
        }
        else{
            setKhoa(false);
            this.txtMaVT.enableInputMethods(false);
            setButton(false);
            cothem = false;
        }        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String mvt = txtMaVT.getText();
        String tvt = txtTenVT.getText();
        if(mvt.length()==0 && tvt.length()==0)
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã và tên loại sản phẩm", "Thông báo", 1);
        else
            if(mvt.length()>2 || tvt.length()>30)
                JOptionPane.showMessageDialog(null, "Mã loại sản phẩm tối đa 2 ký tự và tên loại sản phẩm tối đa 30 kí tự", "Thông báo", 1);
            else
            {
                try{
                    if(cothem == true)
                        vt.InsertData(mvt,tvt);
                    else
                        vt.EditData(mvt,tvt);
                    ClearData();
                    ShowData();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Thông báo", 1);
                }
                setNull();
                setKhoa(true);
                setButton(true);
            }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btnKhongLuuActionPerformed
    
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblViTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViTriMouseClicked
        // TODO add your handling code here:
        //Hien thi du lieu len cac textfield khi click chuot vao table
        try{
            //Lay chi so dong dang chon
            int row= this.tblViTri.getSelectedRow();
            String mvt=(this.tblViTri.getModel().getValueAt(row, 0)).toString();
            ResultSet rs= vt.ShowViTri(mvt);//Goi ham lay du lieu theo ma
            if(rs.next())//Neu co du lieu
            {
                this.txtMaVT.setText(rs.getString("MaViTri"));
                this.txtTenVT.setText(rs.getString("TenVT"));
            }
        }
        catch(SQLException e){
            
        }
    }//GEN-LAST:event_tblViTriMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TrangChu frmChu = new TrangChu();
        frmChu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Code Khoi Tao">
    private final QLViTri vt = new QLViTri();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
    };
    //Ham do du lieu cao table
    public void ShowData() throws SQLException{
        ResultSet result = vt.ShowViTri();
        try{
            while(result.next()){//Neu con doc tiep dc 1 dong du lieu
                String rows[] = new String[2];
                rows[0] = result.getString(1);//Lay du lieu tai cot so 1
                rows[1] = result.getString(2);//Lay du lieu tu cot so 2
                tableModel.addRow(rows);//Dua dong du lieu vao table
                //moi lan co su thay doi du lieu o tableModel thì Jtable tu dong update
            }
        }
        catch(SQLException e){}
    }
    //Ham xoa du lieu trong Model
    public void ClearData() throws  SQLException{
        //Lay chi so dong cuoi cung
        int n= tableModel.getRowCount()-1;
        for(int i=n;i>=0; i--)
            tableModel.removeRow(i);//Remove tung dong
    }
    //Ham xoa cac textfield
    private void setNull()
    {
        //Xoa trng cac Jtext
        this.txtMaVT.setText(null);
        this.txtTenVT.setText(null);
        this.txtMaVT.requestFocus();
    }
    //Ham khoa cac textfield
    private void setKhoa(boolean a)
    {
        //khoa or mo cac textfield
        this.txtMaVT.setEnabled(!a);
        this.txtTenVT.setEnabled(!a);
    }
    //Ham khoa cac button
    private void setButton(boolean a){
        //Khoa hoac mo cac button
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(a);
        this.btnSua.setEnabled(a);
        this.btnLuu.setEnabled(!a);
        this.btnKhongLuu.setEnabled(!a);
        this.btnThoat.setEnabled(a);
    }
    // </editor-fold> 
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
            java.util.logging.Logger.getLogger(ViTri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViTri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViTri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViTri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ViTri().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ViTri.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Code Chuc Nang">
    
    // </editor-fold> 
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblViTri;
    private javax.swing.JTextField txtMaVT;
    private javax.swing.JTextField txtTenVT;
    // End of variables declaration//GEN-END:variables
}
