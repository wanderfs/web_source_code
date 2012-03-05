package utility;

import java.text.DateFormat;
import java.util.Date;

public class ConstellationUtil {

    public enum Constellation {

        Capricorn(1, "摩羯座"), Aquarius(2, "水瓶座"), Pisces(3, "双鱼座"), Aries(4, "白羊座"), Taurus(5, "金牛座"), Gemini(6, "双子座"), Cancer(
        7, "巨蟹座"), Leo(8, "狮子座"), Virgo(9, "处女座"), Libra(10, "天秤座"), Scorpio(11, "天蝎座"), Sagittarius(12, "射手座");
        private int code;
        private String chineseName;

        private Constellation(int code, String chineseName) {
            this.code = code;
            this.chineseName = chineseName;
        }

        public int getCode() {
            return this.code;
        }

        public String getChineseName() {
            return this.chineseName;
        }
    }
    public static final Constellation[] constellationArr = {Constellation.Aquarius, Constellation.Pisces,
        Constellation.Aries, Constellation.Taurus, Constellation.Gemini, Constellation.Cancer, Constellation.Leo,
        Constellation.Virgo, Constellation.Libra, Constellation.Scorpio, Constellation.Sagittarius,
        Constellation.Capricorn};
    public static final int[] constellationEdgeDay = {21, 20, 21, 21, 22, 22, 23, 24, 24, 24, 23, 22};

    public static int calculateConstellation(String birthday) {
        Date date = null;
        try {
            date = new Date(birthday);
        } catch (Throwable t) {
                date = java.sql.Date.valueOf(birthday);
        }

        return calculateConstellation(new Date(birthday));
    }

    public static int calculateConstellation(Date d) {
        System.out.println(d);
        int month = d.getMonth() + 1;
        int day = d.getDay() + 1;
        if (month == 0 || day == 0 || month > 12) {
            return 0;
        }
        month = day < constellationEdgeDay[month - 1] ? month - 1 : month;
        return month > 0 ? constellationArr[month - 1].getCode() : constellationArr[11].getCode();
    }
    
}
