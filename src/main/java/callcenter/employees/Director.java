package callcenter.employees;

import callcenter.Call;

public class Director extends Employee {
    public void showAnswerMessage(Call call) {
        System.out.println("Director answers call id: " + call.getId());
    }
    public void showFinishMessage(Call call) {
        System.out.println("Director finishes call id: " + call.getId());
    }
}
