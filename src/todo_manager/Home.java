/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package todo_manager;

import database.DB;
import helper.ENUMS;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import schema.User;

/**
 *
 * @author user
 */
public final class Home extends javax.swing.JFrame {

    User user;
    String active_team_members = "";
    boolean isAdmin = false;

    public Home() {
        try {
            if (user.id > 0) {
                renderUI(user);
            } else {
                throw new Exception("User not found.");
            }
        } catch (Exception ex) {
            new Login().setVisible(true);
            System.out.println(ex.getMessage());
        }
    }

    public Home(User user) {
        try {
            if (user.id > 0) {
                renderUI(user);
            } else {
                throw new Exception("User not found.");
            }
        } catch (Exception ex) {
            new Login().setVisible(true);
            System.out.println(ex.getMessage());
        }

        TableColumn action_column = all_table.getColumnModel().getColumn(3);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("PENDING");
        comboBox.addItem("DONE");
        action_column.setCellEditor(new DefaultCellEditor(comboBox));
    }

    void renderUI(User user) {
        initComponents();
        this.user = user;
        this.setLocationRelativeTo(null);
        initTeamListUi();
        header_user_name.setText(user.name);
        header_user_email.setText(user.email);
    }

    void updateTableTask() {
        try {
            DefaultTableModel tr_model = (DefaultTableModel) all_table.getModel();
            tr_model.setRowCount(0);
            String q_s = "SELECT * FROM " + ENUMS.TABLE.tasks + " WHERE team='" + teams_list.getSelectedItem() + "';";
            DB task_db = new DB(q_s);
            if (task_db.result == null) {
                throw new Exception("Data not found.");
            }
            int indx = 1;
            all_table.removeAll();

            while (task_db.result.next()) {
                ResultSet db = task_db.result;
                String row_data[] = {
                    Integer.toString(indx),//No.
                    db.getString("title"),//Title
                    db.getString("assigned_to"),//Email
                    db.getString("description"),//DESC
                };
                System.out.println(Arrays.toString(row_data));

                tr_model.addRow(row_data);
                indx++;
            }

            task_db.closeDB();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void initTeamListUi() {
        //CLEARING PREVIOUS ITEMS
        teams_list.removeAllItems();

        try {
            //FATCHING NEW ITEMS
            String q_s = "SELECT * FROM " + ENUMS.TABLE.teams + " WHERE members LIKE '%" + user.email + "%' OR  admin_id =" + user.id;
            System.out.println(q_s);
            DB teams = new DB(q_s);
            boolean temp = true;
            while (teams.result.next()) {
                String name = teams.result.getString("title");
                if (!name.isEmpty()) {
                    teams_list.addItem(name);
                }
                if (temp) {
                    this.active_team_members = teams.result.getString("members");
                    this.isAdmin = teams.result.getInt("admin_id") == user.id;
                    temp = false;
                }

            }
            updateTeamMembersList();
        } catch (SQLException ex) {
            System.out.println("\t🪲--->" + ex.getMessage());
            this.isAdmin = false;
        }
        updateTableTask();

        team_leave_delete_label.setText(this.isAdmin ? "DELETE TEAM." : "LEAVE TEAM");
        team_leave_delete_btn.setText(this.isAdmin ? "DELETE" : "LEAVE");
        eidt_team_btn.setVisible(this.isAdmin);
    }

    void updateTeamMembersList() {
        team_members.removeAllItems();
        String[] s_a = this.active_team_members.split("\\s*,\\s*");
        for (int i = 0; i < s_a.length; i++) {
            if (s_a[i].length() > 0) {
                team_members.addItem(s_a[i]);
            }
        }
        active_team_title.setText((String) teams_list.getSelectedItem());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        header_user_name = new javax.swing.JLabel();
        header_user_email = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        task_tabs = new javax.swing.JTabbedPane();
        table_scroll_panel = new javax.swing.JScrollPane();
        all_table = new javax.swing.JTable();
        add_task_panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        new_task_desc = new javax.swing.JTextArea();
        new_task_title = new javax.swing.JTextField();
        team_members = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        team_leave_delete_label = new javax.swing.JLabel();
        team_leave_delete_btn = new javax.swing.JButton();
        teams_list = new javax.swing.JComboBox<>();
        active_team_title = new javax.swing.JLabel();
        completed_progress = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        pending_progress = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        eidt_team_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todo_manager/mdi_user-circle.png"))); // NOI18N

        header_user_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        header_user_name.setForeground(new java.awt.Color(255, 255, 255));
        header_user_name.setText("USER NAME");

        header_user_email.setFont(new java.awt.Font("Microsoft Tai Le", 1, 10)); // NOI18N
        header_user_email.setForeground(new java.awt.Color(255, 255, 255));
        header_user_email.setText("ADMIN");

        jButton1.setBackground(new java.awt.Color(224, 0, 0));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log Out");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLogout(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header_user_email, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(header_user_name)
                        .addGap(0, 0, 0)
                        .addComponent(header_user_email, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        task_tabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        task_tabs.setName(""); // NOI18N

        all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Title", "Email", "Task", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        all_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        all_table.setColumnSelectionAllowed(true);
        all_table.setMinimumSize(new java.awt.Dimension(500, 400));
        all_table.setPreferredSize(new java.awt.Dimension(500, 400));
        table_scroll_panel.setViewportView(all_table);
        all_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (all_table.getColumnModel().getColumnCount() > 0) {
            all_table.getColumnModel().getColumn(4).setCellEditor(null);
            all_table.getColumnModel().getColumn(4).setCellRenderer(null);
        }

        task_tabs.addTab("All Task", table_scroll_panel);

        add_task_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Title");

        jLabel6.setText("Description :");

        jLabel7.setText("Assign to :");

        new_task_desc.setColumns(20);
        new_task_desc.setRows(5);
        jScrollPane5.setViewportView(new_task_desc);

        team_members.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        team_members.setToolTipText("");
        team_members.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Montserrat", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Cancel");
        jButton3.setBorder(null);

        jButton4.setBackground(new java.awt.Color(24, 180, 101));
        jButton4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAssignNewTask(evt);
            }
        });

