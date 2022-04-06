/**
 * Name: Joseph Parampathu
 * Date: 12/12/2021
 * Assignment: Unit 14 Case Problem 1
 *
 * Purpose (Class Description): A class called JOrderMenu that launches a window to calculate the user's menu price from their selections.
 */
 import javax.swing.*;

 import java.awt.*;
 import java.awt.event.*;

 public class JOrderMenu extends JFrame implements ItemListener
 {
   final int WIDTH = 1000;
   final int HEIGHT = 500;
   final double ENTREE_ONE_PRICE = 6.00;
   final double ENTREE_TWO_PRICE = 4.50;
   final double ENTREE_THREE_PRICE = 3.50;
   final double ENTREE_FOUR_PRICE = 6.00;
   final double SIDE_PRICE = 1.00;
   final double DRINK_ONE_PRICE = 0.10;
   final double DRINK_TWO_PRICE = 0.20;
   final double DRINK_THREE_PRICE = 0.50;
   double totalPrice = 0;

   //The entree menu
   JCheckBox entreeOne = new JCheckBox("Bean Burrito $" + ENTREE_ONE_PRICE, false);
   JCheckBox entreeTwo = new JCheckBox("Kimchi Rice $" + ENTREE_TWO_PRICE, false);
   JCheckBox entreeThree = new JCheckBox("Vegetable Rice $" + ENTREE_THREE_PRICE, false);
   JCheckBox entreeFour = new JCheckBox("Vegan Pizza $" + ENTREE_FOUR_PRICE, false);
   ButtonGroup entreeGroup = new ButtonGroup();
   JPanel entreePanel = new JPanel();

   //The side menu
   JCheckBox sideOne = new JCheckBox("Salad $" + SIDE_PRICE, false);
   JCheckBox sideTwo = new JCheckBox("Green Beans $" + SIDE_PRICE, false);
   JCheckBox sideThree = new JCheckBox("Plain Rice $" + SIDE_PRICE, false);
   JCheckBox sideFour = new JCheckBox("Extra Tortilla $" + SIDE_PRICE, false);
   JCheckBox sideFive = new JCheckBox("Black Bean Soup $" + SIDE_PRICE, false);
   JPanel sidePanel = new JPanel();

   //The drink menu
   JCheckBox drinkOne = new JCheckBox("Lemonade $" + DRINK_ONE_PRICE, false);
   JCheckBox drinkTwo = new JCheckBox("Orange Juice $" + DRINK_TWO_PRICE, false);
   JCheckBox drinkThree = new JCheckBox("Vegan Milkshake $" + DRINK_THREE_PRICE, false);
   JPanel drinkPanel = new JPanel();

   JCheckBox bigBoyBox = new JCheckBox("", false);

   JLabel mealLabel = new JLabel("Meal Price Calculator");
   JLabel priceLabel = new JLabel("\nThe price for your meal is");
   JTextField totPrice = new JTextField(8);
   JLabel optionExplainLabel = new JLabel("\nIf you purchase an entree your cheapest drink is free.");
   JLabel entreeMessage = new JLabel("\nSelect up to one entree:");
   JLabel sideMessage = new JLabel("\nWith an entree first two sides are free:");
   JLabel drinkMessage = new JLabel("\nWith an entree cheapest drink is free:");
   JLabel optionExplainLabel2 = new JLabel("\nUpgrade to a BIGBOY order for an extra 10%.");
   String orderDetails = "";
   JLabel summaryMessage = new JLabel("Your Order: " + orderDetails);

   //Constructor class for the window sets the window title, format, and adds all the components of the window
   public JOrderMenu()
   {
     super("Order Menu Price Calculator");
     setSize(WIDTH, HEIGHT);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new FlowLayout());

     setEntrees();
     setSides();
     setDrinks();
     addComponents();
     add(summaryMessage);

     totPrice.setText("$" + totalPrice);

     entreeOne.addItemListener(this);
     entreeTwo.addItemListener(this);
     entreeThree.addItemListener(this);
     entreeFour.addItemListener(this);
     sideOne.addItemListener(this);
     sideTwo.addItemListener(this);
     sideThree.addItemListener(this);
     sideFour.addItemListener(this);
     sideFive.addItemListener(this);
     drinkOne.addItemListener(this);
     drinkTwo.addItemListener(this);
     drinkThree.addItemListener(this);
     bigBoyBox.addItemListener(this);
   }

   //This method translates a boolean to an integer (0 if false or 1 if true) so that it can be used in boolean calculations to simplify the price calculations
   public int isCheckedInt(boolean checked)
   {
     int answer = checked ? 1 : 0;
     return answer;
   }

   //This method sets the entree panel with all the entrees in the menu
   public void setEntrees()
   {
     entreeGroup.add(entreeOne);
     entreeGroup.add(entreeTwo);
     entreeGroup.add(entreeThree);
     entreeGroup.add(entreeFour);

     entreePanel.setBounds(40,80,200,200);
     entreePanel.add(entreeOne);
     entreePanel.add(entreeTwo);
     entreePanel.add(entreeThree);
     entreePanel.add(entreeFour);
   }

   //This method sets the side panel with all the sides in the menu
   public void setSides()
   {
     sidePanel.setBounds(40,80,200,200);
     sidePanel.add(sideMessage);
     sidePanel.add(sideOne);
     sidePanel.add(sideTwo);
     sidePanel.add(sideThree);
     sidePanel.add(sideFour);
     sidePanel.add(sideFive);
   }

   //This method sets the drink panel with all the drinks in the menu
   public void setDrinks()
   {
     drinkPanel.setBounds(40,80,200,200);
     drinkPanel.add(drinkMessage);
     drinkPanel.add(drinkOne);
     drinkPanel.add(drinkTwo);
     drinkPanel.add(drinkThree);
   }

   //This method adds the components to the window
   public void addComponents()
   {
     add(mealLabel);
     add(optionExplainLabel);
     add(entreePanel);
     add(sidePanel);
     add(drinkPanel);
     add(optionExplainLabel2);
     add(bigBoyBox);
     add(priceLabel);
     add(totPrice);

   }

   //This override is used to recalculate the price each time that a checkbox is clicked
   @Override
   public void itemStateChanged(ItemEvent event)
   {
     Object source = event.getSource();
     int select = event.getStateChange();

    //Calculation for if an entree is selected
     if (entreeOne.isSelected() || entreeTwo.isSelected() || entreeThree.isSelected() || entreeFour.isSelected())
     {
       double sidesPrice;
       int sidesCount = (isCheckedInt(sideOne.isSelected())+ isCheckedInt(sideTwo.isSelected())+ isCheckedInt(sideThree.isSelected())+ isCheckedInt(sideFour.isSelected()) + isCheckedInt(sideFive.isSelected()));
       double drinksPrice;
       if (sidesCount >= 2)
       {
         sidesPrice = (sidesCount-2) * (SIDE_PRICE);
       }
       else
       {
         sidesPrice = 0;
       }
       if (drinkOne.isSelected())
       {
         drinksPrice = (isCheckedInt(drinkTwo.isSelected())*DRINK_TWO_PRICE + isCheckedInt(drinkThree.isSelected())*DRINK_THREE_PRICE);
       }
       else if (drinkTwo.isSelected())
       {
         drinksPrice = isCheckedInt(drinkThree.isSelected())*DRINK_THREE_PRICE;
       }
       else
       {
         drinksPrice = 0;
       }

       totalPrice = (isCheckedInt(entreeOne.isSelected())*ENTREE_ONE_PRICE +
       isCheckedInt(entreeTwo.isSelected())*ENTREE_TWO_PRICE +
       isCheckedInt(entreeThree.isSelected())*ENTREE_THREE_PRICE +
       isCheckedInt(entreeFour.isSelected())*ENTREE_FOUR_PRICE +
       sidesPrice + drinksPrice);

       if (bigBoyBox.isSelected())
       {
         totalPrice *= 1.10;
       }
     }
     //Price calculation for if no entrees are selected
     else
     {
       totalPrice = isCheckedInt(entreeOne.isSelected())*ENTREE_ONE_PRICE +
       isCheckedInt(entreeTwo.isSelected())*ENTREE_TWO_PRICE +
       isCheckedInt(entreeThree.isSelected())*ENTREE_THREE_PRICE +
       isCheckedInt(entreeFour.isSelected())*ENTREE_FOUR_PRICE +
       (isCheckedInt(sideOne.isSelected())+ isCheckedInt(sideTwo.isSelected())+ isCheckedInt(sideThree.isSelected())+ isCheckedInt(sideFour.isSelected()) + isCheckedInt(sideFive.isSelected())*SIDE_PRICE) +
       isCheckedInt(drinkOne.isSelected())*DRINK_ONE_PRICE +
       isCheckedInt(drinkTwo.isSelected())*DRINK_TWO_PRICE +
       isCheckedInt(drinkThree.isSelected())*DRINK_THREE_PRICE;

       if (bigBoyBox.isSelected())
       {
         totalPrice *= 1.10;
       }
     }

     totalPrice = totalPrice*100;
     totalPrice = Math.round(totalPrice);
     totalPrice = totalPrice / 100;
     totPrice.setText("$" + totalPrice);
     //Resert orderDetails and then fill it with the order summary
     orderDetails = "";
     if (entreeOne.isSelected())
     {
       orderDetails += " Bean Burrito";
     }
     if (entreeTwo.isSelected())
     {
       orderDetails += " Kimchi Rice";
     }
     if (entreeThree.isSelected())
     {
       orderDetails += " Vegetable Rice";
     }
     if (entreeFour.isSelected())
     {
       orderDetails += " Vegan Pizza";
     }
     if (sideOne.isSelected())
     {
       orderDetails += " Salad";
     }
     if (sideTwo.isSelected())
     {
       orderDetails += " Green Beans";
     }
     if (sideThree.isSelected())
     {
       orderDetails += " Plain Rice";
     }
     if (sideFour.isSelected())
     {
       orderDetails += " Extra Tortilla";
     }
     if (sideFive.isSelected())
     {
       orderDetails += " Black Bean Soup";
     }
     if (drinkOne.isSelected())
     {
       orderDetails += " Lemonade";
     }
     if (drinkTwo.isSelected())
     {
       orderDetails += " Orange Juice";
     }
     if (drinkThree.isSelected())
     {
       orderDetails += " Vegan Milkshake";
     }
     summaryMessage.setText("Your Order: " + orderDetails);
   }
 }
