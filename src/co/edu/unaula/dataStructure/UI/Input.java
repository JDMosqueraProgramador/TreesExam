package co.edu.unaula.dataStructure.UI;

import co.edu.unaula.dataStructure.Helpers.Strings;
import lombok.NoArgsConstructor;
import java.util.Scanner;

@NoArgsConstructor
public class Input {

    private final Scanner read = new Scanner(System.in).useDelimiter(Strings.ENTER);

    public String string(String message) {

        try {

            String input = Strings.STR_EMPTY_TEXT;

            while (isEmptyText(input)) {

                System.out.println(message);
                input = read.next();

                if (isEmptyText(input)) System.out.println(Strings.MSG_EMPTY_STRING);

            }

            return input;

        } catch (Exception e) {
            throw e;
        }

    }

    public int integer(String msg) {

        String input;
        int result = 0;
        boolean flag = true;

        while (flag) {
            try {

                input = string(msg);

                if (!input.matches(Strings.INT_REGEX)) {
                    System.out.println(Strings.MSG_BAD_NUMBER);
                } else {
                    result = Integer.parseInt(input);
                    flag = false;
                }

            } catch (NumberFormatException e) {
                System.out.println(Strings.MSG_NULL_FORMAT_EXCEPTION);
            }
        }

        return result;

    }

    private boolean isEmptyText(String input) {
        return input.equals(Strings.STR_EMPTY_TEXT);
    }
}

