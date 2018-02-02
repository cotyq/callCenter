package callcenter.employees;


import callcenter.Call;
import callcenter.Mutex;

public class Employee {

    private Boolean busy=false;

    public void answerCall(Call call) {
        this.busy = true;
        call.setOwner(this);
        this.showAnswerMessage(call);
    }

    public void finishCall(Call call) {
        this.busy = false;
        this.showFinishMessage(call);
        call.setFinished(true);
        Mutex.up();
    }

    public void showAnswerMessage(Call call){}
    public void showFinishMessage(Call call){}

    public Boolean isBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }
}
