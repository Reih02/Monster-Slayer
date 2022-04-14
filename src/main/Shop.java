package main;

import java.util.ArrayList;

public class Shop {
	
	private ArrayList<Purchasable> purchasableList;
	
	public Shop() {
		purchasableList = new ArrayList<Purchasable>();
	}
	
	public ArrayList<Purchasable> getPurchasableList(){
		return purchasableList;
	}
	
	public Purchasable buyPurchasable(int index) {
		return purchasableList.get(index);
	}
	
	public Purchasable sellPurchasable(int index) {
		return purchasableList.get(index);
	}
}
