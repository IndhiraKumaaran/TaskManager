import java.util.*;
class Task{
    String name;
    String desc;
    String deadline;
    String level;
    ArrayList<String> Category;
    ArrayList<Task> subTasks;
    
    
    public Task(String name,  String desc, String deadline , String level,ArrayList<String> Category) {
        this.name = name;
        this.desc= desc;
        this.deadline=deadline;
        this.level=level.isEmpty()?"M":level;
        this.Category=Category;
        this.subTasks=new ArrayList<>();
    }

}