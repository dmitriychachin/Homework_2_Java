package Homework_2;

import java.util.Scanner;

public class Exemple_3 {
    public static void main(String[] args) {
        String line = scannerStr();
        int n = (line.length()-1) / 2;
        int m = n;
        Boolean status = true;
        status = palindrom(line, n, status, m);
        System.out.printf("Ваша строка прошла проверку на полиндромность и результат %b", status);
    }

    public static String scannerStr () {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите строку для проверки: ");
        String x = iScanner.nextLine();
        iScanner.close();

        return x;
    }

    public static Boolean palindrom(String line, int n, Boolean status, int m) {

        if (line.charAt(m - n) == line.charAt(m + n)) {
            n--;
            if(n < 0){
                return status;
            }
            else{
                status = palindrom(line, n, status, m);
            }
        }
        else{
            status = false;
        }

        return status;
    }
}
