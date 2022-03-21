public class PolindromSlovVStrok {
    public static void main(String[] args) {
        PolindromSlovVStrok test = new PolindromSlovVStrok();
        String stroka = "Шла Анна и слушала музыку по дороге и думала: но не реч, а черен он.";
        String result = stroka.replaceAll("[^a-zA-ZА-Яа-я]", "").toLowerCase();
        boolean bool = test.checkPalindrom(result);
        if (!bool)
            System.out.println("В строке нет палиндромов");
        System.out.println(test.resultStroka.delete(test.resultStroka.length()-2, test.resultStroka.length()).append("."));
    }

    StringBuilder resultStroka = new StringBuilder("");

    private StringBuilder itog(String s) {
        if (!resultStroka.toString().contains(s) || s.length() == 3) {
            resultStroka.append(s).append(", ");
        }
        return resultStroka;
    }

    private boolean checkPalindrom(String k) {
        int[] count = new int[k.length()];
        boolean[] arr = new boolean[k.length()];
        for (int t = 0; t < k.length(); t++) {
            int j = 0;
            char ch = k.charAt(t);
            for (int x = t + 1; x < k.length(); x++) {
                if (j < count.length) {
                    if (ch == k.charAt(x))
                        count[j] = x + 1;
                    else
                        count[j] = 0;
                    j++;
                }
            }
            arr[t] = workOnArr(count, t, k);
        }
        for (int z = 0; z < arr.length; z++) {
            if (arr[z])
                return true;
        }
        return false;
    }

    private boolean workOnArr(int[] s, int z, String w) {
        int j = s.length - 1;
        while (j-- > 0) {
            if (s[j] != 0) {
                if (isPalindrom(w.substring(z, s[j]))) {
                    if (w.substring(z, s[j]).length() > 2) {
                        itog(w.substring(z, s[j]));
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPalindrom(String s) {
        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            j--;
        }
        return true;
    }
}
