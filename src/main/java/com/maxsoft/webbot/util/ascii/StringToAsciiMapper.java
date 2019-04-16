package com.maxsoft.webbot.util.ascii;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.Map;

/**
 * Project Name : MaxSoft-WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 15/04/2019
 * Time         : 23:27
 * Description  :
 **/


public class StringToAsciiMapper {

    private StringToAsciiMapper() {
    }

    private static final Map<String, CharSequence> asciiStringToAscii = new HashMap<String, CharSequence>() {{{
        put("ue000", Keys.NULL);
        put("ue001", Keys.CANCEL);
        put("ue002", Keys.HELP);
        put("ue003", Keys.BACK_SPACE);
        put("ue004", Keys.TAB);
        put("ue005", Keys.CLEAR);
        put("ue006", Keys.RETURN);
        put("ue007", Keys.ENTER);
        put("ue008", Keys.SHIFT);
        put("ue009", Keys.CONTROL);
        put("ue00a", Keys.ALT);
        put("ue00b", Keys.PAUSE);
        put("ue00c", Keys.ESCAPE);
        put("ue00d", Keys.SPACE);
        put("ue00e", Keys.PAGE_UP);
        put("ue00f", Keys.PAGE_DOWN);
        put("ue010", Keys.END);
        put("ue011", Keys.HOME);
        put("ue012", Keys.LEFT);
        put("ue013", Keys.UP);
        put("ue014", Keys.RIGHT);
        put("ue015", Keys.DOWN);
        put("ue016", Keys.INSERT);
        put("ue017", Keys.DELETE);
        put("ue018", Keys.SEMICOLON);
        put("ue019", Keys.EQUALS);
        put("ue01a", Keys.NUMPAD0);
        put("ue01b", Keys.NUMPAD1);
        put("ue01c", Keys.NUMPAD2);
        put("ue01d", Keys.NUMPAD3);
        put("ue01e", Keys.NUMPAD4);
        put("ue01f", Keys.NUMPAD5);
        put("ue020", Keys.NUMPAD6);
        put("ue021", Keys.NUMPAD7);
        put("ue022", Keys.NUMPAD8);
        put("ue023", Keys.NUMPAD9);
        put("ue024", Keys.MULTIPLY);
        put("ue025", Keys.ADD);
        put("ue026", Keys.SEPARATOR);
        put("ue027", Keys.SUBTRACT);
        put("ue028", Keys.DECIMAL);
        put("ue029", Keys.DIVIDE);
        put("ue031", Keys.F1);
        put("ue032", Keys.F2);
        put("ue033", Keys.F3);
        put("ue034", Keys.F4);
        put("ue035", Keys.F5);
        put("ue036", Keys.F6);
        put("ue037", Keys.F7);
        put("ue038", Keys.F8);
        put("ue039", Keys.F9);
        put("ue03a", Keys.F10);
        put("ue03b", Keys.F11);
        put("ue03c", Keys.F12);
        put("ue03d", Keys.META);
        put("ue040", Keys.ZENKAKU_HANKAKU);
    }}};

    public static CharSequence convertToASCII(String asciiString) {
        if (asciiStringToAscii.containsKey(asciiString)) {
            return asciiStringToAscii.get(asciiString);
        } else {
            Assert.fail("Unsupported ASCII character: \\" + asciiString + "\nFor more info: https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/Keys.java");
        }
        return null;
    }


}
