import java.util.Scanner;

public class SafeInput
{

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine().trim();

            if (retString.length() == 0)
            {
                System.out.println("Input cannot be empty. Please try again.");
            }

        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int value = 0;
        boolean valid = false;

        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();
                valid = true;
            } else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid input.");
            }
        } while (!valid);

        return value;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double result = 0;
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");

            if (pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid number.");
            }

        } while (!done);

        return result;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value = 0;
        boolean valid = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();
                if (value >= low && value <= high)
                {
                    valid = true;
                } else
                {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!valid);

        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value = 0;
        boolean done = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine();
                if (value >= low && value <= high)
                {
                    done = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!done);

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String input;
        boolean valid = false;

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim();
            if (input.equalsIgnoreCase("Y"))
            {
                return true;
            } else if (input.equalsIgnoreCase("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);

        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();

            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please match digit input.");
            }

        } while (!valid);

        return input;
    }

    public static void prettyHeader(String msg)
    {
        final int WIDTH = 60;

        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        int spaceForMsg = WIDTH - 6;
        int spacingTotal = spaceForMsg - msg.length();
        int spacingLeft = spacingTotal / 2;
        int spacingRight = spacingTotal - spacingLeft;

        System.out.print("***");
        for (int i = 0; i < spacingLeft; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < spacingRight; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}