import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValid
{
    private Pattern pattern;
    private Matcher matcher;

    private static final String  RegExPassword =
                 "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public PasswordValid()
          {
        pattern = Pattern.compile(RegExPassword);
          }
    public boolean validate(final String password)
          {
        matcher = pattern.matcher(password);
        return matcher.matches();
          }

}