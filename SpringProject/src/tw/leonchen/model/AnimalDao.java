package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "animalDao")
public class AnimalDao {
	
	@Autowired//setterDI
	private Animal animal;
	
	public void showInfo() {
		System.out.println(animal.getId() + " " + animal.getName() + " " + animal.getContinent());
	}

}
