/**
 * This class is generated by jOOQ
 */
package test.generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import test.generated.tables.Account;
import test.generated.tables.User;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Gestionaccount extends SchemaImpl {

    private static final long serialVersionUID = 1048280265;

    /**
     * The reference instance of <code>gestionAccount</code>
     */
    public static final Gestionaccount GESTIONACCOUNT = new Gestionaccount();

    /**
     * The table <code>gestionAccount.account</code>.
     */
    public final Account ACCOUNT = test.generated.tables.Account.ACCOUNT;

    /**
     * The table <code>gestionAccount.user</code>.
     */
    public final User USER = test.generated.tables.User.USER;

    /**
     * No further instances allowed
     */
    private Gestionaccount() {
        super("gestionAccount", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Account.ACCOUNT,
            User.USER);
    }
}
