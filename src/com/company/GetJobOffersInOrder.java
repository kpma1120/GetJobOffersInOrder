package com.company;

import java.util.ArrayList;
import java.util.List;

public class GetJobOffersInOrder {

    public static void main(String[] args) {
	// write your code here
        JobDetails job1 = new JobDetails(34);
        JobDetails job2 = new JobDetails(22);
        JobDetails job3 = new JobDetails(87);
        JobDetails job4 = new JobDetails(53);
        ArrayList allJobOffers = new ArrayList();
        allJobOffers.add(job1);
        allJobOffers.add(job2);
        allJobOffers.add(job3);
        allJobOffers.add(job4);
        System.out.println("All job offers: " + allJobOffers);
        List<JobDetails> sortedAllJobOffers = getJobOffersInOrder(allJobOffers);
        System.out.println("Sorted job offers: " + sortedAllJobOffers);
    }

    public static List<JobDetails> getJobOffersInOrder(List<JobDetails> allJobOffers) {
        ArrayList sortedAllJobOffers = new ArrayList();
        double[] allJobScores = new double[allJobOffers.size()];
        int[] allJobIndexes = new int[allJobOffers.size()];
        for (int i = 0; i < allJobOffers.size(); i++) {
            allJobScores[i] = allJobOffers.get(i).getJobScore();
            allJobIndexes[i] = i;
        }
        //for (int i = 0; i < allJobScores.length; i++) {
        //    System.out.println("Job score at index " + allJobIndexes[i] + ": " + allJobScores[i]);
        //}
        selectionSort(allJobScores, allJobIndexes);
        //for (int i = 0; i < allJobScores.length; i++) {
        //    System.out.println("Job score at index " + allJobIndexes[i] + ": " + allJobScores[i]);
        //}
        for (int i = 0; i < allJobIndexes.length; i++) {
            int j = allJobIndexes[i];
            sortedAllJobOffers.add(allJobOffers.get(j));
        }
        return sortedAllJobOffers;
    }

    public static void selectionSort(double[] a, int[] d) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                double swapValue = a[i];
                a[i] = a[min];
                a[min] = swapValue;
                int swapIndex = d[i];
                d[i] = d[min];
                d[min] = swapIndex;
            }
        }
    }

    public static class JobDetails {
        private double  jobScore;

        private JobDetails(double jobScore) {
            setJobScore(jobScore);
        }

        public void setJobScore(double jobScore) {
            this.jobScore = jobScore;
        }

        public double getJobScore() {
            return jobScore;
        }

        @Override
        public String toString() {
            return Double.toString(jobScore);
        }
    }
}

