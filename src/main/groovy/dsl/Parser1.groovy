package dsl

import groovy.json.JsonOutput
import groovy.transform.Field

/**
 *
 * CreatedDate: 2020/9/25
 * Author: songjialin
 */

def a = {
    hello 'aaa'
}
@Field def var1 = 'hhh'

class Parser {
    def orderInfo = [:]

    def methodMissing(String name, args) {
        orderInfo[name] = args
        println(var1)
    }

    def duuu() {
        println(this.getClass())
        println(this.getClass().getCanonicalName())
        println(this.getClass().getSuperclass())
        println(this.getClass().getInterfaces())
    }

    def acceptOrder(closure) {
        closure.delegate = this
        closure()
        orderInfo.each { k, v ->
            println("${k}->${v}")
        }
    }
}


def parser = new Parser()
def binding = new Binding()
binding.parser = parser
binding.large = 'large'
binding.thin = 'thin'
binding.visa = 'Visa'
sh = "parser.acceptOrder{" + new File("dsl.Dsl.gdsl").text + "}"
println(sh)
def shell = new GroovyShell(binding)
def clo = shell.parse("{->" + new File("dsl.Dsl.gdsl").text + "}")
println(clo.dump())
parser.acceptOrder(clo.run())
println('=============')
shell.evaluate(sh)
println('=============')

def hello() {
    println(this.dump())
}

hello()

println(this.getClass().getSuperclass())
println(this.getClass().getInterfaces().join(","))

println("------------------")
println(parser.duuu())
println("------------------")
println(JsonOutput.toJson(parser))



