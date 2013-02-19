package restaurant.gui;

import restaurant.CustomerAgent;
<<<<<<< HEAD
import restaurant.MarketAgent;
import restaurant.WaiterAgent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.math.RoundingMode;

import java.text.*;
=======
import restaurant.WaiterAgent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.File;

>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents

/** Main GUI class.
 * Contains the main frame and subsequent panels */
public class RestaurantGui extends JFrame implements ActionListener{
   
<<<<<<< HEAD
    private final int WINDOWX = 650;
    private final int WINDOWY = 450;
=======
    private final int WINDOWX = 450;
    private final int WINDOWY = 350;
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents

    private RestaurantPanel restPanel = new RestaurantPanel(this);
    private JPanel infoPanel = new JPanel();
    private JLabel infoLabel = new JLabel(
<<<<<<< HEAD
    "<html><pre><i>(Click on a customer/waiter/market)</i></pre></html>");
=======
    "<html><pre><i>(Click on a customer/waiter)</i></pre></html>");
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
    private JCheckBox stateCB = new JCheckBox();
	private JButton addTable = new JButton("Add Table");

    private Object currentPerson;
<<<<<<< HEAD
    
    // New GUI variables for v4.1
    // For new customer information
    private JPanel customerPanel = new JPanel();
    private JLabel moneyLabel = new JLabel(" Total $:   ");
    private JFormattedTextField customerMoneyTF = new JFormattedTextField();
    private JLabel customerMoneyOwedLabelA = new JLabel("Money Owed: ");
    private JLabel customerMoneyOwedLabelB = new JLabel("0.00");
    private JButton payOffButton = new JButton("Pay Debt");
    private JCheckBox onlyPayFullyCB = new JCheckBox("Pay Fully");
    private JCheckBox willWaitCB = new JCheckBox("Will Wait");
    
    // Bottom customer panel used to control what the customers order
    private JPanel customerOrderPanel = new JPanel();
    private JLabel customerOrderLabel = new JLabel("Choose what the customer orders: ");
    private Map<String, JCheckBox> customerOrderButtons = new HashMap<String, JCheckBox>();
    
    // For a market's information
    private JPanel marketPanel = new JPanel();
    private ArrayList<JLabel> marketLabels = new ArrayList<JLabel>();
    private Map<String, JTextField> marketTFs = new HashMap<String, JTextField>();
    
    // For the cook's information
    private JPanel cookPanel = new JPanel();
    private ArrayList<JLabel> cookLabels = new ArrayList<JLabel>();
    private Map<String, JTextField> cookTFs = new HashMap<String, JTextField>();
    
    updateGUI cUpdater = new updateGUI(); // Has a timer method to help show the correct values for a customer    
    
    private javax.swing.Timer updateTimer = new javax.swing.Timer(100, cUpdater);
    
    DecimalFormat df = new DecimalFormat();
