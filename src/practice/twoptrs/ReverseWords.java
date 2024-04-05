package practice.twoptrs;

class ReverseWords {

    public static void reverse(char[] c, int st, int ed) {
        while(st <= ed) {
            char temp = c[st];
            c[st] = c[ed];
            c[ed] = temp;
            st++;
            ed--;
        }
    }

    public static String reverseWords(String s) {

        char[] c = s.toCharArray();

        int pre = 0;
        int wbk = 0;


        System.out.println("0: " + new String(c));
        while (wbk < s.length()) {
            System.out.println("1.1: pre: " + pre + ", wbk: " + wbk + ", c[wbk]: " + c[wbk]);
            if(c[wbk] == ' ') {
                while(wbk < s.length() && c[wbk] == ' ') {
                    wbk++;
                }
                if (pre > 0 && wbk < s.length()) {
                    c[pre] = ' ';
                    pre++;
                }
            } else if (c[wbk] != ' ') {
                c[pre] = c[wbk];
                pre++;
                wbk++;
            }
        }
        System.out.println("1: " + new String(c));
        reverse(c, 0, pre-1);
        System.out.println("2: " + new String(c));

        int st = 0;
        int newlen = pre;
        wbk = 0;

        System.out.println("newlen: " + newlen);
        System.out.println("s.length(): " + s.length());

        while(wbk < newlen) {
//            System.out.println("3: wbk: " + wbk);
            if(c[wbk] == ' ') {
                reverse(c, st, wbk-1);
                st = wbk+1;
                wbk++;
            } else {
                wbk++;
            }
        }
        reverse(c, st, wbk-1);

        return new String(c, 0, newlen);
    }

    // Driver code
    public static void main(String[] args) {
        String[] inputs = {
                "Hello World",
                "We love Python",
                "The quick brown fox jumped over the lazy dog.",
                "Hey",
                "To be or not to be",
                "AAAAA",
                " Hello     World "};

        for(int i=0; i<inputs.length; i++){
            System.out.print(i+1);
            System.out.println(".\tActual string:\t\t"+ inputs[i]);
            System.out.println("\tReversed String:\t"+ reverseWords(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}