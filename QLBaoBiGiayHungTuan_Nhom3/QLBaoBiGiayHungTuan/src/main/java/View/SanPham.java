package View;

import ControlData.QLSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import  DTO.dtoLoaiSP;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public final class SanPham extends javax.swing.JFrame {

    final QLSanPham sp = new QLSanPham();
    boolean cothem=true;
    String ml="";
    DefaultTableModel tableModel = new DefaultTableModel(){
      @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<dtoLoaiSP>();
    ArrayList<dtoLoaiSP> listSP = new ArrayList<dtoLoaiSP>();
    
//==============================================================================================================    
    public SanPham() throws SQLException {
        initComponents();
        ShowDataCombo();
        String[] colName = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Giá", "Loại Sản Phẩm"};
        tableModel.setColumnIdentifiers(colName);
        tblSanPham.setModel(tableModel);
        ShowData();
        setNull();
        setKhoa(true);
        setButton(true);
        cboLoaiSP.setModel(comboBoxModel);
        //cboLoaiSP.setModel(comboBoxModel);
    }
       
    //Hàm đổ dữ liệu vào combobox
    public void ShowDataCombo() throws SQLException{
        ResultSet rs = null;
        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel());
        try{
            rs = sp.ShowLoaiSP();
            while (rs.next()) {
                comboBoxModel.addElement(new dtoLoaiSP(rs.getString(1), rs.getString(2)));
            }   
        }
        catch(SQLException e){
        }
        
    }
   
    //Ham do du lieu cao table
    public void ShowData() throws SQLException{
        ResultSet result = sp.ShowSP();
        try{
            while(result.next()){//Neu con doc tiep dc 1 dong du lieu
                String rows[] = new String[6];
                rows[0] = result.getString(1);//Lay du lieu tai cot so 1
                rows[1] = result.getString(2);//Lay du lieu tu cot so 2
                rows[2] = result.getString(3);
                rows[3] = result.getString(4);
                tableModel.addRow(rows);//Dua dong du lieu vao table
                //moi lan co su thay doi du lieu o tableModel thì Jtable tu dong update
            }
        }
        catch(SQLException e){}
    }
    
    //Ham xoa cac textfield
    private void setNull()
    {
        //Xoa trng cac Jtext
        this.txtMaSP.setText(null);
        this.txtTenSP.setText(null);
        this.txtGia.setText(null);
        //this.cboLoaiSP.setSelectedItem(null);
        this.txtMaSP.requestFocus();
    }
    
    //Ham khoa cac textfield
    private void setKhoa(boolean a)
    {
        //khoa or mo cac textfield
        this.txtTenSP.setEnabled(!a);
        this.txtGia.setEnabled(!a);
        this.cboLoaiSP.setEnabled(!a);
        
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
    
    //Ham xoa du lieu trong Model
    public void ClearData() throws  SQLException{
        //Lay chi so dong cuoi cung
        int n= tableModel.getRowCount()-1;
        for(int i=n;i>=0; i--)
            tableModel.removeRow(i);//Remove tung dong
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cboLoaiSP = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKhongLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ DANH MỤC SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Giá :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Loại Sản Phẩm :");

        txtMaSP.setEnabled(false);

        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaKeyTyped(evt);
            }
        });

        cboLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiSPItemStateChanged(evt);
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

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

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

        jLabel6.setText("VNĐ");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKhongLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnKhongLuu)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

//===========click chuột lên table========================================================================================    
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        int row = this.tblSanPham.getSelectedRow();
        String msp = (this.tblSanPham.getModel().getValueAt(row, 0)).toString();
        try{
            //Lay chi so dong dang chon
            ResultSet rs= sp.ShowSPTheoLoai(msp);//Goi ham lay du lieu theo ma
            if(rs.next())//Neu co du lieu
            {
                this.txtMaSP.setText(rs.getString("MaSP"));
                this.txtTenSP.setText(rs.getString("TenSP"));
                this.txtGia.setText(rs.getString("GiaSP"));
            }
        }
        catch(SQLException e){}
        String tl = (this.tblSanPham.getModel().getValueAt(row, 3)).toString();
        comboBoxModel.setSelectedItem(tl);
    }//GEN-LAST:event_tblSanPhamMouseClicked

//===========click nút thêm=======================================================================================    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        setNull(); //Xoa trang textfield
        setKhoa(false); //Mo khoa textfield
        setButton(false); //Goi ham khoa cac button
        cothem = true; //Gan them cothem = true de ghi nhan trang thai them moi
        ml="";
        try {
            ClearData();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnThemActionPerformed

//===========click nút Lưu=======================================================================================        
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String msp = txtMaSP.getText();
        String tsp = txtTenSP.getText();
        String gia = txtGia.getText();
        if(tsp.isEmpty() || txtGia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin sản phẩm", "Thông báo", 1);
        }
        else {
            //Them
            if (cothem == true) {
                if (ml.isEmpty() && (JOptionPane.showConfirmDialog(null, "Vui lòng chọn loại sản phẩm", "Thông báo", -1))==0) {
                    setKhoa(false);
                    setButton(false);
                } 
                else {
                    try {
                        sp.InsertData(tsp, gia, ml);
                        ClearData();
                        ShowData();
                        ml = "";
                        setButton(true);
                        setKhoa(true);
                        setNull();
                    } catch (SQLException e) {
                    }
                }
            }
            //sua
            else{
                //sp.EditData(msp,tsp, gia, lsp); 
                try {
                    int gias = Integer.parseInt(txtGia.getText());
                    sp.EditData(msp, tsp, gias, ml);
                    ClearData();
                    ShowData();
                    ml="";
                    setNull();
                    setButton(true);
                    setKhoa(true);
                } catch (SQLException e) {
                }
            }
        }         
    }//GEN-LAST:event_btnLuuActionPerformed

//===========click combobox lấy mã loại SP=======================================================================================    
    private void cboLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiSPItemStateChanged

          try {
           ml= ((dtoLoaiSP)cboLoaiSP.getSelectedItem()).getMaLoai();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboLoaiSPItemStateChanged

//===========click nút Xóa=======================================================================================        
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String msp = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        if (msp.isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn sản phẩm cần xóa", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
        else{
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa "+tenSP+" không", "Thông báo", 2)==0){
                try {
                    sp.DeleteData(msp);
                    setNull();
                    setKhoa(true);
                    ClearData();
                    ShowData();
                } catch (SQLException e) {
                    JOptionPane.showConfirmDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.CLOSED_OPTION);
                }
            }           
        }
    }//GEN-LAST:event_btnXoaActionPerformed

//===========click nút Sửa=======================================================================================        
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String msp = txtMaSP.getText();
        if (msp.isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn sản phẩm cần sửa", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
        else{
            setButton(false);
            setKhoa(false);
            cothem=false;
        }
    }//GEN-LAST:event_btnSuaActionPerformed
//===========click nút Khoogn lưu=======================================================================================    
    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(true);
        setButton(true);
        try {
            ClearData();
            ShowData();
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnKhongLuuActionPerformed

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
//===========================================================================================================================================
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
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new SanPham().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
