

import java.io.*;


public class SalaryRead {

    public static void main (String[] args) {

        System.out.println("HELLOO");
        String csvFile = "C:\\Users\\josh.dombal\\IdeaProjects\\SalaryData-Parser\\src\\seattleJobs.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int count = 1;
            Location location = new Location();
            line = br.readLine();
            double averageSalary = 0;
            while ((line = br.readLine()) != null) {

                // use comma as seperator
                String[] jobEle = line.split(csvSplitBy);

                String strSalary = jobEle[4];

                System.out.println(strSalary);
                strSalary = strSalary.replace("-", " ").trim();
                strSalary = strSalary.replace("$", "");
                strSalary = strSalary.replace("k", "");
                strSalary = strSalary.replace("\"", "");

                System.out.println("HIII" + strSalary);
                String[] array = strSalary.split(" ");
                double average = 0;
                if (array.length > 1) {
                    average = (Integer.parseInt(array[0]) + Integer.parseInt(array[1]))/2;
                }


                //String intValue = strSalary.replaceAll("[^0-9]", "-");
                //System.out.println(intValue);

                if (strSalary.matches(".*\\d+.*")) {
                    Job job = new Job(jobEle[0], jobEle[1], jobEle[2], jobEle[3], average);
                    location.addJob(job);
                    if (average != 0) {
                        averageSalary += average;
                    }
                } else {
                    Job job = new Job(jobEle[0], jobEle[1], jobEle[2], jobEle[3], 0);
                    location.addJob(job);
                }


                //System.out.println("Job " + job[0] + ", " + job[1] + ", " + job[2]);
                count++;

            }
            location.setAverageSalary(averageSalary);

            System.out.println("Start");
            for (Job j : location.getJobs()) {
                System.out.println(j.getSalary());
            }

            System.out.println(location.getNumberOfJobs());
            System.out.println(location.getAverageSalary());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
