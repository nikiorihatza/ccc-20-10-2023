package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * HHKK
 * HKHK
 * HKKH
 * KHHK
 * KHKH
 * KKHH
 */

/**
 * H,H,H,K
 *
 * K,H,K,H
 *
 * H,H,K,K
 *
 * H,H,H,K
 *
 * H,K,H,K
 *
 * K,H,H,K
 *
 * K,K,H,H
 */

public class PieceUtils {

    public static List<String> allignments() {
        List<String> output = new ArrayList<>();
        output.add("H,H,H,K");
        output.add("K,H,K,H");
        output.add("H,H,K,K");
        output.add("K,H,H,K");
        output.add("K,K,H,H");
        output.add("K,K,H,H");
        return output;
    }
}
