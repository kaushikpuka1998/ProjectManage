package Entities;

import java.util.Date;
import java.util.List;

public class Sprint {
    String sprintTitle;
    String status;
    Date startDate;
    Date endDate;
    List<Task> tasks;

    List<String> allowedStauses = List.of("open", "in_progress", "Closed");

    public Sprint(String sprintTitle, String status, Date startDate, Date endDate, List<Task> tasks) {
        this.sprintTitle = sprintTitle;
        this.status = allowedStauses.contains(status) ? status : "None";
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public String getSprintTitle() {
        return sprintTitle;
    }

    public void setSprintTitle(String sprintTitle) {
        this.sprintTitle = sprintTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<String> getAllowedStauses() {
        return allowedStauses;
    }

    public void setAllowedStauses(List<String> allowedStauses) {
        this.allowedStauses = allowedStauses;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void removeTask(Task task){
        this.tasks.remove(task);
        System.out.println("Task removed");
    }

    public void startSprint(){
        if(this.status.equals("open")){
            this.status = "in_progress";
            System.out.println("Sprint started");
        }
        else{
            System.out.println("Cannot start sprint");
        }
    }

    public void endSprint(){
        if(this.status.equals("in_progress")){
            this.status = "Closed";
            System.out.println("Sprint ended");
        }
        else{
            System.out.println("Cannot end sprint");
        }
    }
}
