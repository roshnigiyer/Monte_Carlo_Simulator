
// Author: Roshni Iyer
// Date: January 2018
// Version 1.5
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;

/*  Monte Carlo simulator that generates simulated data for H.robusta and H.stagnalis from 
    identified life history experimental data. See research paper for details. 
    Data is written into text files generated. Creates files in the same directory 
    as simulator1.java; Cleans files between simulations. 
*/

public class simulator1 {

    public static int inp;

//////////////////////////////////
// PARAMETERS: Change as needed //                        
////////////////////////////////////////////////////////////////                                                              
    // Hro interclutch intervals                              //
    //(mean/standard deviation pairs)                         //
    public static double hro_c1_interval = 56.3;              //
    public static double hro_c1_interval_sd = 8.7;            //
                                                              //  
    public static double hro_c2_interval = 83.5;              //
    public static double hro_c2_interval_sd = 7.7;            //
                                                              //
    public static double hro_c3_interval = 107.4;             //
    public static double hro_c3_interval_sd = 10.5;           //
                                                              //
    public static double hro_c4_interval = 136.8;             //  
    public static double hro_c4_interval_sd = 9.9;            //
                                                              //
    public static double hro_c5_interval = 170.4;             //
    public static double hro_c5_interval_sd = 16.0;           //
                                                              //
    public static double hro_c6_interval = 199.4;             //
    public static double hro_c6_interval_sd = 17.2;           //
                                                              //
    public static double hro_c7_interval = 243.3;             //
    public static double hro_c7_interval_sd = 29.6;           //
                                                              //
    public static double hro_c8_interval = 264.0;             //
    public static double hro_c8_interval_sd = 0.0;            //
                                                              //
    // Hro clutch size (mean/standard deviation pairs)        //
                                                              //
    public static double hro_c1_size = 20.3;                  //
    public static double hro_c1_size_sd = 4.1;                //
                                                              //
    public static double hro_c2_size = 51.1;                  //
    public static double hro_c2_size_sd = 16.3;               //
                                                              //
    public static double hro_c3_size = 71.1;                  //
    public static double hro_c3_size_sd = 19.5;               //
                                                              //
    public static double hro_c4_size = 77.6;                  //
    public static double hro_c4_size_sd = 19.9;               //
                                                              //
    public static double hro_c5_size = 69.1;                  //
    public static double hro_c5_size_sd = 23.5;               //
                                                              //
    public static double hro_c6_size = 51.0;                  //
    public static double hro_c6_size_sd = 30.7;               //
                                                              //
    public static double hro_c7_size = 44.2;                  //
    public static double hro_c7_size_sd = 27.3;               //
                                                              //
    public static double hro_c8_size = 13.0;                  // 
    public static double hro_c8_size_sd = 0.0;                //
                                                              //
    // Hro clutch number (mean/standard deviation pairs)      //
    public static double hro_clutch_num = 3.5;                //
    public static double hro_clutch_num_sd = 1.96;            //
///////////////////////////////////////////////////////////////
/// MAY NOT NEED TO MODIFY CODE BELOW ///
/////////////////////////////////////////

    // SET UP DATA STRUCTURES

    /*  H.stagnalis data 
        PER SAMPLE data:
        Stores data for H.stagnalis clutch intervals, lifespan, and clutch size for
        each leech sample as indicated by the user
    */

    public static ArrayList<Double> sTotalClutch1Interval = new ArrayList<Double>();
    public static ArrayList<Double> sTotalClutch2Interval = new ArrayList<Double>();
    public static ArrayList<Double> sTotalClutch3Interval = new ArrayList<Double>();

    public static ArrayList<Double> sTotalLifespan = new ArrayList<Double>();

    public static ArrayList<Double> sTotalClutch1Size = new ArrayList<Double>();
    public static ArrayList<Double> sTotalClutch2Size = new ArrayList<Double>();
    public static ArrayList<Double> sTotalClutch3Size = new ArrayList<Double>();

    /*  H.robusta data
        PER SAMPLE data:
        Stores data for H.robusta clutch intervals, lifespan, and clutch size for
        each leech sample as indicated by the user
    */

    public static ArrayList<Double> rTotalClutch1Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch2Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch3Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch4Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch5Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch6Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch7Interval = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch8Interval = new ArrayList<Double>();


    public static ArrayList rTotalLifespan = new ArrayList();

    public static ArrayList<Double> rTotalClutch1Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch2Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch3Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch4Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch5Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch6Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch7Size = new ArrayList<Double>();
    public static ArrayList<Double> rTotalClutch8Size = new ArrayList<Double>();

    // ALL SAMPLES COMBINED data:
    /*  combines all clutch_i intervals and clutch size data for each leech sample into
        one data structure
    */  
    public static ArrayList<Double> allClutchIntervals_1 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_2 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_3 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_4 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_5 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_6 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_7 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchIntervals_8 = new ArrayList<Double>();
    

