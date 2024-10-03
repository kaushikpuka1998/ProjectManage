package Entities;

import java.util.Date;
import java.util.List;

public class Feature {
    String title;
    String assignee;
    String type;
    String status;
    String impact;
    Task task;

    List<String> allowedStauses = List.of("open", "in_progress", "testing", "deployed");
    public Feature(String title, String assignee, String task_type, Date due_date, String featureSummery, String impact, String status) {
        this.task = new Task(title, assignee, task_type, due_date);
        this.impact = impact;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void changeAssignee(String newAssignee) {
        this.task.changeAssignee(newAssignee);
    }

    public void changeStatus(String newStatus) {
        if(!allowedStauses.contains(newStatus)) {
            System.out.println("Invalid status");
        }
        if(allowedStauses.indexOf(newStatus) < allowedStauses.indexOf(this.status)) {
            System.out.println("Cannot change status to a lower status");
        }

        System.out.println("Status changed to " + newStatus+ "from " + this.status);
        this.status = newStatus;
    }
}
