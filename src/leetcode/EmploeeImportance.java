package leetcode;

/**
 * Created by parcpaes on 03/05/2018.
 */

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private int id;
    private int importance;
    private List<Integer> subordinates;
    private int v[] = new int[1000000000];
    private long s[] = new long[1000000000];
    private long va = 10000000000l;
    public void setId(int id){
        this.id = id;
    }

    public int Id(){ return id;}


    public void setImportance(int importance){
        this.importance = importance;
    }

    public int getImportance(){ return importance;}

    public void setListSubordinates(List<Integer> list){
        this.subordinates = list;
    }
    public List<Integer> getListSubordinates(){ return subordinates;}
}

public class EmploeeImportance {
    public boolean visited[] = new boolean[2001];
    TreeMap<Integer,Employee> mapemploy = new TreeMap<>();
    public int important;
    private int dfs(int id){
        visited[id] = true;
        Employee employ = mapemploy.get(id);
        important += employ.getImportance();
        for(Integer emp : employ.getListSubordinates()){
            if(!visited[emp]){
                dfs(emp);
            }
        }
        return important;
    }

    public int getImportance(List<Employee> employees,int id){
        if(employees.size()==1){ return employees.get(0).getImportance();}
        important = 0;
        for(Employee employ: employees){
            mapemploy.put(employ.Id(),employ);
        }
        return dfs(id);
    }

    public static void main(String arg[]){
        EmploeeImportance imp = new EmploeeImportance();
        List<Employee> listemployee = new ArrayList<>();
        Employee emp1= new Employee();
        emp1.setId(1);
        emp1.setImportance(15);
        emp1.setListSubordinates(Arrays.asList(2));
        listemployee.add(emp1);

        Employee emp2= new Employee();
        emp2.setId(2);
        emp2.setImportance(10);
        emp2.setListSubordinates(Arrays.asList(3));
        listemployee.add(emp2);


        Employee emp3= new Employee();
        emp3.setId(3);
        emp3.setImportance(5);
        emp3.setListSubordinates(new ArrayList<>());
        listemployee.add(emp3);

        System.out.println(imp.getImportance(listemployee,3));
    }
}
