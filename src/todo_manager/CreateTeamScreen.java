/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package todo_manager;

import database.DB;
import helper.ENUMS;
import java.util.Arrays;
import javax.swing.JOptionPane;
import schema.User;

/**
 *
 * @author user
 */
public class CreateTeamScreen extends javax.swing.JFrame {

    User user = new User();
    String old_team_title;

    /**
     * Creates new form CreateTeamScreen
     */
    public CreateTeamScreen(User user) {
        initComponents();
        this.user = user;
        this.setLocationRelativeTo(null);
        admin_mail.setText(user.email);
        admin_name.setText(user.name);
        admin_id.setText(Integer.toString(user.id));
    }

    public CreateTeamScreen(User user, String edit_team_title) {
        initComponents();
        this.user = user;
        this.old_team_title = edit_team_title;
        this.setLocationRelativeTo(null);
        admin_mail.setText(user.email);
        admin_name.setText(user.name);
        admin_id.setText(Integer.toString(user.id));

        try {
            DB db = new DB("SELECT * FROM " + ENUMS.TABLE.teams + " WHERE title='" + old_team_title + "';");
            while (db.result.next()) {
                team_title.setText(db.result.getString("title"));
                member_list.removeAll();

                String[] members = db.result.getString("members").split("\\s*,\\s*");
                for (int i = 0; i < members.length; i++) {
                    if (members[i].length() > 0) {
                        member_list.add(members[i]);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        goToHome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        admin_name = new javax.swing.JLabel();
        admin_mail = new javax.swing.JLabel();
        admin_id = new javax.swing.JLabel();
        new_member_email = new javax.swing.JTextField();
        team_title = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        member_list = new java.awt.List();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team-p.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel4");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team-p.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(115, 115, 210));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Create New Team");

        goToHome.setBackground(new java.awt.Color(1, 13, 35));
        goToHome.setFont(new java.awt.Font("Fira Code Retina", 1, 18)); // NOI18N
        goToHome.setForeground(new java.awt.Color(255, 255, 255));
        goToHome.setText("<-");
        goToHome.setToolTipText("Home");
        goToHome.setAlignmentY(0.0F);
        goToHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        goToHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(goToHome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(goToHome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(186, 252, 219));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 60, 60));
        jLabel5.setText("Admin ");

        admin_name.setText("Admin Name");

        admin_mail.setText("Admin Email");

        admin_id.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        admin_id.setForeground(new java.awt.Color(60, 60, 60));
        admin_id.setText("_");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_name, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_id, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(admin_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(admin_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        new_member_email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(new_member_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 260, 40));

        team_title.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(team_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("All Members");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Title");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, -1));

        jButton1.setBackground(new java.awt.Color(31, 239, 143));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("ADD");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddMember(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 60, 40));

        jButton2.setBackground(new java.awt.Color(36, 242, 146));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Create Team");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCreateTeam(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 330, 40));

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(member_list);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 330, 90));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Member");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, -1));

        jButton3.setBackground(new java.awt.Color(239, 0, 81));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveMember(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 370, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAddMember(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddMember
        String new_member = new_member_email.getText().trim();
        try {
            if (!new_member.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")) {
                JOptionPane.showMessageDialog(rootPane, "Not Valid Email");
                throw new Exception("Not valid email.");
            }
            if (new_member.length() < 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please Enter member email", "Message.", 1);
                throw new Exception("Please Enter member email");
            }

            String q_s = "SELECT * FROM users WHERE email='" + new_member + "';";
            DB find_db = new DB(q_s);
            boolean isValidUser = false;

            String prev_members = (Arrays.toString(member_list.getItems())).replace("[", "").replace("]", "");

            if (prev_members.contains(new_member)) {
                javax.swing.JOptionPane.showMessageDialog(null, "'" + new_member + "' Exist in member list.", "Message.", 1);
                throw new Exception(new_member + " not found.");
            }
            while (find_db.result.next()) {
                if (find_db.result.getString("email").equals(new_member)) {
                    isValidUser = true;
                }
            }
            if (!isValidUser) {
                javax.swing.JOptionPane.showMessageDialog(null, "'" + new_member + "' not found.", "404 Not Found.", 1);
                throw new Exception(new_member + " not found.");
            };
            new_member_email.setText("");
            member_list.add(new_member);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_onAddMember

    private void onCreateTeam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCreateTeam
        String team_name = team_title.getText();
        String[] members = member_list.getItems();
        String team_members = (Arrays.toString(members)).replace("[", "").replace("]", "");

        try {
            if (this.old_team_title == null) {
                if (team_name.isEmpty()) {
                    String msz = "Please give a team name.";
                    JOptionPane.showMessageDialog(null, msz);
                    throw new Exception(msz);
                }
                //CREATE NEW TEAM.
                String update_query = "INSERT INTO " + ENUMS.TABLE.teams + " (title,members,admin_id) VALUES ('" + team_name + "', '" + team_members + "'," + user.id + ");";
                DB update_team_db = new DB(update_query);
                if (update_team_db.isSuccess <= 0) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Failed to create team.", "Failed to update.", 1);
                    throw new Exception("Failed to create team.");
                } else {
                    this.setVisible(false);
                    new Home(this.user).setVisible(true);
                }
            } else {
                //UPDATE TEAM
                String update_query = "UPDATE " + ENUMS.TABLE.teams + " SET title ='" + team_name + "',members = '" + team_members + "' WHERE title='" + this.old_team_title.trim() + "';";
                DB update_team_db = new DB(update_query);
                if (update_team_db.isSuccess <= 0) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Failed to update team.", "Failed to update.", 1);
                    throw new Exception("Failed to update team.");
                } else {
                    this.setVisible(false);
                    new Home(this.user).setVisible(true);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_onCreateTeam

    private void onRemoveMember(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveMember
        String item = member_list.getSelectedItem();
        if (item != null) {
            int result = JOptionPane.showConfirmDialog(this, "Wanna remove '" + item + "'?", "Remove member",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                //REMOVE MEMBER
                member_list.remove(item);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a member first.");
        }

    }//GEN-LAST:event_onRemoveMember

    private void goToHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToHomeActionPerformed
        new Home(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_goToHomeActionPerformed
    public static void main(String args[]) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_id;
    private javax.swing.JLabel admin_mail;
    private javax.swing.JLabel admin_name;
    private javax.swing.JButton goToHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.List member_list;
    private javax.swing.JTextField new_member_email;
    private javax.swing.JTextField team_title;
    // End of variables declaration//GEN-END:variables
}