import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PluginMain {
	public static void main(String[] args) throws Exception {

		 File proxyList = new File(".");
		 ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
		 for (String f: proxyList.list()) {
			if (f.endsWith(".class")) {
				try {
					plgs.add(PluginManager.load(f.substring(0, f.lastIndexOf('.'))));
				} catch (Exception e) {
					System.out.println("\t" + f + ": Componente ignorado. Nao e IPlugin.");
				}
			}	
		 }
		 Iterator<IPlugin> it = plgs.iterator();
		 while (it.hasNext()) {
			 it.next().fazQualQuerCoisa();
		 }
	}
}
