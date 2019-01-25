import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Book
 *
 * En esta clase se realiza la búsqueda y ordenación de los contactos.
 *
 */
public class Book {
    private String[] groups;         // Guarda únicamnte los nombres de los grupos
    private Contact[] contacts;      // Guarda los contactos objetos
    private String[][] table;       // Contiene el índice de los grupos y el nombre de los contactos
    private int size;

    public Book() {
        this.groups = new String[10];
        this.contacts = new Contact[100];

        this.table = new String[groups.length][contacts.length];
        this.size = 0;
    }

    /**
     * Crea nuevo grupo
     *
     * Crea un nuevo grupo para almacenar a los contactos
     * Realiza un recorrido y simplemente si encuentra un lugar
     * disponible agrega el nuevo nombre al grupo, si no,
     * significa que ya llegado al límite de grupos disponibles.
     *
     * @param gname
     * @return
     */
    public boolean createNewGroup(String gname) {
        boolean retval = false;

        for (int i = 0; i < groups.length - 1; i++) {
            if (groups[i] == null) {
                groups[i] = gname;
                System.out.println("\nSe ha creado el grupo: " + gname + "\n");
                retval = true;
                break;
            }
        }

        if (!retval) {
            System.out.println("Se ha llegado al límite para crear nuevos grupos.");
        }

        return retval;
    }

    /**
     * Agrega un nuevo contacto.
     *
     * Busca primero el nombre al grupo que se quiere agregar
     * busca primero el grupo y si existe entonces lo agrega.
     *
     * @param contact
     * @param gname
     * @return
     */
    public boolean addNewContact(Contact contact, String gname) {
        boolean retval = false;
        boolean groupExists = false;

        // Busca si el grupo existe
        for (int i = 0; i < groups.length - 1; i++) {

            if (groups[i] != null && groups[i].equals(gname)) {
                // System.out.println("El grupo: " + groups[i].toString() + " si existe.");
                groupExists = true;
                break;
            }

        }

        if (groupExists) {
            contact.setGroup_id(gname);

            for (int i = 0; i < contacts.length - 1; i++) {
                if (contacts[i] == null) {
                    contacts[i] = contact;

                    addContactToTable(gname, contact.getNames());

                    size++;
                    retval = true;
                    break;
                }
            }
        } else {
            System.out.println("\nNo se ha encontrado el grupo: " + gname);
        }

        // Verifica si no se ha alcanzado el límite para agregar contactos
        if (size >= contacts.length) {
            System.out.println("Se ha alcanzado el límite para agregar contactos");
        }

        return retval;
    }

    /**
     * Agrega un contacto a la tabla
     *
     * Agrega simplemente el nombre del contacto
     * a la categoría especificada, pasando el nombre
     * de la categoría o grupo por parámetro.
     *
     * @param gname
     * @param cname
     * @return
     */
    private boolean addContactToTable(String gname, String cname) {
        boolean retval = false;

        int index = 0;
        // Busca el nombre del grupo y regresa el índex del nombre del grupo
        for (int i = 0; i < groups.length - 1; i++) {

            if (groups[i] != null) {

                if (groups[i] == gname) {
                    System.out.println("Agregando contacto: " + cname + " al grupo: " + groups[i]);
                    index = i;
                    break;
                }

            }

        }


        // Si es diferente a cero, significa que ya hay un grupo establecido
        if (index != 0) {
            for (int i = 0; i < table[index].length - 1; i++) {

                if (table[index][i] == null) {
                    table[index][i] = cname;
                    // System.out.println("Contacto agregado a la tabla.");
                    retval = true;
                    break;
                }

            }
        } else {
            for (int i = 0; i < table[index].length - 1; i++) {

                if (table[index][i] == null) {
                    table[index][i] = cname;
                    retval = true;
                    break;
                }

            }
        }

        return retval;
    }

    /**
     * Muestra la tabla únicamente
     *
     * Muestra la tabla tal como está.
     */
    public void showTable() {
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i][0] != null) {

                System.out.println("\nGrupo: " + groups[i]);

                for (int j = 0; j < table[i].length - 1; j++) {

                    if (table[i][j] != null) {
                        System.out.println("Contacto: " + table[i][j]);
                    }

                }

            }
        }

    }

    public Contact searchByName(String cname) {
        Contact retval = null;

        int iterator = 0;
        for (int i = 0; i < table.length - 1; i++) {

            for (int j = 0; j < table[i].length - 1; j++) {

                if (table[i][j] != null) {

                    if (table[i][j].equals(cname))
                    {
                        retval = contacts[ iterator ];
                        break;
                    }
                    iterator++;
                }
            }
        }

        if (retval == null) {
            System.out.println("\nEl contacto no existe.");
        }

        return retval;
    }

    public void sortByName(String gname) {
        ArrayList<String> names = new ArrayList<>();

        int index = -1;

        // Obtiene el index del nombre del grupo
        // del cual se van a ordenar sus contactos
        for (int i = 0; i < groups.length - 1; i++) {
            if (groups[i] != null && groups[i] == gname) {
                index = i;
            }
        }


        // Obtiene una copia de la lista de nombres de
        // los contactos del grupo establecido
        for (int i = 0; i < table[index].length - 1; i++) {
            if (table[index][i] != null) {
                names.add(table[index][i]);
            }
        }


        // Ordena los nombres
        Collections.sort(names);

        // Establece los nuevos nombres de forma ordenada
        for (int i = 0; i < names.size(); i++) {
            table[index][i] = names.get(i);
        }
    }
}
