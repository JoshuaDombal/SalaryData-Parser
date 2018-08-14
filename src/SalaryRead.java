

import java.io.*;


public class SalaryRead {

    public static void main (String[] args) {

        System.out.println("HELLOO");
        String csvFile = "C:\\Users\\josh.dombal\\IdeaProjects\\SalaryReader\\src\\seattleJobs.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int count = 1;
            Location location = new Location();
            while ((line = br.readLine()) != null) {

                // use comma as seperator
                String[] jobEle = line.split(csvSplitBy);

                String strSalary = jobEle[4];


                String intValue = strSalary.replaceAll("[^0-9]", "-");
                System.out.println(intValue);


                Job job = new Job(jobEle[0], jobEle[1], jobEle[2], jobEle[3], jobEle[4], jobEle[5]);
                location.addJob(job);

                //System.out.println("Job " + job[0] + ", " + job[1] + ", " + job[2]);
                count++;

            }

            System.out.println(location.getNumberOfJobs());




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
