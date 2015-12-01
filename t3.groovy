import w.*

if (args) {
    try { Common.chainLength = args[0] as int }
    catch (ex) { println "${args[0]} is not an integer."; System.exit(-1) }
}

def d=new Doc('data/wonderland.txt')


def w=d.random
[*1..5].each {
    //println "$w.txt "
    w=w.chainedNext
    if (!w) w=d.random
}