=======
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents

    /** Constructor for RestaurantGui class.
     * Sets up all the gui components. */
    public RestaurantGui(){

	super("Restaurant Application");

<<<<<<< HEAD
	df.setRoundingMode(RoundingMode.UP);
	
=======
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(50,50, WINDOWX, WINDOWY);

	getContentPane().setLayout(new BoxLayout((Container)getContentPane(),BoxLayout.Y_AXIS));

<<<<<<< HEAD
	Dimension rest = new Dimension(WINDOWX, (int)(WINDOWY*.5));
=======
	Dimension rest = new Dimension(WINDOWX, (int)(WINDOWY*.6));
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
	Dimension info = new Dimension(WINDOWX, (int)(WINDOWY*.25));
	restPanel.setPreferredSize(rest);
	restPanel.setMinimumSize(rest);
	restPanel.setMaximumSize(rest);
	infoPanel.setPreferredSize(info);
	infoPanel.setMinimumSize(info);
	infoPanel.setMaximumSize(info);
	infoPanel.setBorder(BorderFactory.createTitledBorder("Information"));

	stateCB.setVisible(false);
	stateCB.addActionListener(this);
<<<<<<< HEAD
	stateCB.addActionListener(cUpdater); // Add my functionality into the old functionality 

	infoPanel.setLayout(new GridLayout(1,5, 30,0));
	infoPanel.add(infoLabel);
	infoPanel.add(stateCB);
	
	// New Functionality
	// Set up the customerPanel
	customerPanel.setLayout(new BoxLayout(customerPanel,BoxLayout.X_AXIS));
	customerPanel.add(moneyLabel);
	customerPanel.add(customerMoneyTF);
	customerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	customerPanel.add(customerMoneyOwedLabelA);
	customerPanel.add(customerMoneyOwedLabelB);
	customerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	customerPanel.add(payOffButton);
	customerPanel.add(onlyPayFullyCB);
	customerPanel.add(willWaitCB);
	
	// Set Sizes for Components
	customerMoneyTF.setPreferredSize(new Dimension(100, 20));
	customerMoneyTF.setMinimumSize(new Dimension(100, 20));
	customerMoneyTF.setMaximumSize(new Dimension(100, 20));
	customerMoneyTF.setHorizontalAlignment(SwingConstants.CENTER);
	
	customerMoneyOwedLabelB.setPreferredSize(new Dimension(75, 20));
	customerMoneyOwedLabelB.setMinimumSize(new Dimension(75, 20));
	customerMoneyOwedLabelB.setMaximumSize(new Dimension(75, 20));
	
	// Set Alignment
	customerMoneyOwedLabelB.setHorizontalAlignment(SwingConstants.CENTER);
	
	// Add Action Listeners
	customerMoneyTF.addActionListener(cUpdater);
	payOffButton.addActionListener(cUpdater);
	onlyPayFullyCB.addActionListener(cUpdater);
	willWaitCB.addActionListener(cUpdater);
	
	// Do the same for the customerOrderPanel
	customerOrderPanel.setLayout(new BoxLayout(customerOrderPanel,BoxLayout.X_AXIS));
	customerOrderPanel.add(customerOrderLabel);
	
	customerOrderButtons.put("Steak", new JCheckBox("Steak"));	
	customerOrderButtons.get("Steak").setPreferredSize(new Dimension(85, 25));
	customerOrderButtons.get("Steak").setMaximumSize(new Dimension(85, 25));
	customerOrderButtons.get("Steak").setMinimumSize(new Dimension(85, 25));
	customerOrderButtons.get("Steak").setHorizontalAlignment(SwingConstants.CENTER);
	
	customerOrderButtons.put("Chicken", new JCheckBox("Chicken"));
	customerOrderButtons.get("Chicken").setPreferredSize(new Dimension(85, 25));
	customerOrderButtons.get("Chicken").setMaximumSize(new Dimension(85, 25));
	customerOrderButtons.get("Chicken").setMinimumSize(new Dimension(85, 25));
	customerOrderButtons.get("Chicken").setHorizontalAlignment(SwingConstants.CENTER);
	
	customerOrderButtons.put("Pizza", new JCheckBox("Pizza"));
	customerOrderButtons.get("Pizza").setPreferredSize(new Dimension(85, 25));
	customerOrderButtons.get("Pizza").setMaximumSize(new Dimension(85, 25));
	customerOrderButtons.get("Pizza").setMinimumSize(new Dimension(85, 25));
	customerOrderButtons.get("Pizza").setHorizontalAlignment(SwingConstants.CENTER);
	
	customerOrderButtons.put("Salad", new JCheckBox("Salad"));
	customerOrderButtons.get("Salad").setPreferredSize(new Dimension(85, 25));
	customerOrderButtons.get("Salad").setMaximumSize(new Dimension(85, 25));
	customerOrderButtons.get("Salad").setMinimumSize(new Dimension(85, 25));
	customerOrderButtons.get("Salad").setHorizontalAlignment(SwingConstants.CENTER);
	
	customerOrderPanel.add(customerOrderButtons.get("Steak"));
	customerOrderPanel.add(customerOrderButtons.get("Chicken"));
	customerOrderPanel.add(customerOrderButtons.get("Pizza"));
	customerOrderPanel.add(customerOrderButtons.get("Salad"));
	
	customerOrderButtons.get("Steak").addActionListener(cUpdater);
	customerOrderButtons.get("Chicken").addActionListener(cUpdater);
	customerOrderButtons.get("Pizza").addActionListener(cUpdater);
	customerOrderButtons.get("Salad").addActionListener(cUpdater);
	
	// Set up the marketPanel
	marketPanel.setLayout(new BoxLayout(marketPanel,BoxLayout.X_AXIS));
	marketLabels.add(new JLabel("Market Inventory ----> "));
	marketLabels.add(new JLabel("Steak: "));
	marketLabels.add(new JLabel("Chicken: "));
	marketLabels.add(new JLabel("Pizza: "));
	marketLabels.add(new JLabel("Salad: "));
	
	marketTFs.put("Steak", new JTextField(10));	
	marketTFs.get("Steak").setPreferredSize(new Dimension(75, 20));
	marketTFs.get("Steak").setMaximumSize(new Dimension(75, 20));
	marketTFs.get("Steak").setMinimumSize(new Dimension(75, 20));
	marketTFs.get("Steak").setHorizontalAlignment(SwingConstants.CENTER);
	
	marketTFs.put("Chicken", new JTextField(10));
	marketTFs.get("Chicken").setPreferredSize(new Dimension(75, 20));
	marketTFs.get("Chicken").setMaximumSize(new Dimension(75, 20));
	marketTFs.get("Chicken").setMinimumSize(new Dimension(75, 20));
	marketTFs.get("Chicken").setHorizontalAlignment(SwingConstants.CENTER);
	
	marketTFs.put("Pizza", new JTextField(10));
	marketTFs.get("Pizza").setPreferredSize(new Dimension(75, 20));
	marketTFs.get("Pizza").setMaximumSize(new Dimension(75, 20));
	marketTFs.get("Pizza").setMinimumSize(new Dimension(75, 20));
	marketTFs.get("Pizza").setHorizontalAlignment(SwingConstants.CENTER);
	
	marketTFs.put("Salad", new JTextField(10));
	marketTFs.get("Salad").setPreferredSize(new Dimension(75, 20));
	marketTFs.get("Salad").setMaximumSize(new Dimension(75, 20));
	marketTFs.get("Salad").setMinimumSize(new Dimension(75, 20));
	marketTFs.get("Salad").setHorizontalAlignment(SwingConstants.CENTER);
	
	// Add everything into the panel
	Set<String> tempStrings = marketTFs.keySet();
	
	int i = 0;
	marketPanel.add(marketLabels.get(i));

	i++;
	marketPanel.add(marketLabels.get(i));
	marketPanel.add(marketTFs.get("Steak"));
	marketTFs.get("Steak").addActionListener(cUpdater);
		
	i++;
	marketPanel.add(marketLabels.get(i));
	marketPanel.add(marketTFs.get("Chicken"));
	marketTFs.get("Chicken").addActionListener(cUpdater);
	
	i++;
	marketPanel.add(marketLabels.get(i));
	marketPanel.add(marketTFs.get("Pizza"));
	marketTFs.get("Pizza").addActionListener(cUpdater);
	
	i++;
	marketPanel.add(marketLabels.get(i));
	marketPanel.add(marketTFs.get("Salad"));
	marketTFs.get("Salad").addActionListener(cUpdater);

	
	// Set up the cookPanel
	cookPanel.setLayout(new BoxLayout(cookPanel,BoxLayout.X_AXIS));
	cookLabels.add(new JLabel("Cook's Inventory ----> "));
	cookLabels.add(new JLabel("Steak: "));
	cookLabels.add(new JLabel("Chicken: "));
	cookLabels.add(new JLabel("Pizza: "));
	cookLabels.add(new JLabel("Salad: "));
	
	cookTFs.put("Steak", new JTextField(10));	
	cookTFs.get("Steak").setPreferredSize(new Dimension(75, 20));
	cookTFs.get("Steak").setMaximumSize(new Dimension(75, 20));
	cookTFs.get("Steak").setMinimumSize(new Dimension(75, 20));
	cookTFs.get("Steak").setHorizontalAlignment(SwingConstants.CENTER);
	
	cookTFs.put("Chicken", new JTextField(10));
	cookTFs.get("Chicken").setPreferredSize(new Dimension(75, 20));
	cookTFs.get("Chicken").setMaximumSize(new Dimension(75, 20));
	cookTFs.get("Chicken").setMinimumSize(new Dimension(75, 20));
	cookTFs.get("Chicken").setHorizontalAlignment(SwingConstants.CENTER);
	
	cookTFs.put("Pizza", new JTextField(10));
	cookTFs.get("Pizza").setPreferredSize(new Dimension(75, 20));
	cookTFs.get("Pizza").setMaximumSize(new Dimension(75, 20));
	cookTFs.get("Pizza").setMinimumSize(new Dimension(75, 20));
	cookTFs.get("Pizza").setHorizontalAlignment(SwingConstants.CENTER);
	
	cookTFs.put("Salad", new JTextField(10));
	cookTFs.get("Salad").setPreferredSize(new Dimension(75, 20));
	cookTFs.get("Salad").setMaximumSize(new Dimension(75, 20));
	cookTFs.get("Salad").setMinimumSize(new Dimension(75, 20));
	cookTFs.get("Salad").setHorizontalAlignment(SwingConstants.CENTER);
	
	// Add everything into the panel
	tempStrings = cookTFs.keySet();
	
	i = 0;
	cookPanel.add(cookLabels.get(i));

	i++;
	cookPanel.add(cookLabels.get(i));
	cookPanel.add(cookTFs.get("Steak"));
	cookTFs.get("Steak").addActionListener(cUpdater);
		
	i++;
	cookPanel.add(cookLabels.get(i));
	cookPanel.add(cookTFs.get("Chicken"));
	cookTFs.get("Chicken").addActionListener(cUpdater);
	
	i++;
	cookPanel.add(cookLabels.get(i));
	cookPanel.add(cookTFs.get("Pizza"));
	cookTFs.get("Pizza").addActionListener(cUpdater);
	
	i++;
	cookPanel.add(cookLabels.get(i));
	cookPanel.add(cookTFs.get("Salad"));
	cookTFs.get("Salad").addActionListener(cUpdater);
	
	getContentPane().add(restPanel);
	getContentPane().add(addTable);
	getContentPane().add(infoPanel);
	// Add new panels
	getContentPane().add(customerPanel);
	getContentPane().add(customerOrderPanel);
	getContentPane().add(marketPanel);
	getContentPane().add(cookPanel);
	
	customerPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on
	marketPanel.setVisible(false); // Only set this panel to visible when a market is clicked
	cookPanel.setVisible(false); // Only set this panel to visible when a market is clicked
	customerOrderPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on 
	updateTimer.start(); // Set the updating timer
=======

	infoPanel.setLayout(new GridLayout(1,2, 30,0));
	infoPanel.add(infoLabel);
	infoPanel.add(stateCB);
	
	getContentPane().add(restPanel);
	getContentPane().add(addTable);
	getContentPane().add(infoPanel);
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
	
	addTable.addActionListener(this);
    }


    /** This function takes the given customer or waiter object and 
     * changes the information panel to hold that person's info.
     * @param person customer or waiter object */
    public void updateInfoPanel(Object person){
	stateCB.setVisible(true);
	currentPerson = person;
	
<<<<<<< HEAD
	cUpdater.setAgent(person); // Set this new agent to the updater
	
=======
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
	if(person instanceof CustomerAgent){
	    CustomerAgent customer = (CustomerAgent) person;
	    stateCB.setText("Hungry?");
	    stateCB.setSelected(customer.isHungry());
	    stateCB.setEnabled(!customer.isHungry());
	    infoLabel.setText(
	    "<html><pre>     Name: " + customer.getName() + " </pre></html>");
<<<<<<< HEAD
	    customerPanel.setVisible(true); // Set my panel to be visible to the customer
	    marketPanel.setVisible(false);
	    cookPanel.setVisible(false); // Only set this panel to visible when a market is clicked
		customerOrderPanel.setVisible(true); // Set my panel to be NOT visible until a customer is clicked on
	    
	    // Set all customer text values
		customerMoneyTF.setText(String.format("%.2f", (customer.getWallet())));
		customerMoneyOwedLabelB.setText(String.format("%.2f", (customer.getAmountOwed())));
		if (customer.getWillingToWait() == true) {
			willWaitCB.setSelected(true);
		}
		else {
			willWaitCB.setSelected(false);
		}
		if (customer.getWillOnlyPayFully() == true) {
			onlyPayFullyCB.setSelected(true);
		}
		else {
			onlyPayFullyCB.setSelected(false);
		}
		
		// Set all orderState values
		Set<String> strings = customerOrderButtons.keySet();
		for (String s: strings) {
			customerOrderButtons.get(s).setSelected(customer.getOrderState(s));
		}
=======
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents

	}else if(person instanceof WaiterAgent){
	    WaiterAgent waiter = (WaiterAgent) person;
	    stateCB.setText("On Break?");
	    stateCB.setSelected(waiter.isOnBreak());
	    stateCB.setEnabled(true);
	    infoLabel.setText(
	    "<html><pre>     Name: " + waiter.getName() + " </html>");
<<<<<<< HEAD
	    customerPanel.setVisible(false); // Set my panel to be NOT visible to the waiter
	    marketPanel.setVisible(false);
	    cookPanel.setVisible(false); // Only set this panel to visible when a market is clicked
		customerOrderPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on

	}
	
	else if(person instanceof MarketAgent){
		MarketAgent market = (MarketAgent) person;
	    stateCB.setText("Randomized Order Times");
	    stateCB.setEnabled(true);
	    infoLabel.setText(
	    "<html><pre>     Name: " + market.getName() + " </html>");
	    customerPanel.setVisible(false); // Set my panel to be NOT visible to the market
	    marketPanel.setVisible(true);
	    cookPanel.setVisible(true); // Only set this panel to visible when a market is clicked
		customerOrderPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on
	    
	    // Set MarketAgent values
		Map<String, Integer> tempInv = market.getInventory();
		Set<String> tempKeySet = tempInv.keySet();
		for (String t: tempKeySet) {
			marketTFs.get(t).setText(Integer.toString(tempInv.get(t))); 
		}
		
	    // Set CookAgent values
		for (String t: tempKeySet) {
			int value = restPanel.getCook().getInventoryItemNumber(t); // Will get the amount of a certain item from the cook's inventory
			cookTFs.get(t).setText(Integer.toString(value)); 
		}
	}	
	
	infoPanel.validate();
    }
    
	private void updateInfoValues(Object person) { // Will update GUI values after an action is completed that changes a value in an agent
		stateCB.setVisible(true);
		currentPerson = person;
		
		if(person instanceof CustomerAgent){
		    CustomerAgent customer = (CustomerAgent) person;
		    stateCB.setText("Hungry?");
		    stateCB.setSelected(customer.isHungry());
		    stateCB.setEnabled(!customer.isHungry());
		    infoLabel.setText(
		    "<html><pre>     Name: " + customer.getName() + " </pre></html>");
		    customerPanel.setVisible(true); // Set my panel to be visible to the customer
		    marketPanel.setVisible(false);
		    cookPanel.setVisible(false); // Only set this panel to visible when a market is clicked
			customerOrderPanel.setVisible(true); // Set my panel to be NOT visible until a customer is clicked on
		    
		    // Set all customer text values
			customerMoneyTF.setText(String.format("%.2f", (customer.getWallet())));
			customerMoneyOwedLabelB.setText(String.format("%.2f", (customer.getAmountOwed())));
			if (customer.getWillingToWait() == true) {
				willWaitCB.setSelected(true);
			}
			else {
				willWaitCB.setSelected(false);
			}
			if (customer.getWillOnlyPayFully() == true) {
				onlyPayFullyCB.setSelected(true);
			}
			else {
				onlyPayFullyCB.setSelected(false);
			}
			
			// Set all orderState values
			Set<String> strings = customerOrderButtons.keySet();
			for (String s: strings) {
				customerOrderButtons.get(s).setSelected(customer.getOrderState(s));
			}

		}else if(person instanceof WaiterAgent){
		    WaiterAgent waiter = (WaiterAgent) person;
		    stateCB.setText("On Break?");
		    stateCB.setSelected(waiter.isOnBreak());
		    stateCB.setEnabled(true);
		    infoLabel.setText(
		    "<html><pre>     Name: " + waiter.getName() + " </html>");
		    customerPanel.setVisible(false); // Set my panel to be NOT visible to the waiter
		    marketPanel.setVisible(false);
		    cookPanel.setVisible(false); // Only set this panel to visible when a market is clicked
			customerOrderPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on
		}
		
		else if(person instanceof MarketAgent){
			MarketAgent market = (MarketAgent) person;
		    stateCB.setText("Randomized Order Times");
		    stateCB.setEnabled(true);
		    infoLabel.setText(
		    "<html><pre>     Name: " + market.getName() + " </html>");
		    customerPanel.setVisible(false); // Set my panel to be NOT visible to the market
		    marketPanel.setVisible(true);
		    cookPanel.setVisible(true); // Only set this panel to visible when a market is clicked
			customerOrderPanel.setVisible(false); // Set my panel to be NOT visible until a customer is clicked on
		    
		    // Set MarketAgent values
			Map<String, Integer> tempInv = market.getInventory();
			Set<String> tempKeySet = tempInv.keySet();
			for (String t: tempKeySet) {
				marketTFs.get(t).setText(Integer.toString(tempInv.get(t))); 
			}
			
		    // Set CookAgent values
			for (String t: tempKeySet) {
				int value = restPanel.getCook().getInventoryItemNumber(t); // Will get the amount of a certain item from the cook's inventory
				cookTFs.get(t).setText(Integer.toString(value)); 
			}
		}
		infoPanel.validate();
	}
