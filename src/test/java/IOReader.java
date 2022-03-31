import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Io reader.
 */
public class IOReader {

    private String m_string;
    /**
     * The Pat.
     */
    Pattern pat;
    /**
     * The Mat.
     */
    Matcher mat;
    /**
     * The Found.
     */
    Boolean found;

    /**
     * Set string.
     */
    public void setString(){
        String s = "";
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            s = br.readLine();
        }
        catch(IOException excError){
            System.out.println(excError.toString());
        }
        this.m_string = s;
    }

    /**
     * Get string string.
     *
     * @return the string
     */
    public String getString(){
        return this.m_string;
    }

    /**
     * Validate option boolean.
     *
     * @return the boolean
     */
    public Boolean validateOption(){
        setString();
        pat = Pattern.compile("^[0-9]");
        mat = pat.matcher(this.m_string);
        found = mat.matches();
        return found;
    }

}
