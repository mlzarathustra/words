import w.*

int WIDTH=80

if (args) {
    try { Common.chainLength = args[0] as int }
    catch (ex) { println "${args[0]} is not an integer."; System.exit(-1) }
}

def d=new Doc('data/wonderland.txt')


def w=d.random
def col=0
[*1..500].each {
    col += w.txt.size()+1
    if (col > WIDTH) { col=0; println '' }
    print "$w.txt "
    w=w.chainedNext
    if (!w) w=d.random
}


