package jonss.com.github.weatherman.utils;

import java.text.DecimalFormat;

/**
 * Created by joao on 28/01/17.
 */

public class StringUtils {

    public static String toDecimal(Double d) {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(d);
    }
}
