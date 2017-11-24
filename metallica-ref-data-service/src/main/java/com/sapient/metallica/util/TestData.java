package com.sapient.metallica.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.CounterParty;
import com.sapient.metallica.beans.Location;

public class TestData {

	public static Collection<Commodity> getCommodities() {

		Commodity c1 = new Commodity("AL", "Aluminum");
		Commodity c2 = new Commodity("ZN", "Zinc");
		Commodity c3 = new Commodity("CU", "Copper");
		Commodity c4 = new Commodity("AU", "Gold");
		Commodity c5 = new Commodity("AG", "Silver");

		List<Commodity> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);

		return list;
	}

	public static Collection<CounterParty> getCounterParties() {

		CounterParty c1 = new CounterParty("Lorem", "Lorem");
		CounterParty c2 = new CounterParty("Ipsum", "Ipsum");
		CounterParty c3 = new CounterParty("Dolor", "Dolor");
		CounterParty c4 = new CounterParty("Amet", "Amet");

		List<CounterParty> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);

		return list;
	}

	public static Collection<Location> getLocations() {

		Location c1 = new Location("LN", "London");
		Location c2 = new Location("NY", "New York");
		Location c3 = new Location("SG", "Singapore");
		Location c4 = new Location("DN", "Denver");

		List<Location> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);

		return list;
	}
}
