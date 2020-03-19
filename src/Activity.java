
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
//implements Comparable<Activity> (add this in later)
public class Activity {

    public String name;

    public int caloriesBurned;
    public double changeInHeartRate;

    public Integer activitytotalcal = 0;
    public Double activitytotalhr = 0.0;
    
    public int totalTimeTrained;
    private int totalCaloriesBurned;

    public Activity(String name, int caloriesBurned, double changeInHeartRate) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.changeInHeartRate = changeInHeartRate;
        this.activitytotalcal = 0;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        if (caloriesBurned >= 0) {
            this.caloriesBurned = caloriesBurned;
        }
    }

    public int getCaloriesBurned() {
        return this.caloriesBurned;
    }

    public int getTotalCalories(int time) {
        int calories = this.caloriesBurned * time;
        activitytotalcal += calories;
        return calories;
    }
    
    public int getCalories() {
        this.totalCaloriesBurned=this.caloriesBurned*this.totalTimeTrained;
        return this.caloriesBurned*this.totalTimeTrained;
    }

    public double getChangeInHeartRate() {
        return changeInHeartRate;
    }

    public double getTotalChangeInHeartRate(double totalHeartRate, int time) {
        double activityChangeInHeartRate = totalHeartRate * this.changeInHeartRate * time;
        activitytotalhr += activityChangeInHeartRate;
        return activityChangeInHeartRate;
    }

    public void setTotalTimeTrained(int totalTimeTrained) {
        if(this.totalTimeTrained>0) {
        	this.totalTimeTrained+=totalTimeTrained;
        }else {
        	this.totalTimeTrained=totalTimeTrained;
        }
    }

    public int getTotalTimeTrained() {
        return totalTimeTrained;
    }

    static class activitycompare implements Comparator<Activity> {

        @Override
        public int compare(Activity activity1, Activity activity2) {

            int caloriescompare = activity1.activitytotalcal.compareTo(activity2.activitytotalcal);
            int heartratecompare = activity1.activitytotalhr.compareTo(activity2.activitytotalhr);

            if (caloriescompare == 0) {
                return ((heartratecompare == 0) ? caloriescompare : heartratecompare);
            } else {
                return caloriescompare;
            }
        }
    }

    public static void sortActivities(ArrayList<Activity> activity) {
        Collections.sort(activity, new activitycompare().reversed());
    }

    @Override
    public String toString() {
        return "[" + this.name + "," + Integer.toString(getTotalTimeTrained()) + " " + Integer.toString(getCalories()) + "]";
    }
}
