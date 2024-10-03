package Entities;

import java.util.Date;
import java.util.List;

public class Bug {
    String title;
    String assignee;
    String type;
    String severity;
    String status;
    Task task;

    List<String> allowedStauses = List.of("Open", "In Progress", "Fixed");
    public Bug(String title, String assignee, String task_type, Date duedate, String severity, String status) {
        this.task = new Task(title, assignee, task_type, duedate);
        this.severity = severity;
        this.status = allowedStauses.contains(status) ? status : "None";
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
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

    public void printBug() {
        System.out.println("Title: " + title +"\t Assignee: " + assignee + "\t Type: " + type + "\t Severity: " + severity);
    }

}
