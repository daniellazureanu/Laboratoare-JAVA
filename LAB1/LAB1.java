public class Tema1 {
    public static void main(String[] args) {
        int month_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String months[] = {"Januray", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.println("1. Display each month alongside its corresponding number of days.");
        for(int i=0; i<month_days.length; i++){
            System.out.println(months[i] + " " +month_days[i]);
        }

        System.out.println("\n2. Display the months that have 31 days.");
        for(int i=0; i<month_days.length; i++){
            if(month_days[i]==31){
                System.out.println(months[i]);
            }
        }

        System.out.println("\n3. Display the months that have fewer than 31 days, along with their number of days.");
        for(int i=0; i<month_days.length; i++){
            if(month_days[i]<31){
                System.out.println(months[i] + " " + month_days[i]);
            }
        }

        System.out.println("\n4. Calculate and display the total number of days for months with fewer than 31 days.");
        int total = 0;
        for(int i=0; i<month_days.length; i++){
            if(month_days[i]<31){
                total+=month_days[i];
            }
        }
        System.out.println(total);

        System.out.println("\n5. Repeat exercise 1, but only display the first 3 characters of each month’s name (e.g.,Jan, Feb, etc.).");
        for(int i=0; i<month_days.length; i++){
            System.out.println(months[i].substring(0,3) + " " +month_days[i]);
        }

    }
}