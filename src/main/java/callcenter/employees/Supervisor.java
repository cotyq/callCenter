package callcenter.employees;

import callcenter.Call;

public class Supervisor extends Employee {
    public void showAnswerMessage(Call call) {
        System.out.println("Supervisor answers call id: " + call.getId());
    }
    public void showFinishMessage(Call call) {
        System.out.println("Supervisor finishes call id: " + call.getId());
    }
}
