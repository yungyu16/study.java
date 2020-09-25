package jdbc

import groovy.sql.DataSet
import groovy.sql.Sql
import groovy.xml.MarkupBuilder

/**
 *
 * CreatedDate: 2020/9/25
 * Author: songjialin
 */
println("hhhh")
def a = { ->
    def xml = new MarkupBuilder();
}

Sql sql = Sql.newInstance("jdbc:mysql://mysql-dev.50lion.com:3306/daiquhua_app_dev", "admin",
        "admin123456")

sql.eachRow("select * from nation") { row ->
    println row.nation_code + " " + row.city + " " + row.province
}

DataSet dataSet = sql.dataSet("area");