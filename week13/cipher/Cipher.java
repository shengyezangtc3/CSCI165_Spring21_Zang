/*
    Cipher is a class and not an interface because it contains
    methods with implementation and abstract methods
*/
public abstract class Cipher{

    private enum Translate{ENCRYPT, DECRYPT};

    // Will split text into tokens based on spaces
	// a token in this situation is simply a collection of non-space characters
	/**
	 * 
	 * @param s The String to translate
	 * @param t	The enum to specify "encode" or "decode"
	 * @return  The translated string
	 */
    private String translate(String s, Translate t){
        String[] tokens     = s.split(" ");
        StringBuilder sb    = new StringBuilder();

        for(String word : tokens){
            if(t == Translate.ENCRYPT)
                 sb.append(encodeToken(word) + " ");
            else sb.append(decodeToken(word) + " ");
        }
        return sb.toString();
    }

	// public helper to abstract the call to "translate"
    // call to encrypt block of text. Will encrypt with calls to encodeToken
	/**
	 * 
	 * @param s The String to encrypt
	 * @return
	 */
    public String encryptText(String s){
        return translate(s, Translate.ENCRYPT);
    }

	// public helper to abstract the call to "translate"
    // call to decrypt block of text. Will decrypt with calls to decodeToken
	/**
	 * 
	 * @param s The string to decrypt
	 * @return
	 */
    public String decryptText(String s){
        return translate(s, Translate.DECRYPT);
    }

    // override this to provide custom, token level encryption
    public abstract String encodeToken(String token);
    // override this to provide custom token level decryption
    public abstract String decodeToken(String token);
}
