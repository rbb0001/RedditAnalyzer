import java.util.Scanner;

public class DataAnalysis {

	public static void main(String[] args) {
		String filename1 = "UserData.txt";
		String filename2 = "PostData.txt";
		String filename3 = "NameData.txt";
		String choice;
		Scanner input = new Scanner(System.in);
		String username = "";
		String keyword = "";
		
		RedditData dataArray[] = new RedditData[6464];
		dataArray = DataReader.DataArrayMaker(filename1, filename2, filename3);
		System.out.println("Enter 'keyword' for post searching or 'username' for user searching");
		choice = input.nextLine();
		
		if (choice.equalsIgnoreCase("keyword")) {
			System.out.println("Enter a keyword to search for.");
			keyword = input.nextLine();
			DataReader.PostCounter(keyword, dataArray);
		} else if (choice.equalsIgnoreCase("username")) {
			System.out.println("Enter a username to seach for.");
			username = input.nextLine();
			System.out.println("The user posted " + DataReader.UserCounter(username, dataArray) + " times");
		} else {
			System.out.println("I couldn't understand your response");
		}
	}
}
