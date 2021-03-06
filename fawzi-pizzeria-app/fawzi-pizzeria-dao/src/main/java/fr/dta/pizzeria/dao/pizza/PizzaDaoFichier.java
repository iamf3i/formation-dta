package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.CategoriePizza;
import fr.dta.pizzeria.model.Pizza;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class PizzaDaoFichier implements PizzaDao {

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {

		List<Pizza> ret = new ArrayList<Pizza>();

		// Basic and Ugly abstraction for pizzas File location in filesystem
		String home = "C:\\Users\\fawzi\\Documents\\workspace-sts-3.8.2.RELEASE\\formation-dta\\fawzi-pizzeria-app\\fawzi-pizzeria-console\\src\\main\\resources\\data";
		String dta = "C:\\Users\\ETY5\\Documents\\WORKSPACE\\src\\fawzi-pizzeria-app\\fawzi-pizzeria-console\\src\\main\\resources\\data";

		File dir = new File(dta);

		dir.mkdir();

		if (dir.exists()) {
			File[] directoryListing = dir.listFiles();

			if (directoryListing != null) {
				int i = 0;
				for (File child : directoryListing) {
					Pizza p = new Pizza();
					p.setId(i++);
					Properties props = new Properties();
					try {
						props.load(new FileInputStream(child));
					} catch (IOException e) {
						throw new PizzaException("InputStream: Fail");
					}
					p.setCode(props.getProperty("code"));
					p.setNom(props.getProperty("nom"));
					p.setPrix(Double.parseDouble(props.getProperty("prix")));
					p.setCat(CategoriePizza.valueOf(props.getProperty("categorie")));
					ret.add(p);
				}
			} else {
				return null;
			}
		}
		return ret;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Pizza> getPizzaIdFromCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

}
