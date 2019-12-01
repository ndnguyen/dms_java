
package manager;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Ban extends javax.swing.JInternalFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs= null;

    public Ban() {
        initComponents();
    }
    public boolean ktid() {
        int line = tbb.getRowCount();
        for (int i = 0; i < line; i++) {
            if (maban.getSelectedItem().toString().equals(tbb.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
    }
    public boolean ktkv() {
    int line = tbkv.getRowCount();
    for (int i = 0; i < line; i++) {
        if (vitri.getSelectedItem().toString().equals(tbkv.getValueAt(i, 0))) {
            return true;
        }
    }
    return false;
}
    public void ShowTable() {
    conn = BCConnection.Connect();
        try {
            pst = conn.prepareStatement("select * from Ban inner join KhuVuc on Ban.MaKV=KhuVuc.MaKV");
            rs = pst.executeQuery();
            String[] arr = {"MaBan", "TenBan","SoNguoi","MaKV","TenKV"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MaBan"));
                vec.add(rs.getString("TenBan"));
                vec.add(rs.getString("SoNguoi"));
                vec.add(rs.getString("MaKV"));
                vec.add(rs.getString("TenKV"));
                model.addRow(vec);
            }
            tbb.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void KhuVuc(){
        conn = BCConnection.Connect();
        try {
            pst = conn.prepareStatement("select * from KhuVuc");
            rs = pst.executeQuery();
            String[] arr = {"MaKV", "TenKV"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MaKV"));
                vec.add(rs.getString("TenKV"));
                model.addRow(vec);
            }
            tbkv.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        thoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maban = new javax.swing.JComboBox<>();
        tenban = new javax.swing.JTextField();
        songuoi = new javax.swing.JComboBox<>();
        vitri = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkv = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbb = new javax.swing.JTable();
        themmoi1 = new javax.swing.JButton();
        chinhsua = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        capnhat = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Quản lí bàn");

        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Bàn");

        jLabel3.setText("Tên Bàn");

        jLabel4.setText("Số người");

        jLabel5.setText("Vị trí");

        maban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bàn 1", "Bàn 2", "Bàn 3" }));

        songuoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        vitri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K01", "K02", "K03", "K008" }));

        tbkv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbkv.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbkvAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbkv);

        tbb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbbAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tbb);

        themmoi1.setText("Thêm mới");
        themmoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themmoi1ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(themmoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chinhsua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(songuoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tenban)
                                    .addComponent(vitri, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maban, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoat))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maban, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenban, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(songuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vitri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themmoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chinhsua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_thoatActionPerformed

    private void tbkvAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbkvAncestorAdded
        KhuVuc();
    }//GEN-LAST:event_tbkvAncestorAdded

    private void tbbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbbAncestorAdded
        ShowTable();
    }//GEN-LAST:event_tbbAncestorAdded

    private void themmoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themmoi1ActionPerformed
        conn = BCConnection.Connect();
        if (ktid())
            JOptionPane.showMessageDialog(null,"Bàn này đã có người ngồi.");
        else if(tenban.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Xin mời nhập tên bàn.");
        else if (!ktkv()) 
            JOptionPane.showMessageDialog(null, "Vị trí không tồn tại.");
        else{
            try {
                pst = conn.prepareStatement("Insert into Ban values(?,?,?,?)");
                pst.setString(1, maban.getSelectedItem().toString());
                pst.setString(2,tenban.getText());
                pst.setInt(3, Integer.parseInt(songuoi.getSelectedItem().toString()));
                pst.setString(4, vitri.getSelectedItem().toString());
                pst.executeUpdate();
                ShowTable();
                JOptionPane.showMessageDialog(null, "Thêm thành công ! ");
            } catch (HeadlessException | SQLException e) {
                System.out.println("errors:" + e.getMessage());
            }
        }
    }//GEN-LAST:event_themmoi1ActionPerformed

    private void chinhsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhsuaActionPerformed
        conn = BCConnection.Connect();
        String mk=JOptionPane.showInputDialog(null,"Xin mời nhâp mật khẩu admin.!!!");
        if("nguyen".equals(mk)){
            String edit = "update Ban set TenBan=?,SoNguoi=?,MaKV=? where MaBan=?";
            try {
                pst = conn.prepareStatement(edit);
                pst.setString(1, tenban.getText());
                pst.setString(2, songuoi.getSelectedItem().toString());
                pst.setString(3, vitri.getSelectedItem().toString());
                pst.setString(4, maban.getSelectedItem().toString());
                pst.executeUpdate();
                ShowTable();
                JOptionPane.showMessageDialog(null, "Ðã cập nhật.");
            } catch (HeadlessException | SQLException e) {
                System.out.println("errors:" + e.getMessage());
                JOptionPane.showMessageDialog(null, "Xin mời nhập lại !!");
            }
        }else
        JOptionPane.showMessageDialog(null,"Mật khẩu nhập không đúng");
    }//GEN-LAST:event_chinhsuaActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        String mk=JOptionPane.showInputDialog(null,"Xin mời nhâp mật khẩu admin.!!!");
        if("nguyen".equals(mk)){
            try {
                pst = conn.prepareStatement("Delete from Ban where MaBan=?");
                pst.setString(1, maban.getSelectedItem().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xóa thành công ! ");
                ShowTable();
            } catch (HeadlessException | SQLException e) {

            }
        }else
        JOptionPane.showMessageDialog(null,"Mật khẩu nhập không đúng");
    }//GEN-LAST:event_xoaActionPerformed

    private void capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatActionPerformed
        maban.setSelectedItem(0);
        tenban.setText("");
        songuoi.setSelectedItem(0);
        vitri.setSelectedItem(0);
        ShowTable();
    }//GEN-LAST:event_capnhatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capnhat;
    private javax.swing.JButton chinhsua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> maban;
    private javax.swing.JComboBox<String> songuoi;
    private javax.swing.JTable tbb;
    private javax.swing.JTable tbkv;
    private javax.swing.JTextField tenban;
    private javax.swing.JButton themmoi1;
    private javax.swing.JButton thoat;
    private javax.swing.JComboBox<String> vitri;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
}
