package fr.pizzeria.model;

public class ListPizza extends Action {


	public ListPizza() {
		super();
		this.setDescription("1. Lister les pizzas");
	}

	@Override
	public void do_action() {

	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
