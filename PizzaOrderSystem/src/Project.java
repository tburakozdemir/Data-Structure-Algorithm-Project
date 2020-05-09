import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.*; 
import java.lang.*;

public class Project {
	
	public static void main(String[] args) {
		TheMenu();
	}
	//Storing the pizzas
	public static List<String> initPizzas() {
		ArrayList<String> thePizza = new ArrayList<String>();
		thePizza.add("Cheese");
		thePizza.add("Mixed");
		thePizza.add("Mushroom");
		thePizza.add("Meat");
		return thePizza;
	}
	public static void viewAllPizza(List<String> pizzas,String CustomerRef[]) {
		//to enumerate the pizzas in the arraylist
		ListIterator<String> it = pizzas.listIterator(); 
		while(it.hasNext()) {
			System.out.println(it.nextIndex() + " " + it.next());
		}
		
	}
	
	public static void addPizza(List<String> pizzas, String CustomerRef[]) {
		Scanner input = new Scanner(System.in);
		String Exit = "E";
		
		while(true) {
			System.out.println("Enter the pizza you would like to add and E to exit");
			String choice = input.next();
			
			if(choice.equals(Exit)) {
				break;
			}else {
				pizzas.add(choice);
;			}
		}
	}
	//Update the value of selected pizza before order otherwise will print 1 as default
	public static void addPizzaForOrder(String CustomerRef[], Map<String, Integer> counts) {
		Scanner input = new Scanner(System.in);
		String Exit = "E";
		
		while(true) {
			System.out.println("Enter the pizza you would like to order and E to exit");
			String choice = input.next();
			
			if(choice.equals(Exit)) {
				break;
			}else {
				if(counts.containsKey(choice)) {
					counts.put(choice, counts.get(choice) + 1);
				}else {
					counts.put(choice, 1);
				}
			}
		}
	}
	//Get updated value from addPizzaForOrder
	public static Map<String, Integer> counts = new HashMap<String, Integer>();
	
	public static void orderPizza(Map<String, Integer> counts,String CustomerRef[]) {
       
		addPizzaForOrder(CustomerRef, counts);
	        for(Map.Entry<String, Integer> entry : counts.entrySet()) {
	            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
	
	public static HashMap<String , Integer> sortByValue(Map<String, Integer> counts2){
		List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(counts2.entrySet());
		
		//For sorting the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
			 public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
				 return (o1.getValue()).compareTo(o2.getValue()); 
			 }
		});
		 HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
	        for (Map.Entry<String, Integer> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp;
	}
	
		
	public static void TheMenu() {
		String Customer[] = new String[10];
		
		Scanner input = new Scanner(System.in);
		List<String> pizzas = initPizzas();
		
		
		String option;
		do {
			System.out.println("\nMenu");
			System.out.println("V: Views all Pizza");
			System.out.println("A: To add a Pizza to the list");
			System.out.println("O: To order Pizza");
			System.out.println("M: To see month of the pizza");
			System.out.println("Q: To exit");
			
			option = input.next();
			
			if(option.charAt(0) == 'V' ) 
		    { 
		        viewAllPizza(pizzas,Customer);
		    } 
		    if(option.charAt(0) == 'A' ) 
		    { 
		        addPizza(pizzas,Customer);
		    }
		    if(option.charAt(0) == 'O'){
		    	orderPizza(counts, Customer);
		    }
		    if(option.charAt(0) == 'M') {
		    	Map<String, Integer> hm1 = sortByValue(counts);
		    	for (Map.Entry<String, Integer> en : hm1.entrySet()) { 
		            System.out.println("Pizza Name = " + en.getKey() +  
		                          ", Number Of Order = " + en.getValue()); 
		        } 
		    }
		    }while (option.charAt(0) != 'Q');
		}

	
	
}