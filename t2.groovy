import w.*

// reports on identical chains multiple times

boolean showChains=true

if (args) {
    try { Common.chainLength = args[0] as int }
    catch (ex) { println "${args[0]} is not an integer."; System.exit(-1) }
}

println "For links=$Common.chainLength"
def d=new Doc('data/wonderland.txt')
def multi=0
d.each {
    Chain chain=new Chain(it)
    def count=chain.likeChains().size()
    if (count>1) {
        if (showChains) println "$chain ${ chain.isComplete()?'':'[incomplete]' } " +
                "like chains: ${ count }"
        multi++
    }
}

println "${d.size()} words; $multi have multiple chains."


