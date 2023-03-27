package Homework_2;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;

public class Exemple_4 {

    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws SecurityException, IOException {
        Scanner iScanner = new Scanner(System.in);
        int x1 = scannerInt("Введите первое число:", iScanner);
        int x2 = scannerInt("Введите второе число", iScanner);
        String znac = scannerStr("Введите знак действия", iScanner);
       
        String res = calculator(x1, x2, znac);
        System.out.println(res);

        iScanner.close();
        
    }

    public static int scannerInt (String message, Scanner iScanner) {
        System.out.println(message);
        int x = iScanner.nextInt();

        return x;
    }

    public static String scannerStr (String message,Scanner iScanner) {
        System.out.println(message);
        String str = null;
        do{
        str = iScanner.nextLine();
        }while(str.isEmpty());


        return str;
    }

    public static String calculator(int x1, int x2, String znac) throws SecurityException, IOException {
        int v = 0;
        StringBuilder res = new StringBuilder();
        FileHandler fh;
        fh = new FileHandler("D:/Android dev/Repository/Java/Homework/Homework_2/log_calc.txt");

        switch(znac) {
            case "+":
            v = x1 + x2;
            res.append("Ваш ответ равен ").append(v);
            break;
            case "-":
            v = x1 + x2;
            res.append("Ваш ответ равен ").append(v);
            break;
            case "*":
            v = x1 * x2;
            res.append("Ваш ответ равен ").append(v);
            break;
            case "/":
            v = x1 / x2;
            res.append("Ваш ответ равен ").append(v);
            break;
            default:
                res.append("Походу этот калькулятор не обрабатывает подобные знаки");
        }

        StringBuilder log = new StringBuilder();
        log.append(x1).append(" ").append(znac).append(" ").append(x2).append(" ").append("=").append(" ").append(v);
        logger(log.toString(), fh);

        return res.toString();
    }

    public static void logger(String res, FileHandler fh) {
        try {

            logger.addHandler(fh);
            XMLFormatter formatter = new XMLFormatter();
            fh.setFormatter(formatter);
            logger.info(res);

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}

