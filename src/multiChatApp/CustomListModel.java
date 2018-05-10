package multiChatApp;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class CustomListModel implements ListModel<String>{

    private List<String> data;

    public CustomListModel(List<String> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        return;
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        return;
    }
}
