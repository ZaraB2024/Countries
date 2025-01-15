/*
Author: Zara Bagai
Date created/edited: 1/8/24
Class Overview: This class contains the code that creates the GUI and contains all the methods that allow users to interact with the game
(ex: it makes sure the information for the right country is displayed)
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;

 
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  
  //Pre-condition: none
  //Post-condition: Initializes elements in countryArray using data from countries-data.csv
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv"); //MODIFIED (1)
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {

    for(int i = 0; i < countryArray.length; i++){

      // Do the following inside the loop
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);

       // inside the loop, create a new Country using your constructor with 4 arguments and pass in data[0], data[1], data[2], data[3] as arguments.

      Country country = new Country(data[0], data[1], data[2], data[3]);

     // inside the loop, set countryArray[i] to the created Country object
      countryArray[i] = country;



    }

    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  //Pre-condition: none
  //Post-condition: displays a photo of the current country (in the GUI) on a world map
  public void showCountry() {
    // Get the country at index from countryArray

    Country c = countryArray[index];
    
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = "worldmap.jpg";
     imagefile = c.getImage();

     
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+ imagefile); //MODIFIED (2)
    imageLabel.setIcon(img);
  }

  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  //Pre-condition: none
  //Post-condition: increments index, displays the next country, and asks the user a question about that country when the 'next' button is pressed
  public void nextButtonClick()
  {
   
    
    index++;
    if(index > 9){

      index = 0; 
      
    }

    outputLabel.setText("");
    showCountry();

    Country country1 = countryArray[index];
    outputLabel.setText("What is the capital of  " + country1.getName() + "?");


  }
  
 
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
 
  //Pre-condition: none
 //Post-condition: Displays information about the current country when the 'review' button is clicked
  public void reviewButtonClick()
  {

  
    Country countryy = countryArray[index];
    String result = countryy.toString();
    System.out.println(result);
    outputLabel.setText(result);



  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  
  //Pre-condition: none
  //Post-condition: (When the 'Quiz' button is clicked) Checks whether the user's input is the correct answer to the question presented
  public void quizButtonClick() 
  {
    Scanner scan = new Scanner(System.in); 

    if(((input.getText()).equals(countryArray[index].getCapital())) || (input.getText()).equals((countryArray[index].getCapital()).toLowerCase()))
    {

      outputLabel.setText("Correct!");

    }
    else{
      

      outputLabel.setText("Incorrect!");


   }
    
    
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("/workspaces/Countries/workspace/countries-data.csv"+"worldmap.jpg"); //MODIFIED (3)
        //1/9/25

        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        //1/9/25
        input = new JTextField(20);
        //1/9/25
        jFrame.add(input);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  





}
