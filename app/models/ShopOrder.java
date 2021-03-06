package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShopOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@OneToOne(cascade = CascadeType.REMOVE)
	private ShoppingList shoppingList = null;

	@ElementCollection
	private List<Integer> categories = new ArrayList<Integer>();

	public ShopOrder() {

	}

	public ShopOrder(String name, ArrayList<Integer> categories) {
		this.name = name;
		this.categories = categories;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public Category[] getCategoriesAsCategory() {
		Category[] categories = new Category[9];
		for (int i = 0; i < this.categories.size(); i++) {
			categories[i] = Category.getCategoryByIndex(this.categories.get(i));
		}
		return categories;
	}

	public void setCategories(ArrayList<Integer> categories) {
		this.categories = categories;
	}

}
