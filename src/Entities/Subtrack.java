package Entities;

import java.util.List;

public class Subtrack {
    String title;
    String status;
    String parent_task_title;

    List<String> allowedStauses = List.of("open", "in_progress", "Closed");

    public Subtrack(String title, String status, String parent_task_title) {
        this.title = title;
        this.status = allowedStauses.contains(status) ? status : "None";
        this.parent_task_title = parent_task_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = allowedStauses.contains(status) ? status : "None";
    }

    public String getParentTaskTitle() {
        return parent_task_title;
    }

    public void setParentTaskTitle(String parent_task_title) {
        this.parent_task_title = parent_task_title;
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
