public class Main {
    public static void main(String[] args) {
        DirectorySize ds = new DirectorySize();

        if(args.length == 1) {
            String path = args[0];
            System.out.printf("Size of %s: %d (kB)\n", path, ds.getDirectorySize(path, false));
            System.exit(0);
        }

        if (args.length == 2 && args[1].equals("-r")) {
            String path = args[1];
            System.out.printf("Size of %s: %d (kB)\n", path, ds.getDirectorySize(path, true));
        } else {
            System.out.println("Usage: java Main <path> [-r]");
            System.exit(1);
        }


    }
}
