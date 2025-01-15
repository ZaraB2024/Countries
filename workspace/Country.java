/*
Author: Zara Bagai
Date created/edited: 1/2/24
Class Overview: This class contains the code that manages (ex: gets, sets) the propeties of the countries that are part of the countries-data.csv file.
 */


public class Country
{
  // add private instance variables for the name, capital, language, and image file.

  private String name;
  private String capital;
  private String language;
  private String image;
 


  // add constructors

  //default constructor:
  public Country(){


    name = "Japan";
    capital = "Tokyo";
    language = "Japanese";
    image = "Japan.png"; 


  }

  //additional constructor:
  
  public Country(String name, String capital, String language, String image){

    this.name =name;
    this.capital = capital;
    this.language = language;
    this.image = image; 

  }


  // Write accessor/get methods for each instance variable that returns it.

public String getName(){

return name;

}

public String getCapital(){

return capital;

}

public String getLanguage(){

return language;

}

public String getImage(){

return image;

}


  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 
  //Pre-condition: none
  //Post-condition: Returns a string which contains information about the current country
  public String toString(){


  return name + "'s capital is " + capital + " and its primary language is " + language;


  }

  
}