package main;

import java.util.ArrayList;

import items.*;

/*
 * Shop class used for storing objects of type Purchasable,
 * and returning specified objects with buy and sell methods
 * for use in game environment
 * @author Orion Lynch and Reilly Haskins.
 * */
public class Shop {
	
	/*
	 * Initiates ArrayList for purchasable items
	 * */
	private ArrayList<Purchasable> purchasableList;
	
	public Shop() {
		purchasableList = new ArrayList<Purchasable>();
		Apple apple = new Apple();
		Carrot carrot = new Carrot();
		Steak steak = new Steak();
		HealthPotion healthPotion = new HealthPotion();
		StrengthPotion strengthPotion = new StrengthPotion();
		purchasableList.add(apple);
		purchasableList.add(carrot);
		purchasableList.add(steak);
		purchasableList.add(healthPotion);
		purchasableList.add(strengthPotion);
		
	}
	
	/*
	 * Returns entire ArrayList
	 * */
	public ArrayList<Purchasable> getPurchasableList(){
		return purchasableList;
	}
	
	/*
	 * Following methods return specified object for use
	 * when buying and selling item in main game environment.
	 * */
	public Purchasable buyPurchasable(int index) {
		return purchasableList.get(index);
	}
	
	public Purchasable sellPurchasable(int index) {
		return purchasableList.get(index);
	}
}