        javax.swing.GroupLayout add_task_panelLayout = new javax.swing.GroupLayout(add_task_panel);
        add_task_panel.setLayout(add_task_panelLayout);
        add_task_panelLayout.setHorizontalGroup(
            add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_task_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(team_members, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(add_task_panelLayout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                            .addComponent(new_task_title))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        add_task_panelLayout.setVerticalGroup(
            add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_task_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_task_title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_task_panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(add_task_panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(team_members, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(add_task_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        task_tabs.addTab("Add", add_task_panel);

        team_leave_delete_label.setFont(new java.awt.Font("Montserrat", 3, 14)); // NOI18N
        team_leave_delete_label.setForeground(new java.awt.Color(224, 0, 0));
        team_leave_delete_label.setText("Delete This Team.");

        team_leave_delete_btn.setBackground(new java.awt.Color(224, 0, 0));
        team_leave_delete_btn.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        team_leave_delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        team_leave_delete_btn.setText("Delete");
        team_leave_delete_btn.setBorder(null);
        team_leave_delete_btn.setBorderPainted(false);
        team_leave_delete_btn.setFocusPainted(false);
        team_leave_delete_btn.setFocusable(false);
        team_leave_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLeaveDelete(evt);
            }
        });

        teams_list.setBackground(new java.awt.Color(51, 102, 255));
        teams_list.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        teams_list.setForeground(new java.awt.Color(255, 255, 255));
        teams_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onChangeTeam(evt);
            }
        });

        active_team_title.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        active_team_title.setText("Team");

        completed_progress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        completed_progress.setForeground(new java.awt.Color(0, 211, 92));
        completed_progress.setValue(60);
        completed_progress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        completed_progress.setMinimumSize(new java.awt.Dimension(10, 10));
        completed_progress.setStringPainted(true);

        jLabel9.setText("Completed");

        pending_progress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pending_progress.setForeground(new java.awt.Color(102, 102, 102));
        pending_progress.setValue(60);
        pending_progress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pending_progress.setMinimumSize(new java.awt.Dimension(10, 10));
        pending_progress.setStringPainted(true);

        jLabel10.setText("Pending");

