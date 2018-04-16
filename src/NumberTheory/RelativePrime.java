package NumberTheory;

import java.util.ArrayList;
import java.util.List;


public class RelativePrime {

    List SetRelative = new ArrayList();

    List GetDivisionNum(int num) {
        List NumDiv = new ArrayList();
        for (int i = 2; i <= (num / 2 + 1); i++) {
            if (num % i == 0) {
                NumDiv.add(i);
            }
        }
        return NumDiv;
    }

    Integer numOFrelative(int num) {
        if (num == 1 || num == 2) {
            SetRelative.add(1);
        } else {
            List NumDiv = GetDivisionNum(num);

            for (int i = 1; i < num; i++) {
                boolean flage = true;
                for (int j = 0; j < NumDiv.size(); j++) {
                    int N = (int) NumDiv.get(j);
                    if (i % N == 0) {
                        flage = false;
                        break;
                    }
                }
                if (flage) {
                    SetRelative.add(i);
                }
            }
        }
        return SetRelative.size();
    }

    List Relative() {
        return SetRelative;

    }

}


