/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.ingest;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.openide.util.Lookup;
import org.sleuthkit.autopsy.corecomponentinterfaces.BlackboardResultViewer;
import org.sleuthkit.autopsy.ingest.IngestMessage.*;
import org.sleuthkit.datamodel.BlackboardArtifact;

/**
 * Notification window showing messages from services to user
 * 
 */
public class IngestMessagePanel extends javax.swing.JPanel {

    private MessageTableModel tableModel;
    private static Font visitedFont = new Font("Arial", Font.PLAIN, 11);
    private static Font notVisitedFont = new Font("Arial", Font.BOLD, 11);
    private int lastRowSelected = -1;

    /** Creates new form IngestMessagePanel */
    public IngestMessagePanel() {
        tableModel = new MessageTableModel();
        initComponents();
        customizeComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailsViewerPane = new javax.swing.JEditorPane();
        viewArtifactButton = new javax.swing.JButton();
        readAllButton = new javax.swing.JButton();
        clearAllButton = new javax.swing.JButton();
        viewContentButton = new javax.swing.JButton();

        setOpaque(false);

        jScrollPane1.setOpaque(false);

        messageTable.setBackground(new java.awt.Color(221, 221, 235));
        messageTable.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        messageTable.setModel(tableModel);
        messageTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        messageTable.setAutoscrolls(false);
        messageTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageTable.setGridColor(new java.awt.Color(204, 204, 204));
        messageTable.setOpaque(false);
        messageTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        messageTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        messageTable.setShowHorizontalLines(false);
        messageTable.setShowVerticalLines(false);
        messageTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(messageTable);

        detailsViewerPane.setBackground(new java.awt.Color(221, 221, 235));
        detailsViewerPane.setContentType(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.detailsViewerPane.contentType")); // NOI18N
        detailsViewerPane.setEditable(false);
        jScrollPane2.setViewportView(detailsViewerPane);

        viewArtifactButton.setText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.viewArtifactButton.text")); // NOI18N
        viewArtifactButton.setToolTipText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.viewArtifactButton.toolTipText")); // NOI18N
        viewArtifactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewArtifactButtonActionPerformed(evt);
            }
        });

        readAllButton.setText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.readAllButton.text")); // NOI18N
        readAllButton.setToolTipText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.readAllButton.toolTipText")); // NOI18N
        readAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readAllButtonActionPerformed(evt);
            }
        });

        clearAllButton.setText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.clearAllButton.text")); // NOI18N
        clearAllButton.setToolTipText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.clearAllButton.toolTipText")); // NOI18N
        clearAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllButtonActionPerformed(evt);
            }
        });

        viewContentButton.setText(org.openide.util.NbBundle.getMessage(IngestMessagePanel.class, "IngestMessagePanel.viewContentButton.text")); // NOI18N
        viewContentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewContentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(clearAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(readAllButton))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(viewArtifactButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewContentButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readAllButton)
                    .addComponent(clearAllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewContentButton)
                    .addComponent(viewArtifactButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewArtifactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewArtifactButtonActionPerformed
        if (lastRowSelected < 0) {
            return;
        }
        final IngestMessage message = tableModel.getMessage(lastRowSelected);
        if (message != null) {
            BlackboardArtifact art = message.getData();
            if (art != null) {
                BlackboardResultViewer v = Lookup.getDefault().lookup(BlackboardResultViewer.class);
                v.viewArtifact(art);
            }
        }

    }//GEN-LAST:event_viewArtifactButtonActionPerformed

    private void readAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readAllButtonActionPerformed
        tableModel.setVisitedAll();
    }//GEN-LAST:event_readAllButtonActionPerformed

    private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllButtonActionPerformed
        clearMessages();
        detailsViewerPane.setText("");
    }//GEN-LAST:event_clearAllButtonActionPerformed

    private void viewContentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewContentButtonActionPerformed
        if (lastRowSelected < 0) {
            return;
        }
        final IngestMessage message = tableModel.getMessage(lastRowSelected);
        if (message != null) {
            BlackboardArtifact art = message.getData();
            if (art != null) {
                BlackboardResultViewer v = Lookup.getDefault().lookup(BlackboardResultViewer.class);
                v.viewArtifactContent(art);
            }
        }
    }//GEN-LAST:event_viewContentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearAllButton;
    private javax.swing.JEditorPane detailsViewerPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable messageTable;
    private javax.swing.JButton readAllButton;
    private javax.swing.JButton viewArtifactButton;
    private javax.swing.JButton viewContentButton;
    // End of variables declaration//GEN-END:variables

    private void customizeComponents() {
        jScrollPane1.setWheelScrollingEnabled(true);

        messageTable.setAutoscrolls(true);
        //messageTable.setTableHeader(null);
        messageTable.setShowHorizontalLines(false);
        messageTable.setShowVerticalLines(false);

        messageTable.getParent().setBackground(messageTable.getBackground());

        //customize column witdhs
        //messageTable.setSize(260, 260);
        messageTable.setSize(messageTable.getParent().getPreferredSize());
        final int width = messageTable.getSize().width;
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = messageTable.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setCellRenderer(new MessageTableRenderer());
                column.setPreferredWidth(((int) (width * 0.68)));
            } else {
                column.setPreferredWidth(((int) (width * 0.30)));
                column.setCellRenderer(new MessageTableRenderer());
            }
        }
        messageTable.setCellSelectionEnabled(false);
        messageTable.setColumnSelectionAllowed(false);
        messageTable.setRowSelectionAllowed(true);
        messageTable.getSelectionModel().addListSelectionListener(new MessageVisitedSelection());

        detailsViewerPane.setContentType("text/html");
        viewArtifactButton.setEnabled(false);
        viewContentButton.setEnabled(false);

    }

    public void addMessage(IngestMessage m) {
        tableModel.addMessage(m);
        //autoscroll
        messageTable.scrollRectToVisible(messageTable.getCellRect(messageTable.getRowCount() - 1, messageTable.getColumnCount(), true));
    }

    public void clearMessages() {
        tableModel.clearMessages();
    }

    private void setVisited(int rowNumber) {
        tableModel.setVisited(rowNumber);
        lastRowSelected = rowNumber;
    }

    private void updateDetails(int rowNumber) {
        final IngestMessage message = tableModel.getMessage(rowNumber);
        if (message != null) {
            String details = message.getDetails();
            if (details != null) {
                this.detailsViewerPane.setText(details);
            } else {
                this.detailsViewerPane.setText("");
            }
            if (message.getData() != null) {
                viewArtifactButton.setEnabled(true);
                viewContentButton.setEnabled(true);
            } else {
                viewArtifactButton.setEnabled(false);
                viewContentButton.setEnabled(false);
            }
        } else {
            viewArtifactButton.setEnabled(false);
            viewContentButton.setEnabled(false);
            detailsViewerPane.setText("");
        }
    }

    private class MessageTableModel extends AbstractTableModel {
        //data

        private Logger logger = Logger.getLogger(MessageTableModel.class.getName());
        private List<TableEntry> messageData = new ArrayList<TableEntry>();

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return messageData.size();
        }

        @Override
        public String getColumnName(int column) {
            String colName = null;

            switch (column) {
                case 0:
                    colName = "Subject";
                    break;
                case 1:
                    colName = "Module";
                    break;
                default:
                    ;

            }
            return colName;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object ret = null;
            TableEntry entry = messageData.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    ret = (Object) entry.message.getSubject();
                    break;
                case 1:
                    Object service = entry.message.getSource();
                    if (service == null) {
                        ret = "";
                    } else {
                        ret = (Object) entry.message.getSource().getName();
                    }
                    break;
                default:
                    logger.log(Level.SEVERE, "Invalid table column index: " + columnIndex);
                    break;
            }
            return ret;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public void addMessage(IngestMessage m) {
            messageData.add(new TableEntry(m));
            int size = messageData.size();
            this.fireTableRowsInserted(size - 1, size);
        }

        public void clearMessages() {
            messageData.clear();
            fireTableDataChanged();
        }

        public void setVisited(int rowNumber) {
            messageData.get(rowNumber).visited = true;
            //repaint the cell 
            fireTableCellUpdated(rowNumber, 0);
        }

        public void setVisitedAll() {
            int row = 0;
            for (TableEntry e : messageData) {
                if (e.visited == false) {
                    e.visited = true;
                    fireTableCellUpdated(row, 0);
                }
                ++row;
            }
        }

        public boolean isVisited(int rowNumber) {
            return messageData.get(rowNumber).visited;
        }

        public MessageType getMessageType(int rowNumber) {
            return messageData.get(rowNumber).message.getMessageType();
        }

        public IngestMessage getMessage(int rowNumber) {
            return messageData.get(rowNumber).message;
        }

        class TableEntry implements Comparable {

            IngestMessage message;
            boolean visited;

            TableEntry(IngestMessage message) {
                this.message = message;
                visited = false;
            }

            @Override
            public int compareTo(Object o) {
                return this.message.getDatePosted().compareTo(((TableEntry) o).message.getDatePosted());
            }
        }
    }

    /**
     * bold font if not visited, colors for errors
     * tooltips that show entire query string, disable selection borders
     */
    private class MessageTableRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            final Component cell = super.getTableCellRendererComponent(
                    table, value, false, false, row, column);

            if (column < 2) {
                String val = (String) table.getModel().getValueAt(row, column);
                setToolTipText(val);
                setText(val);
            }

            if (column == 0) {
                if (tableModel.isVisited(row)) {
                    cell.setFont(visitedFont);
                } else {
                    cell.setFont(notVisitedFont);
                }
                MessageType mt = tableModel.getMessageType(row);
                if (mt == MessageType.ERROR) {
                    cell.setBackground(Color.red);
                } else if (mt == MessageType.WARNING) {
                    cell.setBackground(Color.orange);
                } else {
                    cell.setBackground(table.getBackground());
                }
            }

            return this;
        }

        @Override
        protected void setValue(Object value) {
            super.setValue(value);
        }
    }

    /**
     * handle table selections / cell visitations
     */
    private class MessageVisitedSelection implements ListSelectionListener {

        private Logger logger = Logger.getLogger(MessageVisitedSelection.class.getName());

        @Override
        public void valueChanged(ListSelectionEvent e) {
            DefaultListSelectionModel selModel = (DefaultListSelectionModel) e.getSource();
            if (!selModel.getValueIsAdjusting()) {
                final int minIndex = selModel.getMinSelectionIndex();
                final int maxIndex = selModel.getMaxSelectionIndex();
                int selected = -1;
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (selModel.isSelectedIndex(i)) {
                        selected = i;
                        break;
                    }
                }
                if (selected != -1) {
                    setVisited(selected);
                    updateDetails(selected);
                }


            }
        }
    }
}
