/**
 * 
 */
package addressBook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




/**
 * @author ruchita patil
 *
 */
public class AddressBook {

	/**
	 * 
	 */
	private List<String> personAddress = new ArrayList<String>();
	Map<String, List<String>> addressMap = new HashMap<>();
	String regexForFirstName = "^[A-Za-z]{2,}$";
    String regexForLastName = "^[A-Za-z]{2,}$";
    String regexForAddress = "^[#.0-9a-zA-Z,-]+$";
    String regexForCity = "^[A-Za-z]{2,}$";
    String regexForState = "^[A-Za-z]{2,}$";	
    String regexForZipCode = "^[0-9]{6}";
    String regexForPhoneNumber =  "^[+]?([0-9]{2,3})?[0-9]{10}$";
    String regexForAddressNumber = "^[0-9]{1}";
    int count = 1;
    Scanner sc = new Scanner(System.in);
    PersonAddressBean personAddressBean = new PersonAddressBean();
    String addressNumber = null;
   // private String action = null;
	//private List<PersonAddress> personAddress = null;
	
	public  AddressBook() {
		
	}

	public void addAddress(String action) {
		// TODO Auto-generated constructor stub
		System.out.println("PLEASE ADD YOUR ADDRESS");
		//first name
		System.out.println("Enter your first name: ");
        String firstName=sc.next();
       
        if(!firstName.equals(null)) {
        	while(!firstName.matches(regexForFirstName)) {
        		System.out.println("Please enter valid first name: ");
        		firstName=sc.next();
        	}
        	
       		 personAddressBean.setFirstName(firstName);
       	     personAddress.add(personAddressBean.getFirstName());
        }else {
        	System.out.println("Please enter your first name: ");
        }
       
        //last Name
        System.out.println("Enter your last name: ");
        String lastName=sc.next();

        if(!lastName.equals(null)) {
        	while(!lastName.matches(regexForLastName)) {
        		System.out.println("Please enter valid last name: ");
        		lastName=sc.next();
        	}
    		 personAddressBean.setLastName(lastName);
    	     personAddress.add(personAddressBean.getLastName());
        }else {
        	System.out.println("Please enter your last name: ");
        }

       
        //address
        System.out.println("Enter your address: ");
        String address=sc.next();
        
        if(!address.equals(null)) {
        	while(!address.matches(regexForAddress)) {
        		System.out.println("Please enter valid address: ");
        		address=sc.next();
        	}
    		  personAddressBean.setAddress(address);
    	      personAddress.add(personAddressBean.getAddress());
        }else {
        	System.out.println("Please enter your address: ");
        }
      
        //city
        System.out.println("Enter your city: ");
        String city=sc.next();
        
        if(!city.equals(null)) {
        	while(!city.matches(regexForCity)) {
        		System.out.println("Please enter valid city: ");
        		city=sc.next();
        	}
    		 personAddressBean.setCity(city);
    	     personAddress.add(personAddressBean.getCity());
        }else {
        	System.out.println("Please enter your city: ");
        }
        
        //state
        System.out.println("Enter your state: ");
        String state=sc.next();
        
        if(!state.equals(null)) {
        	while(!state.matches(regexForState)) {
        		System.out.println("Please enter valid state: ");
        		state=sc.next();
        	}
    		 personAddressBean.setState(state);
    	     personAddress.add(personAddressBean.getState());
        	        
        }else {
        	System.out.println("Please enter your state: ");
        }
        
       //zip code
        System.out.println("Enter your zip code: ");
        String zip=sc.next();
        
        if(!zip.equals(null)) {
        	while(!zip.matches(regexForZipCode)) {
        		System.out.println("Please enter zip code: ");
        		zip=sc.next();
        	}
    		 personAddressBean.setZip(zip);
             personAddress.add(personAddressBean.getZip());
        }else {
        	System.out.println("Please enter zip code: ");
        }
        
        
        //phone number
        System.out.println("Enter your phone number: ");
        String phone=sc.next();
        
        if(!phone.equals(null)) {
        	while(!phone.matches(regexForPhoneNumber)) {
        		System.out.println("Please enter valid phone number: ");
        		phone=sc.next();
        	}
    		personAddressBean.setPhone(phone);
            personAddress.add(personAddressBean.getPhone());
        }else {
        	System.out.println("Please enter phone number: ");
        }
        
        
        if(!action.equals(null) && action.equals("EDITADDRESS")) {
        	  addressMap.put(addressNumber, personAddress);
        	  System.out.println("Address updated successfuly: ");
        	  addressNumber = null;
        }else {
        	 addressMap.put("address("+count+")", personAddress);
        	 System.out.println("Address added successfuly: ");
             count++;
        }
         
         System.out.println("YOUR ADDRESS BOOK");
         for (Map.Entry<String, List<String>> entry : addressMap.entrySet()) {
				System.out.println("ADDRESS NUMBER : " +entry.getKey());
				System.out.println(" ADDRESS : " + entry.getValue());
		}
        
	}
	
	public void editAddress() {
		
		
		System.out.println("YOUR ADDRESS BOOK");
        for (Map.Entry<String, List<String>> entry : addressMap.entrySet()) {
				System.out.println("ADDRESS NUMBER : " +entry.getKey());
				System.out.println(" ADDRESS : " + entry.getValue());
		}
        
        System.out.println("PLEASE ENTER ADDRESS NUMBER WHICH YOU WANT TO EDIT");
        String addressNum=sc.next();
        
        if(!addressNum.equals(null)) {
        	while(!addressNum.matches(regexForAddressNumber)) {
        		System.out.println("Please enter valid address number: ");
        		addressNum=sc.next();
        	}
        	addressNumber = "address("+addressNum+")";
        	addAddress("EDITADDRESS");
        }else {
        	System.out.println("Please enter address number: ");
        	return;
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("WELCOME TO ADDRESS BOOK");
		System.out.println("Enter Number of action you want to perform ");
		System.out.println("1. ADD ADDRESS BOOK");
		System.out.println("2. EDIT ADDRESS BOOK");
		System.out.println("3. EXIST ADDRESS BOOK");
		
		AddressBook addressBook = new AddressBook();
		addressBook.addAddress("ADDADDRESS");
		addressBook.editAddress();
		
		
	}

}
