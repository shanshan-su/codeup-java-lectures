package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileIOLecture {
    public static void printPoem(Path filePath) throws IOException { // Write out a try/catch block fpr the OPException would be the more robust path vs. throwing it here. Throwing it here, we're kicking the can down the road!
        System.out.println();
        try {
            List<String> fileContents = Files.readAllLines(filePath);
            for (int i = 0; i < fileContents.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
            }
        } catch (IOException e) {
            System.out.println("Cannot find the file according to the given path.");
        }

    }


    public static void main(String[] args) throws IOException {
        Path filePathToPoem = Paths.get("./src/fileIO/theMiser.txt"); // relative path current working directory [root] > up through the file chain

        Path sameDirectoryPath = Paths.get("/theMiser.txt");

        // Let's print out these filePaths!

        System.out.println("filePathToPoem = " + filePathToPoem); // value of path objects = what  we had set / passed as a parameter!

        System.out.println("Files.exists(filePathToPoem) = " + Files.exists(filePathToPoem)); // true
        System.out.println("Files.exists(sameDirectoryPath) = " + Files.exists(sameDirectoryPath)); // false. The path in java is more strict than it is in javaScript

        printPoem(filePathToPoem);
        System.out.println();

        // Alright! So, we've built a Path - we used the Path with Files.exist - now though, how do we get into the creation of new files/directories?
        String directory = "./src/fileIO/data"; // relative path to where we want our directory to go
        String fileName = "groceryList.txt"; // fileName for our desired file

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, fileName);

        System.out.println("dataFile = " + dataFile);

        if (Files.notExists(dataDirectory)) { // if true: got down path and directory not there
            Files.createDirectories(dataDirectory); // go ahead and create a directory on this path :)

        }

        if (Files.notExists(dataFile)) { // if true: got down path and file not found in directory
            Files.createFile(dataFile);
        }

        // Okay, so: There's the file / directory created! Well how do I take this next step and write into the file? How do I get into the file and read from the file?
        // first idea: write to the file and add a List<String> of groceries!
        Path groceriesTxtPath = Paths.get(directory, fileName);

        System.out.println("groceriesTxtPath = " + groceriesTxtPath); // path to the groceriesList.txt

        List<String> groceries = Arrays.asList("coffee", "milk", "sugar"); // making the list!
        System.out.println("groceries = " + groceries); // There it is! The list to write

        Files.write(groceriesTxtPath, groceries); //

        // second idea: Let's print our list of groceries as it stands!
        System.out.println();

        List<String> groceryList = Files.readAllLines(groceriesTxtPath);

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ": " + groceryList.get(i));
        }

        System.out.println();

        // third idea: append one item to the end of the file [don't overwrite! That's the default! We need to use StandardOpenOption.APPEND is what we need here!

        Files.write(groceriesTxtPath, Arrays.asList("eggs"), StandardOpenOption.APPEND);

        groceryList = Files.readAllLines(groceriesTxtPath);

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ": " + groceryList.get(i));
        }

        // fourth idea: Let's grab what's in the file (Files.readAllLines), iterate through after making it into a list, and then replace milk with cream!

        List<String> lines = Files.readAllLines(groceriesTxtPath);
        List<String> newList = new ArrayList<>();

        for (String line : lines) {
            if (line.equals("milk")) {
                newList.add("cream");
                continue;
            }
            newList.add(line);
        }

        Files.write(groceriesTxtPath, newList);
    }
}
