package dsl

/**
 *
 * CreatedDate: 2020/9/25
 * Author: songjialin
 */


def binding = new Binding()
binding.setVariable("stub", new Stub())
binding.setVariable("test", "new Stub()")
def shell = new GroovyShell(binding)
shell.evaluate(new File("Dsl.gdsl"))

def evaluate = shell.evaluate(new File("Dsl2.gdsl"))
println(evaluate.getClass())
println(evaluate.getClass().getSuperclass())
println(evaluate.getClass().getInterfaces())
evaluate.delegate = new Stub();
evaluate.call()