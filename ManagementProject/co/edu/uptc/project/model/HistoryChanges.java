package co.edu.uptc.project.model;

import java.util.ArrayList;
import java.util.List;

public class HistoryChanges {
    private List<String> changes;
    private String changeDate;

    public HistoryChanges(String changeDate) {
        this.changes = new ArrayList<>();
        this.changeDate = changeDate;
    }

    public void registerChange(String change) {
        changes.add(change);
    }

   

    public List<String> getChanges() {
        return changes;
    }

    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "HistoryChanges{" +
                "changes=" + changes +
                ", changeDate='" + changeDate + '\'' +
                '}';
    }
}