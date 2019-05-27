/********************************
 *	프로젝트 : MediaPlayer
 *	패키지   : net.balusc.webapp
 *	작성일   : 2016. 8. 17.
 *	프로젝트 : OPERA 
 *	작성자   : KYJ
 *******************************/
package net.balusc.webapp;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author KYJ
 *
 */
public class Mp3Table {

	private static Mp3Table INSTANCE;

	private static final Map<String, File> table = new TreeMap<String, File>();

	public static Mp3Table getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new Mp3Table();
		}
		return INSTANCE;
	}

	private Mp3Table() {
		String bASE_PATH = ContextInitializer.BASE_PATH;
		File basePath = new File(bASE_PATH);
		File[] listFiles = basePath.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			if (file.getName().endsWith(".mp3") || file.getName().endsWith(".mp4")  || file.getName().endsWith(".avi") || file.getName().endsWith(".mkv")) {
				table.put(String.valueOf(i), file);
			}
		}
	}

	public Map<String, File> getTable() {
		return table;
	}

	public Set<Entry<String, File>> entrySet() {
		return table.entrySet();
	}

	public File getFile(String id) {
		return table.get(id);
	}
}
