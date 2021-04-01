package com.design.pattern.behavioral;

interface State {
	public void doAction(Context context);
}

class Start implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("GAME Started");
		context.setState(this);
	}

}

class Stop implements State {
	@Override
	public void doAction(Context context) {
		System.out.println("GAME Stopped");
		context.setState(this);
	}
}


class Context {

	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}

public class StateDP {

	public static void main(String[] args) {
		Context c = new Context();
		
		Start start = new Start();
		start.doAction(c);
		System.out.println("Current State is : " + c.getState().getClass().getSimpleName());
		Stop stop = new Stop();
		stop.doAction(c);
		System.out.println("Current State is : " + c.getState().getClass().getSimpleName());
	}
}
