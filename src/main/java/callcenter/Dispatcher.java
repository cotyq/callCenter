package callcenter;

import callcenter.employees.Director;
import callcenter.employees.Employee;
import callcenter.employees.Operator;
import callcenter.employees.Supervisor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.List;

public class Dispatcher {

    public final Integer MaxCallsAllowed = 10;

    private List<Call> pendingCalls;

    private List<Operator> operators;
    private List<Supervisor> supervisors;
    private List<Director> directors;

    public void dispatchCall(List<Call> calls) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(MaxCallsAllowed);
        for(int i = 0; i < calls.size(); i++) {
            Call call = calls.get(i);
            Employee employee = searchFreeEmployee();
            if(employee != null) {
                employee.answerCall(call);
                executor.execute(call);
            } else {
                System.out.println("There are no free employees");
                i--;
                try {
                    Mutex.down();
                } catch (InterruptedException e) {
                }
            }
        }
        executor.shutdown();
    }

    private Employee searchFreeEmployee() {
	    for(Employee operator: operators) {
	        if(!operator.isBusy()) {
	            return operator;
            }
        }
        for(Employee supervisor: supervisors) {
            if(!supervisor.isBusy()) {
                return supervisor;
            }
        }
        for(Employee director: directors) {
            if(!director.isBusy()) {
                return director;
            }
        }
        return null;
    }

    public List<Call> getPendingCalls() {
        return pendingCalls;
    }

    public void setPendingCalls(List<Call> pendingCalls) {
        this.pendingCalls = pendingCalls;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
