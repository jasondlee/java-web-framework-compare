package com.steeplesoft.fwdemo.quarkus;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.dialect.PostgreSQL95Dialect;

public class PostgreSQLCustomDialect extends PostgreSQL95Dialect {

    public PostgreSQLCustomDialect() {
        super();
        System.err.println("\n\n\n\n\n\n\nHi");
        this.registerHibernateType(2003, StringArrayType.class.getName());
    }

}
