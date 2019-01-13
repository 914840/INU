package fileIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static void main(String[] args) {

		Scanner in = null;
		PrintWriter out = null;
		int id;
		String firstName;
		String lastName;
		
		ArrayList<Person> personList = new ArrayList();
		
		try {
			
			in = new Scanner(Paths.get("/home/users/mtymorek/infile.txt"));
			// definiuje rodzaj separatora w pliku z którego czytamy.
			// in.useDelimiter("[^a-zA-Z0-9]");  
			while (in.hasNext()){
				id = in.nextInt();
				firstName = in.next();
				lastName = in.next();
				
				personList.add(new Person(id, firstName, lastName));
				
				System.out.printf("Wczytano dane -> id:%02d | imię: %-12s| nazwisko: %-12s\n", id, firstName, lastName);
			}
			
			out = new PrintWriter("/home/users/mtymorek/outfile.txt");
			
			for(int i=0; i<personList.size(); i++){
				out.printf("%s:%s:%d\n",
						personList.get(i).getLastName(),
						personList.get(i).getFirstName(),
						personList.get(i).getId()
						);
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
		}
		
	}

}
