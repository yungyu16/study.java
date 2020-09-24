import groovy.sql.Sql

//普通类
class Enclosing {
    void run() {
        def whatIsThisObject = { getThisObject() }    //1
        assert whatIsThisObject() == this             //2
        def whatIsThis = { this }                     //3
        assert whatIsThis() == this                   //4


        def whatIsOwnerMethod = { getOwner() }      //1
        assert whatIsOwnerMethod() == this          //2
        def whatIsOwner = { owner }                 //3
        assert whatIsOwner() == this                //4
    }
}


//内部类
class EnclosedInInnerClass {
    class Inner {
        Closure c_this = { this }                         //5
        Closure c_owner = { owner }
    }

    void run() {
        def inner = new Inner()
        assert inner.c_this() == inner                    //6
        assert inner.c_owner() == inner
    }
}

//闭包嵌套定义
class NestedClosures {
    void run() {
        def nestedClosures_this = {
            def c_this = { this }                         //7
            c_this()
        }
        assert nestedClosures_this() == this               //8

        def nestedClosures_owner = {
            def c_owner = { owner }                      //7
            c_owner()
        }
        //owner 对应闭包，这就是 owner 和 this 的不同!!
        assert nestedClosures_owner() == nestedClosures_owner   //8
    }
}

new Enclosing().run()
new EnclosedInInnerClass().run()
new NestedClosures().run()

def test = {
    def a = 1
}


def str = 'example of method reference'
def fun = str.&toUpperCase
println(fun.class)
println(fun.call())
def upper = fun()
assert upper == str.toUpperCase()

Sql.newInstance("")