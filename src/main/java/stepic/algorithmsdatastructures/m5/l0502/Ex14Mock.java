package stepic.algorithmsdatastructures.m5.l0502;


public class Ex14Mock {
    public static void main(String[] args) {
        java.util.HashSet<String> set = new java.util.HashSet<>();
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean ok = false;
        String line, data;
        while (in.hasNextLine()) {
            line = in.nextLine();
            data = line.substring(2);
            switch (line.charAt(0)) {
            case '+':
                ok = set.add(data);
                break;
            case '-':
                ok = set.remove(data);
                break;
            case '?':
                ok = set.contains(data);
                break;
            }
            System.out.println(ok ? "OK" : "FAIL");
        }
        in.close();
    }
}
