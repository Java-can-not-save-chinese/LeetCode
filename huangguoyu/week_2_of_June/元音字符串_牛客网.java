public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        Set<Character> meta = new HashSet<>();
        meta.add('a');
        meta.add('e');
        meta.add('i');
        meta.add('o');
        meta.add('u');


        int temp[][] = new int[s.length()][s.length()];

        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (!meta.contains(chars[i])) break;
                if(meta.contains(chars[j])) temp[i][j] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            int star, end, flaw = 0;
            for (int j = i; j < length; j++) {
                if (temp[i][j] != 1) continue;
                end = star = j;
                while(j < length) {
                    if (temp[i][j] == 0) {
                        flaw++;
                        if (flaw > n) {
                            res = (end - star + 1) > res ? (end - star + 1) : res;
                            j = length;
                        }
                    }
                    else end = j;
                    j++;
                }
                if (flaw == 0 && n == 0) {
                    res = (end - star + 1) > res ? (end - star + 1) : res;
                }
            }
        }
        System.out.println(res);
    }

}