import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataReader {
	static Scanner fileDataInput = null;
	static Scanner filePostInput = null;
	static Scanner fileUserInput = null;
	static RedditData dataArray [];
	static int upvotes;
	static int comments;
	static int numOfPosts = 0;
	static String username;
	static String post;
	
	// This method creates a data array for the username, upvotes, post title, and number of comments in a reddit post
	public static RedditData[] DataArrayMaker(String dataFilename, String postFilename, String userFilename) {
		File dataFile = new File(dataFilename);
		File postFile = new File(postFilename);
		File userFile = new File(userFilename);
		int postCounter = 0;
		dataArray = new RedditData [6465];
		try {
			fileDataInput = new Scanner(dataFile);
			filePostInput = new Scanner(postFile);
			fileUserInput = new Scanner(userFile);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		while (fileDataInput.hasNextLine() && filePostInput.hasNextLine() && fileUserInput.hasNextLine()) {
			try {
				upvotes = fileDataInput.nextInt();
			} catch (Exception Ex) {
				upvotes = -1;
				fileDataInput.next();
			}
			try {
				comments = fileDataInput.nextInt();
			} catch (Exception Ex) {
				comments = -1;
				fileDataInput.next();
			}
			try {
				username = fileUserInput.nextLine();
			} catch (Exception Ex) {
				username = "error";
				fileUserInput.next();
			}
			try {
				post = filePostInput.nextLine();
			} catch (Exception Ex) {
				post = "error";
			}
			dataArray[postCounter] = new RedditData(upvotes, comments, username, post);
			postCounter += 1;
		}
		return dataArray;
	}
	// This method counts how many posts a user has made and display them
	public static int UserCounter(String username, RedditData Array[]) {
		int counter = 0;
		while (counter <=6464) {
			if (Array[counter].userName.equals(username)) {
				numOfPosts += 1;
				System.out.println("User's post: " + Array[counter].post);
			}
			counter += 1;
		}
		return numOfPosts;
	}
	// This method counts how many times a keyword is mentioned, and will count how many upvotes and comments posts that said those words received
	public static void PostCounter(String keyword, RedditData Array[]) {
		int counter = 0;
		int wordCounter = 0;
		int totalUpvotes = 0;
		int totalComments = 0;
		int averageUpvotes;
		int averageComments;
		String word = keyword.toLowerCase();
		while (counter <= 6464) {
			String line = Array[counter].post.toLowerCase();
			if (line.contains(word)) {
				wordCounter += 1;
				totalUpvotes += Array[counter].upvotes;
				totalComments += Array[counter].numComments;
			}
			counter += 1;
		}
		averageUpvotes = totalUpvotes/wordCounter;
		averageComments = totalComments/wordCounter;
		System.out.println("The keyword was mentioned in " + wordCounter + " posts.");
		System.out.println("Posts that mentioned the keyword received " + totalUpvotes + " upvotes in total, and " + averageUpvotes + " upvotes on average.");
		System.out.println("Posts that mentioned the keyword received " + totalComments + " comments in total, and " + averageComments + " comments on average.");
	}
}
