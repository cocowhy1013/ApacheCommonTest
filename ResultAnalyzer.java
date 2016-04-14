import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by coco on 2016/4/14.
 */
public class ResultAnalyzer {
    public boolean resultAnalyzer(String resultFileRoot,File logOutputFile) throws IOException {
        FileUtils.writeStringToFile(logOutputFile,"",false);
        File root = new File(resultFileRoot);
        for(File file:root.listFiles()){
            List<String> lines = FileUtils.readLines(file);
            boolean isMRAlwaysTrue = true;
            String detectLog = "";
            for(int i=0;i<lines.size();i++){
                if(lines.get(i).contains("Result: false")) {
                    isMRAlwaysTrue = false;
                    detectLog = detectLog + i + " ";
                }
            }
            String logline = file.getName()+" "+isMRAlwaysTrue + " | " + detectLog + "\n";
            FileUtils.writeStringToFile(logOutputFile,logline,true);//logOutputFile.
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        File logFile = new File("E:\\Workspace Intelij\\NBC_basic\\dataset\\result.txt");
        boolean b = new ResultAnalyzer().resultAnalyzer("E:\\Workspace Intelij\\NBC_basic\\dataset\\result3"
                ,logFile);

        System.out.println(b);
    }
}