    public static ArrayList<Double> allClutchSize_1 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_2 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_3 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_4 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_5 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_6 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_7 = new ArrayList<Double>();
    public static ArrayList<Double> allClutchSize_8 = new ArrayList<Double>();


    /*  Generate a random number given a distribution, whereby
        sample points differ in probability of being chosen
    */
    public static double getRandom(double mean, double stdDev) {
        Random r = new Random();
        double randNum = r.nextGaussian() * stdDev + mean;
        //Guards against generating a non-positive number
        while ((int) Math.round(randNum) < 1) {
            randNum = (r.nextGaussian() * stdDev) + mean;
        }
        return randNum;
    }

    //Generate inter-clutch intervals for H.stagnalis sample in isolation
    public static double[] sComputeClutchTime(double clutches) {
        double[] retArray = new double[(int) clutches];
        if (clutches >= 1) {
            double clutch1 = Math.round(getRandom(140.0, 25.8));
            while (clutch1 < 1) {
                clutch1 = Math.round(getRandom(140.0, 25.8));
            }
            retArray[0] = clutch1;
            sTotalClutch1Interval.add(clutch1);
        }
        if (clutches >= 2) {
            double clutch2 = Math.round(getRandom(26.0, 15.2));
            while (clutch2 < 1) {
                clutch2 = Math.round(getRandom(26.0, 15.2));
            }
            retArray[1] = clutch2;
            sTotalClutch2Interval.add(clutch2);
        }
        if (clutches >= 3) {
            double clutch3 = Math.round(getRandom(48.7, 5.5));
            while (clutch3 < 1) {
                clutch3 = Math.round(getRandom(48.7, 5.5));
            }
            retArray[2] = clutch3;
            sTotalClutch3Interval.add(clutch3);
        }
        return retArray;
    }

    //Generate inter-clutch intervals for H.robusta sample in isolation
    public static double[] rComputeClutchTime(double clutches) {
        double[] retArray = new double[(int) clutches];
        if (clutches >= 1) {
            double clutch1 = Math.round(getRandom(hro_c1_interval, hro_c1_interval_sd));
            while (clutch1 < 1) {
                clutch1 = Math.round(getRandom(hro_c1_interval, hro_c1_interval_sd));
            }
            retArray[0] = clutch1;
            rTotalClutch1Interval.add(clutch1);
        }
        if (clutches >= 2) {
            double clutch2 = Math.round(getRandom(hro_c2_interval, hro_c2_interval_sd));
            while (clutch2 < 1) {
                clutch2 = Math.round(getRandom(hro_c2_interval, hro_c2_interval_sd));
            }
            retArray[1] = clutch2;
            rTotalClutch2Interval.add(clutch2);
        }
        if (clutches >= 3) {
            double clutch3 = Math.round(getRandom(hro_c3_interval, hro_c3_interval_sd));
            while (clutch3 < 1) {
                clutch3 = Math.round(getRandom(hro_c3_interval, hro_c3_interval_sd));
            }
            retArray[2] = clutch3;
            rTotalClutch3Interval.add(clutch3);
        }
        if (clutches >= 4) {
            double clutch4 = Math.round(getRandom(hro_c4_interval, hro_c4_interval_sd));
            while (clutch4 < 1) {
                clutch4 = Math.round(getRandom(hro_c4_interval, hro_c4_interval_sd));
            }
            retArray[3] = clutch4;
            rTotalClutch4Interval.add(clutch4);
        }
        if (clutches >= 5) {
            double clutch5 = Math.round(getRandom(hro_c5_interval, hro_c5_interval_sd));
            while (clutch5 < 1) {
                clutch5 = Math.round(getRandom(hro_c5_interval, hro_c5_interval_sd));
            }
            retArray[4] = clutch5;
            rTotalClutch5Interval.add(clutch5);
        }
        if (clutches >= 6) {
            double clutch6 = Math.round(getRandom(hro_c6_interval, hro_c6_interval_sd));
            while (clutch6 < 1) {
                clutch6 = Math.round(getRandom(hro_c6_interval, hro_c6_interval_sd));
            }
            retArray[5] = clutch6;
            rTotalClutch6Interval.add(clutch6);
        }
        if (clutches >= 7) {
            double clutch7 = Math.round(getRandom(hro_c7_interval, hro_c7_interval_sd));
            while (clutch7 < 1) {
                clutch7 = Math.round(getRandom(hro_c7_interval, hro_c7_interval_sd));
            }
            retArray[6] = clutch7;
            rTotalClutch7Interval.add(clutch7);
        }
        if (clutches >= 8) {
            double clutch8 = Math.round(getRandom(hro_c8_interval, hro_c8_interval_sd));
            while (clutch8 < 1) {
                clutch8 = Math.round(getRandom(hro_c8_interval, hro_c8_interval_sd));
            }
            retArray[7] = clutch8;
            rTotalClutch8Interval.add(clutch8);
        }
        return retArray;
    }

