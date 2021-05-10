public class ExceptionsAndErrorHandlingLecture {
    // We can throw an exception!
    public static void main(String[] args) throws Exception {
//        throw new Exception("This has broken down! Exception!"); // throwing a generic exception: will break out application!
        // A bunch of nice code down here - unreachable past a thrown exception!
//        System.out.println("Will we see this?"); // Unreachable code after the exception

        try {
            System.out.println("Let's see...");
            int result = 1 / 0;
            System.out.println("With reckless abandon and little thought to what thwy had done, the Marco cohort undid all of the math.");
            System.out.println("result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("User attempted to divide by Zero.");
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Expand down the line - moving towards less specificity with each Catch block{}
        }

        // An example of an array
        int[] numbers = {1, 2, 3};
        int x;

        try {
            x = numbers[100];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught!");
            x = 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("This will always run. [For example: 'I have completed the operation message']");
        }

        // Real life scenario:
//        try {
//            // To connect to the database to get all of the user information
//            // Oh  yeah! It worked: load in all the users, load in all of the posts/movies/coffees/whatever is going on in your application
//            // proceed as normal. . .
//        } catch (SomethingWrongWithDbConnection connectionFailed) {
//            // if connection to DB failed: what's our game plan?
//            // printTheStackTrace for the db connection failing
//            // print out a message to myself: check DB connection - connection failed
//        }





    }
}
