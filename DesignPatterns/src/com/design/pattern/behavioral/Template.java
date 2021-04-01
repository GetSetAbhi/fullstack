package com.design.pattern.behavioral;

abstract class Game {
	public abstract void start();
	public abstract void playing();
	public abstract void stopped();
	
	public void playGame() {
		start();
		playing();
		stopped();
	}
}

class Cricket extends Game {

	@Override
	public void start() {
		System.out.println("Game started " + this.getClass().getSimpleName());
	}

	@Override
	public void playing() {
		System.out.println("Playing Game " + this.getClass().getSimpleName());	
	}

	@Override
	public void stopped() {
		System.out.println("Stopped playing " + this.getClass().getSimpleName());	
	}
}

class Football extends Game {

	@Override
	public void start() {
		System.out.println("Game started " + this.getClass().getSimpleName());
	}

	@Override
	public void playing() {
		System.out.println("Playing Game " + this.getClass().getSimpleName());	
	}

	@Override
	public void stopped() {
		System.out.println("Stopped playing " + this.getClass().getSimpleName());	
	}
}
public class Template {
	
	public static void main(String[] args) {
		Game c = new Cricket();
		c.playGame();
		
		c = new Football();
		c.playGame();
	}

}
