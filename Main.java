import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MyClass{
    int getValue(int n);
}

interface Generic<T>{
    T t(T value);
}

interface TwoObj<T, E>{
    T getUser(T t, E e);
}


class Main{
    public static void main(String[] args) {
        MyClass obj;

        obj = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }

            return result;
        };


        Generic<String> reverse;

        reverse = (word) -> {

            char letters_of_word[] = word.toCharArray();

            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(letters_of_word[i]);
            }

            return String.valueOf(reversedWord);
        };


        Generic<Integer> factorial;

        factorial = (var number) -> {

            int result = 1;

            for (int i = 1; i <= number; i++) {
                result *= i;
            }

            return result;

        };

        System.out.println(obj.getValue(5));


        System.out.println(reverse.t("Lambda"));
        System.out.println(reverse.t("Expression"));

        System.out.println("***********************");

        System.out.println(factorial.t(3));
        System.out.println(factorial.t(5));

        List<String> twoObjList = new ArrayList<>();


        TwoObj<String, Integer> userInfo;

        userInfo = (var username, var password) -> {

            if (String.valueOf(password).length() < 4){
                return "Your password is very small and it may\n" +
                        "cause serious problems";
            }

            return "Your username is: " + username + " and password is: "
                    + password;

        };

        Scanner scanner = new Scanner(System.in);

        int i = 3;

        while (i > 0){
            System.out.print("Please enter your username: ");
            String username = scanner.next();

            System.out.print("Please enter your password: ");
            int password = scanner.nextInt();

            twoObjList.add(userInfo.getUser(username, password));
            i--;
        }

        for (String userInformation:
             twoObjList) {
            System.out.println(userInformation);
        }

    }
}
