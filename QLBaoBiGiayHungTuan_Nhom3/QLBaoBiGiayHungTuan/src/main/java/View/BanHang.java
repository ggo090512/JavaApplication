/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ControlData.BanHangControl;
import ControlData.Giay;
import ControlData.Muc;
import ControlData.QLSanPham;
import DTO.dtoCTHD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ControlData.HoaDonControl;
import java.awt.event.KeyEvent;

/**
 *
 * @author Administrator
 */
public final class BanHang extends javax.swing.JFrame {

    dtoCTHD dtCthd = new dtoCTHD();
    DefaultTableModel tableModelCTHD = new DefaultTableModel(){
        @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
    };
    DefaultTableModel tableModelDetail = new DefaultTableModel(){
        @Override
      public boolean isCellEditable(int row, int column){
          return false;
      }
    };
    String maSP, maGiay, maMuc, maSPo, maGiayo, maMuco, maSPct, maGiayct, maMucct ;
    QLSanPham sp = new QLSanPham();
    HoaDonControl hd = new HoaDonControl();
    Giay giay = new Giay();
    Muc muc = new Muc();
    BanHangControl bh = new BanHangControl();
    int select, giaSP, giaMuc, giaGiay,soLuongc;
    double Tongtien=0.0;
    String maHD=dtoCTHD.maHoaDon;
    
