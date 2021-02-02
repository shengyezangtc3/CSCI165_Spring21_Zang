// Shengye Zang Lab1

public class HelloWorld2 {

    public static void main(String[] args) {

        String temp= "";
        for (String s : args) {
            temp+= s + " ";
        }
        System.out.println("Hello " + temp + "Nice work processing the arguments");
        System.out.println(System.getProperty("java.class.path"));                  // java class path
        System.out.println(System.getProperty("java.home"));                        // java home
        System.out.println(System.getProperty("java.version"));                     // java version
        System.out.println(System.getProperty("os.arch"));                          // operating system architecture
        System.out.println(System.getProperty("os.version"));                       // operating system version
        System.out.println(System.getProperty("user.dir"));                         // current working directory
        System.out.println(System.getProperty("user.home"));                        // user home directory
        System.out.println(System.getProperty("user.name"));                        // user account name

    }

}
