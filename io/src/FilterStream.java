import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class FilterStream {
    
	public static void main(String[] args) {
		//파일을 복사 붙여넣는 작업
		String originFileName = "a.txt";
		String destFileName = "acopy.txt";
		FileInputStream fis = null;//노드스트림
		Reader reader = null;//보조스트림을 담을 그릇
		BufferedReader br = null;//보조스트림을 담을 그릇
		FileOutputStream fos = null;//노드스트림
		Writer writer = null;//보조스트림을 담을 그릇
		BufferedWriter bw = null;//보조스트림을 담을 그릇
		//바이트 단위를 문자 단위로
		try {
			fis = new FileInputStream(originFileName);
			reader = new InputStreamReader(fis);
			br = new BufferedReader(reader);
			fos = new FileOutputStream(destFileName);
			writer = new OutputStreamWriter(fos);
			bw = new BufferedWriter(writer);
			String s = "";
			while((s = br.readLine()) != null){
				bw.write(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bw != null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
