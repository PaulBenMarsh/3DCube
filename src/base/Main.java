package base;

public class Main {

	public static void main(String[] args) {
		
		try {
			new Application().execute();
		}catch(Exception exception) {
			System.err.println(exception.getMessage());
		}
		
	}

}
