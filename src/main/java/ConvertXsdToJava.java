import com.sun.tools.xjc.Driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConvertXsdToJava {
    private final static String INPUT_BASE = "src/main/resources/xsd";
    private final static String OUTPUT_DIR = "src/main/java";

    public static void main(String[] args){
        try {
            for(String dirname : getDirNames()){
                String inputDir = INPUT_BASE + "/" + dirname;
                String packageName = "xsd.generated." + dirname;
                var arguments = new String[]{inputDir, "-d", OUTPUT_DIR, "-p", packageName};
                Driver.run(arguments, System.out, System.out);
            }
        } catch(Throwable e){
            System.out.println(e);
        }
    }

    private static List<String> getDirNames() {
        List<String> dirnames = new ArrayList<>();
        File dir = new File(INPUT_BASE);
        for(File f : dir.listFiles()){
            if(f.isDirectory()){
                dirnames.add(f.getName());
            }
        }
        return dirnames;
    }
}
