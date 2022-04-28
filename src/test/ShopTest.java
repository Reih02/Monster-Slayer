package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import items.Apple;
import main.Shop;

class ShopTest {

	private Shop testShop;
	private Apple apple = new Apple(false);
	
	@BeforeEach
	public void setUp() throws Exception {
		testShop = new Shop(false);
	}

	@Test
	void testGetPurchasableList() {
		assertEquals(5, testShop.getPurchasableList().size());
	}

	@Test
	void testBuyPurchasable() {
		assertEquals(apple.getClass(), testShop.buyPurchasable(0).getClass());
	}

	@Test
	void testSellPurchasable() {
		assertEquals(apple.getClass(), testShop.buyPurchasable(0).getClass());
	}

}