    public BanHang() {
        initComponents();
        String [] colName2 = {"Mã", "Tên", "Giá"};
        tableModelDetail.setColumnIdentifiers(colName2);
        tblDetails.setModel(tableModelDetail);
        String [] colName = {"Tên SP", "Tên Giấy", "Tên Mực", "Số lượng", "Giá"};
        tableModelCTHD.setColumnIdentifiers(colName);
        tblCTHD.setModel(tableModelCTHD);
        
        setNullSP();
        lblTongGia.setText("0");
        if ("".equals(dtCthd.maHoaDon)){
            setButtonsChonSP(false);
        }
        else{
            setButtonsChonSP(true);
            filltblCTHD();
            showTongtien();
        }
        System.out.println("View.BANHANG.<init> --> Ma Hoa Don dtoCTHD="+dtoCTHD.maHoaDon);
        System.out.println("View.BANHANG.<init> --> Ma Hoa Don = "+maHD);
    }

    
    public void setButtonsChonSP(boolean a){
        btnChonSP.setEnabled(a);
        btnChonGiay.setEnabled(a);
        btnChonMuc.setEnabled(a);
        btnAddSP.setEnabled(a);
        btnTim.setEnabled(a);
        btnTaiLai.setEnabled(a);
        txtTim.setEnabled(a);
        txtSoLuong.setEnabled(a);
    }
    public void setNullSP(){
        lblTenSP.setText("");
        lblTenGiay.setText("");
        lblTenMuc.setText("");
        lblTenTableDetails.setText("");
        txtSoLuong.setText("");
    }

// Đổ data vào table Details truyền Tham số 1 2 3 ::: SP - GIẤY - MỰC    
    public void filltblDetails(int s) throws SQLException{
        switch (s){
            case 1 -> {
                //San pham
                ResultSet rs = sp.showMaandTen();
                while (rs.next()) {
                    String[] row = new String[3];
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    tableModelDetail.addRow(row);
                }
            }
            case 2 ->{
                //Giay
                ResultSet ms=giay.showMaandTen();
                while (ms.next()){
                    String [] row = new String[3];
                    row[0] = ms.getString(1);
                    row[1] = ms.getString(2);
                    row[2] = ms.getString(3);
                    tableModelDetail.addRow(row);
                }
            }
            case 3 ->{
                //Muc
                ResultSet gs=muc.showMaandTen();
                while (gs.next()){
                    String [] row = new String[3];
                    row[0] = gs.getString(1);
                    row[1] = gs.getString(2);
                    row[2] = gs.getString(3);
                    tableModelDetail.addRow(row);
                }
            }
        }
    }
    
//clear table Details    
    public void cleartblDetails(){
        int n= tableModelDetail.getRowCount()-1;
        for (int i=n; i>=0; i--){
            tableModelDetail.removeRow(i);
        }
    }
    
// Chức năng tìm kiếm trong table Details truyền tham số    
    public void fillFind (int s){
        // Truyền vào số 1 2 3 ::: tìm tương ứng ::: SP - GIẤY - MỰC
        String tenSP = txtTim.getText();
        if ( tenSP.isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng nhập tên sản phẩm cần tìm", "Thông báo", -1);
        }
        else{
            switch (s){
                case 1 -> {
                    try {
                        ResultSet rs = sp.FindSP(tenSP);
                        while (rs.next()) {
                            String[] row = new String[3];
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            tableModelDetail.addRow(row);
                        }
                    } catch (SQLException e) {
                    }
                }
                case 2 -> {
                    try {
                        ResultSet rs = giay.FindGiay(tenSP);
                        while (rs.next()) {
                            String[] row = new String[3];
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            tableModelDetail.addRow(row);
                        }
                    } catch (SQLException e) {
                    }
                }
                case 3 -> {
                    try {
                        ResultSet rs = muc.FindMuc(tenSP);
                        while (rs.next()) {
                            String[] row = new String[3];
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            tableModelDetail.addRow(row);
                        }
                    } catch (SQLException e) {
                    }
                }
            }          
        }
    }
    
//clear data table CTHD    
    public void cleartblCTHD (){
        int n = tableModelCTHD.getRowCount()-1;
        for (int i=n; i>=0; i--){
            tableModelCTHD.removeRow(i);
        }
    }
    
//Đổ data vào table CTHD    
    public void filltblCTHD (){
        try {
            ResultSet rs = bh.showDetailstoHD(maHD);
            while (rs.next()){
                String [] row = new String[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                tableModelCTHD.addRow(row);
            }
        } catch (SQLException e) {
        }
    }
    
//Hiện tổng số tiền bên dưới danh sánh sản phẩm đã chọn    
    public void showTongtien (){
        int row = tableModelCTHD.getRowCount()-1;
        int Gia=0;
        if (row > -1){
            for (int i=row; i>=0; i--){
                Gia = Gia + Integer.parseInt(tblCTHD.getModel().getValueAt(i, 4).toString());
            }
            lblTongGia.setText(String.valueOf(Gia));
        }
        else{
            lblTongGia.setText("0");
        }
    }
//==================================================================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        pnlChonSP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        btnBoChon = new javax.swing.JButton();
        btnLapHD = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblTongGia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnTaoPhieuOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblTenSP = new javax.swing.JLabel();
        lblTenGiay = new javax.swing.JLabel();
        lblTenMuc = new javax.swing.JLabel();
        btnChonGiay = new javax.swing.JButton();
        btnAddSP = new javax.swing.JButton();
        btnChonSP = new javax.swing.JButton();
        btnChonMuc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlDetal = new javax.swing.JPanel();
        lblTenTableDetails = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        l = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnTaiLai = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlChonSP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 10))); // NOI18N

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTHD);

        btnBoChon.setBackground(new java.awt.Color(255, 102, 102));
        btnBoChon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoChonActionPerformed(evt);
            }
        });

        btnLapHD.setBackground(new java.awt.Color(153, 153, 255));
        btnLapHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLapHD.setText("Lập hóa đơn");
        btnLapHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHDActionPerformed(evt);
            }
        });

        jLabel5.setText("Tổng giá:");

        lblTongGia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTongGia.setText("tenSP");

        javax.swing.GroupLayout pnlChonSPLayout = new javax.swing.GroupLayout(pnlChonSP);
        pnlChonSP.setLayout(pnlChonSPLayout);
        pnlChonSPLayout.setHorizontalGroup(
            pnlChonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChonSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlChonSPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlChonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlChonSPLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongGia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        pnlChonSPLayout.setVerticalGroup(
            pnlChonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChonSPLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTongGia))
                .addGap(18, 18, 18)
                .addGroup(pnlChonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        btnTaoPhieuOrder.setBackground(new java.awt.Color(0, 204, 102));
        btnTaoPhieuOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoPhieuOrder.setText("TẠO PHIẾU ORDER");
        btnTaoPhieuOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuOrderActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên sản phẩm:");

        jLabel2.setText("Tên Giấy:");

        jLabel3.setText("Tên Mực:");

        jLabel4.setText("Nhập số lượng:");

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        lblTenSP.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTenSP.setText("tenSP");

        lblTenGiay.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTenGiay.setText("tenSP");

        lblTenMuc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTenMuc.setText("tenSP");

        btnChonGiay.setBackground(new java.awt.Color(102, 102, 255));
        btnChonGiay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChonGiay.setText("Chọn Giấy");
        btnChonGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonGiayActionPerformed(evt);
            }
        });

        btnAddSP.setBackground(new java.awt.Color(0, 255, 153));
        btnAddSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddSP.setText("<<<<");
        btnAddSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSPActionPerformed(evt);
            }
        });

        btnChonSP.setBackground(new java.awt.Color(102, 102, 255));
        btnChonSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChonSP.setText("Chọn Sản phẩm");
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
            }
        });

        btnChonMuc.setBackground(new java.awt.Color(102, 102, 255));
        btnChonMuc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChonMuc.setText("Chọn Mực");
        btnChonMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonMucActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlDetal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTenTableDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTenTableDetails.setText("jLabel1");

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetails);

        l.setText("Nhập tên cần tìm:");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnTaiLai.setText("Tải lại");
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalLayout = new javax.swing.GroupLayout(pnlDetal);
        pnlDetal.setLayout(pnlDetalLayout);
        pnlDetalLayout.setHorizontalGroup(
            pnlDetalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlDetalLayout.createSequentialGroup()
                        .addComponent(l)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalLayout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTaiLai))
                            .addGroup(pnlDetalLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblTenTableDetails)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetalLayout.setVerticalGroup(
            pnlDetalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenTableDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(pnlDetalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnTaiLai))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnThoat.setBackground(new java.awt.Color(255, 102, 102));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenSP))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenGiay))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenMuc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChonGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnTaoPhieuOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnTaoPhieuOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTenSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTenGiay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTenMuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChonMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnAddSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChonSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlChonSP.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//Ấn Chọn sản phẩm
    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed
        // truyền vào tham số 1 cho filltblDetails
        try {
            lblTenTableDetails.setText("THÔNG TIN SẢN PHẨM");
            cleartblDetails();
            filltblDetails(1);
            select=1;
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChonSPActionPerformed

//Ấn chọn Giấy
    private void btnChonGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonGiayActionPerformed
        // truyền vào tham số 2 cho filltblDetails
        try {
            lblTenTableDetails.setText("THÔNG TIN GIẤY");
            cleartblDetails();
            filltblDetails(2);
            select=2;
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChonGiayActionPerformed

//Ấn chọn MỰC    
    private void btnChonMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonMucActionPerformed
        // truyền vào tham số 3 cho filltblDetails
        try {
            lblTenTableDetails.setText("THÔNG TIN MỰC");
            cleartblDetails();
            filltblDetails(3);
            select=3;
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChonMucActionPerformed

// === Ấn tại một phiếu Order mới
    private void btnTaoPhieuOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuOrderActionPerformed
        if ("".equals(maHD)){
            try {
                bh.createHD(); 
                setButtonsChonSP(true);               
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs;
            try {
                rs = bh.showMaHD();
                if (rs.next()){
                    maHD = rs.getString(1);
                    dtCthd.maHoaDon=maHD;                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }           
            
        }
        else{
            if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc tạo Phiếu mới. Mọi thông tin sẽ bị XÓA", "Thông báo", 2)) == 0) {
                cleartblDetails();
                cleartblCTHD();
                try {
                    // Xóa các chi tiết đơn hàng đang được tạo khi người dùng tạo phiếu order mới
                    ResultSet rs = bh.showMaHD();
                    if (rs.next()) {
                        bh.deleteCTHD(rs.getString(1));
                        dtCthd.maHoaDon = "";;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Xóa tất tất cả hóa đơn đang được thêm sản phẩm khi người dùng Tạo phiếu order mới
                    bh.deleteHDnull();
                    maHD = "";
                    dtCthd.maHoaDon = maHD;
                    //Sa
                    bh.createHD();
                    setButtonsChonSP(true);
                    ResultSet rs;
                    rs = bh.showMaHD();
                    if (rs.next()) {
                        maHD = rs.getString(1);
                        dtCthd.maHoaDon = maHD;
                        showTongtien();
                    }
                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_btnTaoPhieuOrderActionPerformed

// ==== Xử lý nút TẢi lại của table detail    
    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed
      
        try {
            cleartblDetails();
            filltblDetails(select);
            txtTim.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTaiLaiActionPerformed

//====== xử lý nút Tìm của table Details    
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        cleartblDetails();
        fillFind(select);
    }//GEN-LAST:event_btnTimActionPerformed

//=======XU LY SU KIENJ CLICK CHUOT VAO TABLE SAN PHAM=====================================================
    private void tblDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMouseClicked
        int row = tblDetails.getSelectedRow();
        // Số 1 là SẢN PHẨM 2 giay 3 muc
        switch (select){
            case 1 -> {
                maSP = (tblDetails.getModel().getValueAt(row, 0)).toString();
                lblTenSP.setText((tblDetails.getModel().getValueAt(row, 1)).toString());
                giaSP = Integer.parseInt(tblDetails.getModel().getValueAt(row, 2).toString());
            }
            case 2 -> {
                maGiay = (tblDetails.getModel().getValueAt(row, 0)).toString();
                lblTenGiay.setText((tblDetails.getModel().getValueAt(row, 1)).toString());
                giaGiay = Integer.parseInt(tblDetails.getModel().getValueAt(row, 2).toString());
            }
            case 3 -> {
                maMuc = (tblDetails.getModel().getValueAt(row, 0)).toString();
                lblTenMuc.setText((tblDetails.getModel().getValueAt(row, 1)).toString());
                giaMuc = Integer.parseInt(tblDetails.getModel().getValueAt(row, 2).toString());
            }
            default ->{    
            }
        }
    }//GEN-LAST:event_tblDetailsMouseClicked

//=====Xử lý nút thêm Sản phẩm=================================================================================
    private void btnAddSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSPActionPerformed
        String tenSP=lblTenSP.getText();
        String tenGiay=lblTenGiay.getText();
        String tenMuc=lblTenMuc.getText();
        String soLuong=txtSoLuong.getText();
        int soluongm;
        if (tenSP.isEmpty()||tenGiay.isEmpty()||tenGiay.isEmpty()||tenMuc.isEmpty()||soLuong.isEmpty()){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn đủ thông tin cho sản phẩm và nhập số lượng", "Thông báo",-1);
        }
        else{
            if (!maSP.equals(maSPo) || !maGiay.equals(maGiayo) || !maMuc.equals(maSPo)){
                try {
                    bh.addDetailtoCTHD(maSP, maGiay, maMuc, maHD, soLuong);
                    soLuongc=Integer.parseInt(soLuong);
                    cleartblCTHD();
                    filltblCTHD();
                    showTongtien();
                    setNullSP();
                    maSPo=maSP;
                    maGiayo=maGiay;
                    maMuco=maMuc;
                } 
                catch (SQLException e) {
                }
            } 
            else{
                int sl = Integer.parseInt(soLuong);
                try {                    
                    soluongm= sl + soLuongc;
                    bh.editSoluong(soluongm, maHD);
                    cleartblCTHD();
                    filltblCTHD();
                    showTongtien();
                    setNullSP();
                } catch (SQLException e) {
                }
            }
        }
        
    }//GEN-LAST:event_btnAddSPActionPerformed

//===========xử lý sự kiện CLICK CHUOT TABLE CTHD==============================================================
    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        int row = tblCTHD.getSelectedRow();
        String tenS = (tblCTHD.getModel().getValueAt(row, 0).toString());
        String tenG = (tblCTHD.getModel().getValueAt(row, 1).toString());
        String tenM = (tblCTHD.getModel().getValueAt(row, 2).toString());
        try {
            ResultSet rs = bh.getDataCTHD(tenS, tenG, tenM, maHD);
            if (rs.next()){
                maSPct = rs.getString(1);
                maGiayct = rs.getString(2);
                maMucct = rs.getString(3);
            }
        } catch (SQLException e) {
        }
        System.out.println("View.BANHANG.tblCTHDMouseClicked() maSpct maGiayct mamucct"+maSPct+" "+maGiayct+" "+maMucct);
    }//GEN-LAST:event_tblCTHDMouseClicked

//======xử lý sự kiện bỏ chọn 1 sản phẩm ===================================================================
    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        if (!"".equals(maSPct) || !"".equals(maGiayct) || !"".equals(maMucct)) {
            if ((JOptionPane.showConfirmDialog(null, "Sản phẩm sẽ bị XÓA!", "Thông báo", 2)) == 0) {
                try {
                    bh.deleteSPfromCTHD(maSPct, maGiayct, maMucct, maHD);
                    cleartblCTHD();
                    filltblCTHD();
                    maSPct = "";
                    maGiayct = "";
                    maMucct = "";
                } catch (SQLException e) {
                }
                showTongtien();
            }
        }
        else{
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn sản phẩm cần xóa", "Thông báo", -1);
        }
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void btnLapHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHDActionPerformed
        int row = tableModelCTHD.getRowCount();
        if (row == 0 ){
            JOptionPane.showConfirmDialog(null, "Bạn chưa có sản phẩm để lập hóa đơn", "Thông báo", -1);
        }
        else{
            HoaDon frmHoaDon = new HoaDon();
            frmHoaDon.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnLapHDActionPerformed
// Xử lý khi người dùng đóng form
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!"".equals(dtCthd.maHoaDon)) {
            try {
                ResultSet rs = bh.showMaHD();
                if (rs.next()) {
                    bh.deleteCTHD(rs.getString(1));
                    dtCthd.maHoaDon = "";
                    hd.deleteHDmaKHisnull();
                    TrangChu frmTrangChu = new TrangChu();
                    frmTrangChu.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
            TrangChu frmTrangChu = new TrangChu();
            frmTrangChu.setVisible(true);           
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_txtSoLuongKeyTyped

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BanHang().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSP;
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnChonGiay;
    private javax.swing.JButton btnChonMuc;
    private javax.swing.JButton btnChonSP;
    private javax.swing.JButton btnLapHD;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btnTaoPhieuOrder;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l;
    private javax.swing.JLabel lblTenGiay;
    private javax.swing.JLabel lblTenMuc;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTenTableDetails;
    private javax.swing.JLabel lblTongGia;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnlChonSP;
    private javax.swing.JPanel pnlDetal;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
