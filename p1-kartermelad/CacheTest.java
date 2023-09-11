import java.text.DecimalFormat;

/**
 * A tester for the cache class
 * @author Karter Melad
 * @version Fall 2023
 */
public class CacheTest {
    public static void main(String[] args) {

        int size = Integer.parseInt(args[0]);
        int numberWebpages = Integer.parseInt(args[1]);
        double standardDeviation = Double.parseDouble(args[2]);
        int debugLevel = Integer.parseInt(args[3]);
        long seed = 0;
        long diffTime = 0;
        WebpageGenerator seedless = null;
        WebpageGenerator withSeed = null;
        Cache<String, Webpage> myCache = new Cache<String, Webpage>(size);

        // If user args is less than 4 throw an error
        if(args.length < 4 || args.length > 5) {
            System.out.println("Command line arguments needed from user. Cache size, number of ");
            System.out.println("webpages, standard deviation, debug level, and seed(optional).");
        }

        // If user args is equal to four, create a seedless webpage generator
        if(args.length == 4) {
            String newURL;
            long startTime = System.currentTimeMillis();
            seedless = new WebpageGenerator(numberWebpages, standardDeviation);
            for(int i = 0; i < numberWebpages; i++) {
                newURL = seedless.getURL();
                if(myCache.get(newURL) == null) {
                    Webpage newPage = seedless.readPage(newURL);
                    myCache.add(newPage);
                }
            }
            long endTime = System.currentTimeMillis();
            diffTime = endTime - startTime;
        }

        // If user args is equal to five, create a seeded webpage generator
        else if(args.length == 5) {
            seed = Long.parseLong(args[4]);
            String newURL;
            long startTime = System.currentTimeMillis();
            withSeed = new WebpageGenerator(numberWebpages, standardDeviation, seed);
            for(int i = 0; i < numberWebpages; i++) {
                newURL = withSeed.getURL();
                if(myCache.get(newURL) == null) {
                    Webpage newPage = withSeed.readPage(newURL);
                    myCache.add(newPage);
                }
            }
            long endTime = System.currentTimeMillis();
            diffTime = endTime - startTime;
        }

        DecimalFormat newDecimal = new DecimalFormat("0.0");

        // If debug level is equal to zero print contents
        if(debugLevel == 0) {
            System.out.println(myCache.toString());
            System.out.println("----------------------------------------------------------------");
            System.out.println("Time elapsed: " + newDecimal.format(diffTime) + " milliseconds");
            System.out.println("----------------------------------------------------------------");
        }

        // If debug level is equal to one print contents
        if(debugLevel == 1) {
            System.out.println("--------------------------------------");
            System.out.println("Printing the Webpage Distribution: ");
            System.out.println("--------------------------------------");
            if(args.length == 4) {
                seedless.getWebpageDatabasePings();
            }
            if(args.length == 5) {
                withSeed.getWebpageDatabasePings();
            }
            System.out.println(myCache.toString());
            System.out.println("----------------------------------------------------------------");
            System.out.println("Time elapsed: " + newDecimal.format(diffTime) + " milliseconds");
            System.out.println("----------------------------------------------------------------");
        }

        // If debug level is eqaul to two print contents, else if equal to three print contents
        if(debugLevel == 2 || debugLevel == 3) {
            System.out.println("============================================");
            System.out.println("Generated and serialized Webpages");
            System.out.println("============================================");
            if(debugLevel == 2) {
                if(args.length == 4) {
                    seedless.printWebpages(2);
                }
                else if(args.length == 5) {
                    withSeed.printWebpages(2);
                }
            }
            else if(debugLevel == 3) {
                if(args.length == 4) {
                    seedless.printWebpages(3);
                }
                else if(args.length == 5) {
                    withSeed.printWebpages(3);
                }
            }
            System.out.println(myCache.toString());
            System.out.println("----------------------------------------------------------------");
            System.out.println("Time elapsed: " + newDecimal.format(diffTime) + " milliseconds");
            System.out.println("----------------------------------------------------------------");
        }
    }
}

