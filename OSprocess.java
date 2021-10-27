
/**
 * Demonstrating process creation in Java.
 */

import java.io.*;
import java.util.*;

public class OSprocess {
	public static void main(String[] args) throws IOException {

		// show system environment
		Map<String, String> enviro = System.getenv();
		for (String key : enviro.keySet())
			System.out.println(key + "  :  " + enviro.get(key));

		// show current directory
		String workingDirectory = System.getProperty("user.dir") + "\\";
		System.out.println(workingDirectory);
		Scanner console = new Scanner((System.in));
/*
		// Create a command line window
		System.out.print("bash>");

		// Read the command ** A command without parameter **
		
		String command = console.nextLine();
		

		ProcessBuilder pb = new ProcessBuilder(command);
		Process proc = pb.start();

		// obtain the input and output streams of process
		Scanner br = new Scanner(proc.getInputStream());

		while (br.hasNextLine()) {
			System.out.println(br.nextLine());
		}

		br.close();
*/
		// Read the command **A command with parameter **
		// Run cmd /c dir
		String tokerTest="";
		while(!tokerTest.equals("exit")){
		System.out.print("bash>");
		List<String> commandlist = new ArrayList<String>();
		try{
		Scanner toker = new Scanner(console.nextLine());
		tokerTest=toker.next();
		switch(tokerTest){
			case "ls":
			tokerTest="dir";
			break;
			case "pwd":
			tokerTest="cd";
			break;
			case "cp":
			tokerTest="copy";
			break;
			case "man":
			tokerTest="help";
			break;
			case "nano":
			tokerTest="notepad";
			break;
			case "grep":
			tokerTest="find";
			break;
			case "env":
			tokerTest="set";
			break;
			case "ifconfig":
			tokerTest="ipconfig";
			break;
			default:
			break;
		}
		
		//System.out.println(tokerTest);
		if(tokerTest.equals("dir")||tokerTest.equals("cd")||tokerTest.equals("copy")||tokerTest.equals("del")
		||tokerTest.equals("more")||tokerTest.equals("help")||tokerTest.equals("find")||tokerTest.equals("mkdir")
		||tokerTest.equals("rmdir")||tokerTest.equals("set")||tokerTest.equals("exit")){
			commandlist.add("cmd");
			commandlist.add("/c");
			commandlist.add(tokerTest);
		}
		else{
			commandlist.add(tokerTest);
		}
		
			
		//System.out.println(commandlist);

		ProcessBuilder pb1 = new ProcessBuilder(commandlist);
		Process proc1 = pb1.start();

		// obtain the input and output streams -- only for text stream
		Scanner br1 = new Scanner(proc1.getInputStream());

		while (br1.hasNextLine()) {
			System.out.println(br1.nextLine());
		}
	
	
		br1.close();
	}
		catch (Exception e){
			System.out.println("Invalid Command");
		}
		}
		console.close();
	
		// end

	}
}