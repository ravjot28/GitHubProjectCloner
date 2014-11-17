import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Downloader implements Runnable {
	public Thread t = new Thread(this);
	public String fname;

	public Downloader(String url) {
		this.fname = url;
	}

	public void execute() {
		this.t.start();
	}

	public void run() {
		String cmd1 = "rundll32 url.dll,FileProtocolHandler " + this.fname;
		try {
			Runtime.getRuntime().exec(cmd1);
		} catch (Exception ex) {
			if (ex.toString().contains("java.io.IOException: Cannot run program \"rundll32\"")) {
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec("open " + this.fname);
				} catch (Exception as) {
					as.printStackTrace();
				}
			} else {
				System.out.println("Cant run");
			}
		}
	}
	
	public static void executeCommand(String command) throws IOException, InterruptedException{
		ProcessBuilder builder = new ProcessBuilder(
	            "cmd.exe", "/c",command);
	        builder.redirectErrorStream(true);
	        Process p = builder.start();
	        p.waitFor();
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
	}

	public static void main(String[] a) throws IOException, InterruptedException {
		
		executeCommand( "cd \"C:\\Users\\Ravjot\\Desktop\\Projects\" && git clone https://github.com/ravjot28/CloudSync.git");
		executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\CloudSync\" && git log");
		
	}
}
