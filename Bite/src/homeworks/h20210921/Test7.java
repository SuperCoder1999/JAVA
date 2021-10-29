package homeworks.h20210921;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<Integer> subordinates3 = new ArrayList<>();
        List<Integer> subordinates2 = new ArrayList<>();
        List<Integer> subordinates1 = new ArrayList<>();
        subordinates1.add(2);
        subordinates1.add(3);
        Employee e1 = new Employee(1, 5, subordinates1);
        Employee e2 = new Employee(2, 3, subordinates2);
        Employee e3 = new Employee(3, 3, subordinates3);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(getImportance(employees, 1));
        //System.out.println("1" + employees.get(1-1));

    }

   /* 错误方法。id 和 存储顺序没有关系。
   public static int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        List<Integer> subordinates = employees.get(id-1).subordinates;
        //System.out.println(subordinates);
        for (int i = 0; i < subordinates.size(); i++) {
            //System.out.println(employees.get(subordinates.get(i) - 1));
            sum += employees.get(subordinates.get(i) - 1).importance;
        }
        return employees.get(id-1).importance + sum;
    }*/

    //简单递归方法 - https://leetcode-cn.com/problems/employee-importance/comments/
    public static int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                if (e.subordinates.size() == 0) { //递归出口
                    return e.importance;
                } else {
                    for (Integer subId : e.subordinates) {
                        e.importance += getImportance(employees, subId);
                    }
                    return e.importance;
                }
            }
        }
        return 0;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}