=======
	}	   

	infoPanel.validate();
    }
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents

    /** Action listener method that reacts to the checkbox being clicked */
    public void actionPerformed(ActionEvent e){

	if(e.getSource() == stateCB){
	    if(currentPerson instanceof CustomerAgent){
		CustomerAgent c = (CustomerAgent) currentPerson;
		c.setHungry();
		stateCB.setEnabled(false);
<<<<<<< HEAD
		requestFocusInWindow();
		System.out.println("Check Box Clicked!");

	    }else if(currentPerson instanceof WaiterAgent){
		WaiterAgent w = (WaiterAgent) currentPerson;
		}
=======

	    }else if(currentPerson instanceof WaiterAgent){
		WaiterAgent w = (WaiterAgent) currentPerson;
		w.setBreakStatus(stateCB.isSelected());
	    }
		System.out.println("Check Box Clicked!");
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
	}
	else if (e.getSource() == addTable)
	{
		try {
			System.out.println("[Gautam] Add Table!");
			//String XPos = JOptionPane.showInputDialog("Please enter X Position: ");
			//String YPos = JOptionPane.showInputDialog("Please enter Y Position: ");
			//String size = JOptionPane.showInputDialog("Please enter Size: ");
			//restPanel.addTable(10, 5, 1);
			//restPanel.addTable(Integer.valueOf(YPos).intValue(), Integer.valueOf(XPos).intValue(), Integer.valueOf(size).intValue());
			restPanel.addTable();
		}
		catch(Exception ex) {
			System.out.println("Unexpected exception caught in during setup:"+ ex);
		}
	}
	    
    }

    /** Message sent from a customer agent to enable that customer's 
     * "I'm hungery" checkbox.
     * @param c reference to the customer */
    public void setCustomerEnabled(CustomerAgent c){
	if(currentPerson instanceof CustomerAgent){
	    CustomerAgent cust = (CustomerAgent) currentPerson;
	    if(c.equals(cust)){
		stateCB.setEnabled(true);
		stateCB.setSelected(false);
	    }
	}
    }
	
	
    /** Main routine to get gui started */
    public static void main(String[] args){
	RestaurantGui gui = new RestaurantGui();
	gui.setVisible(true);
	gui.setResizable(false);
    }
