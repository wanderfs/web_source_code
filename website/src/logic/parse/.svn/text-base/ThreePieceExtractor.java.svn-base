/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Just to extract a simple pattern:
 * (constant prefix) .* (constant postfix)
 *
 * prelen and postlen is the actual length of matched prefix. They may not be the same as the length
 * of prefix and postfix if using escape character.
 * 
 * @author xuan
 */
class ThreePieceExtractor {
    String prefix;
    int prelen;
    String postfix;
    int postlen;
    Pattern p;

    public ThreePieceExtractor(String prefix, String postfix, int prelen, int postlen) {
        this.prefix = replaceEscapeCharacter(prefix);
        this.postfix = replaceEscapeCharacter(prefix);
        
        this.prelen = prelen;
        this.postlen = postlen;
        p = Pattern.compile(prefix + ".*" + postfix);
    }

    public String extract(String str) {
        Matcher m = p.matcher(str);
        String result = null;
        if (m.find()) {
            String matchstr = str.substring(m.start(), m.end());
            result = matchstr.substring(prelen, matchstr.length() - postlen);
        }
        return result;
    }

    public static String replaceEscapeCharacter(String s) {
        StringBuffer re = new StringBuffer();
        String needescape = ".?+*[](){}\\";
        for (int i = 0; i != s.length(); ++i) {
            if (needescape.indexOf(s.charAt(i)) > 0) {
                re.append("\\");
            }
            re.append(s.charAt(i));
        }
        return re.toString();
    }
}
