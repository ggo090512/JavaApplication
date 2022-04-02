package View;

import ControlData.QLNhanVien;
import ControlData.QLViTri;
import java.awt.event.KeyEvent;
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
public class NhanVien extends javax.swing.JFrame {


    public NhanVien() throws SQLException {
        initComponents();
        String[] colName = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Quên Quán", "CMND", "Giới Tính", "SĐT", "Email","Vị Trí", "Lương Cơ Bản"};
        tableModel.setColumnIdentifiers(colName);
        tblNhanVien.setModel(tableModel);
        ShowData();
        ShowDataCombo();
        setNull();
        setKhoa(true);
        setButton(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Code Khoi Tao">
    private final QLNhanVien nv = new QLNhanVien();
    private  final QLViTri vt = new QLViTri();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel(){
      @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
    };
    public void ClearData() throws  SQLException{
        //Lay chi so dong cuoi cung
        int n= tableModel.getRowCount()-1;
        for(int i=n;i>=0; i--)
            tableModel.removeRow(i);//Remove tung dong
    }
    //Hàm đổ dữ liệu vào combobox
    public final void ShowDataCombo(){
        ResultSet result = null;
        try{
            result = nv.ShowViTri();
            while (result.next()) {
                cboViTri.addItem(result.getString("MaViTri"));   
            }   
        }
        catch(SQLException e){
        }
    }
    //Hien thi ten LoaiSp theo combobox
    public void ShowTenViTri(String mvt) throws SQLException{
        ResultSet result = nv.ShowViTri(mvt);
        if(result.next()){
            this.txtViTri.setText(result.getString("TenVT"));
        }
    }
    //Ham do du lieu cao table
    public final void ShowData() throws SQLException{
        ResultSet result = null;
        result = nv.ShowNV();
        try{
            ClearData();
            while(result.next()){//Neu con doc tiep dc 1 dong du lieu
                String rows[] = new String[10];
                rows[0] = result.getString(1);//Lay du lieu tai cot so 1
                rows[1] = result.getString(2);//Lay du lieu tu cot so 2
                rows[2] = result.getString(3);
                rows[3] = result.getString(4);
                rows[4] = result.getString(5);
                rows[5] = result.getString(6);
                rows[6] = result.getString(7);
                rows[7] = result.getString(8);
                rows[8] = result.getString(10);
                rows[9] = result.getString(11);
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
        this.txtMaNV.setText(null);
        this.txtTenNV.setText(null);
        this.txtNgaySinh.setText(null);
        this.txtQueQuan.setText(null);
        this.txtCMND.setText(null);
        this.txtGioiTinh.setText(null);
        this.txtSDT.setText(null);
        this.txtEmail.setText(null);
        this.txtLuongCB.setText(null);
        //this.txtLoaiSP.setText(null);
        this.txtMaNV.requestFocus();
    }
    //Ham khoa cac textfield
    private void setKhoa(boolean a)
    {
        //khoa or mo cac textfield
        this.txtMaNV.setEnabled(!a);
        this.txtTenNV.setEnabled(!a);
        this.txtNgaySinh.setEnabled(!a);
        this.txtQueQuan.setEnabled(!a);
        this.txtCMND.setEnabled(!a);
        this.txtGioiTinh.setEnabled(!a);
        this.txtSDT.setEnabled(!a);
        this.txtEmail.setEnabled(!a);
        this.cboViTri.setEnabled(!a);
        this.txtLuongCB.setEnabled(!a);
    }
    
    //Ham khoa cac button
    private void setButton(boolean a){
        //Khoa hoac mo cac button
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(a);
        this.btnSua.setEnabled(a);
        this.btnLuu.setEnabled(!a);
        this.btnKLuu.setEnabled(!a);
        this.btnThoat.setEnabled(a);
    }
    // </editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        txtMaNV = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtTenNV = new javax.swing.JTextField();
        txtQueQuan = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuongCB = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboViTri = new javax.swing.JComboBox<>();
        txtGioiTinh = new javax.swing.JTextField();
        txtViTri = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Mã Nhân Viên :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tên Nhân Viên :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Ngày Sinh :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Quê Quán :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("CMND :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("SĐT :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Email :");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Giới Tính :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Vị Trí :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Lương CB :");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

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

        btnKLuu.setText("Không Lưu");
        btnKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtLuongCB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLuongCBKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("VNĐ");

        cboViTri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboViTriItemStateChanged(evt);
            }
        });

        txtViTri.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaNV)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                        .addComponent(txtNgaySinh)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cboViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(56, 56, 56)
                                            .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtQueQuan)
                                        .addComponent(txtCMND)
                                        .addComponent(txtGioiTinh)
                                        .addComponent(txtSDT)
                                        .addComponent(txtEmail)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(txtLuongCB)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboViTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtLuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnKLuu)
                            .addComponent(btnThoat)
                            .addComponent(btnSua)
                            .addComponent(btnLuu))
                        .addGap(58, 58, 58))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Code Chuc Nang">
    private void cboViTriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboViTriItemStateChanged

        try {
            String mvt=cboViTri.getSelectedItem().toString();
            ShowTenViTri(mvt);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_cboViTriItemStateChanged

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        setNull(); //Xoa trang textfield
        setKhoa(false); //Mo khoa textfield
        setButton(false); //Goi ham khoa cac button
        cothem = true; //Gan them cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        String mnv = txtMaNV.getText();
        try{
            if(mnv.length()==0){
                JOptionPane.showMessageDialog(null,"Vui lòng chọn 1 nhân viên để xóa", "Thông báo", 1);
            }
            else{
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên "+mnv+" không ?","Thông báo",2)==0){
                    nv.DeleteData(mnv);//Goi ham xoa du lieu theo ma loai
                    ClearData();//Xoa du lieu trong table
                    ShowData();//Do du lieu vao table
                    setNull();//Xoa trang TextField
                }
            }   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", 1);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        String mnv = txtMaNV.getText();  
        if(mnv.length()==0){
                JOptionPane.showMessageDialog(null,"Vui lòng chọn 1 nhân viên để sửa", "Thong bao", 1);
        }
        else{
            setKhoa(false);
            this.txtMaNV.enableInputMethods(false);
            setButton(false);
            cothem = false;
        }        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        String mnv = txtMaNV.getText();
        String tnv = txtTenNV.getText();
        String ns = txtNgaySinh.getText();
        String qq = txtQueQuan.getText();
        String cm = txtCMND.getText();
        String gt = txtGioiTinh.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String vt = cboViTri.getSelectedItem().toString();
        int lcb;
        lcb = Integer.parseInt(txtLuongCB.getText());
        if(mnv.length()==0 || tnv.length()==0)
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin nhân viên ", "Thông báo", 1);
        else
            if(mnv.length()>5 || tnv.length()>30)
                JOptionPane.showMessageDialog(null, "Mã NV tối đa 5 kí tự, Tên NV tối đa 30 kí tự", "Thông báo", 1);
            else
            {
                try {
                    if (cothem == true) {
                        nv.InsertData(mnv, tnv, ns, qq, cm, gt, sdt, email, vt, lcb);
                    }
                    else
                        nv.EditData(mnv, tnv, ns, qq, cm, gt, sdt, email, vt, lcb);
                    ClearData();
                    ShowData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Thông báo", 1);
                }
                setNull();
                setKhoa(true);
                setButton(true);
            }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKLuuActionPerformed

        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btnKLuuActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked

        try{
            //Lay chi so dong dang chon
            int row = this.tblNhanVien.getSelectedRow();
            String mnv =(this.tblNhanVien.getModel().getValueAt(row, 0)).toString();
            ResultSet rs= nv.ShowNVTheoMaNV(mnv);
            if(rs.next()){
                this.txtMaNV.setText(rs.getString("MaNV"));
                this.txtTenNV.setText(rs.getString("TenNV"));
                this.txtNgaySinh.setText(rs.getString("NgaySinh"));
                this.txtQueQuan.setText(rs.getString("QueQuan"));
                this.txtCMND.setText(rs.getString("CMND"));
                this.txtGioiTinh.setText(rs.getString("GioiTinh"));
                this.txtSDT.setText(rs.getString("SDT"));
                this.txtEmail.setText(rs.getString("Email"));
                this.cboViTri.setSelectedItem(rs.getString("MaViTri"));
                this.txtViTri.setText(rs.getString("TenVT"));
                this.txtLuongCB.setText(rs.getString("LuongCB"));
            }
        }
        catch(SQLException e){}
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TrangChu frmChu = new TrangChu();
        frmChu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txtLuongCBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCBKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_txtLuongCBKeyTyped
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
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NhanVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboViTri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtLuongCB;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtViTri;
    // End of variables declaration//GEN-END:variables
}