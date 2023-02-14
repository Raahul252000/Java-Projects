import java.util.Scanner;
public class Income_tax_calculator {
    static Scanner sc = new Scanner(System.in);
    static int standard_deduction = 50000;


    static double old_regime()
    {
        int income, investment =0, health_insulance=0, homeloan=0, edu_loan=0, house_rent=0;
        double incometax = 0;

        System.out.println("Enter your annual Income: ");
        income = sc.nextInt();
        income = income-standard_deduction;
        System.out.println("Enter your investment amount under Section 80C and 80CCD(1B): ");
        investment = sc.nextInt();
        System.out.println("Enter your health insurance amount under section 80D: ");
        health_insulance = sc.nextInt();
        System.out.println("Enter your House rent allowance: ");
        house_rent = sc.nextInt();
        System.out.println("Enter your educational loan interest: ");
        edu_loan = sc.nextInt();
        System.out.println("Enter the Home loan interest: ");
        homeloan = sc.nextInt();
        income = income - (investment + health_insulance + homeloan + edu_loan + house_rent);
        System.out.println("Taxable income after all the deduction: " + income);

        if(income <= 500000)
        {
            System.out.println("No tax for you!");
        }
        else
        {
            if(income >= 500001 && income <= 1000000)
            {
                   int temp = income - 500000;
                   incometax = 12500 + temp * (20.0/100);
                   return incometax;
            }
            else if(income >= 1000001)
            {
                int temp = income - 1000000;
                incometax = 112500 + temp * (30.0/100);
                return incometax;
            }
        }
        return incometax;
    }

    static double new_regime()
    {
        int income;
        double incometax = 0;

        System.out.println("Enter your annual Income: ");
        income = sc.nextInt();
        income = income - standard_deduction;
        System.out.println("Taxable income after Standard deduction of ₹ 50,000 under Section 16: " + income);

        if(income <= 700000)
        {
            System.out.println("No tax for you!!");
        }
        else
        {
            if(income >= 600001 && income <= 900000)
            {
                    int temp = income-600000;
                    incometax = 15000 + temp * (10.0/100);
                    return incometax;
            }
            else if(income >= 900001 && income <= 1200000)
            {
                if(income == 1200000)
                {
                    incometax = 90000;
                    return incometax;
                }
                else
                {
                    int temp = income-900000;
                    incometax = 45000 + temp *(15.0/100);
                    return incometax;
                }
            }
            else if(income >=1200001 && income <=1500000)
            {
                if(income==1500000)
                {
                    incometax = 150000;
                    return incometax;
                }
                else
                {
                    int temp = income-1200000;
                    incometax = 90000 + temp * (20.0/100);
                    return incometax;
                }
            }
            else
            {
                int temp = income - 1500000;
                incometax = 150000 + temp * (30.0/ 100);
                return incometax;
            }
        }
        return incometax;
    }

    public static void main(String[] args)
    {
        int flag = 2;
        while(flag == 2)
        {
            System.out.println("=====================================================");
            System.out.println("||                INCOME TAX CALCULATOR            ||");
            System.out.println("|| Income Tax Calculator                           ||");
            System.out.println("|| Press 1: For old Regime                         ||");
            System.out.println("|| Press 2: For new Regime                         ||");
            System.out.println("|| Press 3: To close the application               ||");
            System.out.println("=====================================================");

            int regime = sc.nextInt();
            switch (regime)
            {
                case 1:
                    double incometax1 = old_regime();
                    System.out.println("Income tax supposed to be paid: " + incometax1);
                    break;
                case 2:
                    double incometax = new_regime();
                    System.out.println("Income tax supposed to be paid: " + incometax);
                    break;
                case 3:
                    flag +=1;
                    break;
            }
        }
    }
}
