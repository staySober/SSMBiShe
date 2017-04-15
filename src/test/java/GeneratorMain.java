import org.mybatis.generator.api.ShellRunner;

import java.io.File;
import java.io.IOException;


public class GeneratorMain {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "-configfile";
        GeneratorMain.class.getResource("/");
        String configRootPath = GeneratorMain.class.getResource("/").getPath();
        args[1] = configRootPath+"generator.xml";
        args[2] = "-overwrite";
        deleteXmlFiles();
        ShellRunner.main(args);
    }

    public static void deleteXmlFiles() {
        try {
            File directory = new File("");
            String str = directory.getCanonicalPath() + "/dao/src/main/resources/com/bishe/production/dao/mapper";
            File file = new File(str);
            if(file.isDirectory() && null != file.listFiles() && file.listFiles().length > 0){
                for (File f : file.listFiles()) {
                    f.delete();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
