import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Stanislav Makarov
 */
public class RegexTest {
    public static void main(String[] args) {
        String text = "R50=24532-24533 782\"5111650 20.03.2002;R55=24532-24533;R2=11;R3= ;R42=139840;R57=Акционерное общество \"Научно-производственное объединение \"Э;R4=37335;R5=37335;R6=37335;R7=;R8=1966,32;R9=02;R10=;R11=RUB;R12=01;R13=2;R14=3;R15=;R16=0;R17=0;R18=;R19=;R20=;R21=;R22=;R23=;R36=139840;R43=7825111650;COM=\n";
        Pattern pattern = Pattern.compile("\\GR\\d+.+?;|\\GR\\d+=;|\\GCOM=.*");;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
