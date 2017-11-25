package observer_pattern;


import java.util.ArrayList;
import java.util.Iterator;

interface Subject {
     public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObserver();

}



class CricketData implements Subject{

    int runs;
    int wickets;
    float overs;

    ArrayList<Observer> observerArrayList;

    public CricketData()
    {
        observerArrayList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerArrayList.add(o);

    }

    @Override
    public void unregisterObserver(Observer o) {
        observerArrayList.remove(o);

    }

    @Override
    public void notifyObserver() {

        for (Iterator<Observer> it = observerArrayList.iterator();it.hasNext();)
        {
            Observer o =it.next();
            o.update(runs,wickets,overs);
        }

    }
    //  latest run update from stadium
    private int getLatestRuns()
    {
        return 90;
    }
    //  latest wicket update from stadium
    private int getLatestWickets()
    {

        return 2;
    }
    //  latest run update from stadium
    private float getLatestOvers()
    {

        return (float)10.2;
    }

    // This method is used to update display when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObserver();
    }


}

interface Observer{
    public void update(int runs, int wickets, float overs);


}

class AverageScoreDisplay implements Observer{

    private float runRate;
    private  float predictedScore;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runRate  = (float) runs/overs;
        this.predictedScore = (int)(this.runRate*50);
        display();
    }

    public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                + "Run Rate: " + runRate +
                "\nPredictedScore: " +
                predictedScore);
    }
}

class CurrentScoreDisplay implements Observer{

    private int runs, wickets;
    private float overs;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs );
    }

}



//Driver class
 class Main{
    public static void main(String[] args) {
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        CricketData cricketData  = new CricketData();

        //register Observers
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        //when logic changes
        cricketData.dataChanged();
        // remove an observer
        cricketData.unregisterObserver(averageScoreDisplay);
        cricketData.dataChanged();


    }
}











