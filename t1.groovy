import w.*

def d=new Doc('data/ch1.txt')
println "first: $d.first last: $d.last"
println '\nrandom t1:'
[*1..10].each { println d.random }

println '\nMarkov walk:'
def w=d.random
[*1..500].each {
    print "$w.txt "
    w=w.markovNext
}