<<<<<<< HEAD
    
    private class updateGUI implements ActionListener {

    	Object agent = new Object(); // Will hold a reference to an agent to get/set the appropriate values
    	
    	public void setAgent(Object o) {
    		agent = o;
    	}
    	
		public void actionPerformed(ActionEvent e) {
		
			// Update all customer && market boxes/fields to the most updated values
			if (e.getSource() != updateTimer) {
				System.out.print("Action performed: ");
			}
			
			/**** Customer Agent Code ****/
			if (agent instanceof CustomerAgent) {
				CustomerAgent temp = (CustomerAgent) agent;
				
				// DO actions here
				if (e.getSource() == customerMoneyTF) { // Then set money for string					
					String s = (String) customerMoneyTF.getText();
					double d = 0.00;
					// This will create a pattern to see if characters are double numeric							
					Pattern pat = Pattern.compile("^[.0-9]+$"); 
					
					// This will check to make sure that names are int numeric							
					Matcher match = pat.matcher(s);
					
					if (match.find()) { // If all values in the string are correct, convert string to double and then send it to the customer
						d = Double.valueOf(s);
						temp.setWallet(d);
						requestFocusInWindow();
						updateInfoValues(temp);
						System.out.println("Changed customer money");
					}
					else {
						System.out.println("Error: enter decimal number for customer money!");
					}					
				}
				
				if (e.getSource() == willWaitCB) { // Change the state of the willWait customer state variable
					if (temp.getWillingToWait() == true) {
						temp.setWillingToWait(false);
					}
					else {
						temp.setWillingToWait(true);
					}
					System.out.println("Set will wait button");
				}
				
				if (e.getSource() == onlyPayFullyCB) { // Change the state of the willOnlyPayFully customer state variable
					if (temp.getWillOnlyPayFully() == true) {
						temp.setWillOnlyPayFully(false);
					}
					else {
						temp.setWillOnlyPayFully(true);
					}
					System.out.println("Set will only pay fully button");
				}
				
				if (e.getSource() == payOffButton) { // If the customer has enough money, pay off the debt and erase the debt
					if (temp.getWallet() >= temp.getAmountOwed()) { // Then pay off the debt
						temp.setWallet(temp.getWallet() - temp.getAmountOwed());
						temp.setAmountOwed(0.00); // Erase the debt
						System.out.println("Paid off a customer's debt!");
					}
					else {
						System.out.println("Error: You need more money to pay off the debt");
					}
				}
				
				// Set appropriate orderState values
				Set<String> strings = customerOrderButtons.keySet();
				for (String s: strings) {
					if (customerOrderButtons.get(s) == e.getSource()) {
						if (temp.getOrderState(s) == false)
							temp.setOrderState(s, true); // Invert the state
						else
							temp.setOrderState(s, false); // Invert the state
						System.out.println("Set "  + temp.getName() +  "'s Orderstate for " + s);
					}
				}
				
				// DO polling updates here		
				if (!customerMoneyTF.isFocusOwner()) { // Only update the customer text box when the user is NOT editing it
					customerMoneyTF.setText(String.format("%.2f", (temp.getWallet())));
				}
				
				customerMoneyOwedLabelB.setText(String.format("%.2f", (temp.getAmountOwed())));
				
				if (temp.getWillingToWait() == true) { // Update the willing to wait checkbox
					willWaitCB.setSelected(true);
				}
				else {
					willWaitCB.setSelected(false);
				}
				
				if (temp.getWillOnlyPayFully() == true) { // Update the only pay fully checkbox
					onlyPayFullyCB.setSelected(true);
				}
				else {
					onlyPayFullyCB.setSelected(false);
				}
				
				// Set all orderState values
				for (String s: strings) {
					customerOrderButtons.get(s).setSelected(temp.getOrderState(s));
				}
			}
			
			/***** Market & Cook Agent Code *****/
			if (agent instanceof MarketAgent) {
				MarketAgent temp = (MarketAgent) agent;
				Set<String> set = marketTFs.keySet();
				
				// DO actions here
				for (String s: set) {
					if (e.getSource() == marketTFs.get(s)) {
						String test = (String) marketTFs.get(s).getText();

						// This will create a pattern to see if characters are int numeric							
						Pattern pat = Pattern.compile("^[0-9]+$"); 
						
						// This will check to make sure that names are int numeric							
						Matcher match = pat.matcher(test);
						
						if (match.find()) { // If all values in the string are correct, convert string to int and then send it to market inventory
							int i = Integer.valueOf(test);
							System.out.println("Set the market's inventory");
							((MarketAgent) agent).setInventory(s, i);
							requestFocusInWindow();
							updateInfoValues(temp);							
						}	
					}
					if (e.getSource() == cookTFs.get(s)) { // This map has the same keys and is the same size, so the same comparison can be used
						String test = (String) cookTFs.get(s).getText();

						// This will create a pattern to see if characters are int numeric							
						Pattern pat = Pattern.compile("^[0-9]+$"); 
						
						// This will check to make sure that names are int numeric							
						Matcher match = pat.matcher(test);
						
						if (match.find()) { // If all values in the string are correct, convert string to int and then send it to cook inventory
							int i = Integer.valueOf(test);
							System.out.println("Set the cook's inventory");
							restPanel.getCook().setInventoryItemNumber(s, i);
							requestFocusInWindow();
							updateInfoValues(temp);							
						}	
					}
				}
				
				if (e.getSource() == stateCB) { // Then change the market randomizer value
					System.out.println("Set the market's randomizer value");
					if (temp.getRandomizer() == true) {
						temp.setRandomizer(false);
					}
					else {
						temp.setRandomizer(true);
					}					
				}
				
				// DO polling updates here	
			    // Set MarketAgent values
				Map<String, Integer> tempInv = temp.getInventory();
				Set<String> tempKeySet = tempInv.keySet();
				for (String t: tempKeySet) {
					if (!marketTFs.get(t).isFocusOwner()) { // Only update the text box when the user is NOT editing it
						marketTFs.get(t).setText(Integer.toString(tempInv.get(t)));
					}
				}
				
			    // Set CookAgent values
				for (String t: tempKeySet) {
					if (!cookTFs.get(t).isFocusOwner()) { // Only update the text box when the user is NOT editing it
						int value = restPanel.getCook().getInventoryItemNumber(t); // Will get the amount of a certain item from the cook's inventory
						cookTFs.get(t).setText(Integer.toString(value));
					}
				}
				
				// Set stateCB based upon what the randomizer value is
				stateCB.setSelected(temp.getRandomizer());
			}
			
			/***** Waiter Agent Code *****/
			if (agent instanceof WaiterAgent) {
				WaiterAgent temp = (WaiterAgent) agent;
				
				if (e.getSource() == stateCB) {
					// Send message to waiter in an attempt to start the break cycle
					temp.msgGuiButtonPressed(); 
					System.out.println("Set the waiter's break button");
				}
				
				// DO polling updates here
				// Make waiter break get/set values here
				if (temp.isOnBreak() == true) {
					stateCB.setSelected(true);
				}
				else {
					stateCB.setSelected(false);
				}
			}
			
		}
    	
    }
=======
>>>>>>> First commit of the project.  Added in skeleton versions of the cashier and market agents
}
