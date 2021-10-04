public class Cesar {
    public static String decr(String str, int a){
        String decText="";
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            char c= (char)(ch+a);
            decText=decText.concat(String.valueOf(c));
        }

        return decText;
    }
    public static void main(String[] args) {
        String text=">]aOZXWm[Wm\\OmaZOQYm^`WdOb\\cm^]`cYc(m8OdO\":gTS";
        int number=18;
        System.out.println(decr(text, number));
    }
}
