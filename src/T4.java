public class T4 {

    public static void main(String[] args) {
        String[] birth = {"1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"};

        int solution = new T4().solution(birth);

        System.out.println("solution = " + solution);
    }

    public int solution(String[] birth){
        int count = 0;

        for (String one : birth) {
            if(validate(one)) count++;
        }
        return count;
    }

    public boolean validate(String one){

        //1 YYYY-MM-DD 포멧인지 부터 체크
        String[] split = one.split("-");

        // 1.1 3개로 쪼개지는지 체크
        if(split.length != 3) return false;

        // 1.2 각 항목이 적절한 자리수인지 체크
        if(split[0].length() != 4 || split[1].length() != 2 || split[2].length() != 2) return false;

        // 1.3 각 값이 숫자인지 체크
        if(!isInteger(split[0]) || !isInteger(split[1]) || !isInteger(split[2])) return false;

        //2 출생년도 체크
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        if(year > 2022 || year < 1900) return false;

        //3 출생 월 체크
        if(month < 1 || month > 12) return false;

        //4 출생 월에 따른 일 체크
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if(day < 0 || day > 31) return false;
            }
            case 4, 6, 9, 11 -> {
                if(day < 0 || day > 30) return false;
            }
        }

        //5 윤년 체크
        boolean leapYear = false;
        if(year % 400 == 0) leapYear = true;
        else if(year % 4 == 0 && year % 100 != 0) leapYear = true;

        if(!leapYear && month == 2){
            return day >= 0 && day <= 28;
        }
        if(leapYear && month == 2){
            return day >= 0 && day <= 29;
        }

        return true;
    }

    private boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
