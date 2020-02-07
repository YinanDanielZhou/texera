/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.resource.generated;


import edu.uci.ics.texera.web.resource.generated.tables.Dictownship;
import edu.uci.ics.texera.web.resource.generated.tables.Fileownship;
import edu.uci.ics.texera.web.resource.generated.tables.Useraccount;
import edu.uci.ics.texera.web.resource.generated.tables.Userdict;
import edu.uci.ics.texera.web.resource.generated.tables.Userfile;
import edu.uci.ics.texera.web.resource.generated.tables.records.DictownshipRecord;
import edu.uci.ics.texera.web.resource.generated.tables.records.FileownshipRecord;
import edu.uci.ics.texera.web.resource.generated.tables.records.UseraccountRecord;
import edu.uci.ics.texera.web.resource.generated.tables.records.UserdictRecord;
import edu.uci.ics.texera.web.resource.generated.tables.records.UserfileRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>texera</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<DictownshipRecord, Integer> IDENTITY_DICTOWNSHIP = Identities0.IDENTITY_DICTOWNSHIP;
    public static final Identity<UseraccountRecord, Integer> IDENTITY_USERACCOUNT = Identities0.IDENTITY_USERACCOUNT;
    public static final Identity<UserdictRecord, Integer> IDENTITY_USERDICT = Identities0.IDENTITY_USERDICT;
    public static final Identity<UserfileRecord, Integer> IDENTITY_USERFILE = Identities0.IDENTITY_USERFILE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DictownshipRecord> KEY_DICTOWNSHIP_PRIMARY = UniqueKeys0.KEY_DICTOWNSHIP_PRIMARY;
    public static final UniqueKey<FileownshipRecord> KEY_FILEOWNSHIP_PRIMARY = UniqueKeys0.KEY_FILEOWNSHIP_PRIMARY;
    public static final UniqueKey<UseraccountRecord> KEY_USERACCOUNT_USERNAME = UniqueKeys0.KEY_USERACCOUNT_USERNAME;
    public static final UniqueKey<UseraccountRecord> KEY_USERACCOUNT_PRIMARY = UniqueKeys0.KEY_USERACCOUNT_PRIMARY;
    public static final UniqueKey<UserdictRecord> KEY_USERDICT_PRIMARY = UniqueKeys0.KEY_USERDICT_PRIMARY;
    public static final UniqueKey<UserfileRecord> KEY_USERFILE_PRIMARY = UniqueKeys0.KEY_USERFILE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DictownshipRecord, UseraccountRecord> DICTOWNSHIP_IBFK_1 = ForeignKeys0.DICTOWNSHIP_IBFK_1;
    public static final ForeignKey<DictownshipRecord, UserdictRecord> DICTOWNSHIP_IBFK_2 = ForeignKeys0.DICTOWNSHIP_IBFK_2;
    public static final ForeignKey<FileownshipRecord, UseraccountRecord> FILEOWNSHIP_IBFK_1 = ForeignKeys0.FILEOWNSHIP_IBFK_1;
    public static final ForeignKey<FileownshipRecord, UserfileRecord> FILEOWNSHIP_IBFK_2 = ForeignKeys0.FILEOWNSHIP_IBFK_2;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<DictownshipRecord, Integer> IDENTITY_DICTOWNSHIP = Internal.createIdentity(Dictownship.DICTOWNSHIP, Dictownship.DICTOWNSHIP.DICTID);
        public static Identity<UseraccountRecord, Integer> IDENTITY_USERACCOUNT = Internal.createIdentity(Useraccount.USERACCOUNT, Useraccount.USERACCOUNT.USERID);
        public static Identity<UserdictRecord, Integer> IDENTITY_USERDICT = Internal.createIdentity(Userdict.USERDICT, Userdict.USERDICT.DICTID);
        public static Identity<UserfileRecord, Integer> IDENTITY_USERFILE = Internal.createIdentity(Userfile.USERFILE, Userfile.USERFILE.FILEID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<DictownshipRecord> KEY_DICTOWNSHIP_PRIMARY = Internal.createUniqueKey(Dictownship.DICTOWNSHIP, "KEY_dictownship_PRIMARY", Dictownship.DICTOWNSHIP.USERID, Dictownship.DICTOWNSHIP.DICTID);
        public static final UniqueKey<FileownshipRecord> KEY_FILEOWNSHIP_PRIMARY = Internal.createUniqueKey(Fileownship.FILEOWNSHIP, "KEY_fileownship_PRIMARY", Fileownship.FILEOWNSHIP.USERID, Fileownship.FILEOWNSHIP.FILEID);
        public static final UniqueKey<UseraccountRecord> KEY_USERACCOUNT_USERNAME = Internal.createUniqueKey(Useraccount.USERACCOUNT, "KEY_useraccount_userName", Useraccount.USERACCOUNT.USERNAME);
        public static final UniqueKey<UseraccountRecord> KEY_USERACCOUNT_PRIMARY = Internal.createUniqueKey(Useraccount.USERACCOUNT, "KEY_useraccount_PRIMARY", Useraccount.USERACCOUNT.USERID);
        public static final UniqueKey<UserdictRecord> KEY_USERDICT_PRIMARY = Internal.createUniqueKey(Userdict.USERDICT, "KEY_userdict_PRIMARY", Userdict.USERDICT.DICTID);
        public static final UniqueKey<UserfileRecord> KEY_USERFILE_PRIMARY = Internal.createUniqueKey(Userfile.USERFILE, "KEY_userfile_PRIMARY", Userfile.USERFILE.FILEID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<DictownshipRecord, UseraccountRecord> DICTOWNSHIP_IBFK_1 = Internal.createForeignKey(edu.uci.ics.texera.web.resource.generated.Keys.KEY_USERACCOUNT_PRIMARY, Dictownship.DICTOWNSHIP, "dictownship_ibfk_1", Dictownship.DICTOWNSHIP.USERID);
        public static final ForeignKey<DictownshipRecord, UserdictRecord> DICTOWNSHIP_IBFK_2 = Internal.createForeignKey(edu.uci.ics.texera.web.resource.generated.Keys.KEY_USERDICT_PRIMARY, Dictownship.DICTOWNSHIP, "dictownship_ibfk_2", Dictownship.DICTOWNSHIP.DICTID);
        public static final ForeignKey<FileownshipRecord, UseraccountRecord> FILEOWNSHIP_IBFK_1 = Internal.createForeignKey(edu.uci.ics.texera.web.resource.generated.Keys.KEY_USERACCOUNT_PRIMARY, Fileownship.FILEOWNSHIP, "fileownship_ibfk_1", Fileownship.FILEOWNSHIP.USERID);
        public static final ForeignKey<FileownshipRecord, UserfileRecord> FILEOWNSHIP_IBFK_2 = Internal.createForeignKey(edu.uci.ics.texera.web.resource.generated.Keys.KEY_USERFILE_PRIMARY, Fileownship.FILEOWNSHIP, "fileownship_ibfk_2", Fileownship.FILEOWNSHIP.FILEID);
    }
}