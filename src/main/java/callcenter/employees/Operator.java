package callcenter.employees;

import callcenter.Call;

public class Operator extends Employee {
    public void showAnswerMessage(Call call) {
        System.out.println("Operator answers call id: " + call.getId());
    }
    public void showFinishMessage(Call call) {
        System.out.println("Operator finishes call id: " + call.getId());
    }
}