    /*  Compute the lifespan of a Helobdella. This is found
        by retrieving the cumulative inter-clutch interval day count + days survived
        after the last clutch is laid by that individual.
        Type 0 is for getting lifespan of H.stagnalis in isolation.
        Type 1 is for getting lifespan of H.robusta in isolation.
    */
    public static double GetLifespan(double[] InterClutchInterval, double DALC, int type) {
        double life = 0.0;
        if (InterClutchInterval != null && InterClutchInterval.length != 0) {
            life += InterClutchInterval[InterClutchInterval.length - 1];
        }
        if (type == 1) {
            if (useDALC(0.9, 0.3)) {
                rTotalLifespan.add(life + DALC);
                return life + DALC;
            } else {
                rTotalLifespan.add(life);
                return life;
            }
        }
        sTotalLifespan.add(life + DALC);
        return life + DALC;
    }

    /*  Check if Helobdella sample in isolation
        survived after laying its last clutch
    */
    public static boolean useDALC(double mean, double stdDev) {
        double val = getRandom(mean, stdDev);
        return ((int) Math.round(val) != 0);
    }

    //Compute clutch size of H.stagnalis sample in isolation
    public static double[] sComputeCS(double clutches) {
        double[] retArray = new double[(int) clutches];
        if (clutches >= 1) {
            double clutch1 = Math.round(getRandom(26.4, 7.5));
            while (clutch1 < 1) {
                clutch1 = Math.round(getRandom(26.4, 7.5));
            }
            retArray[0] = clutch1;
            sTotalClutch1Size.add(clutch1);
        }
        if (clutches >= 2) {
            double clutch2 = Math.round(getRandom(50.2, 12.7));
            while (clutch2 < 1) {
                clutch2 = Math.round(getRandom(50.2, 12.7));
            }
            retArray[1] = clutch2;
            sTotalClutch2Size.add(clutch2);
        }
        if (clutches >= 3) {
            double clutch3 = Math.round(getRandom(70.3, 4.7));
            while (clutch3 < 1) {
                clutch3 = Math.round(getRandom(70.3, 4.7));
            }
            retArray[2] = clutch3;
            sTotalClutch3Size.add(clutch3);
        }
        return retArray;
    }

    //Compute clutch size of H.robusta sample in isolation
    public static double[] rComputeCS(double clutches) {
        double[] retArray = new double[(int) clutches];
        if (clutches >= 1) {
            double clutch1 = Math.round(getRandom(hro_c1_size, hro_c1_size_sd));
            while (clutch1 < 1) {
                clutch1 = Math.round(getRandom(hro_c1_size, hro_c1_size_sd));
            }
            retArray[0] = clutch1;
            rTotalClutch1Size.add(clutch1);
        }
        if (clutches >= 2) {
            double clutch2 = Math.round(getRandom(hro_c2_size, hro_c2_size_sd));
            while (clutch2 < 1) {
                clutch2 = Math.round(getRandom(hro_c2_size, hro_c2_size_sd));
            }
            retArray[1] = clutch2;
            rTotalClutch2Size.add(clutch2);
        }
        if (clutches >= 3) {
            double clutch3 = Math.round(getRandom(hro_c3_size, hro_c3_size_sd));
            while (clutch3 < 1) {
                clutch3 = Math.round(getRandom(hro_c3_size, hro_c3_size_sd));
            }
            retArray[2] = clutch3;
            rTotalClutch3Size.add(clutch3);
        }
        if (clutches >= 4) {
            double clutch4 = Math.round(getRandom(hro_c4_size, hro_c4_size_sd));
            while (clutch4 < 1) {
                clutch4 = Math.round(getRandom(hro_c4_size, hro_c4_size_sd));
            }
            retArray[3] = clutch4;
            rTotalClutch4Size.add(clutch4);
        }
        if (clutches >= 5) {
            double clutch5 = Math.round(getRandom(hro_c5_size, hro_c5_size_sd));
            while (clutch5 < 1) {
                clutch5 = Math.round(getRandom(hro_c5_size, hro_c5_size_sd));
            }
            retArray[4] = clutch5;
            rTotalClutch5Size.add(clutch5);
        }
        if (clutches >= 6) {
            double clutch6 = Math.round(getRandom(hro_c6_size, hro_c6_size_sd));
            while (clutch6 < 1) {
                clutch6 = Math.round(getRandom(hro_c6_size, hro_c6_size_sd));
            }
            retArray[5] = clutch6;
            rTotalClutch6Size.add(clutch6);
        }
        if (clutches >= 7) {
            double clutch7 = Math.round(getRandom(hro_c7_size, hro_c7_size_sd));
            while (clutch7 < 1) {
                clutch7 = Math.round(getRandom(hro_c7_size, hro_c7_size_sd));
            }
            retArray[6] = clutch7;
            rTotalClutch7Size.add(clutch7);
        }
        if (clutches >= 8) {
            double clutch8 = Math.round(getRandom(hro_c8_size, hro_c8_size_sd));
            while (clutch8 < 1) {
                clutch8 = Math.round(getRandom(hro_c8_size, hro_c8_size_sd));
            }
            retArray[7] = clutch8;
            rTotalClutch8Size.add(clutch8);
        }
        return retArray;
    }

