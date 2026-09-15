import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.BufferedWriter;

public class ValidadorEmails {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static boolean emailValido(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static boolean dominioPossuiMX(String email) {

    String dominio = email.substring(email.indexOf("@") + 1);

    try {
        Hashtable<String, String> env = new Hashtable<>();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");

        DirContext contexto = new InitialDirContext(env);
        Attributes atributos = contexto.getAttributes(dominio, new String[]{"MX"});

        return atributos.get("MX") != null;

    } catch (NamingException e) {
        return false;
    }
}

    public static void main(String[] args) throws IOException {

    List<String> emails = Files.readAllLines(Path.of("emails.txt"));

    try (BufferedWriter writer = Files.newBufferedWriter(Path.of("validacao_emails.csv"))) {

        writer.write("email,status,motivo");
        writer.newLine();

        for (String email : emails) {

            if (!emailValido(email)) {
                writer.write(email + ",Invalido,Sintaxe invalida");

            } else if (!dominioPossuiMX(email)) {
                writer.write(email + ",Invalido,Dominio nao possui registro MX");

            } else {
                writer.write(email + ",Valido,");
            }

            writer.newLine();
        }
    }

    System.out.println("Validação concluída. Arquivo validacao_emails.csv gerado.");
}
}