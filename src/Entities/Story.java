package Entities;

import java.util.Date;
import java.util.List;

public class Story {
    String title;
    String assignee;
    String type;
    String status;
    String story_summary;
    Task task;
    List<Subtrack> subtracks;

    List<String> allowedStauses = List.of("open", "in_progress", "Closed");

    public Story(String title, String assignee, String task_type, String story_summary, String status, Date due_date,List<Subtrack> list) {
        this.task = new Task(title, assignee, task_type,due_date);
        this.story_summary = story_summary;
        this.subtracks = list;
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
        if(!newStatus.equals("Closed")) {
            System.out.println("Status changed to " + newStatus+ "from " + this.status);
            this.status = newStatus;
        }
        else{System.out.println("Status changed to " + newStatus+ "from " + this.status);
            this.status = newStatus;
            int completed_subtracks = 0;
            for(Subtrack subtrack : this.subtracks) {
                if(subtrack.getStatus().equals("Closed")) {
                    completed_subtracks++;
                }
                else if(this.subtracks.size() == completed_subtracks) {
                    this.status = newStatus;
                }
                else{
                    System.out.println("Cannot close story until all subtracks are closed");
                }
            }

        }
    }

    public void addSubtrack(Subtrack subtrack) {
        this.subtracks.add(subtrack);
    }
}
