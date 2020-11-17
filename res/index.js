function hello() {
    print("hello")
    world();
    return 1111
}

function world() {
    print("world")
    echo();
}

function echo() {
    print(echoVar + (++echoIdx))
}

echoVar = "echoooooo";
echoIdx = 1;