        jButton5.setBackground(new java.awt.Color(51, 93, 195));
        jButton5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(215, 231, 242));
        jButton5.setText("Create New Team");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCreateTeam(evt);
            }
        });

        eidt_team_btn.setBackground(new java.awt.Color(14, 237, 134));
        eidt_team_btn.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        eidt_team_btn.setText("Edit");
        eidt_team_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        eidt_team_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onEditTeam(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(teams_list, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(completed_progress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pending_progress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(active_team_title, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eidt_team_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(team_leave_delete_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(team_leave_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(task_tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teams_list, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(active_team_title)
                    .addComponent(eidt_team_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(task_tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(completed_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pending_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(team_leave_delete_label)
                    .addComponent(team_leave_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void onChangeTeam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onChangeTeam
        try {
            String q_s = "SELECT * FROM " + ENUMS.TABLE.teams + " WHERE title LIKE '%" + (String) teams_list.getSelectedItem() + "';";
            System.out.println(q_s);
            DB db = new DB(q_s);
            while (db.result.next()) {
                this.active_team_members = db.result.getString("members");
                this.isAdmin = db.result.getInt("admin_id") == user.id;
            }
            updateTeamMembersList();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.isAdmin = false;
        }
        team_leave_delete_label.setText(this.isAdmin ? "DELETE TEAM." : "LEAVE TEAM");
        team_leave_delete_btn.setText(this.isAdmin ? "DELETE" : "LEAVE");
        eidt_team_btn.setVisible(this.isAdmin);
        updateTableTask();
    }//GEN-LAST:event_onChangeTeam

    private void onAssignNewTask(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAssignNewTask
        try {
            if (!this.isAdmin) {
                String msz = "Only admin can assign task.";
                JOptionPane.showMessageDialog(null, msz);
                throw new Exception(msz);
            }
            String title = "'" + new_task_title.getText() + "'";
            String desc = "'" + new_task_desc.getText() + "'";
            System.out.println(ENUMS.TABLE.tasks);
            String QUERY_STR = "INSERT INTO " + ENUMS.TABLE.tasks + " (team, admin_id, assigned_to, title, description) VALUES ('" + teams_list.getSelectedItem() + "'," + user.id + ",'" + team_members.getSelectedItem() + "'," + title + "," + desc + ");";

            if (new_task_title.getText().length() < 3) {
                String msz = "Too Short Title";
                JOptionPane.showMessageDialog(null, msz);
                throw new Exception(msz);
            } else if (new_task_desc.getText().length() < 3) {
                String msz = "Too Short Description.";
                JOptionPane.showMessageDialog(null, msz);
                throw new Exception(msz);
            } else if (team_members.getSelectedItem() == null) {
                String msz = "Please Select a valid member.";
                JOptionPane.showMessageDialog(null, msz);
                throw new Exception(msz);
            }

            DB database = new DB(QUERY_STR);
            JOptionPane.showMessageDialog(this, database.isSuccess > 0 ? title + " Assigned." : "Fialed to assign task.");

            //ON SUCCESS 
            if (database.isSuccess > 0) {
                new_task_desc.setText("");
                new_task_title.setText("");
            }
            database.closeDB();
        } catch (HeadlessException error) {
            System.out.println("\t🪲-->" + error.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_onAssignNewTask

    private void onLogout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLogout
        this.setVisible(false);
        this.hide();
        new Login().setVisible(true);
    }//GEN-LAST:event_onLogout

    private void toCreateTeam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCreateTeam
        new CreateTeamScreen(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_toCreateTeam

    private void onEditTeam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onEditTeam
        this.setVisible(false);
        new CreateTeamScreen(user, (String) teams_list.getSelectedItem()).setVisible(true);
    }//GEN-LAST:event_onEditTeam

    private void onLeaveDelete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLeaveDelete

        if (this.isAdmin) {
            //DELETE TEAM
            int result = JOptionPane.showConfirmDialog(this, "Wanna Delete '" + teams_list.getSelectedItem() + "'?", "Leave Team.",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                String delete_q = "DELETE FROM " + ENUMS.TABLE.teams + " WHERE title='" + (String) teams_list.getSelectedItem() + "';";
                DB delete_db = new DB(delete_q);
                if (delete_db.isSuccess > 0) {
                    JOptionPane.showMessageDialog(rootPane, "'" + teams_list.getSelectedItem() + "' Team Deleted.");
                    initTeamListUi();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Failed to Delete.");
                }
            }

        } else {
            //LEAVE TEAM
            int result = JOptionPane.showConfirmDialog(this, "Wanna Leave '" + teams_list.getSelectedItem() + "'?", "Leave Team.",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                String new_members = "'" + active_team_members.replace(user.email, "").replace(",,", ",") + "'";
                String update_q = "UPDATE " + ENUMS.TABLE.teams + " SET members=" + new_members + " WHERE title='" + (String) teams_list.getSelectedItem() + "';";
                DB update_db = new DB(update_q);
                if (update_db.isSuccess > 0) {
                    JOptionPane.showMessageDialog(rootPane, "You Leave '" + teams_list.getSelectedItem() + "' Team.");
                    initTeamListUi();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Failed to Leave.");
                }
            }

        }

    }//GEN-LAST:event_onLeaveDelete

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel active_team_title;
    private javax.swing.JPanel add_task_panel;
    private javax.swing.JTable all_table;
    private javax.swing.JProgressBar completed_progress;
    private javax.swing.JButton eidt_team_btn;
    private javax.swing.JLabel header_user_email;
    private javax.swing.JLabel header_user_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea new_task_desc;
    private javax.swing.JTextField new_task_title;
    private javax.swing.JProgressBar pending_progress;
    private javax.swing.JScrollPane table_scroll_panel;
    private javax.swing.JTabbedPane task_tabs;
    private javax.swing.JButton team_leave_delete_btn;
    private javax.swing.JLabel team_leave_delete_label;
    private javax.swing.JComboBox<String> team_members;
    private javax.swing.JComboBox<String> teams_list;
    // End of variables declaration//GEN-END:variables
}