
class Word {
    String txt
    Word prev, next
    def others=[]

    String toString() { "[${prev?.txt}< $txt >${next?.txt}]"}
}

class Doc {
    def wordAry=[]

    Word getFirst() { wordAry[0] }
    Word getLast() { wordAry[-1] }

    Doc(String fileName) {
        File inp=new File(fileName)

        def ary = inp.getText().split(/\s+/).findAll { it =~ /\w/ }
                .collect {
            ((it =~ /\w'\w/) ? it.replaceAll(/^\W|\W$/, '') : it.replaceAll(/\W/, '')).toLowerCase()
        }

        Word last = null
        def map = [:]
        ary.each {
            Word w = new Word(txt: it, prev: last)
            wordAry<<w
            if (last) {
                last.next = w
                w.prev = last
            }
            last = w

            def list = map[it]
            if (!list) {
                list = []; map[it] = list
            }
            list << w
        }

        //println map

        map.keySet().each {
            key ->
                def list = map[key]
                list.each { Word word -> word.others = list }
        }
    }
}

def d=new Doc('data/ch1.txt')
println "$d.first $d.last"