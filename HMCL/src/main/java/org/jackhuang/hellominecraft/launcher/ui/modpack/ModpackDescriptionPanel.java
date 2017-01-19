/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hellominecraft.launcher.ui.modpack;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jackhuang.hellominecraft.util.C;
import org.jackhuang.hellominecraft.util.MessageBox;
import org.jackhuang.hellominecraft.util.StrUtils;
import org.jackhuang.hellominecraft.util.ui.WebPage;
import org.jackhuang.hellominecraft.util.ui.wizard.spi.WizardController;
import org.markdown4j.Markdown4jProcessor;

/**
 *
 * @author huangyuhui
 */
public class ModpackDescriptionPanel extends javax.swing.JPanel {

    public static final String KEY_MODPACK_DESCRITION = "modpackDescription";

    private final transient WizardController controller;
    private final Map wizardData;

    /**
     * Creates new form ModpackDescriptionPanel
     */
    public ModpackDescriptionPanel(WizardController controller, Map wizardData) {
        initComponents();

        this.controller = controller;
        this.wizardData = wizardData;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        txtDescription.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDescriptionCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        jButton1.setText(C.i18n("ui.button.preview")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTitle.setText(C.i18n("modpack.desc")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescriptionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDescriptionCaretUpdate
        wizardData.put(KEY_MODPACK_DESCRITION, txtDescription.getText());
    }//GEN-LAST:event_txtDescriptionCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Object msgs[] = new Object[2];
            msgs[0] = C.i18n("ui.button.preview");
            msgs[1] = new WebPage(new Markdown4jProcessor().process(txtDescription.getText()));
            ((WebPage) msgs[1]).setPreferredSize(new Dimension(800, 350));
            JOptionPane.showOptionDialog(null, msgs, (String) msgs[0], JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        } catch (HeadlessException | IOException e) {
            MessageBox.show(StrUtils.getStackTrace(e), C.i18n("message.error"), MessageBox.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextPane txtDescription;
    // End of variables declaration//GEN-END:variables
}
