package callcenter;


import callcenter.employees.Director;
import callcenter.employees.Operator;
import callcenter.employees.Supervisor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallCenter {
	public static void main(String[] args) {
		ArrayList<Operator> operators = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			operators.add(new Operator());
		}

		ArrayList<Supervisor> supervisors = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			supervisors.add(new Supervisor());
		}

		ArrayList<Director> directors = new ArrayList<>();
		directors.add(new Director());

		List<Call> calls = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			calls.add(new Call(i));
		}

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.setOperators(operators);
		dispatcher.setSupervisors(supervisors);
		dispatcher.setDirectors(directors);

//		dispatcher.dispatchCall(calls);

	}

}
