package data.structures.basic.string;

/*
2678. Number of Senior Citizens
https://leetcode.com/problems/number-of-senior-citizens/description/?envType=daily-question&envId=2024-08-01
 */
public class NumSeniorCitizens {

    // approach #1 with substring
    public int countSeniors(String[] details) {
        // age is at index 11 & 12

        int count = 0;
        for(String detail:details){
            int age = Integer.valueOf(detail.substring(11,13));
            if(age>60) count++;
        }

        return count;
    }

    // approach #2 with character
    public int countSeniors2(String[] details) {
        int seniorCount = 0;

        // Iterate through each passenger's details
        for (String passengerInfo : details) {
            // Extract the digits of age
            int ageTens = passengerInfo.charAt(11) - '0';
            int ageOnes = passengerInfo.charAt(12) - '0';

            // Calculate the full age
            int age = ageTens * 10 + ageOnes;

            // Check if the passenger is a senior (strictly over 60 years old)
            if (age > 60) {
                seniorCount++;
            }
        }

        return seniorCount;
    }

}
