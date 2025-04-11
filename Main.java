
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner (System.in);
	   
	   ArrayList<Task> tasks = new ArrayList<>();
    //    PriorityQueue<Task> stasks = new PriorityQueue<>(TasK.p);
	   //ArrayList<Integer> priortasks = new ArrayList<>();
      
	   boolean f=true;
	   while(f){
	       System.out.print("Select the opperation: \n1. Add task \n2. Display tasks \n3. exit\n");
	       int ip=s.nextInt();

	   switch(ip){
	       case 1:

              {   String o= s.nextLine();  
                  System.out.print("Enter task name: ");
	              String taskName= s.nextLine();
                  System.out.print("Enter task desc: ");
                  String taskDesc=s.nextLine();
               // System.out.println(taskName);
                //System.out.println(taskDesc);
                
                    System.out.print("Enter deadline in DD-MM-YYYY: ");
                    String date= s.nextLine();

                    System.out.println("Specify priority [L,M,H]: ");
                    String prior=s.nextLine();
                    ArrayList<String> cat= new ArrayList<>();
                    System.out.print("Enter Categories");
                    boolean x=true;
                    while(x){
                        String c = s.next();
                        cat.add(c);
                        if(c.equals("x"))x=false;
                    }
                    System.out.println("Enter searching  category: ");
                    String search=s.next();
                    if(isValid(date)){

                  tasks.add(new Task(taskName,taskDesc,date,prior,cat));
                  
                  
                    }
                    else{
                        System.out.println(" Invalid deadline");
                    }

	            break;
       } 
	       case 2:

	             {
//tasks=srt(tasks);
                    System.out.println("Tasks:");
                    
	             for(int i =0;i<tasks.size();i++){
	              System.out.print(i+1+" "+tasks.get(i).name+" | "+tasks.get(i).date+" | "+tasks.get(i).desc+" | "+" | Categories : ");
                  String help="";
                  for(int j=0;j<tasks.get(i).Cat.size()-1;j++){
                    
                    help+=tasks.get(i).Cat.get(j);
                    //System.out.print(tasks.get(i).Cat.get(j)+" "+tasks);
                  }
                  if(help.contains(se)){

                  }
                  System.out.println();
                    //stasks.offer(tasks.get(i));q
                }
                //   System.out.println(stasks);

	             break;}
	   
           case 3: 
                f=false;
                break;
	       default:
	       System.out.println("Invalid input");
	           
	   }
	}
	    
	}
    public static boolean isValid (String date){
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3, 5));
        int year=Integer.parseInt(date.substring(6 ));
        //System.out.println(day+""+month+" "+year);
        if(month>12|| day>31) return false; 
        if(month!=2 && day<=31) return true;
        if(month==2 && year%4==0 && day<=29 )return true;
        if(month==2 && day<=28) return true;
        return false;
    }
    public static ArrayList<Task> srt(ArrayList <Task> tasks){
        int j=0;
        int i=0;
        Task temp;
        while(i<tasks.size()&&j<tasks.size()){
            if(tasks.get(i).prior.equals("H") &&!tasks.get(j).prior.equals("H")){
                temp=tasks.get(i);
                tasks.add(j,temp);
                tasks.add(i,tasks.get(j));
                j++;

            }
            i++;
        }
        return tasks;
    }
    public static ArrayList<Task> srt1(ArrayList <Task> tasks){
        int j=0;
        int i=tasks.size()-1;
        Task temp;
        while(i>=0&&j<tasks.size()){
            if(tasks.get(j).prior.equals("L") &&!tasks.get(i).prior.equals("L")){
                temp=tasks.get(i);
                tasks.add(i,tasks.get(j));
                tasks.add(j,temp);
                j++;

            }
            i--;
        }
        return tasks;
    }
}

