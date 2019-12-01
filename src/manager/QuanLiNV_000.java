package manager;

import com.mysql.cj.jdbc.CallableStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLiNV extends javax.swing.JInternalFrame {

    Connection conn = null;
    ResultSet rs = null;
    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

    public void ShowTable() {
        conn = BCConnection.Connect();
        xoa.setEnabled(false);
        chinhsua.setEnabled(false);
        capnhat.setEnabled(false);
        try {
            CallableStatement pst =(CallableStatement) conn.prepareCall("{call select_nv()}");
            rs = pst.executeQuery();
            String[] arr = {"MANV","MK","HoTen", "DiaChi", "SDT", "NgayVaoLam", "LuongCanBan", "Phai", "NgaySinh", "Ca", "MaKV", "SoNgayLam"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MANV"));
                vec.add(rs.getString("MK"));
                vec.add(rs.getString("HoTen"));
                vec.add(rs.getString("DiaChi"));
                vec.add(rs.getString("SDT"));
                vec.add(rs.getString("NgayVaoLam"));
                vec.add(rs.getString("LuongCanBan"));
                vec.add(rs.getString("Phai"));
                vec.add(rs.getString("NgaySinh"));
                vec.add(rs.getString("Ca"));
                vec.add(rs.getString("MaKV"));
                vec.add(rs.getString("SoNgayLam"));
                model.addRow(vec);
            }
            tbqlnv.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public QuanLiNV() {
        initComponents();
    }

    public boolean ktid() {
        int line = tbqlnv.getRowCount();
        for (int i = 0; i < line; i++) {
            if (ma.getText().trim().equals(tbqlnv.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ma = new javax.swing.JTextField();
        hoten = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbqlnv = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        luongcanban = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        gioitinh = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        calam = new javax.swing.JComboBox<>();
        khuvuc = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        songaylam = new javax.swing.JComboBox<>();
        diachi = new javax.swing.JTextField();
        themmoi = new javax.swing.JButton();
        chinhsua = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        capnhat = new javax.swing.JButton();
        thoat = new javax.swing.JButton();
        matkhaunv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ngaysinh = new com.toedter.calendar.JDateChooser();
        ngayvaolam = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Quản lí nhân viên");

        jLabel2.setText("Mã Nhân Viên");

        jLabel3.setText("Họ Tên ");

        jLabel4.setText("Địa Chỉ");

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Phone");

        tbqlnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbqlnv.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbqlnvAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbqlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbqlnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbqlnv);

        jLabel9.setText("Ngày vào làm");

        jLabel10.setText("Lương căn bản");

        luongcanban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3000000", "3100000", "3200000", "3300000", "3400000", "3500000", "3600000", "3700000", "3800000", "3900000", "4000000" }));

        jLabel11.setText("Giới tính");

        gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel12.setText("Ca làm");

        calam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều", "Tối", "Cả Ngày" }));

        khuvuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K01", "K02", "K03", "K04", "K05", "K06", "K07", "K08", "K09", "K10" }));

        jLabel13.setText("Khu vực");

        jLabel14.setText("Số ngày làm");

        songaylam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30" }));

        themmoi.setText("Thêm mới");
        themmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themmoiActionPerformed(evt);
            }
        });

        chinhsua.setText("Chỉnh sửa");
        chinhsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhsuaActionPerformed(evt);
            }
        });

        xoa.setText("xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        capnhat.setText("Làm mới");
        capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatActionPerformed(evt);
            }
        });

        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        jLabel7.setText("Mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(khuvuc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calam, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gioitinh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diachi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hoten, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ma, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luongcanban, javax.swing.GroupLayout.Alignment.LEADING, 0, 237, Short.MAX_VALUE)
                    .addComponent(songaylam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matkhaunv)
                    .addComponent(ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ngayvaolam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(themmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(chinhsua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 147, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(matkhaunv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayvaolam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(luongcanban, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(khuvuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(songaylam, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addGap(38, 38, 38))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chinhsua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_thoatActionPerformed

    private void tbqlnvAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbqlnvAncestorAdded
        ShowTable();
    }//GEN-LAST:event_tbqlnvAncestorAdded

    private void chinhsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhsuaActionPerformed
        conn = BCConnection.Connect();       
        try {
            CallableStatement pst =(CallableStatement) conn.prepareCall("{call update_nv(?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, matkhaunv.getText());
            pst.setString(2, hoten.getText());
            pst.setString(3, diachi.getText());
            pst.setString(4, phone.getText());
            pst.setString(5, ft.format(ngayvaolam.getDate()));
            pst.setString(6, luongcanban.getSelectedItem().toString());
            pst.setString(7, gioitinh.getSelectedItem().toString());
            pst.setString(8, ft.format(ngaysinh.getDate()));
            pst.setString(9, calam.getSelectedItem().toString());
            pst.setString(10, khuvuc.getSelectedItem().toString());
            pst.setString(11, songaylam.getSelectedItem().toString());
            pst.setString(12, ma.getText());
            pst.executeUpdate();
            ShowTable();
            JOptionPane.showMessageDialog(null, "Ðã cập nhật.");
        } catch (HeadlessException | SQLException e) {
            System.out.println("errors:" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Xin mời nhập lại !!");
        }
    }//GEN-LAST:event_chinhsuaActionPerformed

    private void capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatActionPerformed
        ma.setText("");
        hoten.setText("");
        phone.setText("");
        diachi.setText("");
        ShowTable();
    }//GEN-LAST:event_capnhatActionPerformed

    private void themmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themmoiActionPerformed
        conn = BCConnection.Connect();
        if (ma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin mời nhập mã nhân viên !!");
        } else if (ktid()) {
            JOptionPane.showMessageDialog(null, "nhân viên này đã tồn tại");
        } else if (hoten.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin mời nhập tên !!");
        } else if (phone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin mời nhập phone !!");
        } else if (diachi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin mời nhập địa chỉ !!");
        } else {
            try {
                CallableStatement pst =(CallableStatement) conn.prepareCall("{call insert_nv(?,?,?,?,?,?,?,?,?,?,?,?)}");
                pst.setString(1, ma.getText());
                pst.setString(2, matkhaunv.getText());
                pst.setString(3, hoten.getText());
                pst.setString(4, diachi.getText());
                pst.setString(5, phone.getText());
                pst.setString(6, ft.format(ngayvaolam.getDate()));
                pst.setString(7, luongcanban.getSelectedItem().toString());
                pst.setString(8, gioitinh.getSelectedItem().toString());
                pst.setString(9, ft.format(ngaysinh.getDate()));
                pst.setString(10, calam.getSelectedItem().toString());
                pst.setString(11, khuvuc.getSelectedItem().toString());
                pst.setString(12, songaylam.getSelectedItem().toString());
                pst.executeUpdate();
                ShowTable();
                JOptionPane.showMessageDialog(this, "Thêm thành công ! ");
            } catch (HeadlessException | SQLException e) {
                System.out.println("errors:" + e.getMessage());
            }
        }
    }//GEN-LAST:event_themmoiActionPerformed

    private void tbqlnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbqlnvMouseClicked
        conn = BCConnection.Connect();
        xoa.setEnabled(true);
        chinhsua.setEnabled(true);
        capnhat.setEnabled(true);
        try {
            DefaultTableModel mode = (DefaultTableModel) tbqlnv.getModel();
            int line = tbqlnv.getSelectedRow();
            String manv = (String) tbqlnv.getValueAt(line,0);
            String matkhaun = (String) tbqlnv.getValueAt(line,1);
            String hotennv = (String) tbqlnv.getValueAt(line,2);
            String diachinv = (String) tbqlnv.getValueAt(line,3);
            String phonenv = (String) tbqlnv.getValueAt(line,4);
            Date ngayvaolamnv = new SimpleDateFormat("dd/MM/yyyy").parse((String) mode.getValueAt(line,5));
            String luongcanbannv = (String) tbqlnv.getValueAt(line,6);
            String gioitinhnv = (String) tbqlnv.getValueAt(line,7);
            Date ngaysinhnv = new SimpleDateFormat("dd/MM/yyyy").parse((String) mode.getValueAt(line, 8));
            String calamnv = (String) tbqlnv.getValueAt(line,9);
            String khuvucnv = (String) tbqlnv.getValueAt(line,10);
            String songaylamnv = (String) tbqlnv.getValueAt(line,11);
            ma.setText(manv);
            matkhaunv.setText(matkhaun);
            hoten.setText(hotennv);
            diachi.setText(diachinv);
            phone.setText(phonenv);
            ngayvaolam.setDate(ngayvaolamnv);
            luongcanban.setSelectedItem(luongcanbannv);
            gioitinh.setSelectedItem(gioitinhnv);
            ngaysinh.setDate(ngaysinhnv);
            calam.setSelectedItem(calamnv);
            khuvuc.setSelectedItem(khuvucnv);
            songaylam.setSelectedItem(songaylamnv);

        } catch (ParseException ex) {

        }
    }//GEN-LAST:event_tbqlnvMouseClicked

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        try {
            CallableStatement pst =(CallableStatement) conn.prepareCall("{call delete_nv(?)}");
            pst.setString(1, ma.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công ! ");
            ShowTable();
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> calam;
    private javax.swing.JButton capnhat;
    private javax.swing.JButton chinhsua;
    private javax.swing.JTextField diachi;
    private javax.swing.JComboBox<String> gioitinh;
    private javax.swing.JTextField hoten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> khuvuc;
    private javax.swing.JComboBox<String> luongcanban;
    private javax.swing.JTextField ma;
    private javax.swing.JTextField matkhaunv;
    private com.toedter.calendar.JDateChooser ngaysinh;
    private com.toedter.calendar.JDateChooser ngayvaolam;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> songaylam;
    private javax.swing.JTable tbqlnv;
    private javax.swing.JButton themmoi;
    private javax.swing.JButton thoat;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
}