    //Prints out passed-in array
    public static void printToString(double[] array) {
        if (array == null || array.length == 0) {
            System.out.println("None");
            return;
        }
        else {
            int desLength = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    desLength += 1;
                }
            }
            for (int i = 0; i < desLength - 1; i++) {
                System.out.print((i + 1) + ": " + array[i] + ", ");
            }
            System.out.println(desLength + ": " + array[desLength - 1]);
        }
    }

    /*  Converts passed-in array to cumulative array
        ie. 1 2 3 1 -> 1 3 6 7
    */
    public static double[] convertCumulative(double[] origArray) {
        double[] copyArray = new double[origArray.length];
        for (int i = 0; i < origArray.length; i++) {
            copyArray[i] = origArray[i];
        }
        if (copyArray == null || copyArray.length == 0) {
            return copyArray;
        }
        else {
            // initialize prev value
            double prev = copyArray[0];
            for (int i = 1; i < copyArray.length; i++) {
                copyArray[i] += prev;
                prev = copyArray[i];
            }

            return copyArray;
        }
    }

    // comuptes mean, standard deviation, confidence interval, min/max
    public static void getStats(ArrayList<Double> inputArray) {
        if (inputArray == null || inputArray.size() == 0) {
            return;
        }
        boolean firstTime = true;
        double min = -1.0;
        double max = -1.0;
        double mean = -1.0;
        double lowerC = -1.0;
        double upperC = -1.0;
        double sDev = -1.0;
        int df = inp - 1;
        double multiplier = 1.96;

        double sum = 0;
        double sumDiff = 0;

        for (int index = 0; index < inputArray.size(); index++) {
            if (inputArray.get(index) < min || firstTime) {
                min = inputArray.get(index);
                firstTime = false;
            }
            if (inputArray.get(index) > max || firstTime) {
                max = inputArray.get(index);
                firstTime = false;
            }
            sum += inputArray.get(index);
        }

        mean = sum / inputArray.size();

        for (int index = 0; index < inputArray.size(); index++) {
            double diff = inputArray.get(index) - mean;
            sumDiff += Math.pow(diff, 2);
        }

        sDev = Math.pow(sumDiff/(inputArray.size() - 1), 1/2);
        double rootN = Math.pow(inputArray.size(), 1/2);
        
        

        if (df == 0 || df == 1) {
            multiplier = 6.314;
        }

        else if (2 <= df && df <= 5) {
            multiplier = 2.920;
        }

        else if (6 <= df && df <= 10) {
            multiplier = 1.943;
        }

        else if (11 <= df && df <= 15) {
            multiplier = 1.796;
        }

        else if (16 <= df && df <= 20) {
            multiplier = 1.746;
        }

        else if (21 <= df && df <= 25) {
            multiplier = 1.721;
        }

        else if (26 <= df & df < 29) {
            multiplier = 1.699;
        }

        else {
            multiplier = 1.96;
        }


        lowerC = mean - ((multiplier * sDev) / rootN);
        upperC = mean + ((multiplier * sDev) / rootN);

        System.out.println(        "Mean: " + mean);
        System.out.println(        "Standard Deviation: " + sDev);
        System.out.println(        "Confidence Interval: [" + lowerC + ", " + upperC + "]");
        System.out.println(        "Minimum: " + min);
        System.out.println(        "Maximum: " + max);
    }



    public static void main(String[] args) {
        // Get user input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a sample size: ");
        String input = reader.next();
        inp = Integer.parseInt(input);
        //Check for valid input
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input. Enter a positive integer.");
            System.exit(-1);
        }  

        if (Integer.parseInt(input) <= 0) {
            System.out.println("Invalid input. Enter a positive integer.");
            System.exit(-1);
        } 
    ////////////////////////////////////////////////
    ///////// FOR SURVIVING LEECHES GRAPH///////////
    ///////////////////////////////////////////////
        HashMap<Double, Integer> lifespanMap = new HashMap<Double, Integer>();
        double[] xlife = new double[Integer.parseInt(input)];

    ////////////////////////////////////////////////
    ///////// FOR AGGREGATE CLUTCH NUMBER///////////
    ///////////////////////////////////////////////
        HashMap<Double, Double> aggregateClutchNumMap = new HashMap<Double, Double>();
        ArrayList<Double> xClutchDays = new ArrayList<Double>();
        
        ArrayList<Double> agCDayCount = new ArrayList<Double>();
        HashMap<Double, Integer> agCDayCountMap = new HashMap<Double, Integer>();

        for (int i = 0; i < Integer.parseInt(input); i++) {

            //# clutches laid by H.stagnalis sample in isolation
            double sClutchNum = Math.round(getRandom(5.1, 2.7));
            //# clutches laid by H.robusta sample in isolation
            double rClutchNum = Math.round(getRandom(hro_clutch_num, hro_clutch_num_sd));
            double sDALC = getRandom(58.8, 46.5);
            double rDALC = Math.round(getRandom(40.0, 24.0));
            // double sLife = Math.round(GetLifespan(sComputeClutchTime(sClutchNum), sDALC, 0));
            double rLife = Math.round(GetLifespan(rComputeClutchTime(rClutchNum), rDALC, 1));
            double[] sInterClutchInterval = sComputeClutchTime(sClutchNum);
            double[] rInterClutchInterval = rComputeClutchTime(rClutchNum);
            double[] sClutchSize = sComputeCS(sClutchNum);
            double[] rClutchSize = rComputeCS(rClutchNum);

            double largestDay = 0.0;
            for (int k = 0; k < rInterClutchInterval.length; k++) {
                if (rInterClutchInterval[k] > largestDay) {
                    largestDay = rInterClutchInterval[k];
                }
            }
            while (rDALC < 0.0) {
                rDALC = Math.round(getRandom(40.0, 24.0));
            }
            largestDay += rDALC;
            xlife[i] = largestDay;
            if (lifespanMap.containsKey(largestDay)) {
                int val = lifespanMap.get(largestDay) + 1;
                lifespanMap.put(largestDay, val);
            } else {
                lifespanMap.put(largestDay, 1);
            }

            double[] cumRClutch = convertCumulative(rClutchSize);
            for (int j = 0; j < rInterClutchInterval.length; j++) {
                /*  keeps track of cumulative *clutch* count,
                    mapping days to accumulated clutch count
                */
                agCDayCount.add(rInterClutchInterval[j]);
                if (agCDayCountMap.containsKey(rInterClutchInterval[j])) {
                    if (rInterClutchInterval[j] == 0.0) {
                        agCDayCountMap.put(rInterClutchInterval[j], 0);
                    } else {
                        int val2 = agCDayCountMap.get(rInterClutchInterval[j]);
                        agCDayCountMap.put(rInterClutchInterval[j], val2);
                    }
                } else {
                    if (rInterClutchInterval[j] == 0.0) {
                        agCDayCountMap.put(rInterClutchInterval[j], 0);
                    } else {
                        agCDayCountMap.put(rInterClutchInterval[j], 1);
                    }
                }
            }

            int size = rInterClutchInterval.length;
            int clutchListSize = rClutchSize.length;
            if (size >= 1 && clutchListSize >= 1) {
                double a = rInterClutchInterval[0];
                allClutchIntervals_1.add(a);
                allClutchSize_1.add(rClutchSize[0]);
                if (size >= 2 && clutchListSize >= 2) {
                    double b = rInterClutchInterval[1];
                    allClutchIntervals_2.add(b);
                    allClutchSize_2.add(rClutchSize[1]);
                    if (size >= 3 && clutchListSize >= 3) {
                        double c = rInterClutchInterval[2];
                        allClutchIntervals_3.add(c);
                        allClutchSize_3.add(rClutchSize[2]);
                        if (size >= 4 && clutchListSize >= 4) {
                            double d = rInterClutchInterval[3];
                            allClutchIntervals_4.add(d);
                            allClutchSize_4.add(rClutchSize[3]);
                            if (size >= 5 && clutchListSize >= 5) {
                                double e = rInterClutchInterval[4];
                                allClutchIntervals_5.add(e);
                                allClutchSize_5.add(rClutchSize[4]);
                                if (size >= 6 && clutchListSize >= 6) {
                                    double f = rInterClutchInterval[5];
                                    allClutchIntervals_6.add(f);
                                    allClutchSize_6.add(rClutchSize[5]);
                                    if (size >= 7 && clutchListSize >= 7) {
                                        double g = rInterClutchInterval[6];
                                        allClutchIntervals_7.add(g);
                                        allClutchSize_7.add(rClutchSize[6]);
                                        if (size >= 8 && clutchListSize >= 8) {
                                            double h = rInterClutchInterval[7];
                                            allClutchIntervals_8.add(h);
                                            allClutchSize_8.add(rClutchSize[7]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* UNCOMMENT IF NEEDED: This prints out the inter-clutch intervals and clutch size per clutch

            System.out.println("Clutch 1 Interval Cumulative: " + allClutchIntervals_1);
            System.out.println("Clutch 1 SIZE: " + allClutchSize_1);
            System.out.println();

            System.out.println("Clutch 2 Interval Cumulative: " + allClutchIntervals_2);
            System.out.println("Clutch 2 SIZE: " + allClutchSize_2);
            System.out.println();

            System.out.println("Clutch 3 Interval Cumulative: " + allClutchIntervals_3);
            System.out.println("Clutch 3 SIZE: " + allClutchSize_3);
            System.out.println();

            System.out.println("Clutch 4 Interval Cumulative: " + allClutchIntervals_4);
            System.out.println("Clutch 4 SIZE: " + allClutchSize_4);
            System.out.println();

            System.out.println("Clutch 5 Interval Cumulative: " + allClutchIntervals_5);
            System.out.println("Clutch 5 SIZE: " + allClutchSize_5);
            System.out.println();

            System.out.println("Clutch 6 Interval Cumulative: " + allClutchIntervals_6);
            System.out.println("Clutch 6 SIZE: " + allClutchSize_6);
            System.out.println();

            System.out.println("Clutch 7 Interval Cumulative: " + allClutchIntervals_7);
            System.out.println("Clutch 7 SIZE: " + allClutchSize_7);
            System.out.println();

            System.out.println("Clutch 8 Interval Cumulative: " + allClutchIntervals_8);
            System.out.println("Clutch 8 SIZE: " + allClutchSize_8);

        */
            /*  used to keep track of the aggregate embryo count mapping days to
                cumulative embryo count
            */
            for (int m = 0; m < allClutchIntervals_1.size(); m++) {
                xClutchDays.add(allClutchIntervals_1.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_1.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_1.get(m)) + allClutchSize_1.get(m);
                    aggregateClutchNumMap.put(allClutchIntervals_1.get(m), value);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_1.get(m), allClutchSize_1.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_2.size(); m++) {
                xClutchDays.add(allClutchIntervals_2.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_2.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_2.get(m)) + allClutchSize_2.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_2.get(m), allClutchSize_2.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_3.size(); m++) {
                xClutchDays.add(allClutchIntervals_3.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_3.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_3.get(m)) + allClutchSize_3.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_3.get(m), allClutchSize_3.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_4.size(); m++) {
                xClutchDays.add(allClutchIntervals_4.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_4.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_4.get(m)) + allClutchSize_4.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_4.get(m), allClutchSize_4.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_5.size(); m++) {
                xClutchDays.add(allClutchIntervals_5.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_5.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_5.get(m)) + allClutchSize_5.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_5.get(m), allClutchSize_5.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_6.size(); m++) {
                xClutchDays.add(allClutchIntervals_6.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_6.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_6.get(m)) + allClutchSize_6.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_6.get(m), allClutchSize_6.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_7.size(); m++) {
                xClutchDays.add(allClutchIntervals_7.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_7.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_7.get(m)) + allClutchSize_7.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_7.get(m), allClutchSize_7.get(m));
                }
            }
            for (int m = 0; m < allClutchIntervals_8.size(); m++) {
                xClutchDays.add(allClutchIntervals_8.get(m));
                if (aggregateClutchNumMap.containsKey(allClutchIntervals_8.get(m))) {
                    double value = aggregateClutchNumMap.get(allClutchIntervals_8.get(m)) + allClutchSize_8.get(m);
                }
                else {
                    aggregateClutchNumMap.put(allClutchIntervals_8.get(m), allClutchSize_8.get(m));
                }
            }

            //System.out.println("*******STATISTICS*******");

            // UNCOMMENT IF NEEDED: (all statistics for H. stagnalis and H.robusta will be printed)
    
            // System.out.println("H.stagnalis: ");
            // System.out.println("   LIFESPAN");
            // getStats(sTotalLifespan);
            // System.out.println();
            // System.out.println("   CLUTCH INTERVALS");
            // System.out.println("      Clutch 1:");
            // getStats(sTotalClutch1Interval);
            // System.out.println("      Clutch 2:");
            // getStats(sTotalClutch2Interval);
            // System.out.println("      Clutch 3:");
            // getStats(sTotalClutch3Interval);
            // System.out.println();
            // System.out.println("   CLUTCH SIZE");
            // System.out.println("      Clutch 1:");
            // getStats(sTotalClutch1Size);
            // System.out.println("      Clutch 2:");
            // getStats(sTotalClutch2Size);
            // System.out.println("      Clutch 3:");
            // getStats(sTotalClutch3Size);
            // System.out.println("-------------------------");


            // System.out.println("H.robusta: ");
            // System.out.println("   LIFESPAN");
            // getStats(rTotalLifespan);
            // System.out.println();
            // System.out.println("   CLUTCH INTERVALS");
            // System.out.println("      Clutch 1:");
            // getStats(rTotalClutch1Interval);
            // System.out.println("      Clutch 2:");
            // getStats(rTotalClutch2Interval);
            // System.out.println("      Clutch 3:");
            // getStats(rTotalClutch3Interval);
            // System.out.println("      Clutch 4:");
            // getStats(rTotalClutch4Interval);
            // System.out.println("      Clutch 5:");
            // getStats(rTotalClutch5Interval);
            // System.out.println("      Clutch 6:");
            // getStats(rTotalClutch6Interval);
            // System.out.println("      Clutch 7:");
            // getStats(rTotalClutch7Interval);
            // System.out.println("      Clutch 8:");
            // getStats(rTotalClutch8Interval);
            // System.out.println();
            // System.out.println("   CLUTCH SIZE");
            // System.out.println("      Clutch 1:");
            // getStats(rTotalClutch1Size);
            // System.out.println("      Clutch 2:");
            // getStats(rTotalClutch2Size);
            // System.out.println("      Clutch 3:");
            // getStats(rTotalClutch3Size);
            // System.out.println("      Clutch 4:");
            // getStats(rTotalClutch4Size);
            // System.out.println("      Clutch 5:");
            // getStats(rTotalClutch5Size);
            // System.out.println("      Clutch 6:");
            // getStats(rTotalClutch6Size);
            // System.out.println("      Clutch 7:");
            // getStats(rTotalClutch7Size);
            // System.out.println("      Clutch 8:");
            // getStats(rTotalClutch8Size);
            // System.out.print("-----------------------");
            /////////////////////////////////////////////////
            ////////////////////////////////////////////////
            ///////////////////////////////////////////////

        /*  Creates files to store the data. 
            See readme.txt to get a description of
            the data stored in the txt files 
        */
        try {
            File file1 = new File("survivingLeechesData.txt");
            File file2 = new File("aggregateEmbryoCount.txt");   
            File file3 = new File("aggregateClutchNum.txt");

            // make files for each of the clutches
            File clutch1File = new File("clutch1Data.txt");
            File clutch2File = new File("clutch2Data.txt");
            File clutch3File = new File("clutch3Data.txt");
            File clutch4File = new File("clutch4Data.txt");
            File clutch5File = new File("clutch5Data.txt");
            File clutch6File = new File("clutch6Data.txt");
            File clutch7File = new File("clutch7Data.txt");
            File clutch8File = new File("clutch8Data.txt");
            File readmeFile = new File("readme.txt");

            if (file1.exists()) {
                file1.delete(); 
            }

            if (file2.exists()) {
                file2.delete();
            }

            if (file3.exists()) {
                file3.delete();
            }

            if (clutch1File.exists()) {
                clutch1File.delete();
            }

            if (clutch2File.exists()) {
                clutch2File.delete();
            }

            if (clutch3File.exists()) {
                clutch3File.delete();
            }

            if (clutch4File.exists()) {
                clutch4File.delete();
            }

            if (clutch5File.exists()) {
                clutch5File.delete();
            }

            if (clutch6File.exists()) {
                clutch6File.delete();
            }

            if (clutch7File.exists()) {
                clutch7File.delete();
            }

            if (clutch8File.exists()) {
                clutch8File.delete();
            }

            if (readmeFile.exists()) {
                readmeFile.delete();
            }

            
            // creates a FileWriter Object
            FileWriter writer1 = new FileWriter(file1); 
            Arrays.sort(xlife);
            double maxDay = xlife[xlife.length - 1];
            writer1.write("0.0\t" + input + "\t" + Double.toString(maxDay));
            writer1.write("\r\n");
            int diff = inp;
            for (int i = 0; i < xlife.length; i++) {
                if (diff - lifespanMap.get(xlife[i]) >= 0) {
                    diff -= lifespanMap.get(xlife[i]);   
                }        
                writer1.write(Double.toString(xlife[i]) +  "\t" + Integer.toString(diff));
                writer1.write("\r\n");
            } 
            writer1.flush();
            writer1.close();
            System.out.println("FILE 1: survivingLeechesData.txt...DONE");

            FileWriter writer2 = new FileWriter(file2); 
            Collections.sort(xClutchDays);
            
            writer2.write("0.0\t" + "0.0");
            writer2.write("\r\n");
            double prev = 0.0;
            for (int i = 0; i < xClutchDays.size(); i++) {
                double curr = aggregateClutchNumMap.get(xClutchDays.get(i)) + prev;  
                writer2.write(Double.toString(xClutchDays.get(i)) + "\t" + Double.toString(curr));
                writer2.write("\r\n");
                prev = curr; 
            } 
            writer2.write(Double.toString(maxDay) + "\t" + Double.toString(prev));         
          
            // Writes the content to the file
            writer2.flush();
            writer2.close();
            System.out.println("FILE 2: aggregateEmbryoCount.txt...DONE");

            FileWriter writer3 = new FileWriter(file3); 
            Collections.sort(agCDayCount);
            writer3.write("0.0\t" + "0");
            writer3.write("\r\n");
            int clutchCountPrev = 0;
            for (int r = 0; r < agCDayCount.size(); r++) {
                int clutchCountCurr = agCDayCountMap.get(agCDayCount.get(r)) + clutchCountPrev;
                writer3.write(Double.toString(agCDayCount.get(r)) + "\t" + Integer.toString(clutchCountCurr));
                writer3.write("\r\n");
                clutchCountPrev = clutchCountCurr; 
            }
            writer3.write(Double.toString(maxDay) + "\t" + Integer.toString(clutchCountPrev));         
          
            // Writes the content to the file
            writer3.flush();
            writer3.close();
            System.out.println("FILE 3: aggregateClutchNum.txt...DONE");


            ///////////////// writing to clutches.txt files ////////////////

            // CLUTCH 1

            FileWriter writer4 = new FileWriter(clutch1File); 
            for (int a = 0; a < allClutchIntervals_1.size(); a++) {
                writer4.write(Double.toString(allClutchIntervals_1.get(a)) + "\t" + Double.toString(allClutchSize_1.get(a)));
                writer4.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer4.flush();
            writer4.close();
            System.out.println("FILE 4: clutch1Data.txt...DONE");

            // CLUTCH 2

            FileWriter writer5 = new FileWriter(clutch2File); 
            for (int b = 0; b < allClutchIntervals_2.size(); b++) {
                writer5.write(Double.toString(allClutchIntervals_2.get(b)) + "\t" + Double.toString(allClutchSize_2.get(b)));
                writer5.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer5.flush();
            writer5.close();
            System.out.println("FILE 5: clutch2Data.txt...DONE");

            // CLUTCH 3

            FileWriter writer6 = new FileWriter(clutch3File); 
            for (int c = 0; c < allClutchIntervals_3.size(); c++) {
                writer6.write(Double.toString(allClutchIntervals_3.get(c)) + "\t" + Double.toString(allClutchSize_3.get(c)));
                writer6.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer6.flush();
            writer6.close();
            System.out.println("FILE 6: clutch3Data.txt...DONE");

            // CLUTCH 4

            FileWriter writer7 = new FileWriter(clutch4File); 
            for (int d = 0; d < allClutchIntervals_4.size(); d++) {
                writer7.write(Double.toString(allClutchIntervals_4.get(d)) + "\t" + Double.toString(allClutchSize_4.get(d)));
                writer7.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer7.flush();
            writer7.close();
            System.out.println("FILE 7: clutch4Data.txt...DONE");

            // CLUTCH 5

            FileWriter writer8 = new FileWriter(clutch5File); 
            for (int e = 0; e < allClutchIntervals_5.size(); e++) {
                writer8.write(Double.toString(allClutchIntervals_5.get(e)) + "\t" + Double.toString(allClutchSize_5.get(e)));
                writer8.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer8.flush();
            writer8.close();
            System.out.println("FILE 8: clutch5Data.txt...DONE");

            // CLUTCH 6

            FileWriter writer9 = new FileWriter(clutch6File); 
            for (int f = 0; f < allClutchIntervals_6.size(); f++) {
                writer9.write(Double.toString(allClutchIntervals_6.get(f)) + "\t" + Double.toString(allClutchSize_6.get(f)));
                writer9.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer9.flush();
            writer9.close();
            System.out.println("FILE 9: clutch6Data.txt...DONE");

            // CLUTCH 7

            FileWriter writer10 = new FileWriter(clutch7File); 
            for (int g = 0; g < allClutchIntervals_7.size(); g++) {
                writer10.write(Double.toString(allClutchIntervals_7.get(g)) + "\t" + Double.toString(allClutchSize_7.get(g)));
                writer10.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer10.flush();
            writer10.close();
            System.out.println("FILE 10: clutch7Data.txt...DONE");

            // CLUTCH 8

            FileWriter writer11 = new FileWriter(clutch8File); 
            for (int h = 0; h < allClutchIntervals_8.size(); h++) {
                writer11.write(Double.toString(allClutchIntervals_8.get(h)) + "\t" + Double.toString(allClutchSize_8.get(h)));
                writer11.write("\r\n"); 
            }         
          
            // Writes the content to the file
            writer11.flush();
            writer11.close();
            System.out.println("FILE 11: clutch8Data.txt...DONE");

            /*  Create a readme.txt file and write to it
                The readme.txt file contains descriptions of what 
                each column of the data text files represent.
                Columns of the data text file can be manipulated to 
                plot different graphs using the automatedPlotting.R program
            */

            FileWriter writer12 = new FileWriter(readmeFile); 
            
            writer12.write("NOTE: Data can also be manually manipulated and graphed accordingly");  
            writer12.write("\r\n"); 
            writer12.write("\r\n");  
                     
            writer12.write("File:\tsurvivingLeechesData.txt");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 1: Number of Days");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 2: Number of surviving leeches up to that day");

            writer12.write("\r\n");
            writer12.write("\r\n");

            writer12.write("File:\taggregateClutchNum.txt");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 1: Number of Days");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 2: Aggregate number of clutches up to that day");

            writer12.write("\r\n");
            writer12.write("\r\n");

            writer12.write("File:\taggregateEmbryoCount.txt");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 1: Number of Days");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 2: Aggregate number of embryos up to that day");

            writer12.write("\r\n");
            writer12.write("\r\n");

            writer12.write("File:\t for all clutch#Data.txt");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 1: Number of Days");
            writer12.write("\r\n");
            writer12.write("\t\tColumn 2: Clutch# size on that day");

            writer12.write("\r\n");
            writer12.write("\r\n");

            writer12.flush();
            writer12.close();
            System.out.println("FILE 12: readme.txt...DONE");
        }

    catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        } 
    }
}




