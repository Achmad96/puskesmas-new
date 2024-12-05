package puskesmas.pkg.frame;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Achmad Raihan
 */
public interface PanelBase {

  abstract public void loadData();

  default public DefaultTableModel getUpdatedModel(JTable table, ArrayList<Object[]> dataList) {
    final DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    for (Object[] rowData : dataList) {
      model.addRow(rowData);
    }
    return model;
  }
}
