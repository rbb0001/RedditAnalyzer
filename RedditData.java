
public class RedditData {
	int upvotes;
	int numComments;
	String userName;
	String post;
	public RedditData() {
		upvotes = 0;
		numComments = 0;
		userName = "default";
		post = "default";
	}
	public RedditData(int upvotes, int numComments, String userName, String post) {
		this.upvotes = upvotes;
		this.numComments = numComments;
		this.userName = userName;
		this.post = post;
	}
	public String toString() {
		String result = "";
		result += "Number of Upvotes: " + upvotes + "\n";
		result += "Username: " + userName + "\n";
		result += post + "\n";
		result += "Number of comments: " + numComments + "\n";
		return result;
	}
}
