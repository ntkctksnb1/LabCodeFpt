/*
 * This class contain methods to process a list of country 
 */
package controller;

import entities.EastAsiaCountries;
import java.util.ArrayList;

/**
 *
 * @author Kiennthe141019
 */
public class ManageEastAsiaCountries {

    private ArrayList<EastAsiaCountries> countries = new ArrayList<>();

    // Method to check whether the area user enter is greater than 0 or not
    public boolean checkValidArea(float totalArea) {
        return totalArea > 0;
    }

    // getter
    public ArrayList<EastAsiaCountries> getCountries() {
        return countries;
    }

    // Method used to add a countries to the countries list
    public void addCountry(String countriesCode, String countriesName,
            float totalArea, String countriesTerrain) {
        countries.add(new EastAsiaCountries(countriesTerrain, countriesCode, countriesName, totalArea));
    }

    // Method to check whether a country code is existed or not
    public boolean isExisted(String code){
        return countries.stream().noneMatch((eastAsiaCountry) -> (eastAsiaCountry.getCountryCode().equalsIgnoreCase(code)));
    }
    
    // Method return the last country in the list.
    public ArrayList<EastAsiaCountries> getPrevCountry() {
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        result.add(countries.get(countries.size() - 1));
        return result;
    }

    // This method is used to find countries which is cotain the name user enter
    public ArrayList<EastAsiaCountries> findCountry(String name) {
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCountryName().contains(name)
                    || countries.get(i).getCountryName().equalsIgnoreCase(name)) {
                result.add(countries.get(i));
            }
        }
        // Return the list of country which it has found
        return result;
    }

    // Method to sort countries by name using Insertion Sort Algorithm
    public void sortByName() {

        for (int i = 0; i < countries.size() - 1; i++) {
            for (int j = i + 1; j < countries.size(); j++) {
                if ((countries.get(i).getCountryName().compareTo(countries.get(j).getCountryName())) > 0) {
                    EastAsiaCountries temp = countries.get(i);
                    countries.set(i, countries.get(j));
                    countries.set(j, temp);
                }
            }
        }
    }
}
