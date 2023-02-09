import java.util.Scanner;
public class Tollbooth {

    static Scanner sc = new Scanner(System.in);

    static int oneway_twoway(int amount)
    {
        System.out.println("Press 1 for oneway: ");
        System.out.println("Press 2 for twoway: ");
        int x;
        x = sc.nextInt();
        if(x == 1)
        {
            return amount;
        }
        else if(x == 2)
        {
            return amount + 20;
        }
        return 0;
    }
    static int auto()
    {
        int oneway_charge = 30;
        int twoway_charge = 50;
        System.out.println("Press 1: for oneway: ");
        System.out.println("Press 2: for twoway: ");
        int n;
        n = sc.nextInt();
        switch (n)
        {
            case 1:
                System.out.printf("Pay Rs %d\n",oneway_charge);
                return oneway_charge;
            case 2:
                System.out.printf("Pay Rs %d\n",twoway_charge);
                return twoway_charge;
        }
        return 0;
    }

    static int four_wheelers()
    {
        int n;
        System.out.println("Press 1: For Car: ");
        System.out.println("Press 2: For Bus: ");
        System.out.println("Press 3: For Truck: ");
        System.out.println("Press 4: For Defense vehicle: ");
        System.out.println("Press 5: For Ambulance: ");
        System.out.println("Press 6: For Fire brigade: ");
        n = sc.nextInt();
        switch (n)
        {
            case 1:
                int amount;
                amount = oneway_twoway(40);
                System.out.printf("Pay Rs %d: \n",amount);
                return amount;
            case 2:
                int amount1;
                amount1 = oneway_twoway(50);
                System.out.printf("Pay Rs %d: \n",amount1);
                return amount1;
            case 3:
                int amount3;
                amount3 = oneway_twoway(70);
                System.out.printf("Pay Rs %d: \n",amount3);
                return amount3;
            case 4:
                System.out.println("Jai Hind! No charges.");
                return 0;
            case 5:
                System.out.println("No charges! ");
                return 0;
            case 6:
                System.out.println("NO charges!");
                return 0;

        }
        return 0;
    }
    public static void main(String[] args) {
        int oneday_revenue =0, vechical_count=0;
        int flag = 2;
        while(flag==2)
        {

            System.out.println("=============================================================================");
            System.out.println("||                            TOLLBOOTH                                    ||");
            System.out.println("|| Press 1: For Two wheeler:                                               ||");
            System.out.println("|| Press 2: For Three wheeler:                                             ||");
            System.out.println("|| Press 3: For Four wheeler:                                              ||");
            System.out.println("|| Press 4: To check the total revenue:                                    ||");
            System.out.println("|| Press 5: To check NO. of vehicle passed till yet:                       ||");
            System.out.println("|| Press 6: To exit.                                                       ||");
            System.out.println("=============================================================================");
            int n;
            n = sc.nextInt();
            switch(n)
            {
                case 1:
                    System.out.println("NO charges!");
                    break;
                case 2:
                    int amount;
                    amount = auto();
                    oneday_revenue += amount;
                    vechical_count +=1;
                    break;
                case 3:
                    int amount1 = four_wheelers();
                    oneday_revenue += amount1;
                    vechical_count += 1;
                    break;
                case 4:
                    System.out.println("Total Revenue of the day is: " + oneday_revenue);
                    break;
                case 5:
                    System.out.println("Total vehicle: " + vechical_count);
                    break;
                case 6:
                    flag = 3;
                    break;
            }
        }
    }
}
