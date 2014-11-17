import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import orm.GithubProjects;

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

	public static void executeCommand(String command) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		builder.redirectErrorStream(true);
		System.out.println(command);
		Process p = builder.start();
		//p.waitFor();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
	}

	public static List<String> getURLs(String language) {
		try {
			Session session = DatabaseConfig.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(GithubProjects.class);
			Criterion languageRestriction = Restrictions.eq("language", language);
			crit.add(languageRestriction);
			crit.setProjection(Projections.distinct(Projections.property("repositoryURL")));
			List<String> urlList = ((List<String>) crit.list());
			if (urlList != null && urlList.size() > 0) {
				System.out.println(urlList.size());
				return urlList;
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] a) throws IOException, InterruptedException {
		List<String> list = null;
		list = getURLs("java");
		for(String url:list){
			executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\Java\" && git clone "+url);
		}
		list = getURLs("csharp");
		for(String url:list){
			executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\Csharp\" && git clone "+url);
		}
		list = getURLs("php");
		for(String url:list){
			executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\Php\" && git clone "+url);
		}
		list = getURLs("python");
		for(String url:list){
			executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\Python\" && git clone "+url);
		}
		
		
		
		//executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\" && git clone https://github.com/ravjot28/CloudSync.git");
		//executeCommand("cd \"C:\\Users\\Ravjot\\Desktop\\Projects\\CloudSync\" && git log");

	}
}
