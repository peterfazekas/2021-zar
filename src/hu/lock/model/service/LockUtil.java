package hu.lock.model.service;

public class LockUtil {

    public static String openResult(String value, String pattern) {
        if (!isSameLength(value, pattern)) {
            return "hibás hossz";
        } else {
            return nyit(value, pattern) ? "sikeres" : "hibás kódszám";
        }
    }

    private static boolean isSameLength(String value, String pattern) {
        return value.length() == pattern.length();
    }

    private static boolean nyit(String jo, String proba) {
        var egyezik = isSameLength(jo, proba);
        if (egyezik) {
            int elteres = (int) jo.charAt(0) - (int) proba.charAt(0);
            for (int i = 1; i < jo.length(); i++) {
                if ((elteres - ((int) jo.charAt(i) - (int) proba.charAt(i))) % 10 != 0) {
                    egyezik = false;
                }
            }
        }
        return egyezik;
    }
}
