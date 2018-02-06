package generators;

import model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] arg) throws IOException {
        int count = Integer.parseInt(arg [0]);
        File file = new File (arg[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for(ContactData contact: contacts){
            writer.write(String.format("%s;%s;%s\n",contact.getFirstName(),contact.getLastName(),contact.getAddress()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for(int i = 0; i<count; i++){
            contacts.add(new ContactData()
                    .withFirstName(String.format("firstName %s", i))
                    .withLastName(String.format("lastName %s", i))
                    .withAddress(String.format("addres %s", i)));
        }
        return contacts;
    }
}
