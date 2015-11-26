import w.*

final int links=3

def d=new Doc('data/ch1.txt')

d.each {
    Chain chain=new Chain(it,links)
    //println it
    println "$chain ${ chain.isComplete()?'':'[incomplete]' }"

}


