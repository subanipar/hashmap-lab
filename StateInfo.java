public class StateInfo {

    // instance variables
    private String capital;
    private int population;
    private DLList<String> pictures;

    public StateInfo(String capital, int population) {
        this.capital = capital;
        this.population = population;
        pictures = new DLList<>();
    }

    public boolean addPicture(String url) {
        return pictures.add(url);
    }

    public DLList<String> getPictures() {
        return pictures;
    }

    public String toString() {
        return "Capital: " + capital + "\nPopulation: " + population;
    }
}


// create  a dll list to contain the images for each state
// to string method
// contain variables for state capital and state population
// add the state name variable to state, and change accordingly


// method to add images to that state to that dllist
// already add 2 images for each state we have
// display information about a state
