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
	
	public Shop(boolean difficulty) {
		purchasableList = new ArrayList<Purchasable>();
		Apple apple = new Apple(difficulty);
		Carrot carrot = new Carrot(difficulty);
		Steak steak = new Steak(difficulty);
		HealthPotion healthPotion = new HealthPotion(difficulty);
		StrengthPotion strengthPotion = new StrengthPotion(difficulty);
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
	
	/**
	 * Adds Purchasable object to shop list
	 * @param monster
	 */
	public void addPurchasable(Purchasable purchasable) {
		purchasableList.add(purchasable);
	}
	
	/**
	 * A method that gives you a monsterList that is being sold.
	 * @param monsters ArrayList of class Monster.
	 * @return an ArrayList that has randomly generated monsters.
	 */
	public ArrayList<Monster> getMonsterList(ArrayList<Monster> monsters){
		monsterList = monsters;
		return monsterList;
		
	}
	
	/*
	 * Following methods return specified object for use
	 * when buying and selling item in main game environment.
	 * */
	public Purchasable buyPurchasable(int index) {
		Purchasable boughtItem = purchasableList.get(index);
		purchasableList.remove(index);
		return boughtItem;
	}
}
