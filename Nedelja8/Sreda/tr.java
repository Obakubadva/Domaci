  /*
     * 5. Linijski editor
     * Sa standardnog ulaza se unose niske karaktera koje opisuju neku akciju. Akcije su sledece:
     * iX - korisnike je otkucao karakter X
     * < - korisnik je pritisnuo taster levo
     * > - korisnik je pritisnuo taster desno
     * b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
     * d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
     *
     * Vratiti String dobijen izvrsavanjem svih ackija
     *
     * NPR:
     * iaib<bic>>
     * cb
     *
     * Objasnjenje:
     * Tekst     Naredba
     * |         ia
     * a|        ib
     * ab|       <
     * a|b       b
     * |b        ic
     * c|b       >
     * cb|       >
     * cb|
     *
     * */

    public static String console(String input){
        char[] niz=input.toCharArray();
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < niz.length; i++) {
            switch (niz[i]){
                case 'i':
                    st.push(niz[i+1]);
                    i++;
                    break;
                    case '<':
                        if (!st.isEmpty()){
                            st2.push(st.pop());
                        }
                        break;
                case '>':
                    if (!st2.isEmpty()){
                        st.push(st2.pop());
                    }
                    break;
                case 'b':
                    if (!st.isEmpty()){
                        st.pop();
                    }
                    break;
                case 'd':
                    if (!st2.isEmpty()){
                        st2.pop();
                    }
            }
        }
        String str="";
        String str2="";
        ArrayList<Character> poruka=new ArrayList<>(st);
        ArrayList<Character> poruka2=new ArrayList<>(st2);

            for (int i = 0; i < poruka.size(); i++) {
                str+=poruka.get(i);
        }
            for (int i = 0; i < poruka2.size(); i++) {
                str2+=poruka2.get(i);
            }
      if (!st.isEmpty()&&!st2.isEmpty())
          return str+str2;
       if (st.isEmpty())
           return str2;
       if (st2.isEmpty())
           return str;
       return"";
    }
 * 7. Berza
    * Duzina Si cene nekoe hartije ne berzi je definisana kao najveci broj uzastopnih dana,
    * pre datog dana, za koje je cena hartije manja ili jednaka trenutnoj ceni.
    * Za dat niz cena jedne hartije, vratiti niz duzina Si za svaki od tih dana
    *
    * NPR:
    * Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
    * Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
    * */

    public static int[] hartije(int... hartija){
        // public static int[] hartije(1, 2, 3, 4) -> []
        if (hartija.length==0)
            return null;
        int[] si = new int[hartija.length];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2= new Stack<>();
        si[0]=1;
        st.push(1);
        st2.push(hartija[0]);
        for (int i = 1; i < hartija.length ; i++) {
            if (hartija[i]<st2.peek()){
                si[i]=1;
                st.push(1);
                st2.push(hartija[i]);
            }
            else{
                int count=1;
                while(hartija[i]>=st2.peek()){
                    st2.pop();
                    count+=st.pop();
                    if (st.isEmpty() || st2.isEmpty())
                        break;
                }
                st.push(count);
                st2.push(hartija[i]);
                si[i]=count;
                }
            }
        System.out.println(Arrays.toString(si));
        return si;
    }
 /*
    * 3. Razlika
    * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
    * ali ne i u drugom nizu, bez ponavljanja.
    * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a==b || a==null)
            return null;
        if (b==null)
            return a;
        ArrayList<Integer> list= new ArrayList<>();
        TreeSet<Integer> skup= new TreeSet<>(b);
        for (int i = 0; i < a.size(); i++) {
            if (!skup.contains(a.get(i)))
                list.add(a.get(i));
        }
        return list;
    }
  /*
    * 7. Anagram
    * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
    * jedan String anagram drugog.
    *
    * NPR:
    * "panta redovno zakasni"
    * "neopravdan izostanak"
    * Da
    * */

    public static boolean anagram(String s1, String s2){
        String copyOfs1 = s1.replaceAll(" ", "");
        String copyOfs2 = s2.replaceAll(" ", "");
        char[] c1=copyOfs1.toCharArray();
        char[] c2=copyOfs2.toCharArray();
        TreeSet<Character> skup1= new TreeSet<>();
        TreeSet<Character> skup2= new TreeSet<>();
        for (int i = 0; i < c1.length; i++) {
            skup1.add(c1[i]);
        }
        for (int i = 0; i < c2.length; i++) {
            skup2.add(c2[i]);
        }
        if (skup1.containsAll(skup2) && copyOfs1.length()==copyOfs2.length())
            return true;
        return false;
    }
