package callcenter;

//import org.junit.Assert;
import callcenter.employees.Director;
import callcenter.employees.Operator;
import callcenter.employees.Supervisor;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DispatcherTest {

	@Test
	public void dispatcherDelivers10Calls() {
		Dispatcher dispatcher = new Dispatcher();
		initializeEmployees(dispatcher, 3, 2, 1);
		List<Call> calls = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			calls.add(new Call(i));
		}
		dispatcher.dispatchCall(calls);
		List<Call> finishedCalls = calls.stream().filter(c -> c.getFinished() == true).collect(Collectors.toList());
		Assert.assertEquals(calls.size(), finishedCalls.size());
	}

	@Test
	public void dispatcherDelivers11Calls() {
		Dispatcher dispatcher = new Dispatcher();
		initializeEmployees(dispatcher, 3, 2, 1);
		List<Call> calls = new ArrayList<>();
		for(int i = 0; i < 11; i++) {
			calls.add(new Call(i));
		}
		dispatcher.dispatchCall(calls);
		List<Call> finishedCalls = calls.stream().filter(c -> c.getFinished() == true).collect(Collectors.toList());
		Assert.assertEquals(calls.size(), finishedCalls.size());
	}

	@Test
	public void dispatcherDelivers10CallsWith10Operators() {
		Dispatcher dispatcher = new Dispatcher();
		initializeEmployees(dispatcher, 10, 2, 1);
		List<Call> calls = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			calls.add(new Call(i));
		}
		dispatcher.dispatchCall(calls);
		List<Call> operatorCalls = calls.stream().filter(c -> c.getOwner() instanceof Operator).collect(Collectors.toList());
		Assert.assertEquals(calls.size(), operatorCalls.size());
	}

	private void initializeEmployees(Dispatcher dispatcher, Integer opCount, Integer supCount, Integer dirCount) {
		ArrayList<Operator> operators = new ArrayList<>();
		for(int i = 0; i < opCount; i++) {
			operators.add(new Operator());
		}

		ArrayList<Supervisor> supervisors = new ArrayList<>();
		for(int i = 0; i < supCount; i++) {
			supervisors.add(new Supervisor());
		}

		ArrayList<Director> directors = new ArrayList<>();
		for(int i = 0; i < dirCount; i++) {
			directors.add(new Director());
		}

		dispatcher.setOperators(operators);
		dispatcher.setSupervisors(supervisors);
		dispatcher.setDirectors(directors);
	}

}
