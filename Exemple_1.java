package Homework_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Exemple_1 {

    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws SecurityException, IOException {
        Scanner iScanner = new Scanner(System.in);
        String arg = iScanner.nextLine();
        String res = bubbleSotr(arg);
        iScanner.close();
        System.out.println(res);

    }

    public static String bubbleSotr(String args) throws SecurityException, IOException {
        int n = args.length();
        FileHandler fh;
        fh = new FileHandler("D:/Android dev/Repository/Java/Homework/Homework_2/log.txt");
        StringBuffer res = new StringBuffer(args);
        while (n > 1) {
            for (int i = 0; i < res.length() - 1; i++) {
                if (res.charAt(i) > res.charAt(i + 1)) {
                    res.insert(i, res.charAt(i + 1));
                    res.deleteCharAt(i + 2);
                    logger(res.toString(), fh);
                } else {
                    continue;
                }
            }
            n--;

        }
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
