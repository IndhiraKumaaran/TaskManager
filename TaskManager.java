import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
class TaskManager{
    public static void main(String[] args) {
     
        Scanner s = new Scanner (System.in);
        boolean exit= false;
        ArrayList<Task> tasks= new ArrayList<>();

            while(!exit){
                System.out.println("Select the action need to be performed:\n1.Add Task\n2.Display Task\n3.Exit.\n4.Filter\n5.Add Subtask by id");
                int action=s.nextInt();
                s.nextLine();
                
            switch(action){
                 case 1:
                    addTasks(s,tasks);
                    break;
                case 2:
                    System.out.println("Availabe tasks: ");
                    tasks=taskSort(tasks);
                    for(int i =0;i<tasks.size();i++)
                    {
                        Task currTask= tasks.get(i);
                        System.out.printf("%d. %s | %s | %s | %s",i+1,currTask.name,currTask.desc,currTask.deadline,currTask.level);
                        for(int j =0;j<currTask.Category.size();j++) System.out.print("C"+j+1+" "+currTask.Category.get(j));
                        System.out.println();
                        currTask.subTasks=taskSort(currTask.subTasks);
                        for(int j =0;j<currTask.subTasks.size();j++){
                            
                            Task currSubTask= currTask.subTasks.get(j);
                                System.out.printf("\t S%d. %s | %s | %s | %s",j+1,currSubTask.name,currSubTask.desc,currSubTask.deadline,currSubTask.level);
                                for(int k=0;k<currSubTask.Category.size();k++) System.out.print("C"+k+1+" "+currSubTask.Category.get(k));
                                System.out.println();      
                        }
                    }
                    break;
                case 3:
                    exit=true;
                    break;
                case 4:
                    System.out.println("Enter the Category to filter");
                    String keyWord= s.next();
                    for(int i =0;i<tasks.size();i++){
                        Task currTask= tasks.get(i);
                        if(isCatg(currTask.Category, keyWord)) 
                        {
                            System.out.printf("%d. %s | %s | %s | %s | ",i+1,currTask.name,currTask.desc,currTask.deadline,currTask.level);
                            for(int j =0;j<currTask.Category.size();j++) System.out.print("C"+j+1+" "+currTask.Category.get(j)+" ");
                            System.out.println();
                        }
                    }
                case 5:
                    System.out.println(" enter a parent task id to add subtasks : ");
                    int taskId = s.nextInt();
                    s.nextLine();
                    System.out.println("Add sub tasks : ");
                    addTasks(s,  tasks.get(taskId).subTasks);
                    System.out.println("Sub Task added sucessfully");
                    
                default:
                    System.out.println("Invalid Action");
                    break;
                
            }
        }
        s.close();
        
    }
    public static boolean isValidDate(String date){
       
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-yyy"); 
        LocalDate currentDate=LocalDate.now();
   
        try {
           LocalDate deadLine= LocalDate.parse(date,formater);
           if(!deadLine.isBefore(currentDate)) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public static ArrayList<Task> taskSort(ArrayList<Task> tasks){
        int n = tasks.size();
        boolean swaped;
        for (int i =0;i<n-1;i++){
            swaped=false;
        for(int j =0;j<n-i-1;j++){
            Task iTask= tasks.get(j);
            Task jTask= tasks.get(j+1);
            char ic=iTask.level.charAt(0)=='L'?'L'+2:iTask.level.charAt(0);
            char jc=jTask.level.charAt(0)=='L'?'L'+2:jTask.level.charAt(0);
            if(ic>jc){
                Task temp= iTask;
                iTask= jTask;
                jTask=temp;
                tasks.set(j,iTask);
                tasks.set(j+1,jTask);
                swaped=true;
            }

        }
        if(!swaped) break;
    }
        return tasks;
    }
    public static boolean isCatg(ArrayList<String> catgs, String keyWord){
        for(int i =0;i<catgs.size();i++){
            if(catgs.get(i).equals(keyWord)) return true;
        }
        return false;
    }
    public static void addTasks(Scanner s, ArrayList<Task> SuperTask ){
        System.out.println("Add taks:");
                    String newTask=s.nextLine();

                    System.out.println("Add description for "+newTask+" : ");
                    String newDesc=s.nextLine();

                    System.out.println("Add Deadline for "+ newTask);
                    //String deadLine=s.nextLine();
                    String deadLine="11-08-2025";
            
                   
                        
                    while(!isValidDate(deadLine))
                    {
                        System.out.println("Invalid deadline");
                        System.out.println("Add a valid Deadline for "+ newTask);
                        deadLine=s.nextLine();
                    }

                    System.out.println("Enter the  level of task [H,M,L] : ");
                    String level =s.nextLine().toUpperCase();
                    ArrayList<String>category = new ArrayList<>();
                    System.out.println("Add categories to the task  and press \'x\' to stop: ");
                    while(true)
                    {
                        String catg=s.next();
                        if(catg.equals("x")) break;
                        category.add(catg);
                    }
                    SuperTask.add(new Task(newTask,newDesc,deadLine,level,category));

    }
}