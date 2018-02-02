package callcenter;

import callcenter.employees.Employee;

import java.util.concurrent.TimeUnit;

public class Call implements Runnable {

    private Integer id;
    private Integer duration;
    private Boolean finished = true;

    private Employee owner;

    public Call(Integer id) {
        this.id = id;
    }

    public void run() {
        try {
            Double duration = Math.random() * 5 + 5;
            TimeUnit.SECONDS.sleep(duration.longValue());
            owner.finishCall(this);
        }
        catch (InterruptedException e) {
        }
    }

    public Integer getId() { return id; }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
