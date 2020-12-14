package atmPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Signup extends javax.swing.JFrame {
    OracleDB db = new OracleDB();
    public Signup() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtCheckPassword = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnCheckDuplicate = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel1.setText("회원가입");

        jLabel2.setText("계좌");

        jLabel3.setText("비밀번호");

        jLabel4.setText("비밀번호확인");

        jLabel5.setText("성 명");

        btnCheckDuplicate.setText("중복확인");
        btnCheckDuplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckDuplicateActionPerformed(evt);
            }
        });

        btnSignUp.setText("등록");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCheckPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(txtName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword)
                                    .addComponent(txtAccount))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheckDuplicate)
                            .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckDuplicate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnSignUp))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        //값 가져오기
        int account = Integer.parseInt(txtAccount.getText().trim());
        String pw1 = txtPassword.getText().trim();
        String pw2 = txtCheckPassword.getText().trim();
        String name = txtName.getText().trim();
        boolean state=true;
        try{
            db.dbOpen();
            //중복 체크
            db.DB_rs = db.DB_stmt.executeQuery("Select * From user_info");
                while(db.DB_rs.next() && state){
                     if(db.DB_rs.getInt("account")==account){
                         JOptionPane.showMessageDialog(null, "계좌 번호 중복");
                         state = false;
                         break;
                     } 
                    if(db.DB_rs.getString("name")==name){
                         JOptionPane.showMessageDialog(null, "이름 중복");
                         state = false;                         
                         break;

                     }
                    if(!pw1.equals(pw2)){
                         JOptionPane.showMessageDialog(null, "비밀번호 확인 바람");
                         state = false;                         
                         break;
                     }
            }
            if (state == true) {
                String strSQL = "Insert Into user_info Values (";
                strSQL += "'" + name + "',";
                strSQL += account + ",";
                strSQL += "'" + pw1 + "')";
                db.DB_stmt.executeUpdate(strSQL);
            }
            db.DB_con.commit();
            db.dbClose();
            Main main = new Main();
            main.setVisible(true);
            dispose();
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
            }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnCheckDuplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckDuplicateActionPerformed
        int account = Integer.parseInt(txtAccount.getText().trim());
        String name = txtName.getText().trim();
        String strSQL = "Select * From user_info ";
        try{
            db.dbOpen();
            //중복 체크
            db.DB_rs = db.DB_stmt.executeQuery(strSQL);
                while(db.DB_rs.next()){
                    //계좌 중복
                     if(db.DB_rs.getInt("account")==account){
                         JOptionPane.showMessageDialog(null, "계좌 번호 중복");
                         break;
                     } 
                     //이름 중복
                    if(db.DB_rs.getString("name")==name){
                         JOptionPane.showMessageDialog(null, "이름 중복");                         
                         break;
                     }
                    //중복 없는 경우
                    JOptionPane.showMessageDialog(null, "중복 없음"); 
            }
        }catch (Exception e){
            System.out.println("SQLException : "+e.getMessage());
        }
    }//GEN-LAST:event_btnCheckDuplicateActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckDuplicate;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtCheckPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
