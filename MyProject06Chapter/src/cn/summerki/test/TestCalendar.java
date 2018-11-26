package cn.summerki.test;

import java.beans.IntrospectionException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.SortedMap;

/**
 * 打印日历
 * @author summerki
 */
public class TestCalendar {
    public static void main(String[] args) {
        System.out.println("请输入日期(格式2010-3-3):");
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();

        System.out.println("你刚才输入的日期是:" + inputDate);
        String[] inputDataArray = inputDate.split("-");

        int year = new Integer(inputDataArray[0]);
        int month = new Integer(inputDataArray[1]);
        int day = new Integer(inputDataArray[2]);

        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.set(Calendar.DATE, 1);
        int dow = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for(int i = 0; i < dow - 1; i++){
            System.out.print("\t");
        }

        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        for(int i = 0; i <= maxDay; i++){
            StringBuilder sb = new StringBuilder();
            if(calendar.get(Calendar.DATE) == day){
                sb.append(calendar.get(Calendar.DATE) + "*\t");
            }else{
                sb.append(calendar.get(Calendar.DATE) + "\t");
            }
            System.out.print(sb);

            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.print("\n");
            }
            calendar.add(Calendar.DATE, 1);
        }
    }
}
