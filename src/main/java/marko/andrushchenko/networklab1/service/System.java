package marko.andrushchenko.networklab1.service;

import marko.andrushchenko.networklab1.entities.Person;

import java.util.HashMap;

public class System {
	public static HashMap<Integer, Person> persons = new HashMap<>();
	public static int lastId = 0;
}
