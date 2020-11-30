


/**
 *
 * @author ab845
 */
public class MainFrame extends javax.swing.JFrame {
    DB_MAN DBM = new DB_MAN();
    String strSQL = "Select * From CarInfo";
    
    
    public MainFrame() {
        initComponents();
        try{
            DBM.dbOpen();
            //getDBData(strSQL);
            setTableFromDB(strSQL);
            DBM.dbClose();
        } catch (Exception e){  
            System.out.println("SQLException : "+e.getMessage());
        }
    }
    public void getDBData(String strQuery){
        String strOutput = "번호\t차종\t배기량\t연비\t가격\n";
        jTable1.setText(strOutput);
        try{
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);
            while(DBM.DB_rs.next()){
                strOutput ="\n";
                strOutput +=DBM.DB_rs.getString("No") + "\t";
                strOutput +=DBM.DB_rs.getString("Type") + "\t";
                strOutput +=DBM.DB_rs.getString("Displacement") + "\t";
                strOutput +=DBM.DB_rs.getString("Performance") + "\t";
                strOutput +=DBM.DB_rs.getString("Price") + "\t";
                jTable1.append(strOutput);
            }
            DBM.DB_rs.close();
        }  catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }   
    }
    
    public void setTableFromDB(String strQuery){
        int iCntRow = 0;
        try{
            DBM.DB_rs = DBM.DB_stmt.executeQuery("Select * From CarInfo");
                while(DBM.DB_rs.next()){
                    jTable1.setValueAt(DBM.DB_rs.getString("No"), iCntRow, 0);
                    jTable1.setValueAt(DBM.DB_rs.getString("Type"), iCntRow, 1);
                    jTable1.setValueAt(DBM.DB_rs.getString("Displacement"), iCntRow, 2);
                    jTable1.setValueAt(DBM.DB_rs.getString("Performance"), iCntRow, 3);
                    jTable1.setValueAt(DBM.DB_rs.getString("Price"), iCntRow, 4);
                    iCntRow++;
            }
            DBM.DB_rs.close();
        }  catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }  
        
    }
    public String makeSQLWhere(String strQuery){
        switch(cboSearch.getSelectedIndex()){
            case 0:
                strQuery += " Where No = '" + txtNo.getText().trim()+"'";
                break;
            case 1:
                strQuery += " Where Type = '" + txtCarType.getText()+"' ";
                break;
            case 2:
                strQuery += " Where Displacement = " + txtCC.getText().trim()+" ";
                break;
            case 3:
                strQuery += " Where Performance = '" + txtKM.getText()+"' ";
                break;
            case 4:
                strQuery += " Where Price = '" + txtPrice.getText()+"' ";
                break;
            default:
                strQuery += "Select * From CarInfo";
                break;
        }
        return strQuery;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNo = new javax.swing.JLabel();
        lblCarType = new javax.swing.JLabel();
        lblKM = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblSQL = new javax.swing.JLabel();
        lblCC = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        txtCC = new javax.swing.JTextField();
        txtCarType = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtKM = new javax.swing.JTextField();
        txtSQL = new javax.swing.JTextField();
        lblSerach = new javax.swing.JLabel();
        btnsELECT = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnExecute = new javax.swing.JButton();
        cboSearch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNo.setText("번호");

        lblCarType.setText("차종");

        lblKM.setText("연비");

        lblPrice.setText("가격");

        lblSQL.setText("SQL문");

        lblCC.setText("배기량");

        lblTitle.setText("자동차 정보 관리");

        txtNo.setText(" ");

        txtCC.setText(" ");

        txtCarType.setText(" ");

        txtPrice.setText(" ");

        txtKM.setText(" ");

        txtSQL.setText(" ");

        lblSerach.setText("검색 기준");

        btnsELECT.setText("검색");
        btnsELECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsELECTActionPerformed(evt);
            }
        });

        btnInsert.setText("추가");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("수정");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("삭제");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("종료");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnExecute.setText("실행");
        btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteActionPerformed(evt);
            }
        });

        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "번호", "차종", "배기량", "연비", "가격" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "번호", "차종", "배기량", "연비", "가격"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNo)
                        .addGap(18, 18, 18)
                        .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSerach)
                        .addGap(18, 18, 18)
                        .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCarType)
                        .addGap(18, 18, 18)
                        .addComponent(txtCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSQL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrice)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKM)
                        .addGap(18, 18, 18)
                        .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsELECT)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnExecute, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNo)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSerach)
                            .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCarType)
                                    .addComponent(txtCarType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCC)
                                    .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPrice)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSQL)
                                    .addComponent(txtSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblKM)
                                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsELECT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert)
                        .addGap(6, 6, 6)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExecute)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsELECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsELECTActionPerformed
        strSQL = "Select * From CarInfo";
        strSQL = makeSQLWhere(strSQL);
        try{
            DBM.dbOpen();
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strSQL);
            do{
                txtNo.setText(DBM.DB_rs.getString("No"));
                txtCarType.setText(DBM.DB_rs.getString("Type"));
                txtCC.setText(DBM.DB_rs.getString("Displacement"));
                txtKM.setText(DBM.DB_rs.getString("Performance"));
                txtPrice.setText(DBM.DB_rs.getString("Price"));
            }while(DBM.DB_rs.next());
            DBM.DB_rs.close();
            DBM.dbClose();
        } catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
                
    }//GEN-LAST:event_btnsELECTActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        strSQL = "Insert Into CarInfo Values (";
        strSQL += "'" + txtNo.getText() + "',";
        strSQL += "'" + txtCarType.getText() + "',";
        strSQL += "'" + txtCC.getText() + "',";
        strSQL += "'" + txtKM.getText() + "',";
        strSQL += "'" + txtPrice.getText() + "')";
        try{
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            strSQL = "Select * From CarInfo";
            getDBData(strSQL);
            DBM.dbClose();
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         strSQL = "Update Car Set";
        strSQL += "Type ='" + txtCarType.getText() + "',";
        strSQL += "Displacement ='" + txtCC.getText() + "',";
        strSQL += "Performance =" + txtKM.getText() + ",";
        strSQL += "Price =" + txtPrice.getText();
        strSQL = makeSQLWhere(strSQL);
        try{
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            strSQL = "Select * From CarInfo";
            getDBData(strSQL);
            DBM.dbClose();
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            DBM.dbOpen();
            
            int iCntRow = jTable1.getSelectedRow();
            String carNo = jTable1.getValueAt(iCntRow,0).toString();
            strSQL = "Delete from CarInfo where no ='"+carNo+"'";
            DBM.DB_stmt.executeUpdate(strSQL);
            
            for(int iCnt = 0; iCnt < jTable1.getColumnCount(); iCnt++){
                jTable1.setValueAt(null, jTable1.getRowCount(), iCnt);
            }
            setTableFromDB(strSQL);
            
            DBM.dbClose();
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        String strData = "Select * From CarInfo";
        strSQL = txtSQL.getText();
        strSQL = strSQL.toUpperCase();
        try{
            DBM.dbOpen();
            if(strSQL.contains("SELECT"))
                getDBData(strData);
            else    
                DBM.DB_stmt.executeUpdate(strSQL);
            DBM.dbClose();
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExecuteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int iCntRow = jTable1.getSelectedRow();
        txtNo.setText(jTable1.getValueAt(iCntRow, 0).toString());
        txtCarType.setText(jTable1.getValueAt(iCntRow, 1).toString());
        txtCC.setText(jTable1.getValueAt(iCntRow, 2).toString());
        txtKM.setText(jTable1.getValueAt(iCntRow, 3).toString());
        txtPrice.setText(jTable1.getValueAt(iCntRow, 4).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExecute;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnsELECT;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblCarType;
    private javax.swing.JLabel lblKM;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSQL;
    private javax.swing.JLabel lblSerach;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtCarType;
    private javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSQL;
    // End of variables declaration//GEN-END:variables
}
