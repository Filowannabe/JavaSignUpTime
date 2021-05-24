package frontend.views.utils;

public class EncryptUtils {

    public String cryptPassword(String password) {
        char array[] = password.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] + (char) 1000);
        }
        String crypted = String.valueOf(array);

        return crypted;
    }

}
