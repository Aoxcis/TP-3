import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(cesarchar('z', 'C', true));
        //System.out.println(cesarstring("test", 'D', true));
        //System.out.println(Vigenere("test test test", "TPFI", true));
        Apparition();
    }
    public static char cesarchar(char s, char c, Boolean sens){ //sens = true chiffrage, sens = false déchiffrage
        if(s >= 65 && s<= 90){
            char decalage = (char)(c - 'A');
            if(sens){
                if(s + decalage > 90){
                    char s2 = (char)(s + decalage - 26);
                    return s2;
                }
                else{
                    char s2 = (char)(s + decalage);
                    return s2;
                }
                
            }
            else{
                if(s + decalage < 65){
                    char s2 = (char)(s - decalage + 26);
                    return s2;
                }
                else{
                    char s2 = (char)(s - decalage);
                    return s2;
                }
            }
        }

        if(s >= 97 && s<= 122){
            char decalage = (char)(c - 'A');
            if(sens){
                if(s + decalage > 122){
                    char s2 = (char)(s + decalage - 26);
                    return s2;
                }
                else{
                    char s2 = (char)(s + decalage);
                    return s2;
                }
                
            }
            else{
                if(s + decalage < 97){
                    char s2 = (char)(s - decalage + 26);
                    return s2;
                }
                else{
                    char s2 = (char)(s - decalage);
                    return s2;
                }
            }
        }
        return 0;
    }

    public static String cesarstring(String s, char c, Boolean sens){
        String s2 = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                char decalage = (char)(c - 'A');
                if(sens){
                    if(s.charAt(i) + decalage > 90){
                        char nvchar = (char)(s.charAt(i) + decalage - 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) + decalage);
                        s2 = s2 + nvchar;
                    }
                }
                else{
                    if(s.charAt(i) + decalage < 65){
                        char nvchar = (char)(s.charAt(i) - decalage + 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) - decalage);
                        s2 = s2 + nvchar;
                    }
                }
            }

            else if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                char decalage = (char)(c - 'A');
                if(sens){
                    if(s.charAt(i) + decalage > 122){
                        char nvchar = (char)(s.charAt(i) + decalage - 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) + decalage);
                        s2 = s2 + nvchar;
                    }
                    
                }
                else{
                    if(s.charAt(i) + decalage < 90){
                        char nvchar = (char)(s.charAt(i) - decalage + 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) - decalage);
                        s2 = s2 + nvchar;
                    }
                }
            }
        }
        return s2;
    }


    public static String Vigenere(String s, String c,Boolean sens){
        int k = c.length();
        String s2 = "";
        char decalage = 'A';
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 32){
                s2 = s2 + " ";
            }
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                for(int j = 0; j < k; j++){
                    decalage = (char)(c.charAt(j)- 'A');
                }
                if(sens){
                    if(s.charAt(i) + decalage > 90){
                        char nvchar = (char)(s.charAt(i) + decalage - 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) + decalage);
                        s2 = s2 + nvchar;
                    }
                }
                else{
                    if(s.charAt(i) + decalage < 65){
                        char nvchar = (char)(s.charAt(i) - decalage + 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) - decalage);
                        s2 = s2 + nvchar;
                    }
                }
            }


            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                for(int j = 0; j < k; j++){
                    decalage = (char)(c.charAt(j)- 'A');
                }
                if(sens){
                    if(s.charAt(i) + decalage > 122){
                        char nvchar = (char)(s.charAt(i) + decalage - 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) + decalage);
                        s2 = s2 + nvchar;
                    }
                }
                else{
                    if(s.charAt(i) + decalage < 97){
                        char nvchar = (char)(s.charAt(i) - decalage + 26);
                        s2 = s2 + nvchar;
                    }
                    else{
                        char nvchar = (char)(s.charAt(i) - decalage);
                        s2 = s2 + nvchar;
                    }
                }
            }
        }
    return s2;
    }


    public static String readFileAsString(String fileName)throws
    Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }



    public static void Apparition(){
        String s = "";
        try{
            s = readFileAsString("C:\\Users\\grego\\Downloads\\ComplémentTP3\\ActualiteMinesDouaiCesar.txt");
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        int[] tab = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                tab[s.charAt(i) - 'A']++;
            }
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                tab[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0; i < 26; i++){
            System.out.println((char)(i + 'A') + " : " + tab[i]);
        }
    }
}


