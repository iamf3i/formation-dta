package fr.pizzeria.model;

public class ExitMenu extends Action {

	
	public ExitMenu() {
		super();
		this.setDescription("99. Sortir");
	}

	@Override
	public void do_action() {

	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
