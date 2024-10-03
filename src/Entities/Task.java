package Entities;

import java.util.Date;

public class Task {
    String title;
    String assignee;
    String type;
    Date dueDate;
    public Task(String tite, String assignee, String type, Date dueDate) {
        this.title = tite;
        this.assignee = assignee;
        this.type = type;
        this.dueDate = dueDate;
    }

    public String getTite() {
        return title;
    }

    public void setTite(String tite) {
        this.title = tite;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void changeAssignee(String newAssignee) {
        this.assignee = newAssignee;
    }

    public void printTask() {
        System.out.println("Title: " + title+"\t Assignee: " + assignee + "\t Type: " + type + "\t Due Date: " + dueDate);
    }
}
