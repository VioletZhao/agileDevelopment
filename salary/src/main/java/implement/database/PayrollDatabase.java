package implement.database;

import implement.entity.Employee;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 利用外观模式
 * 以empId为键，Employee为值
 * 以memberId为键，empId为值
 * Created by ZD on 2017/10/24.
 */
public class PayrollDatabase {

    private static PayrollDatabase payrollDatabase = new PayrollDatabase();

    private ConcurrentHashMap<Long,Employee> employees = new ConcurrentHashMap<Long, Employee>();
    private ConcurrentHashMap<Long,Long> members = new ConcurrentHashMap<Long, Long>();
    private ConcurrentHashMap<Long,Employee> unionMembers = new ConcurrentHashMap<Long, Employee>();

    public static PayrollDatabase getPayrollDatabase(){
        return payrollDatabase;
    }

    public Employee getEmployeeById(long id){
        return employees.get(id);
    }

    public void addEmployee(int empId,Employee e){
        employees.put((long) empId,e);
    }


    public void deleteEmployeeById(long id) {
        employees.remove(id);
    }

    public void addUnionMember(int memberId, Employee e) {
        unionMembers.put((long) memberId,e);
    }

    public Employee getEmployeeByMemberId(long memberId) {
        return unionMembers.get(memberId);
    }

    public void removeUnionMember(int memberId) {
        unionMembers.remove(memberId);
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }
}
